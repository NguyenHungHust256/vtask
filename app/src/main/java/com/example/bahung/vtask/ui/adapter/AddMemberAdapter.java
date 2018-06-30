package com.example.bahung.vtask.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bahung.vtask.R;
import com.example.bahung.vtask.bean.Member;

import java.util.ArrayList;

/**
 * Created by bahung on 08/04/2018.
 **/

public class AddMemberAdapter extends RecyclerView.Adapter<AddMemberAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Member> datas = new ArrayList<>();

    public AddMemberAdapter(Context context, ArrayList<Member> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public AddMemberAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(this.context);
        view = inflater.inflate(R.layout.custom_item_add_friend, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AddMemberAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void filterList(ArrayList<Member> filter) {
        datas = filter;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
