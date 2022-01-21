package com.bkacad.nnt.simplemvcdemo.presenter;

import android.os.Handler;

import com.bkacad.nnt.simplemvcdemo.model.MainIterator;
import com.bkacad.nnt.simplemvcdemo.model.MainIteratorImpl;
import com.bkacad.nnt.simplemvcdemo.model.MyMessage;
import com.bkacad.nnt.simplemvcdemo.view.MainView;

public class MainPresenterImpl implements MainPresenter{

    private MainView mainView;
    private MainIterator mainIterator;

    public MainPresenterImpl(MainView mainView){
        this.mainView = mainView;
        this.mainIterator = new MainIteratorImpl();
    }

    @Override
    public void onGetData() {
        // Gọi model (hoặc tools) xử lý ...
        // Fake sau 1s mới lấy dc
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Trả kết quả cho main
                MyMessage msg = mainIterator.handleGetData();
                if(msg.what == 0){
                    mainView.getDataFail(msg.content);
                }
                else{
                    mainView.getDataSuccess(msg.content);
                }
            }
        },1000);
    }
}
