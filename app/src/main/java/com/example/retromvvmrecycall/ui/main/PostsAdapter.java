package com.example.retromvvmrecycall.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retromvvmrecycall.R;
import com.example.retromvvmrecycall.pojo.PostModel;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {

    private List<PostModel> dataList = new ArrayList<>();

    @NonNull
    @NotNull
    @Override
    public PostsAdapter.PostViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PostsAdapter.PostViewHolder holder, int position) {
        holder.nameTv.setText(" "+dataList.get(position).getName());
        holder.bioTv.setText(""+dataList.get(position).getBio());
        Picasso.get().load(dataList.get(position).getImageurl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setDataList(List<PostModel> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView nameTv,bioTv;
        ImageView imageView;
        public PostViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.nameTV);
            bioTv = itemView.findViewById(R.id.bioTV);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
