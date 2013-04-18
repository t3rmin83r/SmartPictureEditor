package com.android.smartpictureeditor.filters;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.android.smartpictureeditor.R;
import com.android.smartpictureeditor.abstracts.FilterInterface;
import com.android.smartpictureeditor.bo.MyBitmap;


public class TestFilter implements FilterInterface, OnSeekBarChangeListener {

	float red = 1;
	ColorMatrix colorMatrix;
	Paint mPaint;
	View updateView;

	private static TestFilter mTestFilter = null;
	
	public static TestFilter getInstance(View view) {
		if(mTestFilter == null) {
			mTestFilter = new TestFilter(view);
		}
		return mTestFilter;
	}
	
	private TestFilter(View view) {
		this.updateView = view;
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		colorMatrix = new ColorMatrix();
		colorMatrix.set(new float[] {
				1, 0, 0, 0, 0,
				0, 1, 0, 0, 0,
				0, 0, 1, 0, 0,
				0, 0, 0, 1, 0 });
		mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
	}

	@Override
	public View onCreateView(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.test_filter, null);
		SeekBar redSeekbar = (SeekBar)view.findViewById(R.id.seekBar1);
		redSeekbar.setOnSeekBarChangeListener(this);
		return view;
	}

	@Override
	public void onUpdate() {
		// TODO Auto-generated method stub
		colorMatrix.set(new float[] {
				red, 0, 0, 0, 0,
				0, 1, 0, 0, 0,
				0, 0, 1, 0, 0,
				0, 0, 0, 1, 0 });
		mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
		updateView.invalidate();
	}

	@Override
	public void onDraw(Canvas canvas, MyBitmap bmp) {
		// TODO Auto-generated method stub
		canvas.drawBitmap(bmp.getBitmap(), bmp.getMatrix(), mPaint);
	}

	@Override
	public void onApply(MyBitmap bmp) {
		// TODO Auto-generated method stub
		Bitmap r = Bitmap.createBitmap(bmp.getBitmap().getWidth(), bmp.getBitmap().getHeight(), bmp.getBitmap().getConfig());
		Canvas canvas = new Canvas(r);
		canvas.drawBitmap(bmp.getBitmap(), bmp.getMatrix(), mPaint);
		bmp.getBitmap().recycle();
		bmp.setBitmap(r);
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		// TODO Auto-generated method stub
		red = (float)(progress+1/100);
		onUpdate();
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

}
