package xyz.dawnfan.shudutest;

import xyz.dawnfan.shududemo.R;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

	//声明控件对象
    Button btn1,btn2,btn3;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //setContentView(new ShuduView(this)); 
        
        btn1 = (Button) findViewById(R.id.btn_num1);    //拿到对象
        btn2 = (Button) findViewById(R.id.btn_num2);
        btn3 = (Button) findViewById(R.id.btn_num3);
        
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View v) {
    	ShuduView ch=new ShuduView(this);
		switch (v.getId()){
	        case R.id.btn_num1:
	        	setContentView(ch);
	            break;
	        case R.id.btn_num2:
	        	setContentView(ch);
	            break;
	        case R.id.btn_num3:
	        	setContentView(ch);
	            break;
		}

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
