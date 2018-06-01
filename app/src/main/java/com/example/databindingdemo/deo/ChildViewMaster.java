package com.example.databindingdemo.deo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import com.example.databindingdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zrh on 2018/5/27.
 */

public class ChildViewMaster extends ViewGroup {
    private Context context;
    private OnClickListener mOnClickListener;

    public ChildViewMaster(Context context) {
        this(context, null);
    }

    public ChildViewMaster(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public void setmOnClickListener(OnClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }

    public interface OnClickListener {
        void onClick(String bean);
    }

    List<View> lefViews = new ArrayList<>();
    List<View> rightViews = new ArrayList<>();
    List<View> fullViews = new ArrayList<>();

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 获得它的父容器为它设置的测量模式和大小
        int parentHight = 0;
        int leftHight = 0;
        int rightHight = 0;
        int fullHight = 0;
        // 如果是warp_content情况下，记录宽和高
        int width = 1080;
        int height = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            ImgItem childBean = (ImgItem) child.getTag();
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            if ("left".equals(childBean.getPosLocation())) {
                leftHight = leftHight + child.getMeasuredHeight() + 10;

                if (fullHight != 0) {
                    if (rightHight != 0) {//判断是否添加左布局
                        parentHight = leftHight > rightHight ? leftHight + fullHight : rightHight + fullHight;
                    } else {
                        parentHight = leftHight + fullHight;
                    }
                } else {
                    if (rightHight != 0) {//判断是否添加左布局
                        parentHight = leftHight > rightHight ? leftHight : rightHight;
                    } else {
                        parentHight = leftHight + 10;
                    }
                }
            } else if ("right".equals(childBean.getPosLocation())) {
                rightHight = rightHight + child.getMeasuredHeight() + 10;

                if (fullHight != 0) {
                    if (leftHight != 0) {//判断是否添加左布局
                        parentHight = leftHight > rightHight ? leftHight + fullHight : rightHight + fullHight;
                    } else {
                        parentHight = rightHight + fullHight;
                    }
                } else {
                    if (leftHight != 0) {//判断是否添加左布局
                        parentHight = leftHight > rightHight ? leftHight : rightHight;
                    } else {
                        parentHight = rightHight;
                    }
                }
            } else if ("full".equals(childBean.getPosLocation())) {
                fullHight = fullHight + child.getMeasuredHeight() + 10;
                parentHight = Math.max(leftHight, rightHight) + fullHight + 10;
                Log.d("parentHightfrrrrr----", parentHight + "");
            }
        }
        Log.d("yang_scroll", "测量高度：" + parentHight);
        setMeasuredDimension(width, parentHight);
    }

    /***
     * 设置数据源
     * @param childBeanList
     */

    public void setItemList(final List<ImgItem> childBeanList) {
        for (int i = 0; i < childBeanList.size(); i++) {
            final LinearLayout linearLayout = new LinearLayout(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT
                    , LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.height = (int) Screen.dip2px(context, Integer.parseInt(childBeanList.get(i).getHeight()) * 50);
            if ("left".equals(childBeanList.get(i).getPosLocation())) {
                linearLayout.setTag(childBeanList.get(i));
                layoutParams.width = Screen.getScreen(context).widthPixels / 2;
                layoutParams.setMargins(0, 10, 0, 0);
                linearLayout.setBackgroundResource(R.color.colorAccent);
                linearLayout.setLayoutParams(layoutParams);
                addView(linearLayout);
            } else if ("right".equals(childBeanList.get(i).getPosLocation())) {
                linearLayout.setTag(childBeanList.get(i));
                layoutParams.width = Screen.getScreen(context).widthPixels / 2;
                layoutParams.setMargins(0, 10, 0, 0);
                linearLayout.setBackgroundResource(R.color.colorPrimary);
                linearLayout.setLayoutParams(layoutParams);
                addView(linearLayout);
            } else if ("full".equals(childBeanList.get(i).getPosLocation())) {
                linearLayout.setTag(childBeanList.get(i));
                layoutParams.width = Screen.getScreen(context).widthPixels;
                layoutParams.setMargins(0, 10, 0, 0);
                linearLayout.setBackgroundResource(R.color.colorPrimary);
                linearLayout.setLayoutParams(layoutParams);
                addView(linearLayout);
            }
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnClickListener != null) {
                        mOnClickListener.onClick((String) linearLayout.getTag());
                    }
                }
            });
        }
