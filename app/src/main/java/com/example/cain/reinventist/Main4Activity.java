package com.example.cain.reinventist;
//機器
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {
TextView textView,textView2;
    Handler h1;
    int aaa=500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        textView=(TextView)findViewById(R.id.textView5);
        textView2=(TextView)findViewById(R.id.textView13);

        h1=new Handler(Looper.getMainLooper());
        h1.post(new Runnable() {
            @Override
            public void run() {
                textView.setText("ET03-N01 : "+String.valueOf(aaa-226)+"\n"+
                                 "ET03-N02 : "+String.valueOf(aaa-165)+"\n"+
                                 "ET03-N03 : "+String.valueOf(aaa));
                textView2.setText("ET03-W01 : "+String.valueOf(aaa-304)+"\n"+
                        "ET03-W02 : "+String.valueOf(aaa-180)+"\n"+
                        "ET03-W03 : "+String.valueOf(aaa-50));
                aaa--;
                h1.postDelayed(this,1000);
            }
        });
    }
}
