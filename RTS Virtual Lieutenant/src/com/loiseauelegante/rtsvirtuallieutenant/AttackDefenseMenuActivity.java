package com.loiseauelegante.rtsvirtuallieutenant;

import java.io.IOException;
import java.io.InputStream;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Build;

public class AttackDefenseMenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_attack_defense_menu);
		// Show the Up button in the action bar.
		setupActionBar();
		
		final AssetManager assetManager = getAssets();
		
		((Button) findViewById(R.id.attack_cities_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
	    	  setContentView(R.layout.guide_details_template);
	    	  TextView details_text = (TextView) findViewById(R.id.details_textview);
	    	  
	  		try {
				InputStream instream = assetManager.open("attacking_cities.txt");
				String file_details = StrategyGuideActivity.StreamToString(instream);
		    	details_text.setText(file_details);
			} catch (IOException e) {			e.printStackTrace();		} 
	  		
	  		((Button)findViewById(R.id.template_back_button)).setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					finish();
					Intent localIntent = new Intent(AttackDefenseMenuActivity.this, AttackDefenseMenuActivity.class);
					AttackDefenseMenuActivity.this.startActivity(localIntent);					
				}
			});
	      }
	    });
		
		((Button) findViewById(R.id.defend_city_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
	    	  setContentView(R.layout.guide_details_template);
	    	  TextView details_text = (TextView) findViewById(R.id.details_textview);
	    	  
	  		try {
				InputStream instream = assetManager.open("city_defense.txt");
				String file_details = StrategyGuideActivity.StreamToString(instream);
		    	details_text.setText(file_details);
			} catch (IOException e) {			e.printStackTrace();		} 
	  		
	  		((Button)findViewById(R.id.template_back_button)).setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					finish();
					Intent localIntent = new Intent(AttackDefenseMenuActivity.this, AttackDefenseMenuActivity.class);
					AttackDefenseMenuActivity.this.startActivity(localIntent);					
				}
			});
	      }
	    });
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.attack_defense_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
