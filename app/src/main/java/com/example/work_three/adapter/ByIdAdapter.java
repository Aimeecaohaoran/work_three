package com.example.work_three.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.work_three.R;
import com.example.work_three.bean.ByIdBean;


import java.util.ArrayList;
import java.util.List;

public class ByIdAdapter extends RecyclerView.Adapter<ByIdAdapter.ViewHolder> {

    ByIdBean byIdBean;
    private Context context;

    public ByIdAdapter(Context context, ByIdBean byIdBean) {
        this.context = context;
        this.byIdBean=byIdBean;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.item_pin,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        Glide.with(context).load(byIdBean.getResult().get(i).getMasterPic()).into(viewHolder.imageView);
        viewHolder.name.setText(byIdBean.getResult().get(i).getCommodityName());
        viewHolder.price.setText(byIdBean.getResult().get(i).getPrice());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    listener.setonclicklisener(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return byIdBean.getResult().size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView name,price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            name=itemView.findViewById(R.id.name);
            price=itemView.findViewById(R.id.price);
        }
    }
    private TopHomeAdapter.Cicklistener listener;

    public void result(TopHomeAdapter.Cicklistener listener) {
        this.listener = listener;
    }
    public interface Cicklistener {
        void setonclicklisener(int index);
    }
}