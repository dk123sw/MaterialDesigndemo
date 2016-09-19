package com.dk.ceshi;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.dk.ceshi.fragment.TabFragment;
import com.dk.ceshi.fragment.TabFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private DrawerLayout mDrawerLayout;

    private NavigationView navigationView;

    private ActionBarDrawerToggle mDrawerToggle;

    private Toolbar toolbar;

    private TabLayout tabLayout;

    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTabLayout();
        //设置导航栏图标
//        toolbar.setNavigationIcon(R.drawable.main_home);
        //设置app logo
//        toolbar.setLogo(R.mipmap.ic_launcher);
//
//        //设置主标题
//        toolbar.setTitle("标题");
//        //设置主标题颜色
//        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
//        //修改主标题的外观，包括文字颜色，文字大小等
//        toolbar.setTitleTextAppearance(this, R.style.Theme_ToolBar_Base_Title);
//
//        //设置子标题
//        toolbar.setSubtitle("子标题");
//        //设置子标题颜色
//        toolbar.setSubtitleTextColor(getResources().getColor(android.R.color.darker_gray));
//        //设置子标题的外观，包括文字颜色，文字大小等
//        toolbar.setSubtitleTextAppearance(this, R.style.Theme_ToolBar_Base_Subtitle);

        /**
         *定义ToolBar
         */
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
//        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_top_game_center);
//        toolbar.setNavigationIcon(R.drawable.ic_menu_top_game_center);
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayUseLogoEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);

    }

//        设置右上角的填充菜单
        toolbar.inflateMenu(R.menu.tb_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int menuItemId = item.getItemId();
                if (menuItemId == R.id.action_game) {
                    Toast.makeText(MainActivity.this, "游戏", Toast.LENGTH_SHORT).show();

                } else if (menuItemId == R.id.action_download) {
                    Toast.makeText(MainActivity.this, "离线下载", Toast.LENGTH_SHORT).show();

                } else if (menuItemId == R.id.action_search) {
                    Toast.makeText(MainActivity.this , "搜索", Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });

        /**
         *将NavigationView和ToolBar结合
         */

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        //设置drawer的开关监听
        mDrawerLayout.addDrawerListener(new MyDrawerListener());

        mDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, mDrawerLayout,
                toolbar  , R.string.app_name, R.string.app_name);

        mDrawerLayout.post(new Runnable()
        {

            @Override
            public void run()
            {

                mDrawerToggle.syncState();
            }
        });
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        /**
         * 设置抽屉栏每个选项要触发的界面
         */
        navigationView = (NavigationView) findViewById(R.id.nv_navigationview);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.item_home:
                        // 主页

                        return true;

                    case R.id.item_download:
                        // 离线缓存

                        return true;

                    case R.id.item_favourite:
                        // 我的收藏

                        return true;

                    case R.id.item_history:
                        // 历史记录

                        return true;

                    case R.id.item_group:
                        // 关注的人

                        return true;

                    case R.id.item_tracker:
                        // 消费记录

                        return true;

                    case R.id.item_theme:
                        // 主题选择

                        return true;

                    case R.id.item_app:
                        // 应用推荐

                        return true;

                    case R.id.item_settings:
                        // 设置中心

                        return true;
                }
                return false;
            }
        });
    }

/**
 * ActionBarDrawerToggle
 */



    private class ActionBarDrawerToggle extends android.support.v7.app.ActionBarDrawerToggle
    {

        public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar,
                                     int openDrawerContentDescRes, int closeDrawerContentDescRes)
        {

            super(activity, drawerLayout, toolbar, openDrawerContentDescRes, closeDrawerContentDescRes);
        }

        @Override
        public void onDrawerClosed(View drawerView)
        {

            super.onDrawerClosed(drawerView);
            invalidateOptionsMenu();
        }

        @Override
        public void onDrawerOpened(View drawerView)
        {

            super.onDrawerOpened(drawerView);
            invalidateOptionsMenu();
        }
    }

    /** drawer的监听 */
    private class MyDrawerListener implements DrawerLayout.DrawerListener {
        @Override
        public void onDrawerOpened(View drawerView) {// 打开drawer
            if (mDrawerToggle != null)
            {
                mDrawerToggle.onDrawerOpened(drawerView);
            }//开关状态改为opened
        }

        @Override
        public void onDrawerClosed(View drawerView) {// 关闭drawer
            if (mDrawerToggle != null)
            {
                mDrawerToggle.onDrawerClosed(drawerView);
            }//开关状态改为closed
        }

        @Override
        public void onDrawerSlide(View drawerView, float slideOffset) {// drawer滑动的回调
            if (mDrawerToggle != null)
            {
                mDrawerToggle.onDrawerSlide(drawerView, slideOffset);
            }
        }

        @Override
        public void onDrawerStateChanged(int newState) {// drawer状态改变的回调
            if (mDrawerToggle != null)
            {
                mDrawerToggle.onDrawerStateChanged(newState);
            }
        }
    }

    // 为了让活动菜单可用这个类必须存在
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tb_menu, menu);
        return true;
    }

    private void initTabLayout() {
        viewPager = findView(R.id.viewPager);

        tabLayout = findView(R.id.tabs);
        List<String> tabList = new ArrayList<>();
        tabList.add("直播");
        tabList.add("推荐");
        tabList.add("番剧");
        tabList.add("分区");
        tabList.add("关注");
        tabList.add("发现");
        tabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        //此处代码设置无效，不知道为啥？？？xml属性是可以的
//        tabLayout.setTabTextColors(android.R.color.white, android.R.color.holo_red_dark);//设置TabLayout两种状态
        tabLayout.addTab(tabLayout.newTab().setText(tabList.get(0)));//添加tab选项卡
        tabLayout.addTab(tabLayout.newTab().setText(tabList.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(tabList.get(2)));
        tabLayout.addTab(tabLayout.newTab().setText(tabList.get(3)));
        tabLayout.addTab(tabLayout.newTab().setText(tabList.get(4)));
        tabLayout.addTab(tabLayout.newTab().setText(tabList.get(5)));

        List<Fragment> fragmentList = new ArrayList<>();
        for (int i = 0; i < tabList.size(); i++) {
            Fragment f1 = new TabFragment();
            Bundle bundle = new Bundle();
            bundle.putString("content", "http://blog.csdn.net/feiduclear_up \n CSDN 废墟的树");
            f1.setArguments(bundle);
            fragmentList.add(f1);
        }

        TabFragmentAdapter fragmentAdapter = new TabFragmentAdapter(getSupportFragmentManager(), fragmentList, tabList);
        viewPager.setAdapter(fragmentAdapter);//给ViewPager设置适配器
        tabLayout.setupWithViewPager(viewPager);//将TabLayout和ViewPager关联起来。
        tabLayout.setTabsFromPagerAdapter(fragmentAdapter);//给Tabs设置适配器

    }
}
