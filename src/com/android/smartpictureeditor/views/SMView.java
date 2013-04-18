package com.android.smartpictureeditor.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.android.smartpictureeditor.abstracts.FilterInterface;
import com.android.smartpictureeditor.abstracts.OnFilterAttachListener;
import com.android.smartpictureeditor.bo.MyBitmap;

public class SMView extends View {
	
	MyBitmap mBitmap;
	Context mContext;
	FilterInterface filter;
	OnFilterAttachListener filterAttachListener;
	LayoutInflater inflater;
	
	public SMView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.mContext = context;
		this.filterAttachListener = (OnFilterAttachListener) context;
		inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	public SMView(Context context, AttributeSet attr) {
		super(context, attr);
		this.mContext = context;
		this.filterAttachListener = (OnFilterAttachListener) context;
		inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
	}
	
	public void init(Bitmap bmp) {
		mBitmap = new MyBitmap(bmp);
	}
	
	public void setFilter(FilterInterface testFilter) {
		// TODO Auto-generated method stub
		this.filter = testFilter;
		filterAttachListener.onAttach(this.filter.onCreateView(inflater));
		filter.onUpdate();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
//		filter.onDraw(canvas, mBitmap);

	}
	
	public MyBitmap getBitmap() {
		return mBitmap;
	}
	public void setBitmap(MyBitmap mBitmap) {
		this.mBitmap = mBitmap;
	}
	public void applyChanges() {
		// TODO Auto-generated method stub
		filter.onApply(mBitmap);
	}
}
