package com.loiseauelegante.rtsvirtuallieutenant;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyCustomBaseAdapter extends BaseAdapter{
	private static ArrayList<EnemyCoordinates> searchArrayList;
	  
	  private LayoutInflater mInflater;
	 
	 public MyCustomBaseAdapter(Context context, ArrayList<EnemyCoordinates> results) {
	   searchArrayList = results;
	   mInflater = LayoutInflater.from(context);
	  }
	 
	 public int getCount() {
	   return searchArrayList.size();
	  }
	 
	 public Object getItem(int position) {
	   return searchArrayList.get(position);
	  }
	 
	 public long getItemId(int position) {
	   return position;
	  }
	 
	 public View getView(int position, View convertView, ViewGroup parent) {
	   ViewHolder holder;
	   if (convertView == null) {
		    convertView = mInflater.inflate(R.layout.enemy_coords_template, null);
		    holder = new ViewHolder();
		    holder.txtName = (TextView) convertView.findViewById(R.id.name);
		    holder.txtAlliance = (TextView) convertView.findViewById(R.id.alliance);
		    holder.txtPosition = (TextView) convertView.findViewById(R.id.position);
		    holder.txtMight = (TextView) convertView.findViewById(R.id.might);
		    holder.txtAggression = (TextView) convertView.findViewById(R.id.agression_level);
		    holder.txtCity1x = (TextView) convertView.findViewById(R.id.city1x);
		    holder.txtCity1y = (TextView) convertView.findViewById(R.id.city1y);
		    holder.txtCity2x = (TextView) convertView.findViewById(R.id.city2x);
		    holder.txtCity2y = (TextView) convertView.findViewById(R.id.city2y);
		    holder.txtCity3x = (TextView) convertView.findViewById(R.id.city3x);
		    holder.txtCity3y = (TextView) convertView.findViewById(R.id.city3y);
	 
		    convertView.setTag(holder);
	   } else {
		   holder = (ViewHolder) convertView.getTag();
	   }
	   
	   holder.txtName.setText(searchArrayList.get(position).getName());
	   holder.txtAlliance.setText(searchArrayList.get(position).getAlliance());
	   holder.txtPosition.setText(searchArrayList.get(position).getPosition());
	   holder.txtMight.setText(searchArrayList.get(position).getMight());
	   holder.txtAggression.setText(searchArrayList.get(position).getAggression());
	   holder.txtCity1x.setText(searchArrayList.get(position).getCity1X());
	   holder.txtCity1y.setText(searchArrayList.get(position).getCity1Y());
	   holder.txtCity2x.setText(searchArrayList.get(position).getCity2X());
	   holder.txtCity2y.setText(searchArrayList.get(position).getCity2Y());
	   holder.txtCity3x.setText(searchArrayList.get(position).getCity3X());
	   holder.txtCity3y.setText(searchArrayList.get(position).getCity3Y());

	  return convertView;
	  }
	 
	 static class ViewHolder {
	   TextView txtName;
	   TextView txtAlliance;
	   TextView txtMight;
	   TextView txtPosition;
	   TextView txtAggression;
	   TextView txtCity1x;
	   TextView txtCity1y;
	   TextView txtCity2x;
	   TextView txtCity2y;
	   TextView txtCity3x;
	   TextView txtCity3y;
	  }
	 

}
