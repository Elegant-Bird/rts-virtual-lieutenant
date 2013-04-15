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

public class BuildingsMenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buildings_menu);
		// Show the Up button in the action bar.
		setupActionBar();
		
		final AssetManager assetManager = getAssets();
		
		/***
		 * Academy
		 */
		((Button) findViewById(R.id.academy_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
	    	  setContentView(R.layout.guide_details_template);
	    	  TextView details_text = (TextView) findViewById(R.id.details_textview);
	    	  
	  		try {
				InputStream instream = assetManager.open("academy.txt");
				String file_details = StrategyGuideActivity.StreamToString(instream);
		    	details_text.setText(file_details);
			} catch (IOException e) {			e.printStackTrace();		} 
	  		
	  		((Button)findViewById(R.id.template_back_button)).setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					finish();
					Intent localIntent = new Intent(BuildingsMenuActivity.this, BuildingsMenuActivity.class);
					BuildingsMenuActivity.this.startActivity(localIntent);					
				}
			});
	      }
	    });
		
		/***
		 * Armory
		 */
		((Button) findViewById(R.id.armory_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
	    	  setContentView(R.layout.guide_details_template);
	    	  TextView details_text = (TextView) findViewById(R.id.details_textview);
	    	  
			String file_details = " The Armory lets you research Siege Weapons, which in turn lets you train higher tiered troops." + 
								" This is slow going, but it's necessary.";
	    	details_text.setText(file_details);

	  		((Button)findViewById(R.id.template_back_button)).setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					finish();
					Intent localIntent = new Intent(BuildingsMenuActivity.this, BuildingsMenuActivity.class);
					BuildingsMenuActivity.this.startActivity(localIntent);					
				}
			});
	      }
	    });
		
		/***
		 * Barracks
		 */
		((Button) findViewById(R.id.barracks_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
	    	  setContentView(R.layout.guide_details_template);
	    	  TextView details_text = (TextView) findViewById(R.id.details_textview);
	    	  
	  		try {
				InputStream instream = assetManager.open("barracks.txt");
				String file_details = StrategyGuideActivity.StreamToString(instream);
		    	details_text.setText(file_details);
			} catch (IOException e) {			e.printStackTrace();		} 
	  		
	  		((Button)findViewById(R.id.template_back_button)).setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent localIntent = new Intent(BuildingsMenuActivity.this, BuildingsMenuActivity.class);
					BuildingsMenuActivity.this.startActivity(localIntent);					
				}
			});
	      }
	    });
		
		
		/***
		 * Embassy
		 */
		((Button) findViewById(R.id.embassy_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
	    	  setContentView(R.layout.guide_details_template);
	    	  TextView details_text = (TextView) findViewById(R.id.details_textview);
	    	  
	  		try {
				InputStream instream = assetManager.open("embassy.txt");
				String file_details = StrategyGuideActivity.StreamToString(instream);
		    	details_text.setText(file_details);
			} catch (IOException e) {			e.printStackTrace();		} 
	  		
	  		((Button)findViewById(R.id.template_back_button)).setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent localIntent = new Intent(BuildingsMenuActivity.this, BuildingsMenuActivity.class);
					BuildingsMenuActivity.this.startActivity(localIntent);					
				}
			});
	      }
	    });
		
		/****
		 * Forge
		 */
		((Button) findViewById(R.id.forge_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
	    	  setContentView(R.layout.guide_details_template);
	    	  TextView details_text = (TextView) findViewById(R.id.details_textview);
	    	  
				String file_details = "This lets you train stronger Foot soldiers.";
		    	details_text.setText(file_details);
	  		
	  		((Button)findViewById(R.id.template_back_button)).setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent localIntent = new Intent(BuildingsMenuActivity.this, BuildingsMenuActivity.class);
					BuildingsMenuActivity.this.startActivity(localIntent);					
				}
			});
	      }
	    });
		
		/***
		 * Great Hall
		 */
		((Button) findViewById(R.id.great_hall_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
	    	  setContentView(R.layout.guide_details_template);
	    	  TextView details_text = (TextView) findViewById(R.id.details_textview);
	    	  
	  		try {
				InputStream instream = assetManager.open("great_hall.txt");
				String file_details = StrategyGuideActivity.StreamToString(instream);
		    	details_text.setText(file_details);
			} catch (IOException e) {			e.printStackTrace();		} 
	  		
	  		((Button)findViewById(R.id.template_back_button)).setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent localIntent = new Intent(BuildingsMenuActivity.this, BuildingsMenuActivity.class);
					BuildingsMenuActivity.this.startActivity(localIntent);					
				}
			});
	      }
	    });
		
		
		/****
		 * Houses
		 */
		((Button) findViewById(R.id.house_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
	    	  setContentView(R.layout.guide_details_template);
	    	  TextView details_text = (TextView) findViewById(R.id.details_textview);
	    	  
	  		try {
				InputStream instream = assetManager.open("houses.txt");
				String file_details = StrategyGuideActivity.StreamToString(instream);
		    	details_text.setText(file_details);
			} catch (IOException e) {			e.printStackTrace();		} 
	  		
	  		((Button)findViewById(R.id.template_back_button)).setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent localIntent = new Intent(BuildingsMenuActivity.this, BuildingsMenuActivity.class);
					BuildingsMenuActivity.this.startActivity(localIntent);					
				}
			});
	      }
	    });
		
		
		
		/****
		 * Keep
		 */
		((Button) findViewById(R.id.keep_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
	    	  setContentView(R.layout.guide_details_template);
	    	  TextView details_text = (TextView) findViewById(R.id.details_textview);
	    	  
	  		try {
				InputStream instream = assetManager.open("keep.txt");
				String file_details = StrategyGuideActivity.StreamToString(instream);
		    	details_text.setText(file_details);
			} catch (IOException e) {			e.printStackTrace();		} 
	  		
	  		((Button)findViewById(R.id.template_back_button)).setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent localIntent = new Intent(BuildingsMenuActivity.this, BuildingsMenuActivity.class);
					BuildingsMenuActivity.this.startActivity(localIntent);					
				}
			});
	      }
	    });
		
		
		/****
		 * Muster Field
		 */
		((Button) findViewById(R.id.muster_field_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
	    	  setContentView(R.layout.guide_details_template);
	    	  TextView details_text = (TextView) findViewById(R.id.details_textview);
	    	  
	  		try {
				InputStream instream = assetManager.open("muster_field.txt");
				String file_details = StrategyGuideActivity.StreamToString(instream);
		    	details_text.setText(file_details);
			} catch (IOException e) {			e.printStackTrace();		} 
	  		
	  		((Button)findViewById(R.id.template_back_button)).setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					finish();
					Intent localIntent = new Intent(BuildingsMenuActivity.this, BuildingsMenuActivity.class);
					BuildingsMenuActivity.this.startActivity(localIntent);		
				}
			});
	      }
	    });
		
		
		/****
		 * Resource Fields
		 */
		((Button) findViewById(R.id.resource_fields_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
	    	  setContentView(R.layout.guide_details_template);
	    	  TextView details_text = (TextView) findViewById(R.id.details_textview);
	    	  
	  		try {
				InputStream instream = assetManager.open("resource_fields.txt");
				String file_details = StrategyGuideActivity.StreamToString(instream);
		    	details_text.setText(file_details);
			} catch (IOException e) {			e.printStackTrace();		} 
	  		
	  		((Button)findViewById(R.id.template_back_button)).setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent localIntent = new Intent(BuildingsMenuActivity.this, BuildingsMenuActivity.class);
					BuildingsMenuActivity.this.startActivity(localIntent);					
				}
			});
	      }
	    });
		
		
		
		/***
		 * Sage's Tower
		 */
		((Button) findViewById(R.id.sage_tower_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
	    	  setContentView(R.layout.guide_details_template);
	    	  TextView details_text = (TextView) findViewById(R.id.details_textview);
	    	  
	  		try {
				InputStream instream = assetManager.open("sage_tower.txt");
				String file_details = StrategyGuideActivity.StreamToString(instream);
		    	details_text.setText(file_details);
			} catch (IOException e) {			e.printStackTrace();		} 
	  		
	  		((Button)findViewById(R.id.template_back_button)).setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent localIntent = new Intent(BuildingsMenuActivity.this, BuildingsMenuActivity.class);
					BuildingsMenuActivity.this.startActivity(localIntent);					
				}
			});
	      }
	    });
		
		
		/****
		 * Stable
		 */
		((Button) findViewById(R.id.stable_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
	    	  setContentView(R.layout.guide_details_template);
	    	  TextView details_text = (TextView) findViewById(R.id.details_textview);
	    	  
				String file_details = " Your stable allows you to train stronger Mounted troops.";
		    	details_text.setText(file_details);
	  		
	  		((Button)findViewById(R.id.template_back_button)).setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent localIntent = new Intent(BuildingsMenuActivity.this, BuildingsMenuActivity.class);
					BuildingsMenuActivity.this.startActivity(localIntent);					
				}
			});
	      }
	    });
		
		
		
		/***
		 * Tavern
		 * 
		 */
		((Button) findViewById(R.id.tavern_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
	    	  setContentView(R.layout.guide_details_template);
	    	  TextView details_text = (TextView) findViewById(R.id.details_textview);
	    	  
	  		try {
				InputStream instream = assetManager.open("tavern.txt");
				String file_details = StrategyGuideActivity.StreamToString(instream);
		    	details_text.setText(file_details);
			} catch (IOException e) {			e.printStackTrace();		} 
	  		
	  		((Button)findViewById(R.id.template_back_button)).setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent localIntent = new Intent(BuildingsMenuActivity.this, BuildingsMenuActivity.class);
					BuildingsMenuActivity.this.startActivity(localIntent);					
				}
			});
	      }
	    });
		
		
		
		/****
		 * Vault
		 */
		((Button) findViewById(R.id.vault_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
	    	  setContentView(R.layout.guide_details_template);
	    	  TextView details_text = (TextView) findViewById(R.id.details_textview);
	    	  
	  		try {
				InputStream instream = assetManager.open("vault.txt");
				String file_details = StrategyGuideActivity.StreamToString(instream);
		    	details_text.setText(file_details);
			} catch (IOException e) {			e.printStackTrace();		} 
	  		
	  		((Button)findViewById(R.id.template_back_button)).setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent localIntent = new Intent(BuildingsMenuActivity.this, BuildingsMenuActivity.class);
					BuildingsMenuActivity.this.startActivity(localIntent);					
				}
			});
	      }
	    });
		
		
		/***
		 * Wall
		 */
		((Button) findViewById(R.id.wall_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
	    	  setContentView(R.layout.guide_details_template);
	    	  TextView details_text = (TextView) findViewById(R.id.details_textview);
	    	  
	  		try {
				InputStream instream = assetManager.open("wall.txt");
				String file_details = StrategyGuideActivity.StreamToString(instream);
		    	details_text.setText(file_details);
			} catch (IOException e) {			e.printStackTrace();		} 
	  		
	  		((Button)findViewById(R.id.template_back_button)).setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent localIntent = new Intent(BuildingsMenuActivity.this, BuildingsMenuActivity.class);
					BuildingsMenuActivity.this.startActivity(localIntent);					
				}
			});
	      }
	    });
		
		
		/***
		 * Watch Tower
		 */
		((Button) findViewById(R.id.watch_tower_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
	    	  setContentView(R.layout.guide_details_template);
	    	  TextView details_text = (TextView) findViewById(R.id.details_textview);
	    	  
	  		try {
				InputStream instream = assetManager.open("watch_tower.txt");
				String file_details = StrategyGuideActivity.StreamToString(instream);
		    	details_text.setText(file_details);
			} catch (IOException e) {			e.printStackTrace();		} 
	  		
	  		((Button)findViewById(R.id.template_back_button)).setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent localIntent = new Intent(BuildingsMenuActivity.this, BuildingsMenuActivity.class);
					BuildingsMenuActivity.this.startActivity(localIntent);					
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
		getMenuInflater().inflate(R.menu.buildings_menu, menu);
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
