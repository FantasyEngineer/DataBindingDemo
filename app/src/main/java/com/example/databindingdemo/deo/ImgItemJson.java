package com.example.databindingdemo.deo;


import java.io.Serializable;
import java.util.List;

/**
 * Created by zrh on 2018/6/1.
 */

public class ImgItemJson implements Serializable {

    private String totalcount;
    private String title;
    private String icon;
    private List<ImgItem> imageItems;

    public String getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(String totalcount) {
        this.totalcount = totalcount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<ImgItem> getImageItems() {
        return imageItems;
    }

    public void setImageItems(List<ImgItem> imageItems) {
        this.imageItems = imageItems;
    }
}
