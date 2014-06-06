package com.FHSUMobile.csa;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RestaurantInfoActivity extends Activity {
	
	
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_restaurant_info);
		
		Bundle extras = getIntent().getExtras(); 
		 
		GoogleMap map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
		        .getMap();
		
		Button phoneButton = (Button)findViewById(R.id.phoneNumberButton);
		
		TextView address = (TextView)findViewById(R.id.restaurantTextView);
		
		phoneButton.setText(extras.getString("phoneNumber"));
		
		final LatLng RESTAURANT = new LatLng(extras.getDouble("lat"), extras.getDouble("long"));
		
		
		
		setTitle(extras.getString("name"));
		
		address.setText(extras.getString("Address")+"\n Hays Ks, 67601");
		
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(RESTAURANT, 18));
		
		map.addMarker(new MarkerOptions().position(RESTAURANT).title(extras.getString("name")));
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.restaurant_info, menu);
		return true;
	}
	
	public void callRestaurant(View view)
	{
		Button button= (Button)view;
		
		Intent callIntent = new Intent(Intent.ACTION_DIAL);
	    callIntent.setData(Uri.parse("tel:"+button.getText().toString()));
	    startActivity(callIntent);
		
	}
	
	public void getDirections(View view)
	{
		Bundle extras = getIntent().getExtras(); 
		
		String address= extras.getString("Address")+" Hays Ks, 67601";
		
		Intent directionsIntent = new Intent(Intent.ACTION_VIEW);
		directionsIntent.setData(Uri.parse("geo:0,0?q="+address));
		
		startActivity(directionsIntent);
	
	}

}
