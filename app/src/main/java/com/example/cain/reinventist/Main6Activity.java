package com.example.cain.reinventist;
//HomeAssigntItem//居家復健細項
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main6Activity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> listAdapter;
    private String[][] list={{"抱膝運動","股盆運動"},{"口腔運動","毛巾運動"},{"鐘擺運動"},{"手指肌腱伸展運動"},{"母指肌腱伸展運動"},{"前臂肌肉伸展運動"},{"手腕肌腱伸展及手指運動"}};

    Handler h1=new Handler();
    private int  name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        Intent intent=getIntent();
        name=intent.getIntExtra("name",2);
        listView = (ListView)findViewById(R.id.listView);

        listAdapter = new ArrayAdapter(this,R.layout.lisitem,list[name]);
        listView.setAdapter(listAdapter);

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                updateBackground(position,view);
            }
        });
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void updateBackground(int position, View view) {
        int backgroundId;
        if (listView.isItemChecked(position)) {
            backgroundId = R.color.colorb;
        } else {
            backgroundId =R.color.colorw;
        }
        Drawable background = this.getResources().getDrawable(backgroundId);
        view.setBackground(background);
    }

    public void button01(View view) {
        finish();
    }

}
