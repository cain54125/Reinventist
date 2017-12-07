package com.example.cain.reinventist;

import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AssigntPatientMessage extends AppCompatActivity {
    private String name;
    private ListView listView;
    private ArrayAdapter<String> listAdapter;
    private String[] list;
    private EditText e1;
    Handler h1=new Handler();
    HandlerThread ht;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignt_patient_message);
        Intent intent=getIntent();
        name=intent.getStringExtra("name");
        listView = (ListView)findViewById(R.id.listview);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        e1=(EditText)findViewById(R.id.editText);
        updata();

    }

    public void button01(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if( e1.getText().toString()!=""&&e1.getText()!=null) {
                    netUtils.phpOfPost("INSERT INTO home_message (Assignt,ID,data)" +
                            "VALUES ('" + "復健師" + "','" + name + "','" +"1"+e1.getText().toString() + "')");
                }
            }
        }).start();
        if( e1.getText().toString()!=""&&e1.getText()!=null) {
            e1.setText("");
        }
    }
    boolean aBoolean=true;
    void updata(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                final String a=netUtils.phpOfPost("SELECT * FROM home_message");
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
                                char aa[]=json.getString("data").toCharArray();
                                if(0==Integer.parseInt(String.valueOf(aa[0]))){
                                    list[i]=json.getString("ID");
                                }else{
                                    list[i]=json.getString("Assignt");
                                }
                                list[i]+=":";
                                for(int j=1;j<aa.length;j++){
                                    list[i]+=aa[j];
                                }
                                // list[i]+=":"+json.getString("data");
                                Log.i("XXX::", list[i]);
                            }
                            listAdapter = new ArrayAdapter(AssigntPatientMessage.this,R.layout.lisitem,list);
                            listView.setAdapter(listAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
                new Thread(this).start();
            }
        }).start();
    }
}
