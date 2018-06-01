package com.example.databindingdemo.deo;

import java.io.Serializable;

/**
 * Created by zrh on 2018/6/1.
 */

public class ImgItem implements Serializable {
    private String type;
    private String width;
    private String height;
    private String align;
    private String onlyImage;
    private String image;
    private String techIcon1;
    private String techIcon2;
    private String title;
    private String titleColor;
    private String subtitle;
    private String subtitleColor;
    private String sku;
    private String price;
    private String start;

    public ImgItem(String width, String height, String align, String subtitle) {
        this.width = width;
        this.height = height;
        this.align = align;
        this.subtitle = subtitle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public String getOnlyImage() {
        return onlyImage;
    }

    public void setOnlyImage(String onlyImage) {
        this.onlyImage = onlyImage;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTechIcon1() {
        return techIcon1;
    }

    public void setTechIcon1(String techIcon1) {
        this.techIcon1 = techIcon1;
    }

    public String getTechIcon2() {
        return techIcon2;
    }

    public void setTechIcon2(String techIcon2) {
        this.techIcon2 = techIcon2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getSubtitleColor() {
        return subtitleColor;
    }

    public void setSubtitleColor(String subtitleColor) {
        this.subtitleColor = subtitleColor;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    /**
     * 得到布局的位置
     *
     * @return
     */
    public String getPosLocation() {
        if ("full".equals(width)) {
            return "full";
        } else if ("half".equals(width)) {
            if ("left".equals(align)) {
                return "left";
            } else if ("right".equals(align)) {
                return "right";
            }
        }
        return "left";
    }


}
