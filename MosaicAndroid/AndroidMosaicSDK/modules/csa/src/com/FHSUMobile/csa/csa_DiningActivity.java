package com.FHSUMobile.csa;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.blackboard.android.MosaicSdk.Mosaic;

public class csa_DiningActivity extends Activity implements AdapterView.OnItemClickListener  {

	ListView onCampusMenu, offCampusMenu;// declare the listview item
	//AlertDialog.Builder dialog = new AlertDialog.Builder(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(Mosaic.getResId(this, Mosaic.LAYOUT_RESOURCE, "csa_activity_dining"));
		
		onCampusMenu = (ListView) findViewById(Mosaic.getResId(this, Mosaic.ID_RESOURCE, "csa_onCampusListView")); //connects our Menu object to our listview
		onCampusMenu.setOnItemClickListener(this);// set the itemoncliclistener for our Menu object
		
		offCampusMenu = (ListView) findViewById(Mosaic.getResId(this, Mosaic.ID_RESOURCE, "csa_offCampusListView")); //connects our Menu object to our listview
		offCampusMenu.setOnItemClickListener(this);// set the itemoncliclistener for our Menu object
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(Mosaic.getResId(this, Mosaic.MENU_RESOURCE, "csa_dining"), menu);
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
		
		Intent intent = new Intent(this, csa_DisplayTxtActivity.class );//create an intent to launch activity
		//Intent intent2 = new Intent(this, RestaurantInfoActivity.class );//create an intent to launch activity
		
		
		
		
		
		if(list.getId()==Mosaic.getResId(this, Mosaic.ID_RESOURCE, "csa_onCampusListView"))
		{
		
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
			
		}
			
		
		else if(list.getId()==Mosaic.getResId(this, Mosaic.ID_RESOURCE, "csa_offCampusListView"))
		{
			switch(position)
			{
			case 0:Dialog("Chinese Food Express", "1312 Main St.", "(785) 628-9999");
				break;
			case 1:Dialog("Gellas Diner & LB Brewing Co.", "117 E. 11th St.", "(785) 621-2739");
				break;
			case 2:Dialog("Gutchs Bar & Grill", "111 W. 7th St.", "(785) 623-4088");
				break;
			case 3:Dialog("Neighbars Bar & Grill", "507 W 7th St", "(785) 625-1774");
				break;
			case 4:Dialog("Taco Shop", "333 W. 8th St", "(785) 625-7114");
				break;
			case 5:Dialog("China Garden", "2503 Vine Street", "(785) 628-2280");
				break;
			case 6:Dialog("Lucky Buffet and Grocery", "2405 Vine Street", "(785) 621-2727");
   	   			break;
			case 7:Dialog("Chinese Grocery Store", "1501 Main Street", "(785) 432-1089");
  					
  					
  				break;
			default:;
				break;
			}
		
		}
		
		
	}
	
	public void Dialog(String name, final String address, final String phone)
	{
		
		
		
		AlertDialog.Builder dialogBox = new AlertDialog.Builder(this);
		dialogBox.setMessage(name+"\n"+address+"\n Hays KS, 67601");
		
		dialogBox.setPositiveButton(phone, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            	Intent callIntent = new Intent(Intent.ACTION_DIAL);
        	    callIntent.setData(Uri.parse("tel:"+phone));
        	    startActivity(callIntent);
            }
		});
		
		dialogBox.setNegativeButton("Directions", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
        		
        		Intent directionsIntent = new Intent(Intent.ACTION_VIEW);
        		directionsIntent.setData(Uri.parse("geo:0,0?q="+address));
        		
        		startActivity(directionsIntent);
            }
        });
		dialogBox.show();
		
	}
	
	

}
