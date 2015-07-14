package com.example.demo5real;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Mainmenu extends Activity {
	Vibrator v;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainmenu);
		v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mainmenu, menu);
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
	
	public void Start(View ClickedButton){
		v.vibrate(50);
		Intent intent=new Intent(ClickedButton.getContext(), MainActivity.class);
		startActivityForResult(intent,0);
	}
	public void Ultimate(View ClickedButton){
		v.vibrate(50);
		Intent intent=new Intent(ClickedButton.getContext(), Color.class);
		startActivityForResult(intent,0);
	}
	public void Secret(View ClickedButton){
		v.vibrate(50);
		Intent intent=new Intent(ClickedButton.getContext(), Secret.class);
		startActivityForResult(intent,0);
	}
}
