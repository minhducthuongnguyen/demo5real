package com.example.demo5real;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Word extends Activity {
	int[] colorlist= {0xFF1E90FF,0xFF2E8B57,0xff990000};
	String[] wordlist={"blu","grn","red"};
	Button b1;
	Button b2;
	Button b3;
	Random random;
	int randint;
	int randstr;
	Vibrator v;
	CountDownTimer cd;
	TextView tv1,tv2,tv3,tv4;
	int color1,color2,color3,wscore;
	int point=0;		
	boolean game=true;		
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_word);
		
		//textview set
		tv1=(TextView)findViewById(R.id.textView1);
		tv2=(TextView)findViewById(R.id.textView2);
		tv3=(TextView)findViewById(R.id.textView3);
		tv4=(TextView)findViewById(R.id.textView4);
		
		//Button set
		b1=(Button)findViewById(R.id.button1);
		b2=(Button)findViewById(R.id.button2);
		b3=(Button)findViewById(R.id.button3);
		
		//vibrator set
		v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);	
		
		//randomize
		randomize();
		
		//get best score
		SharedPreferences prefs = this.getSharedPreferences("whighscore", Context.MODE_PRIVATE);
		wscore = prefs.getInt("wscore", 0); 
		tv3.setText("Best: "+wscore);
				
		//time countdown
		cd=new CountDownTimer(1000, 1) {

			 public void onTick(long millisUntilFinished) {
			     tv4.setText("" + millisUntilFinished / 1000+":"+millisUntilFinished%1000);
			 }
			 public void onFinish() {
				 Context context = getApplicationContext();
				 Intent intent=new Intent(context, WScore.class);
				 intent.putExtra("wpoint", point);
				 if (game==true){
					 game=false;
					 startActivityForResult(intent,0);}}};
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.word, menu);
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
	@Override
	public void onBackPressed() {};
	
	public void randomize(){
		random=new Random();
		randint=random.nextInt(3);
		randstr=random.nextInt(3);
		tv1.setText(wordlist[randstr]);
		tv1.setTextColor(colorlist[randint]);}
	
	public void play(View CLickedButton){
		v.vibrate(100);
		if (((b1.isPressed())&&(wordlist[randstr].equals("grn")))||
	        	((b2.isPressed())&&(wordlist[randstr].equals("red"))||
	        	((b3.isPressed())&&(wordlist[randstr].equals("blu"))))){
			point=point+1;
        	tv2.setText(""+point);
        	if(point>wscore)
        		tv3.setText("Best: "+point);
        	cd.cancel();
        	cd.start();
        	randomize();}
		else{
        	Context context = getApplicationContext();
			
			 Intent intent=new Intent(context, WScore.class);
			 intent.putExtra("wpoint", point);
			 if (game==true){
				 game=false;
				 startActivityForResult(intent,0);
		}}}}
	
	
	

