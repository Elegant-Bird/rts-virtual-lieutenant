package com.loiseauelegante.rtsvirtuallieutenant;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
	    ((Button) findViewById(R.id.enemy_activity_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
	        Intent localIntent = new Intent(MainActivity.this, EnemyActivity.class);
	        MainActivity.this.startActivity(localIntent);
	      }
	    });
	    
	    ((Button) findViewById(R.id.personal_list_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
	        Intent localIntent = new Intent(MainActivity.this, PersonalHitlistActivity.class);
	        MainActivity.this.startActivity(localIntent);
	      }
	    });
	    
	    ((Button) findViewById(R.id.personal_growth_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
	           Toast.makeText(MainActivity.this, "Growth Tracker Coming Soon!!!", Toast.LENGTH_LONG).show();

	      }
	    });
	    
	    ((Button) findViewById(R.id.strategy_guide_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
		        Intent localIntent = new Intent(MainActivity.this, StrategyGuideActivity.class);
		        MainActivity.this.startActivity(localIntent);
	      }
	    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
}
