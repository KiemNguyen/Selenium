package com.seleniumsimplified.junit.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Used to copy and paste to create a new suite!
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({

})
public class FailOnIEOnlySuiteTest {
    // tests still fail in IE 11 but only because the sendkeys is so slow
    // do not run your tests against IE11
    // keep your eyes open for an official Microsoft driver
}
