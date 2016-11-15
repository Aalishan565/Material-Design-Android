package com.materialdesignpoc.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.materialdesignpoc.R;
import com.materialdesignpoc.activity.ScrollingActivity;
import com.materialdesignpoc.model.UserDTO;

import java.util.List;

/**
 * Created by aalishan on 15/11/16.
 */

public class UserDetailAdapter extends RecyclerView.Adapter<UserDetailAdapter.ViewHolder> {
    List<UserDTO>dto;
    Context ctx;
    private LayoutInflater inflater;

    public UserDetailAdapter(Context ctx, List<UserDTO>dto) {
        this.dto = dto;
        this.ctx = ctx;
        inflater = LayoutInflater.from(ctx);


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.single_user_row_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTvName.setText(dto.get(position).getName());
        holder.mTvDescription.setText(dto.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return dto.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView mTvName;
        TextView mTvDescription;
        CardView mCardView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTvName = (TextView) itemView.findViewById(R.id.tv_name);
            mCardView = (CardView) itemView.findViewById(R.id.card_view);
            mTvDescription = (TextView) itemView.findViewById(R.id.tv_description);
            mCardView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ctx, ScrollingActivity.class);
            //intent.putExtra()
            ctx.startActivity(intent);

        }
    }
}