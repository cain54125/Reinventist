package com.example.cain.reinventist;
//  --> HomeAssigntItem //居家復健項目
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Main5Activity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> listAdapter;
        private String[] list={"腰痛","腦中風","五十肩","板機指","媽媽手","網球肘","腕隧道症候群"};
    Handler h1=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        listView = (ListView)findViewById(R.id.listView);
        listAdapter = new ArrayAdapter(this,R.layout.lisitem,list);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =new Intent();
                intent.putExtra("name",position);
                intent.setClass(Main5Activity.this,Main6Activity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
