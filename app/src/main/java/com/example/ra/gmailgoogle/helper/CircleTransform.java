package com.example.ra.gmailgoogle.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import javax.xml.transform.Source;

public class CircleTransform extends BitmapTransformation {
    public CircleTransform(Context context) {
        super(context);
    }


    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        return circleCrop(pool,toTransform);
    }

    private static Bitmap circleCrop(BitmapPool pool, Bitmap Source) {
        if (Source == null) return null;

        int size=Math.min(Source.getWidth(),Source.getHeight());
        int x =(Source.getWidth()-size)/2;
        int y=(Source.getHeight()-size)/2;

//        TODO  this could be acquired from the pool too
        Bitmap squared = Bitmap.createBitmap(Source,x,y,size,size);
        Bitmap result = pool.get(size,size,Bitmap.Config.ARGB_8888);
        if (result == null) {
            result =Bitmap.createBitmap(size,size,Bitmap.Config.ARGB_8888);

        }
        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(squared,BitmapShader.TileMode.CLAMP,BitmapShader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        float r = size/2f;
        canvas.drawCircle(r,r,r,paint);
        return result;

    }

    @Override
    public String getId() {
        return null;
    }
}
