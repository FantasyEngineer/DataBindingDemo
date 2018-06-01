package com.example.databindingdemo.deo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zrh on 2018/6/1.
 */

public class CustomImgItem {

    List<ImgItemJson> imgItems = new ArrayList<>();

    public List<ImgItemJson> getImgItems() {
        return imgItems;
    }

    public void setImgItems(List<ImgItemJson> imgItems) {
        this.imgItems = imgItems;
    }
}
