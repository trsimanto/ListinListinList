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

import java.util.HashMap;
import java.util.List;


public class ParentAdapter extends ArrayAdapter<ParentModel> {

    Context mcontext;
    List<ParentModel> parentModel;
    View view;
    HashMap<Integer, Boolean> checkHash;


    public ParentAdapter(Context context, int resource, List<ParentModel> objects) {
        super(context, resource, objects);
        mcontext = context;
        parentModel = objects;
        checkHash = new HashMap<Integer, Boolean>();

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        view = convertView;
        if (null == view) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.parent_recycler, null);
        }
        ParentModel parentModel1=getItem(position);

        TextView textView = (TextView) view.findViewById(R.id.textView);
        ListView rv_child = (ListView) view.findViewById(R.id.rv_child);
        final LinearLayout expandable_layout = (LinearLayout) view.findViewById(R.id.expandable_layout);


        textView.setText(parentModel.get(position).getTitle());

        ChildAdapter childAdapter=new ChildAdapter(mcontext,R.layout.baby_recycler,parentModel1.getChildModels());
        rv_child.setAdapter(childAdapter);






        if (checkHash.containsKey(position)) {
            if (checkHash.get(position)) {
                expandable_layout.setVisibility(View.VISIBLE);
            } else {
                expandable_layout.setVisibility(View.GONE);

            }
        } else {
            expandable_layout.setVisibility(View.GONE);

        }

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (expandable_layout.getVisibility() == View.VISIBLE) {
                    expandable_layout.setVisibility(View.GONE);
                    checkHash.put(position, false);
                } else {
                    expandable_layout.setVisibility(View.VISIBLE);

                    checkHash.put(position, true);
                }


            }
        });













        return view;

    }
}