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
 * ����������ʾ
 * @author Administrator
 *
 */
  
public class ShuduView extends View{  
  
    //��Ԫ��Ŀ�Ⱥ͸߶�  
    private float width;  
    private float height;  
      
    private Game game = new Game();  
    private int selectedX;  
    private int selectedY;  
      
    public ShuduView(Context context) {  
        super(context);
    }  
      
    /** 
     * w:��ǰview�Ŀ�� 
     * h:��ǰview�ĸ߶� 
     *  
     */  
    @Override  
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {  
        //���㵱ǰ��Ԫ��Ŀ�Ⱥ͸߶�  
        this.width = w / 9f;  
        this.height = h / 9f;  
          
        super.onSizeChanged(w, h, oldw, oldh);  
    }  
      
    @Override  
    protected void onDraw(Canvas canvas) {  
        //�������ڻ��Ʊ���ɫ�Ļ���  
        Paint backgroundPaint = new Paint();
        //���û��ʵ���ɫ  
        backgroundPaint.setColor(getResources().getColor(R.color.shudu_background));  
        //���Ʊ���ɫ  
        canvas.drawRect(0, 0,getWidth(),getHeight(),backgroundPaint);  
          
        Paint darkPaint = new Paint();  
        darkPaint.setColor(getResources().getColor(R.color.shudu_dark));  
          
        Paint hilitePaint = new Paint();  
        hilitePaint.setColor(getResources().getColor(R.color.shudu_hilite));  
          
        Paint lightPaint = new Paint();  
        lightPaint.setColor(getResources().getColor(R.color.shudu_light));  
          
        /** 
         * �������ڷָ�С�Ź������(������Ļ�ֳ�81������) 
         */  
        for(int i = 0 ; i < 9 ; i++){  
            /** 
             * canvas.drawLine(0, i*height, getWidth(),i*height, lightPaint) 
             * ��1��2������: �������� 
             * ��3��4������: �յ������ 
             * ��5������: ��ʹ�õĻ��� 
             */  
            canvas.drawLine(0, i*height, getWidth(),i*height, lightPaint);//������  
            canvas.drawLine(0, i*height + 1, getWidth(), i*height + 1, hilitePaint);//Ҳ�ǻ�����,Ϊ�˶Ա�ͻ������"�̳���"��Ч��  
            canvas.drawLine(i*width, 0, i*width, getHeight(), lightPaint);  
            canvas.drawLine(i*width + 1, 0, i*width + 1, getHeight() , hilitePaint);  
              
        }  
          
        /** 
         * �������ڽ���Ļ�ֳ�9��С�Ź������ 
         * 3��6���߼�����ɫ
         */  
        for(int i = 0 ; i < 9 ; i++){  
            if(i % 3 != 0){  
                continue;  
            }  
              
            canvas.drawLine(0, i*height, getWidth(),i*height, darkPaint);//������  
            canvas.drawLine(0, i*height + 1, getWidth(), i*height + 1, hilitePaint);//Ҳ�ǻ�����,Ϊ�˶Ա�ͻ������"�̳���"��Ч��  
            canvas.drawLine(i*width, 0, i*width, getHeight(), darkPaint);  
            canvas.drawLine(i*width + 1, 0, i*width + 1, getHeight() , hilitePaint);  
              
        }
          
        //��������  
        Paint numberPaint = new Paint();  
        numberPaint.setColor(Color.BLACK);
        numberPaint.setStyle(Paint.Style.FILL); //���û�ͼΪʵ�ģ�����ΪStyle.STROKE
        numberPaint.setTextSize(height*0.75f);  
        numberPaint.setTextAlign(Paint.Align.CENTER);//�������ֶ��뷽ʽ  �����ж���
        
        //�����ھ��η����о��еķ���
        FontMetrics fm = numberPaint.getFontMetrics();
        float x = width / 2;  
        float y = height/2 - (fm.ascent + fm.descent)/2;        
        
        //���������ĳ�ʼ������  
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
          
        //�ж��û����������һ����Ԫ��  
        selectedX = (int)(event.getX() / width);  
        selectedY = (int)(event.getY() / height);  
          
        int used[] = game.getUsedTilesByCoor(selectedX, selectedY);  
        StringBuffer sb = new StringBuffer();  
        for(int i = 0 ; i < used.length ; ++i){//������֤һ�¿��Բ���  
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