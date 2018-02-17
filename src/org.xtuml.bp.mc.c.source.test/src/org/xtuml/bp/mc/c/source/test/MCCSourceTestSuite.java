package org.xtuml.bp.mc.c.source.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.xtuml.bp.mc.c.source.test.sets.SetOperationsTest;

import junit.framework.TestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    SetOperationsTest.class
})

public class MCCSourceTestSuite extends TestSuite {
}
