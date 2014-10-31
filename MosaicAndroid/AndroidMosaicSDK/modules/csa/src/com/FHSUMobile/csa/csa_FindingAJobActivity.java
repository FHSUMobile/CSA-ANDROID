package com.FHSUMobile.csa;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.*;

import com.blackboard.android.MosaicSdk.Mosaic;

public class csa_FindingAJobActivity extends Activity implements AdapterView.OnItemClickListener  {

	
	ListView Menu;// declare the listview item
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(Mosaic.getResId(this, Mosaic.LAYOUT_RESOURCE, "csa_activity_finding_ajob"));
		
		Menu = (ListView) findViewById(Mosaic.getResId(this, Mosaic.ID_RESOURCE, "csa_FindingAJobListView")); //connects our Menu object to our listview
		Menu.setOnItemClickListener(this);// set the itemoncliclistener for our Menu object
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(Mosaic.getResId(this, Mosaic.MENU_RESOURCE, "csa_finding_ajob"), menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		/*0 jobX
		 *1 legal information
		 */
		Intent intent = new Intent(this, csa_DisplayTxtActivity.class );//create an intent to launch activity

		
		switch(position)//position is the value of the position of the item in the Menu
		{
			case 0: intent.putExtra("fileName", "jobx.txt");
			intent.putExtra("windowTitle", "JobX");
			startActivity(intent);//exicute dat intent
				break;
			case 1: intent.putExtra("fileName", "legalinformation.txt");
			intent.putExtra("windowTitle", "Legal Information");
			startActivity(intent);//exicute dat intent
				break;	
			default : ; //no activity for that Menu position, well then dont' do anything
			break;
		
		}
		
	}

}
