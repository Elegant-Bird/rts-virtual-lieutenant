package com.loiseauelegante.rtsvirtuallieutenant;

public class EnemyCoordinates {
	  private String name = "";
	  private String alliance = "";
	  private String position = "";
	  private String might = "";
	  private String aggression_level = "";
	  
	  //First city coordinates
	  private String x1 = "";
	  private String y1 = "";
	  
	  //Second city coordinates
	  private String x2 = "";
	  private String y2 = "";
	  
	  //Third city coordinates
	  private String x3 = "";
	  private String y3 = "";
	  
	  //Constructor
	  public EnemyCoordinates() {
		  
	  }
	  /*** Constructor	**/
	  public EnemyCoordinates(String name, String alliance, String might, String position, String aggression_level, 
			  String x1, String y1, String x2, String y2, String x3, String y3) {
		  this.name = name;
		  this.alliance = alliance;
		  this.position = position;
		  this.aggression_level = aggression_level;
		  this.might = might;
		  
		  this.x1 = x1;
		  this.x2 = x2;
		  this.x3 = x3;
		  
		  this.y1 = y1;
		  this.y2 = y2;
		  this.y3 = y3;
	  }
	  
	  /*** Setter Functions ***/
	  public void setName(String name) {	   this.name = name;	  }
	  public void setAlliance(String alliance) {	   this.alliance = alliance;	  }
	  public void setPosition(String position) {	   this.position = position;	  }
	  public void setMight(String might) 	{		   this.might = might;	  }
	  public void setAggression(String aggression_level) {	    this.aggression_level = aggression_level;		  }
	  public void setCity1X(String x1) {		    this.x1 = x1;		  }
	  public void setCity1Y(String y1) {		    this.y1 = y1;		  }
	  public void setCity2X(String x2) {		    this.x2 = x2;		  }
	  public void setCity2Y(String y2) {		    this.y2 = y2;		  }
	  public void setCity3X(String x3) {		    this.x3 = x3;		  }
	  public void setCity3Y(String y3) {		    this.y3 = y3;		  }
	 
	 /*** Getter Functions ***/
	  public String getName() 	{		   return name;		  }
	  public String getAlliance() {		   return alliance;	  }
	  public String getPosition() {	   return position;	  	  }
	  public String getMight() 	{		   return might;	  }
	  public String getAggression() {	   return aggression_level;		  }
	  public String getCity1X() {		   return x1;		  }
	  public String getCity1Y() {		   return y1;		  }
	  public String getCity2X() {		   return x2;		  }
	  public String getCity2Y() {		   return y2;		  }
	  public String getCity3X() {		   return x3;		  }
	  public String getCity3Y() {		   return y3;		  }
}
