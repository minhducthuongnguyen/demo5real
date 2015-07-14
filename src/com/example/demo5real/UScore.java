package com.example.demo5real;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class UScore extends Activity {
	Vibrator v;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_uscore);
		Intent a=getIntent();
		int thePoint= a.getIntExtra("thepoint", 0);
		v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);	
		
		TextView theGreet= (TextView) findViewById(R.id.textView3);
		
		SharedPreferences prefs = this.getSharedPreferences("ulhighscore", Context.MODE_PRIVATE);
		int score = prefs.getInt("ulthescore", 0); 
		
		if((thePoint>score)&&(thePoint!=0)){
			theGreet.setText("ULTIMATE\nHIGHSCORE!!\n\n\n"+thePoint);
			Editor editor = prefs.edit();
			editor.putInt("ulthescore", thePoint);
			editor.commit();}
		
		else
			theGreet.setText("ULTIMATE\nGAMEOVER!\n\n\n"+thePoint);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.uscore, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void Ret(View ClickedButton){
		v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);	
		v.vibrate(100);
		Context context = getApplicationContext();
		Intent intent=new Intent(context, Mainmenu.class);
		startActivityForResult(intent,0);
		
	}
}
