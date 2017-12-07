package com.example.cain.reinventist;
//歷程->
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main8Activity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> listAdapter;
    private String[] list={"口腔運動","手腕肌腱伸展及手指運動"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        listView = (ListView)findViewById(R.id.listView);
        listAdapter = new ArrayAdapter(this,R.layout.lisitem,list);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =new Intent();
                //intent.putExtra("name",position);
                if(position==0) {
                    intent.setClass(Main8Activity.this, Main3Activity.class);
                }if(position==1) {
                    intent.setClass(Main8Activity.this, Main9Activity.class);
                }
                startActivity(intent);
                finish();
            }
        });
    }
}
