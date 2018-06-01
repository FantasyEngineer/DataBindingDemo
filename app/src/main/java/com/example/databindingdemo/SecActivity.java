package com.example.databindingdemo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.databindingdemo.databinding.ActivityMainBinding;
import com.example.databindingdemo.databinding.ActivitySecBinding;
import com.example.databindingdemo.deo.ChildViewMaster;
import com.example.databindingdemo.deo.ImgItem;

import java.util.ArrayList;
import java.util.List;

public class SecActivity extends AppCompatActivity {
    private List<ImgItem> childbeanList;
    private ChildViewMaster childMaster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
        childMaster = findViewById(R.id.childMaster);
        childbeanList = new ArrayList<>();
        childbeanList.add(new ImgItem("full", "2", "left", "21231"));
        childbeanList.add(new ImgItem("1", "3", "left", "21231"));
        childbeanList.add(new ImgItem("2", "3", "right", "21231"));
        childMaster.setItemList(childbeanList);
    }

    public void flush(View view) {
        childbeanList.add(new ImgItem("full", "2", "left", "21231"));
        childMaster.setItemList(childbeanList);
    }
}
