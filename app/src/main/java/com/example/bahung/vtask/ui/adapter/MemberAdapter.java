package com.example.bahung.vtask.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bahung.vtask.R;
import com.example.bahung.vtask.bean.Member;

import java.util.ArrayList;

/**
 * Created by bahung on 07/04/2018.
 **/

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.ViewHolder>{
    private Context context;
    private ArrayList<Member> datas = new ArrayList<>();
    TextView txtCounter;
    public MemberAdapter(Context context, ArrayList<Member> datas, TextView txtCounter) {
        this.context = context;
        this.datas = datas;
        this.txtCounter = txtCounter;
    }

    @Override
    public MemberAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(this.context);
        view = inflater.inflate(R.layout.custom_member, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MemberAdapter.ViewHolder holder, int position) {
        if(position < 3){
            txtCounter.setVisibility(View.VISIBLE);
        } else if(position>6){
            txtCounter.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
