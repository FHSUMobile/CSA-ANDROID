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

package com.blackboard.android.ModuleValidator;

import java.io.InputStream;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockListActivity;
import com.blackboard.android.ModuleValidatorLib.Module;
import com.blackboard.android.ModuleValidatorLib.ModuleValidatorLib;

public class ModuleListActivity extends SherlockListActivity
{
  //list of sdk modules
  private List<Module> _modules;

  @Override
  protected void onCreate( Bundle savedInstanceState )
  {
    super.onCreate( savedInstanceState );    
            
    //get the modules from the modules.xml file
    InputStream moduleXmlStream = getResources().openRawResource( R.raw.sdkmodules );
    
    //set the title
    ActionBar ab = getSupportActionBar();
    String title = getResources().getString( R.string.app_name );
    ab.setTitle( title );
    
    try
    {
      //parse the modules into a list
      _modules = ModuleValidatorLib.parseModules( moduleXmlStream );      
    }
    catch (Exception e)
    {
      Log.e( "ModuleValidator", "Exception while parsing modules.xml: " + e );
      return;
    }
    
    //create the module adapter
    ModuleArrayAdapter moduleAdapter = new ModuleArrayAdapter(this, R.layout.modules_listitem, _modules);
     
    //set our list view's adapter
    getListView().setAdapter(moduleAdapter);
  }
  
  @Override
  protected void onListItemClick (ListView l, View v, int position, long id)
  {
    //get the selected module item
    Module selectedModule = (Module) l.getItemAtPosition( position );
    
    try
    { 
      //create the intent from the module's intent string
      Intent moduleIntent = Intent.getIntent( selectedModule.getIntentString() );
      
      //blank out the action
      moduleIntent.setAction( "" );
      
      //kick 'er off
      startActivity( moduleIntent );
    }
    catch (Exception e)
    {
      Log.e( "LauncherModule", "launchModule: Unable to launch module: " + e );
    }
  }

}
