package com.example.bahung.vtask.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.bahung.vtask.R;
import com.example.bahung.vtask.bean.Member;
import com.example.bahung.vtask.ui.adapter.AddMemberAdapter;

import java.util.ArrayList;

public class AddMemberActivity extends AppCompatActivity  {
    RecyclerView rcvAddMember;
    ArrayList<Member> datas = new ArrayList<>();
    AddMemberAdapter adapter;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);
        anhXa();
        initDatas();
        catchEventToolbar();
        adapter = new AddMemberAdapter(this, datas);
        RecyclerView.LayoutManager giaoDien = new LinearLayoutManager(this);
        rcvAddMember.setLayoutManager(giaoDien);
        rcvAddMember.setAdapter(adapter);

//        Bat su kien search

    }

    private void catchEventToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    private void filter(String s) {
        ArrayList<Member> filter = new ArrayList<>();
        for(Member m: datas){
            if(m.getName().toLowerCase().contains(s.toLowerCase())) {
                filter.add(m);
            }
        }
        adapter.filterList(filter);
    }

    private void initDatas() {
        datas.add(new Member("", "", "",""));
        datas.add(new Member("", "", "",""));
        datas.add(new Member("", "", "",""));
        datas.add(new Member("", "", "",""));
        datas.add(new Member("", "", "",""));
        datas.add(new Member("", "", "",""));
        datas.add(new Member("", "", "",""));
    }

    private void anhXa() {
        rcvAddMember = findViewById(R.id.rcvAddMember);
        toolbar = findViewById(R.id.toolbar_add_member);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

//                Intent intent = new Intent(AddMemberActivity.this, MainActivity.class);
//                startActivity(intent);
                onBackPressed();
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_add_member, menu);
        MenuItem mSearch = menu.findItem(R.id.search_id);
        SearchView mSearchView = (SearchView) mSearch.getActionView();
        mSearchView.setQueryHint("Search");

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
//                adapter.getFilter().filter(newText);
                filter(s);
                return true;
            }
        });
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            mSearch.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {

                @Override
                public boolean onMenuItemActionCollapse(MenuItem item) {

                    return true; // Return true to collapse action view
                }

                @Override
                public boolean onMenuItemActionExpand(MenuItem item) {
                    // TODO Auto-generated method stub

                    return true;
                }
            });
        } else {
            // do something for phones running an SDK before froyo
            mSearchView.setOnCloseListener(new SearchView.OnCloseListener() {

                @Override
                public boolean onClose() {

                    // TODO Auto-generated method stub
                    return false;
                }
            });
        }

        return true;
    }
}
