package com.android.smartpictureeditor;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;

import com.android.smartpictureeditor.abstracts.OnFilterAttachListener;
import com.android.smartpictureeditor.bl.DefaultOptionsGalleryAdapter;
import com.android.smartpictureeditor.features.FeatureOption;
import com.android.smartpictureeditor.features.Option1;
import com.android.smartpictureeditor.views.OptionsGallery;
import com.android.smartpictureeditor.views.SMView;

public class MainActivity extends Activity implements OnFilterAttachListener, OnItemClickListener {

	SMView mView;
	LinearLayout mContainerView;
	OptionsGallery mDefaultGallery;
	DefaultOptionsGalleryAdapter mAdapter;
	ArrayList<FeatureOption> mFeaturesList = new ArrayList<FeatureOption>();
	FeatureOption mSelectedOption = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mView = (SMView)findViewById(R.id.editorView1);
		mContainerView = (LinearLayout)findViewById(R.id.container);
		loadDefaultOptions();
	}

	private void loadDefaultOptions() {
		if(mDefaultGallery == null) {
			mDefaultGallery = new OptionsGallery(MainActivity.this);
			mDefaultGallery.setSpacing(20);
			mAdapter = new DefaultOptionsGalleryAdapter(MainActivity.this, 0, mFeaturesList);
			mDefaultGallery.setAdapter(mAdapter);
			mDefaultGallery.setOnItemClickListener(this);
			loadFeaturesList();
		}
		loadViewInContainer(mDefaultGallery);
	}

	private void loadFeaturesList() {
		// TODO Auto-generated method stub
		Option1 opt1 = new Option1("Option1", R.drawable.feature_option_icon_1);
		Option1 opt2 = new Option1("Option2", R.drawable.feature_option_icon_1);
		Option1 opt3 = new Option1("Option3", R.drawable.feature_option_icon_1);
		Option1 opt4 = new Option1("Effects", R.drawable.feature_option_icon_1);
		Option1 opt5 = new Option1("Option5", R.drawable.feature_option_icon_1);
		Option1 opt6 = new Option1("Option6", R.drawable.feature_option_icon_1);
		Option1 opt7 = new Option1("Option7", R.drawable.feature_option_icon_1);
		Option1 opt8 = new Option1("Option8", R.drawable.feature_option_icon_1);
		Option1 opt9 = new Option1("Option9", R.drawable.feature_option_icon_1);
		Option1 opt10 = new Option1("Option10", R.drawable.feature_option_icon_1);
		Option1 opt11 = new Option1("Option11", R.drawable.feature_option_icon_1);
		Option1 opt12 = new Option1("Option12", R.drawable.feature_option_icon_1);
		Option1 opt13 = new Option1("Option13", R.drawable.feature_option_icon_1);
		Option1 opt14 = new Option1("Option14", R.drawable.feature_option_icon_1);

		mFeaturesList.add(opt1);
		mFeaturesList.add(opt2);
		mFeaturesList.add(opt3);
		mFeaturesList.add(opt4);
		mFeaturesList.add(opt5);
		mFeaturesList.add(opt6);
		mFeaturesList.add(opt7);
		mFeaturesList.add(opt8);
		mFeaturesList.add(opt9);
		mFeaturesList.add(opt10);
		mFeaturesList.add(opt11);
		mFeaturesList.add(opt12);
		mFeaturesList.add(opt13);
		mFeaturesList.add(opt14);

		mAdapter.notifyDataSetChanged();
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
	}

	@Override
	public void onAttach(View controller) {
		loadViewInContainer(controller);
	}

	@Override
	public void onDetach() {
		// TODO Auto-generated method stub

	}

	public void loadViewInContainer(View view) {
		mContainerView.removeAllViews();
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
		mContainerView.addView(view, params);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		loadFilterOptionItems(parent, position);
	}

	public void loadFilterOptionItems(AdapterView<?> view, int position) {
		mSelectedOption = (FeatureOption)view.getItemAtPosition(position);
	}

}