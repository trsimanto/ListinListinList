package com.towhid.listinlistinlist;

import java.util.List;

public class ChildModel {
    private String title;
    private List<BabyModel> babyModels;
    public ChildModel() {
    }

    public ChildModel(String title) {

        this.title = title;
    }

    public ChildModel(String title, List<BabyModel> babyModels) {
        this.title = title;
        this.babyModels = babyModels;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public List<BabyModel> getBabyModels() {
        return babyModels;
    }

    public void setBabyModels(List<BabyModel> babyModels) {
        this.babyModels = babyModels;
    }
}
