package asd.dsa.namespace;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;


public class AsdActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        String FILENAME = "hello_file.txt";
		String string = "1234" ;

		FileOutputStream fos = null;
		try {
			fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fos.write(string.getBytes());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileInputStream fstream = null;
		try {
			fstream = openFileInput("hello_file.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			fstream.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    byte[] buffer;
	    String strLine;
	    try{
	    	buffer = new byte[fstream.available()];
			while (fstream.read(buffer) != -1);
	        strLine = new String(buffer);
	        
	        Debug("text: " + strLine);
	       
	        
	    }catch (Exception e){//Catch exception if any
	    Debug("Error: " + e.getMessage());
	    }
	
	    try {
			fstream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static void Debug(String debug) {
		Log.d("GameTest01", debug);
	}
}