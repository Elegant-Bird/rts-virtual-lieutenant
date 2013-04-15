package com.loiseauelegante.rtsvirtuallieutenant;

import java.util.ArrayList;

import com.loiseauelegante.rtsvirtuallieutenant.MyCustomBaseAdapter.ViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class StrategyGuideDetails {

	  private LayoutInflater mInflater;
	  private static String details_text;
	  
	  public StrategyGuideDetails(Context context, String results) {
			   details_text = results;
			   mInflater = LayoutInflater.from(context);
	 }
	  
	  public View getView(int position, View convertView, ViewGroup parent) {
		   ViewHolder holder;
		   if (convertView == null) {
			    convertView = mInflater.inflate(R.layout.guide_details_template, null);
			    holder = new ViewHolder();
			    holder.object_details = (TextView) convertView.findViewById(R.id.details_textview);
			    convertView.setTag(holder);
		   } else {
			   holder = (ViewHolder) convertView.getTag();
		   }

		   holder.object_details.setText(details_text);
		   
		  return convertView;
		  }
		 
		 static class ViewHolder {
		   TextView object_details;

		  }
	
}
