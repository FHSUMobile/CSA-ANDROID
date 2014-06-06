package com.FHSUMobile.csa;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class CommunicationActivity extends Activity implements AdapterView.OnItemClickListener {

	ListView Menu;// declare the listview item
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_communication);
		
		Menu = (ListView) findViewById(R.id.CommunicationListView); //connects our Menu object to our listview
		Menu.setOnItemClickListener(this);// set the itemoncliclistener for our Menu object
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.communication, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		//This b workin!
		
		/*0 Internet Access/Cable
		 *1 Cell Phone 
		 *2 Transportation
		 */
		Intent intent = new Intent(this, DisplayTxtActivity.class );//create an intent to launch activity

		
		switch(position)//position is the value of the position of the item in the Menu
		{
			case 0: intent.putExtra("fileName", "internet.txt");
			intent.putExtra("windowTitle", "Internet/Cable");
			startActivity(intent);//exicute dat intent
				break;
			case 1: intent.putExtra("fileName", "cellphones.txt");
			intent.putExtra("windowTitle", "Cell Phone");
			startActivity(intent);//exicute dat intent
				break;
			case 2:intent.putExtra("fileName", "internationalphone.txt");
			intent.putExtra("windowTitle", "International Phonecall");
			startActivity(intent);//exicute dat intent 
				break;
				
			default : ; //no activity for that Menu position, well then dont' do anything
			break;
		
		}
		
	}

}
