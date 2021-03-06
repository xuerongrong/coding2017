package com.coderising.myood.litejunit.liuxinv2.extension;


import com.coderising.myood.litejunit.liuxinv2.Protectable;
import com.coderising.myood.litejunit.liuxinv2.Test;
import com.coderising.myood.litejunit.liuxinv2.TestResult;

/**
 * A Decorator to set up and tear down additional fixture state.
 * Subclass TestSetup and insert it into your tests when you want
 * to set up additional state once before the tests are run.
 */
public class TestSetup extends TestDecorator {

	public TestSetup(Test test) {
		super(test);
	}
	public void run(final TestResult result) {
		Protectable p= new Protectable() {
			public void protect() throws Exception {
				setUp();
				basicRun(result);
				tearDown();
			}
		};
		result.runProtected(this, p);
	}
	/**
	 * Sets up the fixture. Override to set up additional fixture
	 * state.
	 */
	protected void setUp() throws Exception {
	}
	/**
	 * Tears down the fixture. Override to tear down the additional
	 * fixture state.
	 */
	protected void tearDown() throws Exception {
	}
}