package org.xtuml.bp.mc.c.source.test;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.junit.After;
import org.junit.Before;
import org.xtuml.bp.test.common.BaseTest;

public abstract class MCCSourceTest extends BaseTest {

    private static final String TOOLS_DIR = "tools/mc/bin";
    private static final String MCMC = "mcmc";
    private static final String MCMC_DISABLED = "_mcmc";

    private String output;
    private String error;

    // Test suites implementing this class, should override this method
    // to provide the name of the project to build
    protected abstract String getProjectName();

    @Before
    public void setUp() throws Exception {
        super.setUp();
        output = "";
        error = "";
        // load the project
        String projectName = getProjectName();
        assertTrue( "Project name cannot be empty.", null != projectName && !"".equals( projectName ) );
        loadProject( projectName );
        // enable mcmc by default
        setMcmcEnabled( true );
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
        setMcmcEnabled( true );
    }

    // build the project
    protected void buildProject() throws Exception {
        assertNotNull( "Null project handle.", project );

        // remove 'gen/code_generation' if it exists
        IFolder codeGen = project.getFolder( "gen/code_generation" );
        if ( null != codeGen && codeGen.exists() ) {
            codeGen.delete( true, false, new NullProgressMonitor() );
        }

        // remove all .c and .h files from the src folder
        IFolder src = project.getFolder( "src" );
        if ( null != src && src.exists() ) {
            for ( IResource res : src.members() ) {
                if ( res instanceof IFile && ( res.getName().endsWith( ".c" ) || res.getName().endsWith( ".h" ) ) ) res.delete( true, new NullProgressMonitor() );
            }
        }

        // refresh project
        project.refreshLocal( IResource.DEPTH_INFINITE, new NullProgressMonitor() );

        // clean
        project.build( IncrementalProjectBuilder.CLEAN_BUILD, new NullProgressMonitor() );

        // build
        project.build( IncrementalProjectBuilder.FULL_BUILD, new NullProgressMonitor() );
    }

    // execute the application
    protected int executeApplication( String appPath, List<String> args, File inputFile ) throws Exception {
        assertNotNull( "Null project handle.", project );
        project.refreshLocal( IResource.DEPTH_INFINITE, new NullProgressMonitor() );

        // get the executable file
        IFile exeFile = project.getFile( appPath );
        assertNotNull( "Null file handle.", exeFile );
        assertTrue( "Could not find executable: " + exeFile.getRawLocation().makeAbsolute().toOSString(), exeFile.exists() );

        // set up command line arguments
        List<String> commandLine = new ArrayList<String>();
        commandLine.add( exeFile.getRawLocation().makeAbsolute().toOSString() );
        if ( null != args ) commandLine.addAll( args );

        // set up input
        if ( null != inputFile ) assertTrue( "Could not find input file: " + inputFile.getAbsolutePath(), inputFile.exists() );

        // set up output
        File outputFile = File.createTempFile( "mccsourcetest_stdout", null );
        System.out.println( "stdout location: " + outputFile.getAbsolutePath() );

        // set up error
        File errorFile = File.createTempFile( "mccsourcetest_stderr", null );
        System.out.println( "stderr location: " + errorFile.getAbsolutePath() );

        // run the executable
        Process proc = null;
        if ( null == inputFile ) proc = new ProcessBuilder( commandLine ).redirectOutput( outputFile ).redirectError( errorFile ).start();
        else proc = new ProcessBuilder( commandLine ).redirectInput( inputFile ).redirectOutput( outputFile ).redirectError( errorFile ).start();
        int returnCode = proc.waitFor();

        // collect the output
        output = readFile( outputFile );
        error = readFile( errorFile );

        return returnCode;
    }

    // return output
    protected String getOutput() throws Exception {
        return output;
    }

    // return error output
    protected String getError() throws Exception {
        return error;
    }

    // set whether or not the model based portion
    // of the C model compiler is enabled
    protected void setMcmcEnabled( boolean enable ) {
        IPath toolsDir = new Path( System.getProperty( "eclipse.home.location" ).replaceAll( "file:", "" ) ).append( new Path( TOOLS_DIR ) );
        assertTrue( "Could not locate tools directory.", toolsDir.toFile().exists() && toolsDir.toFile().isDirectory() );
        File enabledMcmc = toolsDir.append( MCMC ).toFile();
        File disabledMcmc = toolsDir.append( MCMC_DISABLED ).toFile();
        if ( enable ) {
            if ( disabledMcmc.exists() && !enabledMcmc.exists() ) disabledMcmc.renameTo( enabledMcmc );
        }
        else {
            if ( enabledMcmc.exists() && !disabledMcmc.exists() ) enabledMcmc.renameTo( disabledMcmc );
        }
    }

    // read the contents of a file into a string
    protected String readProjectFile( String filePath ) throws Exception {
        assertNotNull( "Null project handle.", project );
        IFile file = project.getFile( filePath );
        assertNotNull( "Null file handle.", file );
        assertTrue( "File does not exist: " + file.getRawLocation().makeAbsolute().toOSString(), file.exists() );
        return readFile( file.getRawLocation().makeAbsolute().toFile() );
    }

    // read the contents of a file into a string
    private String readFile( File file ) throws Exception {
        assertNotNull( "Null file handle.", file );
        assertTrue( "File does not exist: " + file.getAbsolutePath(), file.exists() );
        String output = "";
        int c;
        FileReader rd = new FileReader( file );
        while ( -1 != (c = rd.read()) ) output += (char)c;
        rd.close();
        return output;
    }

}
