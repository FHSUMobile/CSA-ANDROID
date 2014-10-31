/*
 * Copyright 2013 Blackboard Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.example.android.HelloWorld;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.blackboard.android.MosaicSdk.Mosaic;

public class MainActivity extends Activity
{

  @Override
  protected void onCreate( Bundle savedInstanceState )
  {
    super.onCreate( savedInstanceState );    

    //use the Mosaic SDK library function to get the id of the resource at runtime through reflection
    //note that resource names are prefixed with the project name to ensure uniqueness
    //once you have the id, you can use it exactly as you normally would
    
    //let's get a string resource that says "Hello Mosaic!"
    int helloMosaicStringId = Mosaic.getResId( this, Mosaic.STRING_RESOURCE, "helloworld_hellomosaic" );
        
    //use the id as you normally would, for example in a toast message
    String toastString = getResources().getString( helloMosaicStringId );
    Toast.makeText( this, toastString, Toast.LENGTH_LONG ).show();
    
    //to get a layout id, use the same mechanism
    int helloMosaicLayoutId = Mosaic.getResId(this, Mosaic.LAYOUT_RESOURCE, "helloworld_hellomosaic");
    setContentView( helloMosaicLayoutId );
    
    //same with finding an id within a layout
    int textviewId = Mosaic.getResId( this, Mosaic.ID_RESOURCE, "helloworld_textview" );
    TextView textview = (TextView) findViewById( textviewId );
    
    //set the text just as you'd expect
    textview.setText( helloMosaicStringId );
  }

}
