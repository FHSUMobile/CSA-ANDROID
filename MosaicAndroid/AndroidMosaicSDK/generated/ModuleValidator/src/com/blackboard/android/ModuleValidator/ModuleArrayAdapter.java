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

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.blackboard.android.ModuleValidatorLib.Module;

public class ModuleArrayAdapter extends ArrayAdapter<Module>
{
  private Context _context;
  private List<Module> _modules = new ArrayList<Module>();

  public ModuleArrayAdapter( Context context, int listItemId, List<Module> modules )
  {
    super( context, listItemId, modules );
    _context = context;
    _modules = modules;
  }

  public int getCount()
  {
    return _modules.size();
  }

  public Module getItem( int index )
  {
    return _modules.get( index );
  }

  public View getView( int position, View convertView, ViewGroup parent )
  {
    View row = convertView;
    if ( row == null )
    {
      LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService( Context.LAYOUT_INFLATER_SERVICE );
      row = inflater.inflate( R.layout.modules_listitem, parent, false );
    }

    // Get item
    Module module = getItem( position );

    // Get reference to module_icon and set it
    Drawable moduleIcon = loadDrawableFromStringId( module.getIconIdString() );
    ImageView moduleImageView = (ImageView) row.findViewById( R.id.module_image );
    moduleImageView.setImageDrawable( moduleIcon );

    // Get reference to module_name and set it
    String moduleName = loadStringFromStringId( module.getNameIdString() );
    TextView moduleTextView = (TextView) row.findViewById( R.id.module_name );
    moduleTextView.setText( moduleName );

    return row;
  }

  private String loadStringFromStringId( String idString )
  {
    int id = loadResId( idString, "string" );
    return _context.getResources().getString( id );
  }

  private Drawable loadDrawableFromStringId( String drawableString )
  {
    int id = loadResId( drawableString, "drawable" );
    return _context.getResources().getDrawable( id );
  }

  private int loadResId( String resourceHandle, String resType )
  {
    if ( _context != null )
    {
      return _context.getResources().getIdentifier( resourceHandle, resType, _context.getPackageName() );
    }
    else
    {
      Log.e( "ModuleValidator", "Context was null in loadResId" );
      return 0;
    }

  }
}
