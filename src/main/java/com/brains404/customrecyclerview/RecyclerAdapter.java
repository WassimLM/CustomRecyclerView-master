package com.brains404.customrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;


import java.util.HashMap;
import java.util.List;
import java.util.Objects;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>  {
    private List<HashMap<String,String>> mDataset;
class  ViewHolder extends RecyclerView.ViewHolder{
    TextView textView;
    TextView textView2;
     ImageView imageView;

    ViewHolder(@NonNull View itemView) {
        super(itemView);
        textView=itemView.findViewById(R.id.item_title);
        textView2=itemView.findViewById(R.id.item_detail);
        imageView=itemView.findViewById(R.id.item_image);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();

                Snackbar snackbar = Snackbar
                        .make(v.getRootView(), mDataset.get(position).get("titre")+" : "+mDataset.get(position).get("description"), Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });
    }
}

    // Provide a suitable constructor (depends on the kind of dataset)
     RecyclerAdapter(List<HashMap<String, String>> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_list_item, parent, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textView.setText(mDataset.get(position).get("titre"));
        holder.textView2.setText(mDataset.get(position).get("description"));
        try {
            int idImage = Integer.valueOf(Objects.requireNonNull(mDataset.get(position).get("image")));
            holder.imageView.setImageResource(idImage);
        }catch (Exception e){
            e.printStackTrace();
        }




    }


    @Override
    public int getItemCount() {
        return mDataset.size();
    }



}
