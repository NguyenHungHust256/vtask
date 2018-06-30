package com.example.bahung.vtask.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.bahung.vtask.ui.fragment.ProjectFragment.IsDoingProjectFragment;

/**
 * Created by bahung on 27/03/2018.
 **/

public class ProjectTabAdapter extends FragmentPagerAdapter {
    public static final int PAGE_COUNT = 2;
    public static final String tieuDeTabs[] = new String[]{"ĐANG LÀM",  "HOÀN THÀNH"};

    public ProjectTabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if(position == 0){
            fragment = new IsDoingProjectFragment();

        } else if(position == 1) {
            fragment = new IsDoingProjectFragment();
        }
        return  fragment;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tieuDeTabs[position];
    }
}
