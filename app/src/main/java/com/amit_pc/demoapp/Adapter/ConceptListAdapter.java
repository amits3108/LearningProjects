package com.amit_pc.demoapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amit_pc.demoapp.R;
import com.amit_pc.demoapp.interfaces.ConceptClickListener;
import com.amit_pc.demoapp.models.ConceptModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by amit_pc on 24-09-2017.
 */

public class ConceptListAdapter extends RecyclerView.Adapter<ConceptListAdapter.MyViewHolder> {

    private final Context mContext;
    private final ArrayList<ConceptModel> conceptModelArrayList;
    private final ConceptClickListener clickListener;

    public ConceptListAdapter(Context context, ArrayList<ConceptModel> conceptModelArrayList) {
        this.mContext = context;
        this.conceptModelArrayList = conceptModelArrayList;
        this.clickListener = (ConceptClickListener) context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.row_concept_item, parent, false));
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

        public MyViewHolder(View itemView) {
            super(itemView);
            tvConceptName = itemView.findViewById(R.id.tv_concept_name);
            LinearLayout llRoot = itemView.findViewById(R.id.ll_root);
            llRoot.setOnClickListener(view -> clickListener.onConceptClick(conceptModelArrayList.get(getAdapterPosition())));
        }
    }
}
