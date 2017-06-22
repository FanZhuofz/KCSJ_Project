package xyz.dawnfan.shudutest;

 
import xyz.dawnfan.shududemo.R;
import android.content.Context;  
import android.graphics.Canvas;  
import android.graphics.Color;  
import android.graphics.Paint;  
import android.graphics.Paint.FontMetrics;  

import android.view.MotionEvent;  
import android.view.View;  

/**
 * 数独界面显示
 * @author Administrator
 *
 */
  
public class ShuduView extends View{  
  
    //单元格的宽度和高度  
    private float width;  
    private float height;  
      
    private Game game = new Game();  
    private int selectedX;  
    private int selectedY;  
      
    public ShuduView(Context context) {  
        super(context);
    }  
      
    /** 
     * w:当前view的宽度 
     * h:当前view的高度 
     *  
     */  
    @Override  
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {  
        //计算当前单元格的宽度和高度  
        this.width = w / 9f;  
        this.height = h / 9f;  
          
        super.onSizeChanged(w, h, oldw, oldh);  
    }  
      
    @Override  
    protected void onDraw(Canvas canvas) {  
        //生成用于绘制背景色的画笔  
        Paint backgroundPaint = new Paint();
        //设置画笔的颜色  
        backgroundPaint.setColor(getResources().getColor(R.color.shudu_background));  
        //绘制背景色  
        canvas.drawRect(0, 0,getWidth(),getHeight(),backgroundPaint);  
          
        Paint darkPaint = new Paint();  
        darkPaint.setColor(getResources().getColor(R.color.shudu_dark));  
          
        Paint hilitePaint = new Paint();  
        hilitePaint.setColor(getResources().getColor(R.color.shudu_hilite));  
          
        Paint lightPaint = new Paint();  
        lightPaint.setColor(getResources().getColor(R.color.shudu_light));  
          
        /** 
         * 绘制用于分割小九宫格的线(即将屏幕分成81个格子) 
         */  
        for(int i = 0 ; i < 9 ; i++){  
            /** 
             * canvas.drawLine(0, i*height, getWidth(),i*height, lightPaint) 
             * 第1、2个参数: 起点的坐标 
             * 第3、4个参数: 终点的坐标 
             * 第5个参数: 所使用的画笔 
             */  
            canvas.drawLine(0, i*height, getWidth(),i*height, lightPaint);//划横线  
            canvas.drawLine(0, i*height + 1, getWidth(), i*height + 1, hilitePaint);//也是划横线,为了对比突出那种"刻出来"的效果  
            canvas.drawLine(i*width, 0, i*width, getHeight(), lightPaint);  
            canvas.drawLine(i*width + 1, 0, i*width + 1, getHeight() , hilitePaint);  
              
        }  
          
        /** 
         * 绘制用于将屏幕分成9个小九宫格的线 
         * 3、6条线加深颜色
         */  
        for(int i = 0 ; i < 9 ; i++){  
            if(i % 3 != 0){  
                continue;  
            }  
              
            canvas.drawLine(0, i*height, getWidth(),i*height, darkPaint);//划横线  
            canvas.drawLine(0, i*height + 1, getWidth(), i*height + 1, hilitePaint);//也是划横线,为了对比突出那种"刻出来"的效果  
            canvas.drawLine(i*width, 0, i*width, getHeight(), darkPaint);  
            canvas.drawLine(i*width + 1, 0, i*width + 1, getHeight() , hilitePaint);  
              
        }
          
        //绘制数字  
        Paint numberPaint = new Paint();  
        numberPaint.setColor(Color.BLACK);
        numberPaint.setStyle(Paint.Style.FILL); //设置绘图为实心，空心为Style.STROKE
        numberPaint.setTextSize(height*0.75f);  
        numberPaint.setTextAlign(Paint.Align.CENTER);//设置数字对齐方式  ，居中对齐
        
        //文字在矩形方框中居中的方法
        FontMetrics fm = numberPaint.getFontMetrics();
        float x = width / 2;  
        float y = height/2 - (fm.ascent + fm.descent)/2;        
        
        //生成数独的初始化数据  
        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){  
                canvas.drawText(game.getTileString(i, j), i*width + x, j*height + y, numberPaint);  
            }  
        }  
          
        super.onDraw(canvas);  
    }  
      
    @Override  
    public boolean onTouchEvent(MotionEvent event) {  
        if(event.getAction() != MotionEvent.ACTION_DOWN){  
            return super.onTouchEvent(event);  
        }  
          
        //判断用户点击的是哪一个单元格  
        selectedX = (int)(event.getX() / width);  
        selectedY = (int)(event.getY() / height);  
          
        int used[] = game.getUsedTilesByCoor(selectedX, selectedY);  
        StringBuffer sb = new StringBuffer();  
        for(int i = 0 ; i < used.length ; ++i){//用来验证一下看对不对  
            sb.append(used[i]);
        }  
          
        KeyDialog keyDialog = new KeyDialog(getContext(),used,this);  
        keyDialog.show();  
          
        return true;  
    }  

    public void setSelectedTile(int tile) {  
        if(game.setTileIfValid(selectedX,selectedY,tile)){  
            invalidate();
        }
    }  
}