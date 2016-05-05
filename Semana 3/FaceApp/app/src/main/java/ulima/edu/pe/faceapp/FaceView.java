package pe.edu.ulima.faceapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;


public class FaceView extends View {
    public int mAncho, mAlto, mSonrisa;

    private ScaleGestureDetector mDetector;

    public FaceView(Context context) {
        super(context);
        mDetector = new ScaleGestureDetector(getContext(), new GestosListener());
    }

    public FaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mDetector = new ScaleGestureDetector(getContext(), new GestosListener());
    }

    public FaceView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mDetector = new ScaleGestureDetector(getContext(), new GestosListener());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint mpaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mpaint.setColor(Color.BLACK);

        Paint mPaintSonrisa = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintSonrisa.setColor(Color.BLACK);
        mPaintSonrisa.setStyle(Paint.Style.STROKE);
        mPaintSonrisa.setStrokeWidth(10);

        canvas.drawCircle(mAncho / 4, mAlto / 3, Math.min(mAlto, mAncho) / 8, mpaint);
        canvas.drawCircle((mAncho / 4) * 3, mAlto / 3, Math.min(mAlto, mAncho) / 8, mpaint);

        if (mSonrisa == 0) {
            mSonrisa = mAncho / 4;
        }

        RectF rect = new RectF();
        rect.top = 2 * (mAlto / 3) - mSonrisa/2;
        rect.left = mAncho / 4;
        rect.bottom = 2 * (mAlto / 3) + mSonrisa/2;
        rect.right = (mAncho / 4) * 3;

        canvas.drawArc(rect, 0, 180, false, mPaintSonrisa);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mAncho = w;
        mAlto = h;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mDetector.onTouchEvent(event);
        return true;
    }

    private class GestosListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            float scale = detector.getScaleFactor();
            mSonrisa *= scale;

            invalidate();

            return true;
        }
    }
}