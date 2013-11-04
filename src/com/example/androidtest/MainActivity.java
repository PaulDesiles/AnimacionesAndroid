package com.example.androidtest;

import android.os.Bundle;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View.OnTouchListener;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends Activity {
	  private Button bt1 = null;
	  private Button bt2 = null;
	  private Button bt3 = null;
	  private Button bt4 = null;
	  private LinearLayout l = null;
	  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bt1 = (Button) findViewById(R.id.button1);
		bt2 = (Button) findViewById(R.id.button2);
		bt3 = (Button) findViewById(R.id.button3);
		bt4 = (Button) findViewById(R.id.button4);
		l = (LinearLayout) findViewById(R.id.linearLayout1);
		
	    bt1.setOnTouchListener( new OnTouchListener() {
		    	public boolean onTouch(View arg0, MotionEvent arg1) {
		    		miAnimacion(1);
		    		return false;
		    	}
	    	}
	    );
	    bt2.setOnTouchListener( new OnTouchListener() {
		    	public boolean onTouch(View arg0, MotionEvent arg1) {
		    		miAnimacion(2);
		    		return false;
		    	}
	    	}
	    );
	    bt3.setOnTouchListener( new OnTouchListener() {
		    	public boolean onTouch(View arg0, MotionEvent arg1) {
		    		miAnimacion(3);
		    		return false;
		    	}
	    	}
	    );
	    bt4.setOnTouchListener( new OnTouchListener() {
		    	public boolean onTouch(View arg0, MotionEvent arg1) {
		    		miAnimacion(4);
		    		return false;
		    	}
			}
		);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	public void miAnimacion(int i) {
		switch(i) {
		case(1): Animation animSize = AnimationUtils.loadAnimation(getBaseContext(), R.anim.scale);
			bt1.startAnimation(animSize);
			break;
		case(2): Animation animRotate = AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotation);
			bt2.startAnimation(animRotate);
			break;
		case(3): Animation animMove = AnimationUtils.loadAnimation(getBaseContext(), R.anim.move);
			bt3.startAnimation(animMove);
			animMove.setFillAfter(true);//para gardar el estado de fin de animacion : sin eso volve automaticamente al estado antes de la animacion
			break;
		case(4): 
			LayoutAnimationController animLayout = AnimationUtils.loadLayoutAnimation(getBaseContext(), R.anim.layoutanim);
			l.setLayoutAnimation(animLayout);
			
			//para lanzar la animacion de layout : sucio pero funciona...
			l.setVisibility(0);
			l.setVisibility(1);
		break;
		default:break;
		}
		
	}
}
