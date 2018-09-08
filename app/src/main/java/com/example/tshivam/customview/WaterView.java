package com.example.tshivam.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class WaterView extends View {

    Paint ctx;
    int a = 0;

    public WaterView(Context context) {
        super(context);
        init();
    }

    public WaterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WaterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public WaterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    public Path createPath(int sides, float radius ) {
        int cx=10;
        int cy = 10;
        Path path = new Path();
        double angle = 2.0 * Math.PI / sides;
        path.moveTo(
                cx + (float)(radius * Math.cos(0.0)),
                cy + (float)(radius * Math.sin(0.0)));
        for (int i=1;i<=sides;++i ) {
            path.lineTo(
                    cx + (float)(radius * Math.cos(angle * i)),
                    cy + (float)(radius * Math.sin(angle * i)));
        }
        path.close();
        return path;
    }


    public void update(){
        a= a>10?0:a+1;
        postInvalidate();
    }

    public void init(){
         ctx = new Paint();
        ctx.setStrokeWidth(2);
        ctx.setAntiAlias(true);

    }
    @Override
    protected void onDraw(Canvas canvas) {
       // super.onDraw(canvas);
        update();
        canvas.drawLine(a,0,a,200,ctx);
        canvas.drawPath(createPath(5,20),ctx);

    }
}
