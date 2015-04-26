package be.odisee.pajottertest;

import junit.framework.Test;
import junit.framework.TestSuite;

public class TestenSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(TestTelerToevoegen.class);
		suite.addTestSuite(TestTelerUpdate.class);
		suite.addTestSuite(TestTelerVerwijderen.class);
		return suite;
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}
