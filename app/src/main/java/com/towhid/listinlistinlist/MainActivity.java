package com.towhid.listinlistinlist;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ListView rv_parent;
    List<ParentModel> parentModelList;
    List<ChildModel> childModelList;
    List<BabyModel> babyModelList;
    ParentAdapter parentAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_parent = findViewById(R.id.rv_parent);

        parentModelList = new ArrayList<>();
        childModelList = new ArrayList<>();
        babyModelList = new ArrayList<>();


        for (int i = 0; i < 5; i++){
            String  s="this is baby  " + i;
            babyModelList.add(new BabyModel(s));
        }

        for (int i = 0; i < 5; i++){
            String  s="this is child  " + i;
            childModelList.add(new ChildModel(s,babyModelList));
        }

        for (int i = 0; i < 40; i++)
        { String  s="this is Parrent " + i;
            parentModelList.add(new ParentModel(s, childModelList));
        }



        parentAdapter = new ParentAdapter(this, R.layout.parent_recycler,parentModelList);
        rv_parent.setAdapter(parentAdapter);









    }





}


