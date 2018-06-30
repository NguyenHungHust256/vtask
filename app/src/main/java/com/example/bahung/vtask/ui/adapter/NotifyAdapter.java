package com.example.bahung.vtask.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bahung.vtask.R;
import com.example.bahung.vtask.bean.Notify;

import java.util.ArrayList;

/**
 * Created by bahung on 26/03/2018.
 **/

public class NotifyAdapter extends RecyclerView.Adapter<NotifyAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Notify> notifyData = new ArrayList<>();

    public NotifyAdapter(Context context, ArrayList<Notify> notifyData) {
        this.context = context;
        this.notifyData = notifyData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(this.context);
        view = inflater.inflate(R.layout.custom_item_notify, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return notifyData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txtNameProject);
        }
    }
}
