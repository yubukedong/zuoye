package com.example.daytwozuoyefour.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.daytwozuoyefour.R;
import com.example.daytwozuoyefour.bean.Beanone;

import java.util.ArrayList;
import java.util.List;

public class Adapterrlvtwo extends RecyclerView.Adapter<Adapterrlvtwo.Holderone> {
    private ArrayList<Beanone.BodyBean.ResultBean> list;
    private Context context;

    public Adapterrlvtwo(ArrayList<Beanone.BodyBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holderone onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_one, viewGroup, false);
        return new Holderone(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Holderone holderone, final int i) {
        Beanone.BodyBean.ResultBean bean = list.get(i);
        holderone.tv_teacherName.setText(bean.getTeacherName());
        holderone.tv_title.setText(bean.getTitle());
        Glide.with(context).load(bean.getTeacherPic()).circleCrop().into(holderone.iv_teacherPic);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holderone extends RecyclerView.ViewHolder {

        private final ImageView iv_teacherPic;
        private final TextView tv_teacherName;
        private final TextView tv_title;
        private final TextView tv_typename;

        public Holderone(@NonNull View itemView) {
            super(itemView);
            iv_teacherPic = itemView.findViewById(R.id.iv_TeacherPic);
            tv_teacherName = itemView.findViewById(R.id.tv_TeacherName);
            tv_title = itemView.findViewById(R.id.tv_Title);
            tv_typename = itemView.findViewById(R.id.tv_typename);
        }
    }
}
