package com.androidrecipes.drawerlayout;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class SupportActivity extends AppCompatActivity
implements AdapterView.OnItemClickListener{

    private static final String[] ITEMS =
            {"White", "RED" , "GREEN" , "BLUE"};

    private static final int[] COLORS =
            {Color.WHITE, 0xffe51c23, 0xff259b24, 0xff5677fc};

    private DrawerLayout drawerLayout;

    private View mview;

    private ListView listView;

    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.container_drawer);
        mview =  findViewById(R.id.container_root);
        listView = (ListView) findViewById(R.id.drawer_main);
        actionBarDrawerToggle = new ActionBarDrawerToggle(
                this , drawerLayout ,R.string.drawer_open ,R.string.drawer_close
        ){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                supportInvalidateOptionsMenu();
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                super.onDrawerStateChanged(newState);
                supportInvalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                supportInvalidateOptionsMenu();
            }
        };
        ListAdapter adapter =new ArrayAdapter<String>(this ,
        android.R.layout.simple_list_item_1 , ITEMS);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    protected void onPostCreate( Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main , menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean isOpen = drawerLayout.isDrawerVisible(listView);
        menu.findItem(R.id.action_delete).setVisible(!isOpen);
        menu.findItem(R.id.action_settings).setVisible(!isOpen);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            drawerLayout.post(new Runnable() {
                @Override
                public void run() {
                    supportInvalidateOptionsMenu();
                }
            });
            return true;
        }
        switch(item.getItemId()){
            case R.id.action_delete:
                return true;
            case R.id.action_settings:
                return true;
            default:
                return  super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        mview.setBackgroundColor(COLORS[i]);
        drawerLayout.closeDrawer(listView);
    }
}