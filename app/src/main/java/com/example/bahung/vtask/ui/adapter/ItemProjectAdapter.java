package com.example.bahung.vtask.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bahung.vtask.R;
import com.example.bahung.vtask.bean.Project;

import java.util.ArrayList;

/**
 * Created by bahung on 27/03/2018.
 **/

public class ItemProjectAdapter  extends RecyclerView.Adapter<ItemProjectAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Project> datas = new ArrayList<>();

    public ItemProjectAdapter(Context context, ArrayList<Project> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public ItemProjectAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(this.context);
        view = inflater.inflate(R.layout.custom_doing_project, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemProjectAdapter.ViewHolder holder, int position) {

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
