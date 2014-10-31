/*
 * Copyright 2013 Blackboard, Inc.
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

package com.example.android.MosaicLinkLauncher;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

/*
 * Launches an app if it's installed on a device, otherwise redirects to the Google Play Store to download and install
 */

public class MainActivity extends Activity
{

  @Override
  protected void onCreate( Bundle savedInstanceState )
  {
    super.onCreate( savedInstanceState );

    //package name of the app on the google play store
    //you can find the package name in your AndroidManifest.xml file
    //to launch your own app, simply replace this string with your package name
    String packageName = "com.blackboard.android";

    //get the package manager to look up the package name
    PackageManager packageManager = getPackageManager();
    Intent intent = packageManager.getLaunchIntentForPackage( packageName );

    //if the intent is null then the app is not installed on the device, so launch the play store app
    if ( intent == null )
    {
      Intent intentMarket = new Intent( Intent.ACTION_VIEW, Uri.parse( "market://details?id=" + packageName ) );
      startActivity( intentMarket );
    }
    //otherwise it is installed, so let's start it!
    else
    {
      startActivity( intent );
    }
    
    //finish this launcher activity
    finish();
  }

}
