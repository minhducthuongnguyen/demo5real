package com.example.demo5real;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	int point=0;
	
	Vibrator v;
	
	CountDownTimer cd;
	
	int[] colorlist= {0xFFFF0066,0xFF3366FF,0xff00CC00,0xffCC00CC,0xffFF0000,0xff00FFFF,0xff996633,0xff660066,0xff339933};
	
	boolean game=true;
	
	Button b1;
	Button b2;
	Button b3;
	Button b4;
	Button b5;
	Button b6;
	Button b7;
	Button b8;
	Button b9;
	Button b10;
	TextView tv1;
	TextView tv3;
	Random random1;
	Random random2;
	Random random3;
	Random random4;
	Random random5;
	Random random6;
	Random random7;
	Random random8;
	Random random9;
	Random random10;
	
	int score;
	int r1;
	int r2;
	int r3;
	int r4;
	int r5;
	int r6;
	int r7;
	int r8;
	int r9;
	int r10;
	TextView tv2;

	@Override
	public void onBackPressed() {};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv2=(TextView)findViewById(R.id.textView2);
		
		tv3=(TextView)findViewById(R.id.textView3);
		cd=new CountDownTimer(1500, 1) {

			 public void onTick(long millisUntilFinished) {
			     tv2.setText("" + millisUntilFinished / 1000+":"+millisUntilFinished%1000);
			 }

			 public void onFinish() {
				 
				 
				 
				 Context context = getApplicationContext();
				
				 Intent intent=new Intent(context, Score.class);
				 intent.putExtra("thepoint", point);
				 if (game==true){
					 game=false;
					 startActivityForResult(intent,0);
					 
				 }
				 
					 
			 }
			};
			//cd.start();
		
		
		
		random1 = new Random();
		random2 = new Random();
		random3 = new Random();
		random4 = new Random();
		random5 = new Random();
		random6 = new Random();
		random7 = new Random();
		random8 = new Random();
		random9 = new Random();
		random10 = new Random();
		
		//create vibrator
		v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);		
		//random all the buttons
		randomize();
		
		//create textview 
		tv1=(TextView)findViewById(R.id.textView1);
		
		
		
		//get best score
		SharedPreferences prefs = this.getSharedPreferences("highscore", Context.MODE_PRIVATE);
		score = prefs.getInt("thescore", 0); 
		
		tv3.setText("Best: "+score);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	int color1,color2,color3,color4,color5,color6,color7,color8,color9,color10;
	public void gameon(View ClickedButton){
		//vibrate
		v.vibrate(100);
		
		//get button color
		Drawable background1 = b1.getBackground();
        if (background1 instanceof ColorDrawable){
        	color1 = ((ColorDrawable) background1).getColor();
        	}
		
        Drawable background2 = b2.getBackground();
        if (background2 instanceof ColorDrawable){
        	color2 = ((ColorDrawable) background2).getColor();
        	}
        
        Drawable background3 = b3.getBackground();
        if (background3 instanceof ColorDrawable){
        	color3 = ((ColorDrawable) background3).getColor();
        	}
        
        Drawable background4 = b4.getBackground();
        if (background4 instanceof ColorDrawable){
        	color4 = ((ColorDrawable) background4).getColor();
        	}
        
        Drawable background5 = b5.getBackground();
        if (background5 instanceof ColorDrawable){
        	color5 = ((ColorDrawable) background5).getColor();
        	}
        
        Drawable background6 = b6.getBackground();
        if (background6 instanceof ColorDrawable){
        	color6 = ((ColorDrawable) background6).getColor();
        	}
        
        Drawable background7 = b7.getBackground();
        if (background7 instanceof ColorDrawable){
        	color7 = ((ColorDrawable) background7).getColor();
        	}
        
        Drawable background8 = b8.getBackground();
        if (background8 instanceof ColorDrawable){
        	color8 = ((ColorDrawable) background8).getColor();
        	}
        
        Drawable background9 = b9.getBackground();
        if (background9 instanceof ColorDrawable){
        	color9 = ((ColorDrawable) background9).getColor();
        	}
        
        Drawable background10 = b10.getBackground();
        if (background10 instanceof ColorDrawable){
        	color10 = ((ColorDrawable) background10).getColor();
        	}
        
        ////.check button
        if (((b2.isPressed())&&(color1==color2))||
        	((b3.isPressed())&&(color1==color3))||
        	((b4.isPressed())&&(color1==color4))||
        	((b5.isPressed())&&(color1==color5))||
        	((b6.isPressed())&&(color1==color6))||
        	((b7.isPressed())&&(color1==color7))||
        	((b8.isPressed())&&(color1==color8))||
        	((b9.isPressed())&&(color1==color9))||
        	((b10.isPressed())&&(color1==color10)))
        	
        	{point=point+1;
        	tv1.setText(""+point);
        	if(point>score)
        		tv3.setText("Best: "+point);
        	cd.cancel();
        	cd.start();
        	
        	randomize();}
        else{
        	Context context = getApplicationContext();
			
			 Intent intent=new Intent(context, Score.class);
			 intent.putExtra("thepoint", point);
			 if (game==true){
				 game=false;
				 startActivityForResult(intent,0);
				 
			 }
        	}
        
        
        
        
        
	}
	public void randomize(){
		b1=(Button)findViewById(R.id.button1);
		r1=random1.nextInt(9);
		b1.setBackgroundColor(colorlist[r1]);
		
		
		b2=(Button)findViewById(R.id.button2);
		r2=random2.nextInt(9);
		b2.setBackgroundColor(colorlist[r2]);
		
		b3=(Button)findViewById(R.id.button3);
		r3=random3.nextInt(9);
		while (r3==r2)
			r3=random3.nextInt(9);
		b3.setBackgroundColor(colorlist[r3]);
		
		b4=(Button)findViewById(R.id.button4);
		r4=random4.nextInt(9);
		while ((r4==r2)||(r4==r3))
			r4=random4.nextInt(9);
		b4.setBackgroundColor(colorlist[r4]);
		
		b5=(Button)findViewById(R.id.button5);
		r5=random5.nextInt(9);
		while ((r5==r4)||(r5==r2)||(r5==r3))
			r5=random5.nextInt(9);
		b5.setBackgroundColor(colorlist[r5]);
		
		b6=(Button)findViewById(R.id.button6);
		r6=random6.nextInt(9);
		while ((r6==r5)||(r6==r4)||(r6==r3)||(r6==r2))
			r6=random6.nextInt(9);
		b6.setBackgroundColor(colorlist[r6]);
		
		b7=(Button)findViewById(R.id.button7);
		r7=random7.nextInt(9);
		while ((r7==r6)||(r7==r5)||(r7==r4)||(r7==r3)||(r7==r2))
			r7=random7.nextInt(9);
		b7.setBackgroundColor(colorlist[r7]);
		
		b8=(Button)findViewById(R.id.button8);
		r8=random8.nextInt(9);
		while ((r8==r7)||(r8==r6)||(r8==r5)||(r8==r4)||(r8==r3)||(r8==r2))
			r8=random8.nextInt(9);
		b8.setBackgroundColor(colorlist[r8]);
		
		b9=(Button)findViewById(R.id.button9);
		r9=random9.nextInt(9);
		while ((r9==r8)||(r9==r7)||(r9==r6)||(r9==r5)||(r9==r4)||(r9==r3)||(r9==r2))
			r9=random9.nextInt(9);
		b9.setBackgroundColor(colorlist[r9]);
		
		b10=(Button)findViewById(R.id.button10);
		r10=random10.nextInt(9);
		while ((r10==r9)||(r10==r8)||(r10==r7)||(r10==r6)||(r10==r5)||(r10==r4)||(r10==r3)||(r10==r2))
			r10=random10.nextInt(9);
		b10.setBackgroundColor(colorlist[r10]);
		
	}
}
