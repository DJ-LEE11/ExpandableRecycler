package com.uwork.expandablerecycler.bean;

import java.util.ArrayList;

/**
 * @author 李栋杰
 * @time 2017/8/9  17:07
 * @desc ${TODD}
 */
public class GroupBean {
    private String title;
    private ArrayList<ChildBean> children;

    public GroupBean(String title, ArrayList<ChildBean> children) {
        this.title = title;
        this.children = children;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<ChildBean> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<ChildBean> children) {
        this.children = children;
    }
}
