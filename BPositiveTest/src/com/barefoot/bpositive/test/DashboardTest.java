package com.barefoot.bpositive.test;

import android.test.ActivityInstrumentationTestCase2;

import com.barefoot.bpositive.Dashboard;
import com.jayway.android.robotium.solo.Solo;

public class DashboardTest extends ActivityInstrumentationTestCase2<Dashboard> {

	private Solo solo;

	public DashboardTest() {
		super("com.barefoot.bpositive", Dashboard.class);
	}

	public void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	public void testDashboardPageOpensAsExpected() {
		boolean textFound = solo.searchText("Dashboard");
		assertEquals(false, textFound);
	}
	
	public void tearDown() throws Exception {
		try {
			solo.finalize();
		} catch(Throwable e) {
			e.printStackTrace();
		}
		getActivity().finish();
		super.tearDown();
	}

}
