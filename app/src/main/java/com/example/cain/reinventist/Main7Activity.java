package com.example.cain.reinventist;
//聊天
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.cain.reinventist.R.id.wrap;
import static com.example.cain.reinventist.R.id.wrap_content;

public class Main7Activity extends AppCompatActivity {
TextView t1,t3,t4,t5,t6,t7;
    LinearLayout linearLayout;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        t1=(TextView)findViewById(R.id.textView6123);
        t3=(TextView)findViewById(R.id.textView8123);
        t4=(TextView)findViewById(R.id.textView9123);
        t5=(TextView)findViewById(R.id.textView10123);
        t6=(TextView)findViewById(R.id.textView11123);
        t7=(TextView)findViewById(R.id.textView12123);

        editText=(EditText)findViewById(R.id.editText2);
        linearLayout=(LinearLayout)findViewById(R.id.LinearLayout01);

        t3.setText("鄭珍珍 : 今天我做復健時我的腰有點痛");
        //復健過程中有點疼痛是正常的，疼痛的時候不要太過勉強，以免二度受傷
        t6.setText("");
        t5.setText("鄭珍珍 : ");
        t4.setText("");
        t1.setText("鄭珍珍 : ");
        t7.setText("");

        t6.setVisibility(View.INVISIBLE);
        t5.setVisibility(View.INVISIBLE);
        t4.setVisibility(View.INVISIBLE);
        t1.setVisibility(View.INVISIBLE);
        t7.setVisibility(View.INVISIBLE);


    }
int iiiiiii=0;
    @SuppressWarnings("ResourceType")
    public void Button01n(View view){
        if(editText.getText().toString()!=""&&editText.getText()!=null){
            t6.setVisibility(View.VISIBLE);
            t6.setText(editText.getText().toString());
            editText.setText("");
          /*  TextView txt=new TextView(this); //宣告一個TextView
            txt.setGravity(Gravity.RIGHT);
            //txt.setForegroundGravity(Gravity.RIGHT);
        //    txt.setBackground(ResourcesCompat.getDrawable(getResources(),,null));
            //txt.setBackgroundColor(R.color.colorb1);
            txt.setWidth(wrap_content);
            txt.setEms(1);
            txt.setMaxWidth(1);
            txt.setText(editText.getText().toString());
            linearLayout.addView(txt); //把這個TextView 加入
            editText.setText("");*/


        }
    }
}
