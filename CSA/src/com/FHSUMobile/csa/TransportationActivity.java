package com.FHSUMobile.csa;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class TransportationActivity extends Activity implements AdapterView.OnItemClickListener {

	ListView Menu;// declare the listview item
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_transportation);
		
		Menu = (ListView) findViewById(R.id.TransportationListView); //connects our Menu object to our listview
		Menu.setOnItemClickListener(this);// set the itemoncliclistener for our Menu object
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.transportation, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		//This b workin!
		
		/*0 Public Transportation
		 *1 Private Cars
		 *2 Travel Transportation
		 *3 Travel abroad or going home
		 *4 Important Tips
		 */
		Intent intent = new Intent(this, DisplayTxtActivity.class );//create an intent to launch activity
		
		switch(position)//position is the value of the position of the item in the Menu
		{
			case 0: intent.putExtra("fileName", "publictransportation.txt");
			intent.putExtra("windowTitle", "Public Transportation");
			startActivity(intent);//exicute dat intent
				break;
			case 1: intent.putExtra("fileName", "privatecars.txt");
			intent.putExtra("windowTitle", "Private Cars");
			startActivity(intent);//exicute dat intent
				break;
			case 2: intent.putExtra("fileName", "traveltransportation.txt");
			intent.putExtra("windowTitle", "Travel Transportation");
			startActivity(intent);//exicute dat intent
				break;
			case 3: intent.putExtra("fileName", "travelabroad.txt");
			intent.putExtra("windowTitle", "Travel Abroad");
			startActivity(intent);//exicute dat intent
				break;
			case 4: intent.putExtra("fileName", "tips.txt");
			intent.putExtra("windowTitle", "Importatn Tips");
			startActivity(intent);//exicute dat intent
				break;
			
			default : ; //no activity for that Menu position, well then dont' do anything
			break;
		
		}
		
	}

}
