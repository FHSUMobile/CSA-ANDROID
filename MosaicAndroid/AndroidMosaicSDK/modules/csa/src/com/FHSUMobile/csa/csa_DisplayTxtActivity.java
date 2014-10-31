package com.FHSUMobile.csa;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

import com.blackboard.android.MosaicSdk.Mosaic;

public class csa_DisplayTxtActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(Mosaic.getResId(this, Mosaic.LAYOUT_RESOURCE, "csa_activity_display_txt"));
	
		Bundle extras=getIntent().getExtras();
		TextView textView = (TextView) findViewById(Mosaic.getResId(this, Mosaic.ID_RESOURCE, "csa_displayTextTextView"));
		
		setTitle(extras.getString("windowTitle"));
		textView.setText(csa_Utilities.readDataFile(extras.getString("fileName"), getApplicationContext()));//sends text to the text view object
		//read data file gets the text from the file for you and returns it as text. This method needs the name of the .txt file and the application context
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(Mosaic.getResId(this, Mosaic.MENU_RESOURCE, "csa_display_txt"), menu);
		return true;
	}

}
