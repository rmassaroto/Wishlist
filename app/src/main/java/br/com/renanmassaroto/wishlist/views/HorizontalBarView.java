package br.com.renanmassaroto.wishlist.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import br.com.renanmassaroto.wishlist.R;

/**
 * Created by renan on 02/12/15.
 */
public class HorizontalBarView extends View {

    public static final String TAG = "HorizontalBarView";

    private Paint barBackgroundPaint;
    private Paint barForegroundPaint;

    private int barBackgroundColor;
    private int barForegroundColor;

    private float progress;
    private float maxProgress;

    public HorizontalBarView(Context context) {
        super(context);

        initPaints();
    }

    public HorizontalBarView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initPaints();

        applyAttrs(context, attrs);
    }

    public HorizontalBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initPaints();

        applyAttrs(context, attrs);
    }

    public HorizontalBarView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        initPaints();

        applyAttrs(context, attrs);
    }

    public void initPaints() {
        barBackgroundPaint = new Paint();
        barForegroundPaint = new Paint();
    }

    private void applyAttrs(Context context, AttributeSet attrs) {
        TypedArray attrsTypedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.HorizontalBarView,
                0, 0
        );

        try {

            barBackgroundPaint.setColor(
                    attrsTypedArray.getColor(R.styleable.HorizontalBarView_backgroundColor,
                            Color.parseColor("#E1BEE7"))
            );

            barForegroundPaint.setColor(
                    attrsTypedArray.getColor(R.styleable.HorizontalBarView_foregroundColor,
                            Color.parseColor("#9C27B0"))
            );

            progress = attrsTypedArray.getInt(R.styleable.HorizontalBarView_progress, 50);
            maxProgress = attrsTypedArray.getInt(R.styleable.HorizontalBarView_maxProgress, 100);

        } finally {
            attrsTypedArray.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {

        // Draw background rectangle before to maintain z axys
        canvas.drawRect(
                0,
                0,
                canvas.getWidth(),
                canvas.getHeight(),
                barBackgroundPaint
        );
        Log.d(TAG, "Finished drawing background rectangle with (" + Integer.toString(0) + "," +
                Integer.toString(0) + "," +
                Integer.toString(canvas.getWidth()) + "," +
                Integer.toString(canvas.getHeight()) +
                ")");

        // Calculate percentage for the foreground bar
        float width = canvas.getWidth();
        float percentage = (progress / maxProgress) * width;

        canvas.drawRect(
                0,
                0,
                percentage,
                canvas.getHeight(),
                barForegroundPaint
        );

        Log.d(TAG, "Finished drawing foreground rectangle with (" + Integer.toString(0) + "," +
                Integer.toString(0) + "," +
                Float.toString(percentage) + "," +
                Integer.toString(canvas.getHeight()) +
                ")");


        super.onDraw(canvas);
    }

    public Paint getBarBackgroundPaint() {
        return barBackgroundPaint;
    }

    public void setBarBackgroundPaint(Paint barBackgroundPaint) {
        this.barBackgroundPaint = barBackgroundPaint;
    }

    public Paint getBarForegroundPaint() {
        return barForegroundPaint;
    }

    public void setBarForegroundPaint(Paint barForegroundPaint) {
        this.barForegroundPaint = barForegroundPaint;
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }

    public float getMaxProgress() {
        return maxProgress;
    }

    public void setMaxProgress(float maxProgress) {
        this.maxProgress = maxProgress;
    }

    public int getBarBackgroundColor() {
        return barBackgroundColor;
    }

    public void setBarBackgroundColor(int barBackgroundColor) {
        this.barBackgroundColor = barBackgroundColor;
        this.barBackgroundPaint.setColor(barBackgroundColor);
    }

    public int getBarForegroundColor() {
        return barForegroundColor;
    }

    public void setBarForegroundColor(int barForegroundColor) {
        this.barForegroundColor = barForegroundColor;
        this.barForegroundPaint.setColor(barForegroundColor);
    }
}
