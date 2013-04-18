package com.android.smartpictureeditor.bl;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.smartpictureeditor.R;
import com.android.smartpictureeditor.features.FeatureOption;

public class DefaultOptionsGalleryAdapter extends ArrayAdapter<FeatureOption> {

	ArrayList<FeatureOption> mFeaturesList;
	Context mContext;
	LayoutInflater inflater;

	public DefaultOptionsGalleryAdapter(Context context, int textViewResourceId, ArrayList<FeatureOption> list) {
		super(context, textViewResourceId, list);
		// TODO Auto-generated constructor stub
		this.mContext = context;
		this.mFeaturesList = list;
		inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mFeaturesList.size();
	}

	@Override
	public FeatureOption getItem(int position) {
		// TODO Auto-generated method stub
		return mFeaturesList.get(position);
	}
	
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view = null;
		if(convertView == null) {
			view = inflater.inflate(R.layout.feature_option, parent, false);
		}
		else {
			view = convertView;
		}

		FeatureOption option = getItem(position);
		TextView title = (TextView)view.findViewById(R.id.option_title);
		ImageView icon = (ImageView)view.findViewById(R.id.option_icon); 
		title.setText(option.getName());
		icon.setImageResource(option.getIcon());


		return view;
	}

}
