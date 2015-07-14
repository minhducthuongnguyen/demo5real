package com.example.demo5real;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Color extends Activity {
	Vibrator v;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_color);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.color, menu);
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
	public void Back(View ClickedButton){
		v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);	
		v.vibrate(50);
		Intent intent=new Intent(ClickedButton.getContext(), Mainmenu.class);
		startActivityForResult(intent,0);
	}
	
	public void Red(View ClickedButton){
		v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);	
		v.vibrate(50);
		Intent intent=new Intent(ClickedButton.getContext(), Red.class);
		startActivityForResult(intent,0);
	}
	
	
	public void Green(View ClickedButton){
		v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);	
		v.vibrate(50);
		Intent intent=new Intent(ClickedButton.getContext(), Green.class);
		startActivityForResult(intent,0);
	}
	
	public void Blue(View ClickedButton){
		v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);	
		v.vibrate(50);
		Intent intent=new Intent(ClickedButton.getContext(), Blue.class);
		startActivityForResult(intent,0);
	}
}
