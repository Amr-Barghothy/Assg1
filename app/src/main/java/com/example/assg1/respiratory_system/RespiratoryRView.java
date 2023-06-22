package com.example.assg1.respiratory_system;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.assg1.R;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RespiratoryRView extends RecyclerView.Adapter<RespiratoryRView.ViewHolder> {
    Context context;
    ArrayList<RespiratorySystem> data;
    public RespiratoryRView(Context context,ArrayList<RespiratorySystem> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @NotNull
    @Override
    public RespiratoryRView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.parts_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RespiratoryRView.ViewHolder holder, int position) {
        holder.partName.setText(data.get(position).getPartName());
        holder.Explain.setText(data.get(position).getExplain());
        holder.imageView.setImageResource(data.get(position).getImg());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView partName,Explain;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imageView =itemView.findViewById(R.id.imageView);
            partName = itemView.findViewById(R.id.textView);
            Explain = itemView.findViewById(R.id.explainLabel);
        }

    }
}
