package com.example.bahung.vtask.ui.fragment.ProjectFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bahung.vtask.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompletedProjectFragment extends Fragment {


    public CompletedProjectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_completed_project, container, false);
    }

}
