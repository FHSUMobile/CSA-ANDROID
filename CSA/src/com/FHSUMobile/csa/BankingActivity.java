package com.FHSUMobile.csa;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.*;//required for  AdapterView.OnItemClickListener

public class BankingActivity extends Activity implements AdapterView.OnItemClickListener{

	ListView Menu;// declare the listview item
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_banking);
		
		Menu = (ListView) findViewById(R.id.bankingListView); //connects our Menu object to our listview
		Menu.setOnItemClickListener(this);// set the itemoncliclistener for our Menu object
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.banking, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		/*0 Banks around the City
		 *1 Checking Account
		 *2 Credit Card
		 *3 Money transfer from china
		 */
		
		Intent intent = new Intent(this, DisplayTxtActivity.class );//create an intent to launch activity

		switch(position)//position is the value of the position of the item in the Menu
		{
			case 0:intent.putExtra("fileName", "banks.txt");
			intent.putExtra("windowTitle", "Banks Around the City");
			startActivity(intent);//exicute dat intent
				break;
			case 1:intent.putExtra("fileName", "checkingaccount.txt");
			intent.putExtra("windowTitle", "Checking Account");
			startActivity(intent);//exicute dat intent 
				break;
			case 2:intent.putExtra("fileName", "creditcard.txt");
			intent.putExtra("windowTitle", "Credit Card");
			startActivity(intent);//exicute dat intent 
				break;
			case 3:intent.putExtra("fileName", "moneytransfer.txt");
			intent.putExtra("windowTitle", "Money Transfer from Chine");
			startActivity(intent);//exicute dat intent 
				break;	
			default : ; //no activity for that Menu position, well then dont' do anything
			break;
		
		}
		
	}

}
