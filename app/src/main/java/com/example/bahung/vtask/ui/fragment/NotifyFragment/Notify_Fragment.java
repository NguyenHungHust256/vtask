package com.example.bahung.vtask.ui.fragment.NotifyFragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bahung.vtask.R;
import com.example.bahung.vtask.bean.Notify;
import com.example.bahung.vtask.ui.adapter.NotifyAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Notify_Fragment extends Fragment {
    ArrayList<Notify> datas = new ArrayList<>();
    RecyclerView rcvProject;
    public Notify_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notify, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        anhXa(view);
        initData();
        NotifyAdapter adapter = new NotifyAdapter(getActivity(), datas);
        RecyclerView.LayoutManager giaoDien = new LinearLayoutManager(getActivity());
        rcvProject.setLayoutManager(giaoDien);
        rcvProject.setAdapter(adapter);
    }

    private void initData() {
        datas.add(new Notify("Hoan thanh giao dien"));
        datas.add(new Notify("Hoan thanh giao dien"));
        datas.add(new Notify("Hoan thanh giao dien"));
        datas.add(new Notify("Hoan thanh giao dien"));
        datas.add(new Notify("Hoan thanh giao dien"));
        datas.add(new Notify("Hoan thanh giao dien"));
        datas.add(new Notify("Hoan thanh giao dien"));
    }

    private void anhXa(View view) {
        rcvProject = view.findViewById(R.id.rcv_project);
    }
}
