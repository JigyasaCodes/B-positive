package com.barefoot.bpositive.db.test;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.test.ActivityInstrumentationTestCase2;

import com.barefoot.bpositive.Dashboard;
import com.barefoot.bpositive.db.BPositiveDatabase;
import com.barefoot.bpositive.db.DonorTable;
import com.barefoot.bpositive.db.FitnessTable;
import com.barefoot.bpositive.db.Table;
import com.barefoot.bpositive.models.Donor;
import com.barefoot.bpositive.models.Fitness;

public class FitnessTableTest extends ActivityInstrumentationTestCase2<Dashboard> {
	private BPositiveDatabase testDBInstance;
	private SQLiteDatabase db;
	private Table<Fitness> fitnessTable;
	private Table<Donor> donorTable;
	private Donor testDonor;
	
	public FitnessTableTest() {
		super("com.barefoot.bpositive", Dashboard.class);
	}
	
	public void setUp() throws Exception {
		testDBInstance = new BPositiveDatabase(getActivity(), "BPOSITIVE_TEST");
		fitnessTable = new FitnessTable(testDBInstance);
		donorTable = new DonorTable(testDBInstance);
		db = testDBInstance.getWritableDatabase();
		
		testDonor = donorTable.create(new Donor(-1, "Jimmy","Hendrix","24-07-1982","B+"));
	}
	
	public void testCreationOfNewFitnessRecord() {
		
	}
		
	public void tearDown() throws Exception {
		dbCleanup("DELETE FROM FITNESS;");
		dbCleanup("DELETE FROM DONORS;");
		
		try {
			//to compress the unused space and clean pages left after cleaning tables
			db.execSQL("VACUUM;");
		} catch(SQLException sqle) {
			fail();
			sqle.printStackTrace();
		} finally {
			testDBInstance.close();
		}
		
		getActivity().finish();
		super.tearDown();
	}
	
	//Since android doesn't provide db transaction methods, we'll clean up db ourselves
	//This is dependent on real code which it shouldn't be but for now I think it's ok.
	private void dbCleanup(final String sqlStatement) {
		db.beginTransaction();
		try {
			db.execSQL(sqlStatement);
			db.setTransactionSuccessful();
		} catch(SQLException sqle) {
			sqle.printStackTrace();
			fail();
		}finally {
			db.endTransaction();
		}
	}
}
