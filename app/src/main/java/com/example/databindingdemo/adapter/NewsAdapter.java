package com.example.databindingdemo.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.ViewGroup;

import com.example.databindingdemo.BR;
import com.example.databindingdemo.R;
import com.example.databindingdemo.base.BaseAdapter;
import com.example.databindingdemo.base.BaseViewHolder;
import com.example.databindingdemo.model.SimpleNewsBean;

/**
 * Created by Administrator on 2018/5/23.
 */

//public class NewsAdapter extends BaseAdapter<SimpleNewsBean, BaseViewHolder> {
//    public NewsAdapter(Context context) {
//        super(context);
//    }
//
//    @Override
//    public BaseViewHolder onCreateVH(ViewGroup parent, int viewType) {
//        ViewDataBinding dataBinding = DataBindingUtil.inflate(inflater, R.layout.item_news, parent, false);
//        return new BaseViewHolder(dataBinding);
//    }
//
//    @Override
//    public void onBindVH(BaseViewHolder baseViewHolder, int position) {
//        ViewDataBinding binding = baseViewHolder.getBinding();
//        binding.setVariable(BR.position, position);
//        binding.setVariable(BR.simpleNewsBean, mList.get(position));
//        binding.setVariable(BR.adapter, this);
//        binding.executePendingBindings(); //防止闪烁
//    }
//
//    /**
//     * 点赞
//     *
//     * @param simpleNewsBean
//     * @param position
//     */
//    public void clickDianZan(SimpleNewsBean simpleNewsBean, int position) {
//        if (simpleNewsBean.isGood.get()) {
//            simpleNewsBean.isGood.set(false);
//        } else {
//            simpleNewsBean.isGood.set(true);
//        }
//    }
//}
