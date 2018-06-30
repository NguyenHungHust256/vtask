package com.example.bahung.vtask.ui.fragment.MemberFragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bahung.vtask.R;
import com.example.bahung.vtask.bean.Member;
import com.example.bahung.vtask.ui.activity.AddMemberActivity;
import com.example.bahung.vtask.ui.adapter.MemberAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MemberFragment extends Fragment implements View.OnClickListener {
    RecyclerView rcvMember;
    ArrayList<Member> datas = new ArrayList<>();
    FloatingActionButton fabMember;
    TextView txtCounterMember;

    public MemberFragment() {
       
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_member, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        anhXa(view);
        initData();
        MemberAdapter adapter = new MemberAdapter(getActivity(), datas, txtCounterMember);
        RecyclerView.LayoutManager giaoDien = new LinearLayoutManager(getActivity());
        rcvMember.setLayoutManager(giaoDien);
        rcvMember.setAdapter(adapter);
        fabMember.setOnClickListener(this);
    }

    private void initData() {
        datas.add(new Member("","","",""));
        datas.add(new Member("","","",""));
        datas.add(new Member("","","",""));
        datas.add(new Member("","","",""));
        datas.add(new Member("","","",""));
        datas.add(new Member("","","",""));
        datas.add(new Member("","","",""));
        datas.add(new Member("","","",""));
        datas.add(new Member("","","",""));
    }

    private void anhXa(View view) {
        rcvMember = view.findViewById(R.id.rcvMember);
        fabMember = view.findViewById(R.id.fabMember);
        txtCounterMember = view.findViewById(R.id.txtCounter);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.fabMember){
            Intent intent = new Intent(getActivity(), AddMemberActivity.class);
            startActivity(intent);
        }
    }
}
