package app.koala.com.taobao.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by v-rosong on 2015/3/30.
 */
public class ScratchTextView extends TextView {
    private float TOUCH_TOLERANCE;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Paint mPaint;
    private Path mPath;
    private float mX,mY;

    private boolean isInited = false;


    public ScratchTextView(Context context){
        super(context);
    }

    public ScratchTextView(Context context,AttributeSet attrs){
        super(context,attrs);
    }

    public ScratchTextView(Context context,AttributeSet attrs,int defStyle){
        super(context,attrs,defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(this.isInited){
            this.mCanvas.drawPath(this.mPath, this.mPaint);
            canvas.drawBitmap(this.mBitmap,0,0,null);
        }
    }

    public void initScratchCard(final int bgColor,final int paintStrokeWidth,float touchTolerance){
        this.TOUCH_TOLERANCE = touchTolerance;

        this.mPaint = new Paint();
        this.mPaint.setAlpha(240);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.mPaint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setStrokeWidth(paintStrokeWidth);

        this.mPath = new Path();

        this.mBitmap = Bitmap.createBitmap(getLayoutParams().width,getLayoutParams().height, Bitmap.Config.ARGB_8888);
        this.mCanvas = new Canvas(this.mBitmap);

        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#A79F9F"));
        paint.setTextScaleX(30);

        this.mCanvas.drawColor(bgColor);
        this.mCanvas.drawText("刮开此图层",getLayoutParams().width / 4,getLayoutParams().height / 2 + 15,paint);

        this.isInited = true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(!this.isInited){
            return true;
        }

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                this.touchDown(event.getX(),event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                this.touchMove(event.getX(),event.getY());
                break;
        }

        return true;
    }

    private void touchDown(float x,float y){
        this.mPath.reset();
        this.mPath.moveTo(x,y);
        this.mX = x;
        this.mY = y;
    }

    private void touchMove(float x,float y){
        float dx = Math.abs(x - mX);
        float dy = Math.abs(y - mY);

        if(dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE){
            this.mPath.quadTo(mX,mY,(x + mX)/2,(y + mY)/2);
            this.mX = x;
            this.mY = y;
        }
    }
}

































