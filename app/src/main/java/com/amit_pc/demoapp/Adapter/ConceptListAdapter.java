package com.amit_pc.demoapp.Adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amit_pc.demoapp.R;
import com.amit_pc.demoapp.interfaces.ConceptClickListener;
import com.amit_pc.demoapp.models.ConceptModel;

import java.util.ArrayList;

/**
 * Created by amit_pc on 24-09-2017.
 */

public class ConceptListAdapter extends RecyclerView.Adapter<ConceptListAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<ConceptModel> conceptModelArrayList;
    private ConceptClickListener clickListener;

    public ConceptListAdapter(Context context, ArrayList<ConceptModel> conceptModelArrayList) {
        this.mContext = context;
        this.conceptModelArrayList = conceptModelArrayList;
        this.clickListener = (ConceptClickListener) context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.row_concept_item, parent,false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvConceptName.setText(conceptModelArrayList.get(position).getConceptName());
    }

    @Override
    public int getItemCount() {
        return conceptModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvConceptName;
        private final LinearLayout llRoot;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvConceptName = (TextView) itemView.findViewById(R.id.tv_concept_name);
            llRoot = (LinearLayout) itemView.findViewById(R.id.ll_root);
            llRoot.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    clickListener.onConceptClick(conceptModelArrayList.get(getAdapterPosition()));
                }
            });
        }
    }
}
