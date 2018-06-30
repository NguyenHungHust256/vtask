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
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bahung.vtask.R;
import com.example.bahung.vtask.bean.Group;
import com.example.bahung.vtask.controller.MainActivityController;
import com.example.bahung.vtask.ui.adapter.MenuAdapter;
import com.example.bahung.vtask.ui.dialog.PresistentSingleChoiceSort;
import com.example.bahung.vtask.ui.fragment.MemberFragment.MemberFragment;
import com.example.bahung.vtask.ui.fragment.NotifyFragment.Notify_Fragment;
import com.example.bahung.vtask.ui.fragment.ProjectFragment.ProjectFragment;
import com.example.bahung.vtask.ui.fragment.TabJobFragment.TabJobFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private static final String TAG = "Test";
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    BottomNavigationView bottomNavigation;
    ListView listViewGroupMenu1;
    ListView listViewGroupMenu2;
    ArrayList<Group> dataGroup;
    ImageView navUpUser, navDownUser;
    LinearLayout layoutMenuGroup;
    ArrayAdapter mAdapter;
    TextView mEmptyView;
    FrameLayout mFrameLayout;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**
         * Hieen nut back
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         */
        mFrameLayout = findViewById(R.id.myLayout);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        mListView = (ListView) findViewById(R.id.list);
        mEmptyView = (TextView) findViewById(R.id.emptyView);
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
        listViewGroupMenu1 = navigationView.findViewById(R.id.listview_group_menu1);
        listViewGroupMenu2 = navigationView.findViewById(R.id.listview_group_menu2);
        createDataGroupMenu();
//        layoutmenuGroup
        layoutMenuGroup = navigationView.findViewById(R.id.layout_menu_group);
        MenuAdapter menuAdapter = new MenuAdapter(dataGroup, MainActivity.this);
        listViewGroupMenu1.setAdapter(menuAdapter);
        listViewGroupMenu2.setAdapter(menuAdapter);

//        Listview cho search view
        mAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.months_array));
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });
        mListView.setEmptyView(mEmptyView);
        //Thuc hien addFragment cua item 0 in NAVBT
        replaceFragment(R.id.myLayout, new TabJobFragment());
        mListView.setVisibility(View.GONE);


        // Bat su kien instanceof
    }

    private void createDataGroupMenu() {
        dataGroup = new ArrayList<>();
        dataGroup.add(new Group("", "San xuat may tinh", "nguyenbahung@gmail.com"));
        dataGroup.add(new Group("", "San xuat may tinh", "nguyenbahung@gmail.com"));
        dataGroup.add(new Group("", "San xuat may tinh", "nguyenbahung@gmail.com"));
        dataGroup.add(new Group("", "San xuat may tinh", "nguyenbahung@gmail.com"));
        dataGroup.add(new Group("", "San xuat may tinh", "nguyenbahung@gmail.com"));
        dataGroup.add(new Group("", "San xuat may tinh", "nguyenbahung@gmail.com"));
        dataGroup.add(new Group("", "San xuat may tinh", "nguyenbahung@gmail.com"));
        dataGroup.add(new Group("", "San xuat may tinh", "nguyenbahung@gmail.com"));
        dataGroup.add(new Group("", "San xuat may tinh", "nguyenbahung@gmail.com"));
    }

    public void replaceFragment(int id, Fragment fragment) {
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
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem mSearch = menu.findItem(R.id.search_id);
        SearchView mSearchView = (SearchView) mSearch.getActionView();
        mSearchView.setQueryHint("Search");

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return true;
            }
        });
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            mSearch.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {

                @Override
                public boolean onMenuItemActionCollapse(MenuItem item) {
                    mListView.setVisibility(View.GONE);
                    mFrameLayout.setVisibility(View.VISIBLE);
                    bottomNavigation.setVisibility(View.VISIBLE);
                    // Do something when collapsed
                    Log.i(TAG, "onMenuItemActionCollapse " + item.getItemId());
                    return true; // Return true to collapse action view
                }

                @Override
                public boolean onMenuItemActionExpand(MenuItem item) {
                    // TODO Auto-generated method stub
                    mListView.setVisibility(View.VISIBLE);
                    mFrameLayout.setVisibility(View.GONE);
                    bottomNavigation.setVisibility(View.GONE);
                    Log.i(TAG, "onMenuItemActionExpand " + item.getItemId());
                    return true;
                }
            });
        } else {
            // do something for phones running an SDK before froyo
            mSearchView.setOnCloseListener(new SearchView.OnCloseListener() {

                @Override
                public boolean onClose() {
                    mListView.setVisibility(View.GONE);
                    mFrameLayout.setVisibility(View.VISIBLE);
                    bottomNavigation.setVisibility(View.VISIBLE);
                    Log.i(TAG, "mSearchView on close ");
                    // TODO Auto-generated method stub
                    return false;
                }
            });
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.search_id:
                break;
            case R.id.action_sort:
                PresistentSingleChoiceSort dialogFragment = new PresistentSingleChoiceSort();
                dialogFragment.show(getSupportFragmentManager(),"");
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
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
                replaceFragment(R.id.myLayout, new TabJobFragment());
                Toast.makeText(this, "action_One", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_two:
                replaceFragment(R.id.myLayout, new ProjectFragment());
                Toast.makeText(this, "action_two", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_three:
                replaceFragment(R.id.myLayout, new Notify_Fragment());
                Toast.makeText(this, "action_three", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_four:
                replaceFragment(R.id.myLayout, new MemberFragment());
                Toast.makeText(this, "action_four", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.up_nav_id) {
            navigationView.getMenu().clear();
//                navigationView.inflateMenu(R.menu.menu_group_join);
            layoutMenuGroup.setVisibility(View.VISIBLE);
            navUpUser.setVisibility(View.GONE);
            navDownUser.setVisibility(View.VISIBLE);
        } else if (v.getId() == R.id.down_nav_id) {
            navigationView.getMenu().clear();
            layoutMenuGroup.setVisibility(View.GONE);
            navigationView.inflateMenu(R.menu.navigation_menu);
            navUpUser.setVisibility(View.VISIBLE);
            navDownUser.setVisibility(View.GONE);
        }
    }
}
