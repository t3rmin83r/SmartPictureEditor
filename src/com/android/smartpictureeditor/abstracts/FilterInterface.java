package com.android.smartpictureeditor.abstracts;

import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;

import com.android.smartpictureeditor.bo.MyBitmap;

public interface FilterInterface {
	public View onCreateView(LayoutInflater inflater);
	public void onUpdate();
	public void onDraw(Canvas canvas, MyBitmap bmp);
	public void onApply(MyBitmap bmp);
}
