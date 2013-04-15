package com.loiseauelegante.rtsvirtuallieutenant;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.io.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;

public class EnemyActivity extends Activity {

	ArrayList<EnemyCoordinates> coords_from_nodes = new ArrayList<EnemyCoordinates>();
	boolean sorted = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enemy);
		
		// Show the Up button in the action bar.
		setupActionBar();
		
		//load the xml file with the coordinates in it
		File sdCard = Environment.getExternalStorageDirectory();
		File directory = new File (sdCard.getAbsolutePath() + "/VirtualLieutenant");
		directory.mkdirs();
		String filename = "enemy_coordinates.xml";
		File enemy_file = new File(directory, filename);
		 
		 if(!enemy_file.exists()) {
	           Toast.makeText(EnemyActivity.this, "Click the options button to add new enemies!!!", Toast.LENGTH_LONG).show();
		}
		else {
			ArrayList<EnemyCoordinates> searchResults = GetEnemyCoordinates(true, enemy_file);
		        
	        final ListView enemy_list = (ListView) findViewById(R.id.ListView01);
	        enemy_list.setAdapter(new MyCustomBaseAdapter(this, searchResults));
	         
	        enemy_list.setOnItemClickListener(new OnItemClickListener() {
		          @Override
		          public void onItemClick(AdapterView<?> a, View v, int position, long id) { 
			          Object o = enemy_list.getItemAtPosition(position);
			          final EnemyCoordinates fullObject = (EnemyCoordinates)o;
			          
			          //here we must provide a dialog for edit or delete
			          AlertDialog.Builder builder = new AlertDialog.Builder(EnemyActivity.this);
			          String [] options = {"Edit", "Delete"};
			        	
			          builder.setTitle("Edit or Delete Entry?")
			          	.setItems(options, new DialogInterface.OnClickListener() {
			                  public void onClick(DialogInterface dialog, int which) {
			                  	   Log.v("Sort Key: ", String.valueOf(which + 1));
			                   	   try {
			                   		   DeleteEnemy(which + 1, fullObject);
			                   	   } 
			                   	   catch (XPathExpressionException e) {		e.printStackTrace();		} 
			                   	   catch (SAXException e) {			e.printStackTrace();				} 
			                   	   catch (IOException e) {			e.printStackTrace();				} 
			                   	   catch (ParserConfigurationException e) {		e.printStackTrace();	} 
			                   	   catch (TransformerException e) {	e.printStackTrace();				}		
		                     }
			            });

			        	AlertDialog dialog = builder.create();
			        	dialog.show();
			          
			           Toast.makeText(EnemyActivity.this, "You have chosen: " + " " + fullObject.getName(), Toast.LENGTH_LONG).show();
		          }  
	        }); 
		 }
	}
	
	public void DeleteEnemy(int selected, EnemyCoordinates selectedObject) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException, TransformerException {
		 File sdCard = Environment.getExternalStorageDirectory();
		 File directory = new File (sdCard.getAbsolutePath() + "/VirtualLieutenant");
		 directory.mkdirs();
		 String filename = "enemy_coordinates.xml";
		 File enemy_file = new File(directory, filename);
		
		switch(selected) {
		case 1:	//Edit
			
			//load this object into the add enemy form -- make a new activity?
			AddEnemyActivity.edit_values[0] = selectedObject.getName().substring(selectedObject.getName().indexOf(":") + 2);
			AddEnemyActivity.edit_values[1] = selectedObject.getMight().substring(selectedObject.getMight().indexOf(":") + 2);
			AddEnemyActivity.edit_values[2] = selectedObject.getPosition().substring(selectedObject.getPosition().indexOf(":") + 2);
			AddEnemyActivity.edit_values[3] = selectedObject.getAlliance().substring(selectedObject.getAlliance().indexOf(":") + 2);
			AddEnemyActivity.edit_values[4] = selectedObject.getCity1X().substring(selectedObject.getCity1X().indexOf(":") + 2);
			AddEnemyActivity.edit_values[5] = selectedObject.getCity2X().substring(selectedObject.getCity2X().indexOf(":") + 2);
			AddEnemyActivity.edit_values[6] = selectedObject.getCity3X().substring(selectedObject.getCity3X().indexOf(":") + 2);
			AddEnemyActivity.edit_values[7] = selectedObject.getCity1Y().substring(selectedObject.getCity1Y().indexOf(":") + 2);
			AddEnemyActivity.edit_values[8] = selectedObject.getCity2Y().substring(selectedObject.getCity2Y().indexOf(":") + 2);
			AddEnemyActivity.edit_values[9] = selectedObject.getCity2Y().substring(selectedObject.getCity2Y().indexOf(":") + 2);
			
			//then, save these changes to the xml 			//reload the results of this intent
	        Intent localIntent = new Intent(EnemyActivity.this, AddEnemyActivity.class);
	        EnemyActivity.this.startActivity(localIntent);
			
			//grab the object in xml that corresponds to this user name and delete it
			DeleteCoordinates(selectedObject, enemy_file);
	        
			break;
		case 2: //Delete
			DeleteCoordinates(selectedObject, enemy_file);
			break;
		default:
			break;
		}
	}
	
	public void DeleteCoordinates(EnemyCoordinates selected_object, File enemy_file) throws 
		SAXException, IOException, ParserConfigurationException, XPathExpressionException, TransformerException {
		
		//get the substring of the selectedObject's name
		String name = selected_object.getName();
    	name = name.substring(name.indexOf(":") + 2);
	
	 	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document document = dbf.newDocumentBuilder().parse(enemy_file);       
        
        XPathFactory xpf = XPathFactory.newInstance();
        XPath xpath = xpf.newXPath();
        XPathExpression expression = xpath.compile("//Enemies/Enemy/name[.='" + name + "']");
        Node selected_nodes = (Node) expression.evaluate(document, XPathConstants.NODE);
        
        //get the parent node of the selected name and delete that node from teh document
        Node enemy_node = selected_nodes.getParentNode();
        enemy_node.getParentNode().removeChild(enemy_node);

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        StreamResult result = new StreamResult(new PrintWriter(
        		new FileOutputStream(enemy_file, false)));
        t.transform(new DOMSource(document), result);
        
        //remove the selected object from the list of results
		ArrayList<EnemyCoordinates> searchResults = coords_from_nodes;
        searchResults.remove(selected_object);
		
        //reload the list
        final ListView enemy_list = (ListView) findViewById(R.id.ListView01);
        enemy_list.setAdapter(new MyCustomBaseAdapter(this, searchResults));
	}
	
	/***
	 * This function grabs the existing xml file and loads those coordinates
	 * If the xml file is empty, add "No Data" to the list
	 *
	 * @return
	 */
	public ArrayList<EnemyCoordinates> GetEnemyCoordinates(boolean file_exists, File coord_file){
	      ArrayList<EnemyCoordinates> results = new ArrayList<EnemyCoordinates>();

	      //load the assets file enemy_coordinates
	      //read the xml nodes of the file
	      try {
		      DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		      DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		      Document document = documentBuilder.parse(coord_file);
	
		      // Root Element
		      Element root_element = document.getDocumentElement();
		      NodeList enemy_nodes = root_element.getElementsByTagName("Enemy");
		      
		      NodeList name_nodes = root_element.getElementsByTagName("name");
		      NodeList position_nodes = root_element.getElementsByTagName("position");
		      NodeList might_nodes = root_element.getElementsByTagName("might");
		      NodeList alliance_nodes = root_element.getElementsByTagName("alliance");
		      NodeList aggression_nodes = root_element.getElementsByTagName("aggression_level");
		      NodeList city1x_nodes = root_element.getElementsByTagName("city1_x_coordinate");
		      NodeList city1y_nodes = root_element.getElementsByTagName("city1_y_coordinate");
		      NodeList city2x_nodes = root_element.getElementsByTagName("city2_x_coordinate");
		      NodeList city2y_nodes = root_element.getElementsByTagName("city2_y_coordinate");
		      NodeList city3x_nodes = root_element.getElementsByTagName("city3_x_coordinate");
		      NodeList city3y_nodes = root_element.getElementsByTagName("city3_y_coordinate");
		      
		      enemy_nodes = root_element.getChildNodes();
		      
		      for(int count = 0; count < enemy_nodes.getLength(); count++) {
		    	  EnemyCoordinates coords = new EnemyCoordinates();

		    	  coords.setName("Member Name: " + name_nodes.item(count).getTextContent());
		    	  coords.setPosition("Member Position: " + position_nodes.item(count).getTextContent());
		    	  coords.setAlliance("Alliance: " + alliance_nodes.item(count).getTextContent());
		    	  coords.setMight("Might: " + might_nodes.item(count).getTextContent());
		    	  coords.setAggression("Agression Level: " + aggression_nodes.item(count).getTextContent());
		    	  coords.setCity1X("City 1 X-Coord: " + city1x_nodes.item(count).getTextContent());
		    	  coords.setCity1Y("City 1 Y-Coord: " + city1y_nodes.item(count).getTextContent());
		    	  coords.setCity2X("City 2 X-Coord: " + city2x_nodes.item(count).getTextContent());
		    	  coords.setCity2Y("City 2 Y-Coord: " + city2y_nodes.item(count).getTextContent());
		    	  coords.setCity3X("City 3 X-Coord: " + city3x_nodes.item(count).getTextContent());
		    	  coords.setCity3Y("City 3 Y-Coord: " + city3y_nodes.item(count).getTextContent());
		    	  coords_from_nodes.add(coords);
		      }
	      }
	      catch(Exception e) {
	    	  Log.v(e.toString(), e.getMessage());
	      }
	      
	      for(int i = 0; i < coords_from_nodes.size(); i++) {
	    	  results.add(coords_from_nodes.get(i));
	      }
	      return results;
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
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.add_enemy, menu);
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
		case R.id.add_coords:
	        Intent localIntent = new Intent(EnemyActivity.this, AddEnemyActivity.class);
	        EnemyActivity.this.startActivity(localIntent);
            //newGame();
            return true;
        case R.id.help:
        	AlertDialog.Builder builder = new AlertDialog.Builder(this);
        	String [] sort_keys = {"Name", "Might", "Alliance", "Aggression", "City-1 X-Coordinate", "City-1  Y-Coordinate"};
        	
        	builder.setTitle("Sort By...")
        		.setItems(sort_keys, new DialogInterface.OnClickListener() {
                       public void onClick(DialogInterface dialog, int which) {
                    	   Log.v("Sort Key: ", String.valueOf(which));
                    	   ReOrderElements(which + 1);		//sort the elements and display based on the item selected
                       }
                });

        	AlertDialog dialog = builder.create();
        	dialog.show();
        	
            return true;
        default:
            return super.onOptionsItemSelected(item);
		}
	}
	
	public void ReOrderElements(int sort_key) {
		Log.v("Ordering By...", String.valueOf(sorted));
		switch(sort_key) {
		case 1:	//name
			List<EnemyCoordinates> name_order = coords_from_nodes;
			Collections.sort(name_order, new Comparator<EnemyCoordinates>() {
		        @Override 
		        public int compare(EnemyCoordinates p1, EnemyCoordinates p2) {
		           	String value1 = p1.getName();
		        	String value2 = p2.getName();
		        	value1 = value1.substring(value1.indexOf(":") + 2);
		        	value2 = value2.substring(value2.indexOf(":") + 2);
		        	Log.v(value1, value2);
		            return value1.compareToIgnoreCase(value2);		//ignore upper and lower case when comparing
		        }
		    });
			Log.v("Ordering By...", "Name");
			coords_from_nodes = (ArrayList<EnemyCoordinates>)name_order;
			break;
		case 2:	//might
			List<EnemyCoordinates> might_order = coords_from_nodes;
			Collections.sort(might_order, new Comparator<EnemyCoordinates>() {
		        @Override 
		        public int compare(EnemyCoordinates p1, EnemyCoordinates p2) {
		           	String value1 = p1.getMight();
		        	String value2 = p2.getMight();
		        	value1 = value1.substring(value1.indexOf(":") + 2);
		        	value2 = value2.substring(value2.indexOf(":") + 2);
		        	Log.v(value1, value2);
		            return Integer.valueOf(value1) - Integer.valueOf(value2);	
		        }
		    });
			Log.v("Ordering By...", "Might");
			coords_from_nodes = (ArrayList<EnemyCoordinates>)might_order;
			break;
		case 3:	//alliance
			List<EnemyCoordinates> alliance_order = coords_from_nodes;
			Collections.sort(alliance_order, new Comparator<EnemyCoordinates>() {
		        @Override 
		        public int compare(EnemyCoordinates p1, EnemyCoordinates p2) {
		           	String value1 = p1.getAlliance();
		        	String value2 = p2.getAlliance();
		        	value1 = value1.substring(value1.indexOf(":") + 2);
		        	value2 = value2.substring(value2.indexOf(":") + 2);
		        	Log.v(value1, value2);
		            return value1.compareToIgnoreCase(value2);	//ignore upper and lower case when comparing
		        }
		    });
			Log.v("Ordering By...", "Alliance");
			coords_from_nodes = (ArrayList<EnemyCoordinates>)alliance_order;
			break;
		case 4:	//aggression
			List<EnemyCoordinates> aggression_order = coords_from_nodes;
			Collections.sort(aggression_order, new Comparator<EnemyCoordinates>() {
		        @Override 
		        public int compare(EnemyCoordinates p1, EnemyCoordinates p2) {
		           	String value1 = p1.getAggression();
		        	String value2 = p2.getAggression();
		        	value1 = value1.substring(value1.indexOf(":") + 2);
		        	value2 = value2.substring(value2.indexOf(":") + 2);
		        	Log.v(value1, value2);
		            return value1.compareToIgnoreCase(value2);		//ignore upper and lower case when comparing
		        }
		    });
			Log.v("Ordering By...", "Aggression");
			coords_from_nodes = (ArrayList<EnemyCoordinates>)aggression_order;
			break;
		case 5:	//city 1 X
			List<EnemyCoordinates> city1_x = coords_from_nodes;
			Collections.sort(city1_x, new Comparator<EnemyCoordinates>() {
		        @Override 
		        public int compare(EnemyCoordinates p1, EnemyCoordinates p2) {
		           	String value1 = p1.getCity1X();
		        	String value2 = p2.getCity1X();
		        	value1 = value1.substring(value1.indexOf(":") + 2);
		        	value2 = value2.substring(value2.indexOf(":") + 2);
		        	Log.v(value1, value2);
		            return Integer.valueOf(value1) - Integer.valueOf(value2);
		        }
		    });
			Log.v("Ordering By...", "City X");
			coords_from_nodes = (ArrayList<EnemyCoordinates>)city1_x;
			break;
		case 6:	//city 1 Y
			List<EnemyCoordinates> city1_y = coords_from_nodes;
			Collections.sort(city1_y, new Comparator<EnemyCoordinates>() {
		        @Override 
		        public int compare(EnemyCoordinates p1, EnemyCoordinates p2) {
		        	String value1 = p1.getCity1Y();
		        	String value2 = p2.getCity1Y();
		        	value1 = value1.substring(value1.indexOf(":") + 2);
		        	value2 = value2.substring(value2.indexOf(":") + 2);
		        	Log.v(value1, value2);
		            return Integer.valueOf(value1) - Integer.valueOf(value2);
		        }
		    });
			Log.v("Ordering By...", "City Y");
			coords_from_nodes = (ArrayList<EnemyCoordinates>)city1_y;
			break;
		default:
			break;
		}
		/*sorted = true;
        Intent localIntent = new Intent(EnemyActivity.this, EnemyActivity.class);
        EnemyActivity.this.startActivity(localIntent);*/
		ArrayList<EnemyCoordinates> searchResults = coords_from_nodes;
        
        final ListView enemy_list = (ListView) findViewById(R.id.ListView01);
        enemy_list.setAdapter(new MyCustomBaseAdapter(this, searchResults));
	}
	
	 private class StableArrayAdapter extends ArrayAdapter<String> {
		    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

		    public StableArrayAdapter(Context context, int textViewResourceId,
		        List<String> objects) {
		      super(context, textViewResourceId, objects);
		      for (int i = 0; i < objects.size(); ++i) {
		        mIdMap.put(objects.get(i), i);
		      }
		    }

		    @Override
		    public long getItemId(int position) {
		      String item = getItem(position);
		      return mIdMap.get(item);
		    }

		    @Override
		    public boolean hasStableIds() {
		      return true;
		    }

	 }

}
