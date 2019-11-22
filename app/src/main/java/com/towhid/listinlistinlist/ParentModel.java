package com.towhid.listinlistinlist;

import java.util.List;

public class ParentModel {
    private String title;
    private List<ChildModel> childModels;

    public ParentModel() {
    }

    public ParentModel(String title, List<ChildModel> childModels) {
        this.title = title;
        this.childModels = childModels;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ChildModel> getChildModels() {
        return childModels;
    }

    public void setChildModels(List<ChildModel> childModels) {
        this.childModels = childModels;
    }


}
