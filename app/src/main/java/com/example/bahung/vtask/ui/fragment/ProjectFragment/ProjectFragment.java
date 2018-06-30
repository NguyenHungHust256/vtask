package com.example.bahung.vtask.ui.fragment.ProjectFragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bahung.vtask.R;
import com.example.bahung.vtask.ui.activity.MainActivity;
import com.example.bahung.vtask.ui.adapter.ProjectTabAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectFragment extends Fragment {
    View mView;
    ViewPager viewPager;
    TabLayout tabLayout;

    public ProjectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_project, container, false);

        ((MainActivity)getActivity()).getSupportActionBar().setElevation(0);

        viewPager = (ViewPager) mView.findViewById(R.id.viewpager_project);
        tabLayout =(TabLayout) mView.findViewById(R.id.tabLayout_project);
        ProjectTabAdapter adapter = new ProjectTabAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return mView;
    }

}
