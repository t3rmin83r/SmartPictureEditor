package com.android.smartpictureeditor.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Gallery;

public class OptionsGallery extends Gallery {

	public OptionsGallery(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public OptionsGallery(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public OptionsGallery(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		return super.onFling(e1, e2, velocityX/3, velocityY);
	}

}