//        requestLayout();
    }

    int tempMaxHight = 0;

    /**
     * 保存高度
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.d("onLayout", "onLayout: ");
        int left = 0;
        int right = 0;
        int top = 0;
        int bottom = 0;
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            ImgItem childBean = (ImgItem) child.getTag();
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            if ("left".equals(childBean.getPosLocation())) {
                left = 0;
                right = child.getMeasuredWidth();
                if (lefViews.size() == 0) {
                    if (tempMaxHight == 0) {
                        top = lp.topMargin + getFullViewHight();
                    } else {
                        top = tempMaxHight + lp.topMargin;
                    }
                    bottom = top + child.getMeasuredHeight();
                } else {
                    if (tempMaxHight == 0) {
                        top = lp.topMargin + getFullViewHight() + getLefthViewHight();
                    } else {
                        top = tempMaxHight + getLefthViewHight() + lp.topMargin;
                    }
                    bottom = top + child.getMeasuredHeight();
                }
                lefViews.add(child);
            } else if ("right".equals(childBean.getPosLocation())) {
                left = child.getMeasuredWidth() + lp.leftMargin;
                right = 2 * left;
                if (rightViews.size() == 0) {
                    if (tempMaxHight == 0) {
                        top = lp.topMargin + getFullViewHight();
                    } else {
                        top = lp.topMargin + tempMaxHight;
                    }
                    bottom = top + child.getMeasuredHeight();
                } else {
                    if (tempMaxHight == 0) {
                        top = getRightViewHight() + getFullViewHight() + lp.topMargin;
                    } else {
                        top = tempMaxHight + getRightViewHight() + lp.topMargin;
                    }
                    bottom = top + child.getMeasuredHeight();
                }
                rightViews.add(child);
            } else if ("full".equals(childBean.getPosLocation())) {
                left = lp.leftMargin;
                top = 0;
                right = Screen.getScreen(context).widthPixels;
                if (fullViews.size() == 0) {
                    left = lp.leftMargin;
                    top = lp.topMargin + Math.max(getLefthViewHight(), getRightViewHight());
                    bottom = top + child.getMeasuredHeight();
                } else {
                    if (getLefthViewHight() > getRightViewHight()) {
                        Log.d("childmasterRightHight--", "左边》》》》右边");
                        top = tempMaxHight + getLefthViewHight() + lp.topMargin;
                        bottom = top + child.getMeasuredHeight();
                    } else {
                        Log.d("childmasterRightHight--", "左边《《《《右边");
                        top = tempMaxHight + getRightViewHight() + lp.topMargin;
                        bottom = top + child.getMeasuredHeight();
                    }
                }
                fullViews.add(child);
                //full 时 保存高度，清除左右list数据
                tempMaxHight = tempMaxHight + Math.max(getLefthViewHight(), getRightViewHight()) + child.getMeasuredHeight() + lp.topMargin;
                lefViews.clear();
                rightViews.clear();
                requestLayout();
                invalidate();
            }
            child.layout(left, top, right, bottom);

        }
    }

    /**
     * 得到左边View的总高度
     *
     * @return
     */
    public int getLefthViewHight() {
        int leftHight = 0;
        for (int i = 0; i < lefViews.size(); i++) {
            leftHight = leftHight + (lefViews.get(i).getMeasuredHeight() + 10);
        }
        return leftHight;
    }

    /**
     * 得到右边View的总高度
     *
     * @return
     */
    public int getRightViewHight() {
        int rightHight = 0;
        for (int i = 0; i < rightViews.size(); i++) {
            rightHight = rightHight + (rightViews.get(i).getMeasuredHeight() + 10);
        }
        return rightHight;
    }

    /**
     * 得到右边View的总高度
     *
     * @return
     */
    public int getFullViewHight() {
        int fullHight = 0;
        for (int i = 0; i < fullViews.size(); i++) {
            fullHight = fullHight + (fullViews.get(i).getMeasuredHeight() + 10);
        }
        return fullHight;
    }
}
