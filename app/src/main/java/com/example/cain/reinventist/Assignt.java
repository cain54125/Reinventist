package com.example.cain.reinventist;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Assignt extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> listAdapter;
    private String[] list={"鄭意臻","方育亭","李易澄","潘俊瑋"};
    Handler h1=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        listView = (ListView)findViewById(R.id.listview);
       /* new Thread(new Runnable() {
            @Override
            public void run() {
                final String a=netUtils.phpOfPost("SELECT * FROM assigned");
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
                                list[i]=json.getString("ID");
                                Log.i("XXX::", list[i]);
                            }
                            listAdapter = new ArrayAdapter(Assignt.this,R.layout.lisitem,list);
                            listView.setAdapter(listAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }).start();
*/

        listAdapter = new ArrayAdapter(Assignt.this,R.layout.lisitem,list);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =new Intent();
                intent.putExtra("name",list[position]);
                intent.setClass(Assignt.this,AssigntPatient.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
