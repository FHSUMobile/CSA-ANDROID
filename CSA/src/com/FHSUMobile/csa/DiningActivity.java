package com.FHSUMobile.csa;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class DiningActivity extends Activity implements AdapterView.OnItemClickListener {

	ListView onCampusMenu, offCampusMenu;// declare the listview item
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dining);
		
		onCampusMenu = (ListView) findViewById(R.id.onCampusListView); //connects our Menu object to our listview
		onCampusMenu.setOnItemClickListener(this);// set the itemoncliclistener for our Menu object
		
		offCampusMenu = (ListView) findViewById(R.id.offCampusListView); //connects our Menu object to our listview
		offCampusMenu.setOnItemClickListener(this);// set the itemoncliclistener for our Menu object
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dining, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> list, View arg1, int position, long arg3) {
		
		/*
		 * 	On Campus
		 * 0 McMindes Hall Cafeteria
		 * 1 Food Court Union Station
		 * 
		 * 	Off Campus
		 * 0 Chinese Food Express
		 * 1 Gellas Diner & LB Brewing Co.
		 * 2 Gutch's Bar & Grill
		 * 3 Neighbars Bar & Grill
		 * 4 Taco Shop
		 * 5 China Garden
		 * 6 Lucky Buffet and Grocery 
		 * 7 Chinese Grocery
		 */
		
		Intent intent = new Intent(this, DisplayTxtActivity.class );//create an intent to launch activity
		Intent intent2 = new Intent(this, RestaurantInfoActivity.class );//create an intent to launch activity
		
		
		switch(list.getId())
		{
		case R.id.onCampusListView: 
			switch(position)
			{
			case 0: intent.putExtra("fileName", "mcmindes.txt");
			intent.putExtra("windowTitle", "McMindes");
			startActivity(intent);//exicute dat intent
				break;
			case 1:	intent.putExtra("fileName", "union.txt");
			intent.putExtra("windowTitle", "Memorial Union");
			startActivity(intent);//exicute dat intent
				break;
			default:;
				break;
			}
			break;
		case R.id.offCampusListView: 
			switch(position)
			{
			case 0:intent2.putExtra("name", "Chinese Food Express");
				   intent2.putExtra("lat", 38.873699);
				   intent2.putExtra("long", -99.329136);
				   intent2.putExtra("phoneNumber", "(785) 628-9999");
				   intent2.putExtra("Address", "1312 Main St.");
				   startActivity(intent2);
				break;
			
			case 1:intent2.putExtra("name", "Gellas Diner & LB Brewing Co.");
			   	   intent2.putExtra("lat", 38.872926);
			       intent2.putExtra("long", -99.329989);
			       intent2.putExtra("phoneNumber", "(785) 621-2739");
			       intent2.putExtra("Address", "117 E. 11th St.");
				   startActivity(intent2);
				break;
			case 2:intent2.putExtra("name", "Gutchs Bar & Grill");
			   	   intent2.putExtra("lat", 38.870003);
			       intent2.putExtra("long", -99.332167);
			       intent2.putExtra("phoneNumber", "(785) 623-4088");
			       intent2.putExtra("Address", "111 W. 7th St.");
				   startActivity(intent2);
				break;
			case 3:intent2.putExtra("name", "Neighbars Bar & Grill");
		   	   	   intent2.putExtra("lat", 38.873093);
		   	   	   intent2.putExtra("long", -99.338894);
		   	   	   intent2.putExtra("phoneNumber", "(785) 625-1774");
		   	   	   intent2.putExtra("Address", "507 W 7th St");
		   	   	   startActivity(intent2);
				break;
			case 4: intent2.putExtra("name", "Taco Shop");
		   	   	  	intent2.putExtra("lat", 38.872642);
		   	   	  	intent2.putExtra("long", -99.335053);
		   	   	  	intent2.putExtra("phoneNumber", "(785) 625-7114");
		   	   	  	intent2.putExtra("Address", "333 W. 8th St");
		   	   	  	startActivity(intent2);
				break;
			case 5: intent2.putExtra("name", "China Garden");
		   	   		intent2.putExtra("lat", 38.881642);
		   	   		intent2.putExtra("long", -99.317801);
		   	   		intent2.putExtra("phoneNumber", "(785) 628-2280");
		   	   		intent2.putExtra("Address", "2503 Vine Street");
		   	   		startActivity(intent2);
				break;
			case 6: intent2.putExtra("name", "Lucky Buffet and Grocery");
   	   				intent2.putExtra("lat", 38.881212);
   	   				intent2.putExtra("long", -99.318115);
   	   				intent2.putExtra("phoneNumber", "(785) 621-2727");
   	   				intent2.putExtra("Address", "2405 Vine Street");
   	   				startActivity(intent2);
   	   			break;
			case 7: intent2.putExtra("name", "Chinese Grocery Store");
  					intent2.putExtra("lat", 38.875589);
  					intent2.putExtra("long", -99.328499);
  					intent2.putExtra("phoneNumber", "(785) 432-1089");
  					intent2.putExtra("Address", "1501 Main Street");
  					startActivity(intent2);
  				break;
			default:;
				break;
			}
			
		default:;
			break;
		}
		
		
	}
	

}
