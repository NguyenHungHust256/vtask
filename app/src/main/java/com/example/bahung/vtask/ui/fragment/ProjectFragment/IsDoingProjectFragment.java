package com.example.bahung.vtask.ui.fragment.ProjectFragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bahung.vtask.R;
import com.example.bahung.vtask.bean.Project;
import com.example.bahung.vtask.ui.adapter.ItemProjectAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class IsDoingProjectFragment extends Fragment {
    ArrayList<Project> datas = new ArrayList<>();
    RecyclerView rcv;
    public IsDoingProjectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_is_doing_project, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        anhXa(view);
        initData();
        ItemProjectAdapter itemProjectAdapter = new ItemProjectAdapter(getContext(), datas);
        rcv.setAdapter(itemProjectAdapter);
        rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        // That's all!
    }

    private void anhXa(View v) {
        rcv = v.findViewById(R.id.rcv_doing_project);
    }

    private void initData() {
        datas.add(new Project("a"));
        datas.add(new Project("a"));
        datas.add(new Project("a"));
        datas.add(new Project("a"));
        datas.add(new Project("a"));
    }
}
