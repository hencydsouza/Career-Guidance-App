package com.example.careerapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.careerapp.R;
import com.example.careerapp.model.collageModel;
import com.example.careerapp.model.examModel;

import java.util.List;

public class ExamRecyclerViewAdapter extends RecyclerView.Adapter<ExamRecyclerViewAdapter.ExamViewHolder> {

    private Context mContext;
    private List<examModel> mData;
    RequestOptions option;

    public ExamRecyclerViewAdapter(Context mContext, List<examModel> mData) {
        this.mContext = mContext;
        this.mData = mData;

        //option
        option = new RequestOptions().fitCenter().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @NonNull
    @Override
    public ExamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.exam_row_item,parent,false);

        return new ExamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamViewHolder holder, int position) {
        holder.exam_Name.setText(mData.get(position).getExamName());
        holder.exam_Eligibility.setText(mData.get(position).getExamEligibility());
        holder.exam_Date.setText(mData.get(position).getExamDate());

        //Image
        Glide.with(mContext).load(mData.get(position).getExamLogo()).apply(option).into(holder.exam_Logo);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ExamViewHolder extends RecyclerView.ViewHolder{

        TextView exam_Name,exam_Eligibility,exam_Date;
        ImageView exam_Logo;
        LinearLayout exam_container;

        public ExamViewHolder(@NonNull View itemView) {
            super(itemView);

            exam_Name = itemView.findViewById(R.id.exam_Name);
            exam_Eligibility = itemView.findViewById(R.id.exam_Eligibility);
            exam_Date = itemView.findViewById(R.id.exam_Date);
            exam_Logo = itemView.findViewById(R.id.exam_Logo);
//            exam_container = itemView.findViewById(R.id.exam_container);
        }
    }
}
