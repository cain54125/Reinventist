package com.example.cain.reinventist;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

public class AssigntPatient extends AppCompatActivity {
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_patient);
        Intent intent=getIntent();
        name=intent.getStringExtra("name");

    }

    public void button01(View view) {
        Intent intent=new Intent();
        intent.putExtra("name",name);
        intent.setClass(this,Main5Activity.class);
        startActivity(intent);
    }
    public void button02(View view) {
        Intent intent=new Intent();
        intent.putExtra("name",name);
        intent.setClass(this,Main7Activity.class);
        startActivity(intent);
    }
    public void button03(View view) {
        Intent intent=new Intent();
        intent.setClass(this,Main2Activity.class);
        startActivity(intent);
    }
    public void button04(View view) {
        Intent intent=new Intent();
        intent.setClass(this,Main8Activity.class);
        startActivity(intent);
    }
}
