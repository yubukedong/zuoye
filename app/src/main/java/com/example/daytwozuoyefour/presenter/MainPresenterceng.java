package com.example.daytwozuoyefour.presenter;


import com.example.daytwozuoyefour.model.MainModel;
import com.example.daytwozuoyefour.bean.Beanone;
import com.example.daytwozuoyefour.view.MainView;

public class MainPresenterceng implements MainPresenter, MainView {
    private MainModel mainModel;
    private MainView mainView;

    public MainPresenterceng(MainModel mainModel, MainView mainView) {
        this.mainModel = mainModel;
        this.mainView = mainView;
    }

    @Override
    public void getData() {
        mainModel.getData(this);
    }

    @Override
    public void onSeecss(Beanone beanone) {
        mainView.onSeecss(beanone);
    }

    @Override
    public void onError(String str) {
        mainView.onError(str);
    }
}
