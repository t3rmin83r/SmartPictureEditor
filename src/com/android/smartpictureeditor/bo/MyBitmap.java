package com.android.smartpictureeditor.bo;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;

public class MyBitmap {
	
	public Bitmap bmp;
	public PointF position;
	public Matrix matrix;
	
	public MyBitmap() {
		matrix = new Matrix();
	}
	public MyBitmap(Bitmap bmp) {
		this.bmp = bmp;
		matrix = new Matrix();
	}
	public void rotateMatrix(float degrees) {
		
	}
	public void scaleMatrix(float scaleX, float scaleY) {
		
	}
	public Bitmap getBitmap() {
		return bmp;
	}
	public void setBitmap(Bitmap mBitmap) {
		this.bmp = mBitmap;
	}
	public PointF getPosition() {
		return position;
	}
	public void setPosition(PointF position) {
		this.position = position;
	}
	public Matrix getMatrix() {
		return matrix;
	}
	public void setMatrix(Matrix matrix) {
		this.matrix = matrix;
	}
}
