package com.example.cain.reinventist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        ListView listView;
        List<QueueData> listitem ;
        boolean aBoolean;
    static int aaaa=1;
    QueueAdapter queueAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //
        // drawer.setDrawerListener(toggle);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        listView=(ListView)findViewById(R.id.listView);
        updata();
    }


    void updata(){
        listitem = new ArrayList<QueueData>();

        listitem.add(new QueueData("110113419","潘俊瑋","PT01","","0","0"));
        listitem.add(new QueueData("110125419","方育亭","PT01","","0","0"));
        listitem.add(new QueueData("110132578","鄭意臻","PT01","","0","0"));
        listitem.add(new QueueData("110127951","李易澄","PT01","","0","0"));
        queueAdapter = new QueueAdapter(MainActivity.this.getLayoutInflater(),listitem);
        listView.setAdapter(queueAdapter);

      /*  new Thread(new Runnable() {
            @Override
            public void run() {
                final String a=netUtils.phpOfPost("SELECT * FROM  queue");

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        JSONArray jsonarray = null;
                        try {
                            jsonarray = new JSONArray(a);
                            listitem = new ArrayList<QueueData>();
                            for(int i=0;i<jsonarray.length();i++){
                                JSONObject json=jsonarray.getJSONObject(i);//order_n
                                listitem.add(new QueueData(json.getString("ID"),json.getString("Name"),json.getString("Treat_Number"),json.getString("Status"),json.getString("order_n"),json.getString("bool_n")));
                            }
                            queueAdapter = new QueueAdapter(MainActivity.this.getLayoutInflater(),listitem);
                            listView.setAdapter(queueAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
               new Thread(this).start();
            }
        }).start();
*/
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent intent =new Intent();
            intent.setClass(this,Assignt.class);
            startActivity(intent);
        } else if (id == R.id.nav_slideshow) {
            Intent intent =new Intent();
            intent.setClass(this,Main4Activity.class);
            startActivity(intent);
        } else if (id == R.id.nav_manage) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
