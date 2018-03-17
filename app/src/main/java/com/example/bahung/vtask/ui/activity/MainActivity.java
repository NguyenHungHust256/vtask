package com.example.bahung.vtask.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bahung.vtask.R;
import com.example.bahung.vtask.bean.Group;
import com.example.bahung.vtask.controller.MainActivityController;
import com.example.bahung.vtask.ui.adapter.MenuAdapter;
import com.example.bahung.vtask.ui.fragment.TabJobFragment.TabJobFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    BottomNavigationView bottomNavigation;
    ListView listViewGroupMenu;
    ArrayList<Group> dataGroup;
    ImageView navUpUser, navDownUser;
    LinearLayout layoutMenuGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**
         * Hieen nut back
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         */

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        bottomNavigation = findViewById(R.id.bottom_navigation);
//        Bat id cho navUp va navDown
        View header = navigationView.getHeaderView(0);
        navUpUser = header.findViewById(R.id.up_nav_id);
        navDownUser = header.findViewById(R.id.down_nav_id);
//        Mac dinh la chon item 1
        bottomNavigation.setSelectedItemId(R.id.action_one);
//        bottomNavigation.performClick();
//An title va chinh lai item bottomNav co dinh
        MainActivityController.disableShiftMode(bottomNavigation);
//Chinh lai size icon
        MainActivityController.changeIconBottomNav(bottomNavigation, this);
//        Bat su kien cho BottomNavItem
        bottomNavigation.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.setDrawerListener(toggle);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(3).setVisible(true);
//        Bat su kien cho navUpUser
        navUpUser.setOnClickListener(this);
//        Bat su kien cho navDownUser
        navDownUser.setOnClickListener(this);
        toggle.syncState();
//        Bat su kien cho listview
        listViewGroupMenu = navigationView.findViewById(R.id.listview_group_menu);
        createDataGroupMenu();
//        layoutmenuGroup
        layoutMenuGroup = navigationView.findViewById(R.id.layout_menu_group);
        MenuAdapter menuAdapter = new MenuAdapter(dataGroup, MainActivity.this);
        listViewGroupMenu.setAdapter(menuAdapter);
        //Thuc hien addFragment cua item 0 in NAVBT
        addFragment(R.id.myLayout, new TabJobFragment());
//
    }

    private void createDataGroupMenu() {
        dataGroup = new ArrayList<>();
        dataGroup.add(new Group("","San xuat may tinh","nguyenbahung@gmail.com"));
        dataGroup.add(new Group("","San xuat may tinh","nguyenbahung@gmail.com"));
        dataGroup.add(new Group("","San xuat may tinh","nguyenbahung@gmail.com"));
    }

    public void addFragment(int id, Fragment fragment) {
        String name = fragment.getClass().getName();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(id, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
        transaction.addToBackStack(name);
        transaction.commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.search_id:
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.subject_id:

                Toast.makeText(this, "Chủ đề Dự án", Toast.LENGTH_SHORT).show();
                break;
            case R.id.member_id:
                Toast.makeText(this, "Thành viên", Toast.LENGTH_SHORT).show();
                break;
            case R.id.notify_id:
                Toast.makeText(this, "Thông báo", Toast.LENGTH_SHORT).show();
                break;
            case R.id.info_id:
                Toast.makeText(this, "Thông tin tài khoản", Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting_id:
                Toast.makeText(this, "Cài đặt phần mềm", Toast.LENGTH_SHORT).show();
                break;
            case R.id.waiting_id:
                Toast.makeText(this, "Đang chờ duyệt", Toast.LENGTH_SHORT).show();
                break;
            case R.id.join_id:
                Toast.makeText(this, "Đã tham gia", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_one:
                addFragment(R.id.myLayout, new TabJobFragment());
                Toast.makeText(this, "action_One", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_two:
                Toast.makeText(this, "action_two", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_three:
                Toast.makeText(this, "action_three", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_four:
                Toast.makeText(this, "action_four", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.up_nav_id){
                navigationView.getMenu().clear();
//                navigationView.inflateMenu(R.menu.menu_group_join);
            layoutMenuGroup.setVisibility(View.VISIBLE);
                navUpUser.setVisibility(View.GONE);
                navDownUser.setVisibility(View.VISIBLE);
        } else if(v.getId() == R.id.down_nav_id){
            navigationView.getMenu().clear();
            layoutMenuGroup.setVisibility(View.GONE);
            navigationView.inflateMenu(R.menu.navigation_menu);
            navUpUser.setVisibility(View.VISIBLE);
            navDownUser.setVisibility(View.GONE);
        }
    }
}
