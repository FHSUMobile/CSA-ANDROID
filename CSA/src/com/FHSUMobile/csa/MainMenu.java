package com.FHSUMobile.csa;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.*;//required for  AdapterView.OnItemClickListener

public class MainMenu extends Activity implements AdapterView.OnItemClickListener {
	
	ListView Menu;// declare the listview item

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		
		Menu = (ListView) findViewById(R.id.mainMenuListView); //connects our Menu object to our listview
		Menu.setOnItemClickListener(this);// set the itemoncliclistener for our Menu object
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
		//This b workin!
		
		/*0 Dining 
		 *1 Communication 
		 *2 Transportation
		 *3 Finding a Job
		 *4 Protecting yourself
		 *5 Banking
		 *6 Visa Information
		 *7 Contact CSA  
		 */
		
		switch(position)//position is the value of the position of the item in the Menu
		{
			case 0: Intent intent = new Intent(this, DiningActivity.class );//create an intent to launch activity
			startActivity(intent);//exicute dat intent
				break;
			case 1: Intent intent1 = new Intent(this, CommunicationActivity.class );//create an intent to launch activity
			startActivity(intent1);//exicute dat intent
				break;
			case 2: Intent intent2 = new Intent(this, TransportationActivity.class );//create an intent to launch activity
			startActivity(intent2);//exicute dat intent
				break;
			case 3: Intent intent3 = new Intent(this, FindingAJobActivity.class );//create an intent to launch activity
			startActivity(intent3);//exicute dat intent
				break;
			case 4: Intent intent4 = new Intent(this, ProtectingYourselfActivity.class );//create an intent to launch activity
			startActivity(intent4);//exicute dat intent
				break;
			case 5: Intent intent5 = new Intent(this, BankingActivity.class );//create an intent to launch activity
			startActivity(intent5);//exicute dat intent
				break;
			case 6: Intent intent6 = new Intent(this, VisaInformationActivity.class );//create an intent to launch activity
			startActivity(intent6);//exicute dat intent
				break;
			case 7: Intent intent7 = new Intent(this, DisplayTxtActivity.class );//create an intent to launch activity
			intent7.putExtra("fileName", "contact.txt");
			intent7.putExtra("windowTitle", "Contact");
			startActivity(intent7);//exicute dat intent
				break;
				
				
			default : ; //no activity for that Menu position, well then dont' do anything
			break;
		
		}
		
		
	}
	
	

}
