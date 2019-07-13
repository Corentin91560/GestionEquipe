package com.example.players_application;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MatchViewHolder> {

    private ArrayList<String> mLieuMatch ;
    private ArrayList<String> mDateMatch ;
    private ArrayList<String> mTypeSport;
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> LieuMatch, ArrayList<String> DateMatch, ArrayList<String> TypeSport, Context mContext) {
        this.mLieuMatch = LieuMatch;
        this.mDateMatch = DateMatch;
        this.mTypeSport = TypeSport;
        this.mContext = mContext;
    }







    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_recycler_row, viewGroup, false);
        MatchViewHolder holder = new MatchViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder matchViewHolder, int i) {
        matchViewHolder.recycler_lieu_match_row.setText(mLieuMatch.get(i));
        matchViewHolder.recycler_date_row.setText(mDateMatch.get(i));
        matchViewHolder.recycler_type_sport.setText(mTypeSport.get(i));

        matchViewHolder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, InformationMatch.class);
                intent.putExtra("date_info", mDateMatch.get(i));
                intent.putExtra("type_sport", mTypeSport.get(i));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mLieuMatch.size();
    }

    public class MatchViewHolder extends RecyclerView.ViewHolder{
        ImageView recycler_logo_row;
        TextView recycler_type_sport;
        TextView recycler_date_row;
        TextView recycler_lieu_match_row;
        RelativeLayout parent_layout;

        public MatchViewHolder(@NonNull View itemView) {
            super(itemView);
            recycler_date_row = itemView.findViewById(R.id.recycler_date_row);
            recycler_lieu_match_row = itemView.findViewById(R.id.recycler_lieu_match_row);
            recycler_type_sport = itemView.findViewById(R.id.recycler_type_sport);
            parent_layout = itemView.findViewById(R.id.parent_layout);
            recycler_logo_row = itemView.findViewById(R.id.recycler_logo_row);




        }
    }

}
