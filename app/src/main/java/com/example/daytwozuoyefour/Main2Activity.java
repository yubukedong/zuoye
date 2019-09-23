package com.example.daytwozuoyefour;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.daytwozuoyefour.adapter.Adapterrlvone;
import com.example.daytwozuoyefour.adapter.Adapterrlvtwo;
import com.example.daytwozuoyefour.bean.Beanone;
import com.example.daytwozuoyefour.fragment.JieShaoFragment;
import com.example.daytwozuoyefour.fragment.KeChengFragment;
import com.example.daytwozuoyefour.fragment.ZhuanTiFragment;

import java.io.Serializable;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private TabLayout mTab;
    private ViewPager mVp;
    private RecyclerView mRlvs;
    private Beanone.BodyBean.ResultBean bean;
    private ArrayList<Beanone.BodyBean.ResultBean> list;
    private Adapterrlvtwo adapterrlvtwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mRlvs = (RecyclerView) findViewById(R.id.rlvs);
        mTab = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);
        Intent intent = getIntent();
        bean = (Beanone.BodyBean.ResultBean) intent.getSerializableExtra("bean");
        String id = intent.getStringExtra("ID");
        mRlvs.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapterrlvtwo = new Adapterrlvtwo(list, this);
        list.add(bean);
        mRlvs.setAdapter(adapterrlvtwo);
        final ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new JieShaoFragment());
        fragments.add(new KeChengFragment());
        fragments.add(new ZhuanTiFragment());

        mVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        mTab.setupWithViewPager(mVp);
        mTab.getTabAt(0).setText("介绍").setIcon(null);
        mTab.getTabAt(1).setText("课程").setIcon(null);
        mTab.getTabAt(2).setText("专题").setIcon(null);
    }
}
