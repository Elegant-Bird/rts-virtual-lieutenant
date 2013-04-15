package com.loiseauelegante.rtsvirtuallieutenant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
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

public class StrategyGuideActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_strategy_guide);
		// Show the Up button in the action bar.
		setupActionBar();
		
		final AssetManager assetManager = getAssets();
		
		//onClick listeners for the buttons
	    ((Button) findViewById(R.id.wilds_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
	        Intent localIntent = new Intent(StrategyGuideActivity.this, WildsMenuActivity.class);
	        StrategyGuideActivity.this.startActivity(localIntent);
	      }
	    });
	    
	    ((Button) findViewById(R.id.attack_defense_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
	        Intent localIntent = new Intent(StrategyGuideActivity.this, AttackDefenseMenuActivity.class);
	        StrategyGuideActivity.this.startActivity(localIntent);
	      }
	    });
	    
	    ((Button) findViewById(R.id.alliance_assistance_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
	        Intent localIntent = new Intent(StrategyGuideActivity.this, AllianceMenuActivity.class);
	        StrategyGuideActivity.this.startActivity(localIntent);
	      }
	    });
	    
	    ((Button) findViewById(R.id.heroes_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
	    	  setContentView(R.layout.guide_details_template);
	    	  TextView details_text = (TextView) findViewById(R.id.details_textview);
	    	  
	  		try {
				InputStream instream = assetManager.open("heroes.txt");
				String file_details = StrategyGuideActivity.StreamToString(instream);
		    	details_text.setText(file_details);
			} catch (IOException e) {			e.printStackTrace();		} 
	  		
	  		((Button)findViewById(R.id.template_back_button)).setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					finish();
					Intent localIntent = new Intent(StrategyGuideActivity.this, StrategyGuideActivity.class);
					StrategyGuideActivity.this.startActivity(localIntent);					
				}
			});
	      }
	    });
	    
	    ((Button) findViewById(R.id.relics_deeds_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
	        Intent localIntent = new Intent(StrategyGuideActivity.this, DeedsMenuActivity.class);
	        StrategyGuideActivity.this.startActivity(localIntent);
	      }
	    });
	    
	    ((Button) findViewById(R.id.troops_might_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
	    	  setContentView(R.layout.guide_details_template);
	    	  TextView details_text = (TextView) findViewById(R.id.details_textview);
	    	  
	  		try {
				InputStream instream = assetManager.open("training_troops.txt");
				String file_details = StrategyGuideActivity.StreamToString(instream);
		    	details_text.setText(file_details);
			} catch (IOException e) {			e.printStackTrace();		} 
	  		
	  		((Button)findViewById(R.id.template_back_button)).setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					finish();
					Intent localIntent = new Intent(StrategyGuideActivity.this, StrategyGuideActivity.class);
					StrategyGuideActivity.this.startActivity(localIntent);					
				}
			});
	      }
	    });
	    
	    ((Button) findViewById(R.id.buildings_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
	        Intent localIntent = new Intent(StrategyGuideActivity.this, BuildingsMenuActivity.class);
	        StrategyGuideActivity.this.startActivity(localIntent);
	      }
	    });
	}

	public static String StreamToString(InputStream in_stream) throws IOException {
		String fullString = "";
		
		if(in_stream != null) {
			Writer writer = new StringWriter();
			char [] buffer = new char[1024];
			try {
				Reader reader = new BufferedReader(new InputStreamReader(in_stream, "UTF-8"));
				int n;
				while((n= reader.read(buffer)) != -1) {
					writer.write(buffer, 0, n);
					fullString += buffer;
				}
			} finally {
				in_stream.close();
			}
			return writer.toString();
		} else {
			return fullString;
		}
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
		getMenuInflater().inflate(R.menu.strategy_guide, menu);
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
