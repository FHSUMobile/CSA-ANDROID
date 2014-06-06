package com.FHSUMobile.csa;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class DisplayTxtActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_txt);
	
		Bundle extras=getIntent().getExtras();
		TextView textView = (TextView) findViewById(R.id.displayTextTextView);
		
		setTitle(extras.getString("windowTitle"));
		textView.setText(Utilities.readDataFile(extras.getString("fileName"), getApplicationContext()));//sends text to the text view object
		//read data file gets the text from the file for you and returns it as text. This method needs the name of the .txt file and the application context
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_txt, menu);
		return true;
	}

}
