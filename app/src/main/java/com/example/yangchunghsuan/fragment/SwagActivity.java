package com.example.yangchunghsuan.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class SwagActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private ContactFragment contact;
    private DetailFragment detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swag);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        contact = ContactFragment.newInstance("a","b");
        detail = DetailFragment.newInstance("a","b");
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction trans = fragmentManager.beginTransaction();
        trans.add(R.id.container,contact);
        trans.commit();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swag();
            }
        });
    }

    private void swag(){
//        Toast.makeText(this,"swag",Toast.LENGTH_LONG).show();
        FragmentTransaction trans = fragmentManager.beginTransaction();
        trans.replace(R.id.container,detail);
        trans.addToBackStack(null);
        trans.commit();
    }
}
