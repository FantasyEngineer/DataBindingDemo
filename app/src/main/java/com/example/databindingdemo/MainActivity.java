package com.example.databindingdemo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.databindingdemo.databinding.ActivityMainBinding;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

public class MainActivity extends AppCompatActivity implements XRecyclerView.LoadingListener {

    private ActivityMainBinding binding;
//    private NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(
                this, R.layout.activity_main);
//        initRecyclerView();
        startActivity(new Intent(this, SecActivity.class));
    }

    /**
     * 初始化RecyclerView
     */
    private void initRecyclerView() {
//        binding.newsRv.setRefreshProgressStyle(ProgressStyle.BallClipRotate); //设置下拉刷新的样式
//        binding.newsRv.setLoadingMoreProgressStyle(ProgressStyle.BallClipRotate); //设置上拉加载更多的样式
//        binding.newsRv.setLoadingListener(this);
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        binding.newsRv.setLayoutManager(layoutManager);
//        newsAdapter = new NewsAdapter(this);
//        binding.newsRv.setAdapter(newsAdapter);
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }


}
