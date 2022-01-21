package com.bkacad.nnt.simplemvcdemo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bkacad.nnt.simplemvcdemo.R;
import com.bkacad.nnt.simplemvcdemo.presenter.MainPresenter;
import com.bkacad.nnt.simplemvcdemo.presenter.MainPresenterImpl;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener {

    private Button btnGet;
    private TextView tvResult;
    private MainPresenter mainPresenter;

    private void initUI(){
        btnGet = findViewById(R.id.btn_main_get);
        tvResult = findViewById(R.id.tv_main_result);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Tạo presenter
        mainPresenter = new MainPresenterImpl(this);
        initUI();
        btnGet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_main_get){
            mainPresenter.onGetData();
        }
    }

    @Override
    public void getDataSuccess(String data) {
        tvResult.setText(data);
        tvResult.setTextColor(getResources().getColor(android.R.color.holo_green_light));
    }

    @Override
    public void getDataFail(String error) {
        tvResult.setText(error);
        tvResult.setTextColor(getResources().getColor(android.R.color.holo_red_light));

    }

}