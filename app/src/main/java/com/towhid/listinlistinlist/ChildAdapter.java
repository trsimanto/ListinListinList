package com.towhid.listinlistinlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChildAdapter extends ArrayAdapter<ChildModel> {

    Context mcontext;
    List<ChildModel> childModel;
    View view;


    HashMap<Integer, Boolean> checkHash;


    public ChildAdapter(Context context, int resource, List<ChildModel> objects) {
        super(context, resource, objects);
        mcontext = context;
        childModel = objects;
        checkHash = new HashMap<Integer, Boolean>();


    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        view = convertView;
        if (null == view) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.child_recycler, null);
        }

        TextView child_textView = (TextView) view.findViewById(R.id.child_textView);
        ListView rv_baby = (ListView) view.findViewById(R.id.rv_baby);
        final LinearLayout expandable_layout_child = (LinearLayout) view.findViewById(R.id.expandable_layout_child);

        child_textView.setText(childModel.get(position).getTitle());

        BabyAdapter babyAdapter = new BabyAdapter(mcontext, R.layout.baby_recycler, childModel.get(position).getBabyModels());
        rv_baby.setAdapter(babyAdapter);


        if (checkHash.containsKey(position)) {
            if (checkHash.get(position)) {
                expandable_layout_child.setVisibility(View.VISIBLE);
            } else {
                expandable_layout_child.setVisibility(View.GONE);

            }
        } else {
            expandable_layout_child.setVisibility(View.GONE);

        }

        child_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (expandable_layout_child.getVisibility() == View.VISIBLE) {
                    expandable_layout_child.setVisibility(View.GONE);
                    checkHash.put(position, false);
                } else {
                    expandable_layout_child.setVisibility(View.VISIBLE);

                    checkHash.put(position, true);
                }


            }
        });


        return view;

    }
}