package com.example.cain.reinventist;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HomeAssigntItem extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> listAdapter;
    private String[] list;
    Handler h1=new Handler();
    private View mMultiSelectActionBarView;
    private TextView mSelectedCount;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_assignt_item);
        Intent geti=getIntent();
        name=geti.getStringExtra("name");
        listView = (ListView)findViewById(R.id.listview);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);




        new Thread(new Runnable() {
            @Override
            public void run() {
                final String a=netUtils.phpOfPost("SELECT * FROM homeassign");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    JSONArray jsonarray = null;
                    try {
                        jsonarray = new JSONArray(a);
                        list=new String[jsonarray.length()];
                        Log.i("XXX::", ""+jsonarray.length());
                        for(int i=0;i<jsonarray.length();i++){
                            JSONObject json=jsonarray.getJSONObject(i);
                            list[i]=json.getString("treatment");
                            Log.i("XXX::", list[i]);
                        }
                        listAdapter = new ArrayAdapter(HomeAssigntItem.this,R.layout.lisitem,list);
                        listView.setAdapter(listAdapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    }
                });
            }
        }).start();
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
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<list.length;i++) {
                    if (listView.isItemChecked(i)) {
                        netUtils.phpOfPost("INSERT INTO home_assigned (name,treatment)" +
                                "VALUES ('" + name + "','" + list[i] + "')");
                    }
                }
            }
        }).start();
        finish();
    }

}
