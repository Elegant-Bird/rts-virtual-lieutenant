package com.loiseauelegante.rtsvirtuallieutenant;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class AddPersonalEnemyActivity extends Activity {

	//final text boxes of everything on the screen
	static EditText alliance_box;
	static EditText name_box;
	static EditText position_box;
	static EditText might_box;
	static EditText city1x_box;
	static EditText city1y_box;
	static EditText city2x_box;
	static EditText city2y_box;
	static EditText city3x_box;
	static EditText city3y_box;
	static Spinner agression_box;
	
	public static String [] edit_values = new String[10];

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_personal_enemy);
		// Show the Up button in the action bar.
		setupActionBar();
		
		alliance_box = (EditText) findViewById(R.id.alliance2_edittext);
		name_box = (EditText) findViewById(R.id.name2_edittext);
		position_box = (EditText) findViewById(R.id.position2_edittext);
		might_box = (EditText) findViewById(R.id.might2_edittext);
		city1x_box = (EditText) findViewById(R.id.city1x2_edittext);
		city1y_box = (EditText) findViewById(R.id.city1y2_edittext);
		city2x_box = (EditText) findViewById(R.id.city2x2_edittext);
		city2y_box = (EditText) findViewById(R.id.city2y2_edittext);
		city3x_box = (EditText) findViewById(R.id.city3x2_edittext);
		city3y_box = (EditText) findViewById(R.id.city3y2_edittext);
		
		if(edit_values != null) {
			alliance_box.setText(edit_values[3]);
			name_box.setText(edit_values[0]);
			position_box.setText(edit_values[2]);
			might_box.setText(edit_values[1]);
			city1x_box.setText(edit_values[4]);
			city1y_box.setText(edit_values[7]);
			city2x_box.setText(edit_values[5]);
			city2y_box.setText(edit_values[8]);
			city3x_box.setText(edit_values[6]);
			city3y_box.setText(edit_values[9]);
		}
		
		String [] array_spinner= new String[5];
		array_spinner[0] = "Totally Non-Threatening";
		array_spinner[1] = "As Annoying as a Fly";
		array_spinner[2] = "Really Starting to Annoy Me";
		array_spinner[3] = "Royally Pissing me Off";
		array_spinner[4] = "Total Douchebag";
		agression_box = (Spinner) findViewById(R.id.agression2_spinner);
		ArrayAdapter adapter = new ArrayAdapter(this,
		android.R.layout.simple_spinner_item, array_spinner);
		agression_box.setAdapter(adapter);
		
		//set up save button on click
	    ((Button) findViewById(R.id.save2_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
		      //make sure that certain fields are not left blank
	    	  if(alliance_box.getText().length() > 2 && might_box.getText().length() > 2 && 
	    			  name_box.getText().length() > 2 && city1x_box.getText().length() > 1 &&
	    			  city1y_box.getText().length() > 1) {

	    		  //save the data to the xml file
	    		  AddToXmlFile();
	    	  
			      Intent localIntent = new Intent(AddPersonalEnemyActivity.this, PersonalHitlistActivity.class);
			      AddPersonalEnemyActivity.this.startActivity(localIntent);
				  edit_values = new String[10];
				  finish();
	    	  }
	    	  else {
	    		  //toast, don't leave those fields blank!!!
	    		  String error_text = "Do not leave the alliance, might, name, \n " +
	    				  "or city 1 coords blank!!!";
	              Toast.makeText(AddPersonalEnemyActivity.this, error_text, Toast.LENGTH_LONG).show();
	    	  }
	      }
	    });
	    
	    //set up cancel button on click
	    ((Button) findViewById(R.id.cancel2_button)).setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
	        Intent localIntent = new Intent(AddPersonalEnemyActivity.this, PersonalHitlistActivity.class);
	        AddPersonalEnemyActivity.this.startActivity(localIntent);
	        
	        //post a toast saying that the action was cancelled
	        if(edit_values != null) {
	        	//restore the original values of the text boxes, and store again
				alliance_box.setText(edit_values[3]);
				name_box.setText(edit_values[0]);
				position_box.setText(edit_values[2]);
				might_box.setText(edit_values[1]);
				city1x_box.setText(edit_values[4]);
				city1y_box.setText(edit_values[7]);
				city2x_box.setText(edit_values[5]);
				city2y_box.setText(edit_values[8]);
				city3x_box.setText(edit_values[6]);
				city3y_box.setText(edit_values[9]);
	    		AddToXmlFile();
	        }
			edit_values = new String[10];
		    finish();
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
		getMenuInflater().inflate(R.menu.add_personal_enemy, menu);
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
	
	private void AddToXmlFile () {
		 try {
			 //if file exists, read the existing node
			 File sdCard = Environment.getExternalStorageDirectory();
			 File directory = new File (sdCard.getAbsolutePath() + "/VirtualLieutenant");
			 directory.mkdirs();
			 String filename = "personal_enemies.xml";
			 File enemy_file = new File(directory, filename);
			 Element root_element;
			 Document document;
			 
			 if(enemy_file.exists()) {
				DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		        document = documentBuilder.parse(enemy_file);

		        // Root Element
		        root_element = document.getDocumentElement();
			 } else {
				 enemy_file.createNewFile();

				 DocumentBuilderFactory doc_factory = DocumentBuilderFactory.newInstance();
				 DocumentBuilder doc_builder = doc_factory.newDocumentBuilder();
				 
				 //root elements
				 document = doc_builder.newDocument();
				 root_element = document.createElement("Enemies");
				 document.appendChild(root_element);
			 }
			 
			 //enemy element
			 Element enemy_element = document.createElement("Enemy");
			 root_element.appendChild(enemy_element);
			 
			 //child elements
			 Element name = document.createElement("name");
			 name.appendChild(document.createTextNode(name_box.getText().toString()));
			 enemy_element.appendChild(name);
			 
			 Element alliance = document.createElement("alliance");
			 alliance.appendChild(document.createTextNode(alliance_box.getText().toString()));
			 enemy_element.appendChild(alliance);
			 
			 Element position = document.createElement("position");
			 position.appendChild(document.createTextNode(position_box.getText().toString()));
			 enemy_element.appendChild(position);
			 
			 Element might = document.createElement("might");
			 might.appendChild(document.createTextNode(might_box.getText().toString()));
			 enemy_element.appendChild(might);
			 
			 Element agression = document.createElement("aggression_level");
			 agression.appendChild(document.createTextNode(agression_box.getSelectedItem().toString()));
			 enemy_element.appendChild(agression);
			 
			 //add the city coordinates elements
			 Element city1x = document.createElement("city1_x_coordinate");
			 city1x.appendChild(document.createTextNode(city1x_box.getText().toString()));
			 enemy_element.appendChild(city1x);
			 
			 Element city1y = document.createElement("city1_y_coordinate");
			 city1y.appendChild(document.createTextNode(city1y_box.getText().toString()));
			 enemy_element.appendChild(city1y);
			 
			 Element city2x = document.createElement("city2_x_coordinate");
			 city2x.appendChild(document.createTextNode(city2x_box.getText().toString()));
			 enemy_element.appendChild(city2x);
			 
			 Element city2y = document.createElement("city2_y_coordinate");
			 city2y.appendChild(document.createTextNode(city2y_box.getText().toString()));
			 enemy_element.appendChild(city2y);
			 
			 Element city3x = document.createElement("city3_x_coordinate");
			 city3x.appendChild(document.createTextNode(city3x_box.getText().toString()));
			 enemy_element.appendChild(city3x);
			 
			 Element city3y = document.createElement("city3_y_coordinate");
			 city3y.appendChild(document.createTextNode(city3y_box.getText().toString()));
			 enemy_element.appendChild(city3y);
			 
			 //write the content to the file
			 TransformerFactory transformer_factory = TransformerFactory.newInstance();
			 Transformer transformer = transformer_factory.newTransformer();
			 DOMSource source = new DOMSource(document);
			 StreamResult result = new StreamResult(enemy_file);
			 
			 transformer.transform(source, result);
			 
		 } catch(Exception E) {
			 Log.v(E.getMessage(), E.toString());
		 }
	 }


}
