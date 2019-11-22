package com.towhid.listinlistinlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class BabyAdapter extends ArrayAdapter<BabyModel> {

    Context mcontext;
    List<BabyModel> babyModel;
    View view;

    public BabyAdapter(Context context, int resource, List<BabyModel> objects) {
        super(context, resource, objects);
        mcontext = context;
        babyModel = objects;


    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull final ViewGroup parent) {
        view = convertView;
        if (null == view) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.baby_recycler, null);
        }
        TextView baby_textView = (TextView) view.findViewById(R.id.baby_textView);


        baby_textView.setText(babyModel.get(position).getTitle());

        baby_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mcontext, "position "+position, Toast.LENGTH_SHORT).show();
            }
        });





        return view;

    }
}