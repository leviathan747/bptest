package org.xtuml.bp.mc.c.source.test.sets;

import org.junit.Test;
import org.xtuml.bp.mc.c.source.test.MCCSourceTest;

public class SetOperationsTest extends MCCSourceTest {

    @Override
    protected String getProjectName() {
        return "test_set_operations_5007";
    }

    @Test
    public void testSetOperations() throws Exception {
        // build the project
        buildProject();

        // execute application
        executeApplication( "src/set_ops_test", null, null );

        // compare with expected results
        assertEquals( "Output did not match expected results.", readProjectFile( "gen/expected_results.txt" ), getOutput() );
    }

    @Test
    public void testSetOperationsNoMcmc() throws Exception {
        // disable mcmc
        setMcmcEnabled( false );

        // build the project
        buildProject();

        // execute application
        executeApplication( "src/set_ops_test", null, null );

        // compare with expected results
        assertEquals( "Output did not match expected results.", readProjectFile( "gen/expected_results.txt" ), getOutput() );
    }

}
