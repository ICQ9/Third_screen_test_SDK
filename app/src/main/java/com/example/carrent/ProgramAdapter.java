package com.example.carrent;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProgramAdapter extends RecyclerView.Adapter<ProgramAdapter.ViewHolder> {


    Context context;
    String[] programNameList;
    String[] programDescriptionList;
    int[] images;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.rowName.setText(programNameList[position]);
        holder.rowDesck.setText(programDescriptionList[position]);
        holder.rowImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return programNameList.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView rowName;
        TextView rowDesck;
        ImageView rowImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rowName = itemView.findViewById(R.id.title_text);
            rowDesck = itemView.findViewById(R.id.description_text);
            rowImage = itemView.findViewById(R.id.imageView);
        }
    }

    public ProgramAdapter(Context context, String[] programNameList, String[] programDescriptionList, int[] images){
        this.context = context;
        this.programNameList = programNameList;
        this.programDescriptionList = programDescriptionList;
        this.images = images;
    }

}
