package com.FHSUMobile.csa;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.*;//required for  AdapterView.OnItemClickListener


public class VisaInformationActivity extends Activity implements AdapterView.OnItemClickListener {

	ListView Menu;// declare the listview item
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_visa_information);
		
		Menu = (ListView) findViewById(R.id.visaInformationListView); //connects our Menu object to our listview
		Menu.setOnItemClickListener(this);// set the itemoncliclistener for our Menu object
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.visa_information, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		/*0 Obtain a Student Visa
		 *1 Renew your student Visa
		 *2 Dependent Visa
		 */
		Intent intent = new Intent(this, DisplayTxtActivity.class );//create an intent to launch activity
		
		switch(position)//position is the value of the position of the item in the Menu
		{
			case 0: intent.putExtra("fileName", "studentvisa.txt");
			intent.putExtra("windowTitle", "Obtain a Student Visa");
			startActivity(intent);//exicute dat intent
				break;
			case 1: intent.putExtra("fileName", "renewvisa.txt");
			intent.putExtra("windowTitle", "Renew your Student Visa");
			startActivity(intent);//exicute dat intent
				break;
			case 2: intent.putExtra("fileName", "dependantvisa.txt");
			intent.putExtra("windowTitle", "Dependant Visa");
			startActivity(intent);//exicute dat intent
				break;	
			default : ; //no activity for that Menu position, well then dont' do anything
			break;
		
		}
		
	}

}
