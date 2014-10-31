package com.FHSUMobile.csa;

import java.io.*;
import android.app.Activity;
import android.content.Context;


public class csa_Utilities extends Activity// takes file name and application context and returns the contents of the file as a properly formatted sting
{
	public static String readDataFile(String fileName, Context context)
	{
		String temp, read=null;
		try
		{
			InputStreamReader inputReader=new InputStreamReader(context.getAssets().open(fileName));
			BufferedReader file = new BufferedReader(inputReader);
			
			while((temp=file.readLine())!=null)
			{
				if(read==null)
					read=temp;
				else
				read += temp;
				read += "\n";
			}
			file.close();
		}
		catch(FileNotFoundException e)
		{
			read= "Uh oh. Your file was not found!";
			e.printStackTrace();
			
		} 
		catch (IOException e) 
		{
			read="Woops, there was a problem.";
			e.printStackTrace();
			
		}

		return(read);
	}
	 

}
