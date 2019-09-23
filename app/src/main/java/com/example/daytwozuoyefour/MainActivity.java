package com.example.daytwozuoyefour;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.daytwozuoyefour.adapter.Adapterrlvone;
import com.example.daytwozuoyefour.bean.Beanone;
import com.example.daytwozuoyefour.model.MainModelceng;
import com.example.daytwozuoyefour.presenter.MainPresenterceng;
import com.example.daytwozuoyefour.view.MainView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainView {

    private RecyclerView mRlv;
    private ArrayList<Beanone.BodyBean.ResultBean> list;
    private Adapterrlvone adapterrlvone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAdd();
        initView();
    }

    private void initView() {
        mRlv = (RecyclerView) findViewById(R.id.rlv);
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapterrlvone = new Adapterrlvone(list, this);
        mRlv.setAdapter(adapterrlvone);

        adapterrlvone.setOnItemClickListener(new Adapterrlvone.OnItemClickListener() {
            @Override
            public void OnItemClick(int i) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                Beanone.BodyBean.ResultBean bean = list.get(i);
                intent.putExtra("ID",bean.getID()+"");
                intent.putExtra("bean",list.get(i));
                startActivity(intent);
            }
        });

    }

    private void initAdd() {
        MainPresenterceng mainPresenterceng = new MainPresenterceng(new MainModelceng(), this);
        mainPresenterceng.getData();
    }

    @Override
    public void onSeecss(Beanone beanone) {
        list.addAll(beanone.getBody().getResult());
        adapterrlvone.notifyDataSetChanged();
    }

    @Override
    public void onError(String str) {
        Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
    }
}
