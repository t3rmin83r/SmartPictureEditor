package com.android.smartpictureeditor.filters;

import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import com.android.smartpictureeditor.abstracts.FilterInterface;
import com.android.smartpictureeditor.bo.MyBitmap;

public class TestFilter3 implements FilterInterface {

	private static TestFilter3 mTestFilter = null;
	View updateView;

	public static TestFilter3 getInstance(View view) {
		if(mTestFilter == null) {
			mTestFilter = new TestFilter3(view);
		}
		return mTestFilter;
	}

	private TestFilter3(View view) {
		this.updateView = view;
	}

	@Override
	public View onCreateView(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onUpdate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDraw(Canvas canvas, MyBitmap bmp) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onApply(MyBitmap bmp) {
		// TODO Auto-generated method stub

	}

}
