package co.example.fitness.recyclerview;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import co.example.fitness.FitnessMoveClass;
import co.example.fitness.R;

public class ViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    ProgressBar progressBar;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView=itemView.findViewById(R.id.recy_list_imageview);
        progressBar=itemView.findViewById(R.id.recy_progress_bar);

    }

    public void getMoves(Context context, FitnessMoveClass fitnessMoveClass){

        itemView.setTag(fitnessMoveClass);

        Picasso.get().load(fitnessMoveClass.getFitnessPicture()).fit().centerCrop().into(imageView, new Callback() {

            @Override
            public void onSuccess() {

                progressBar.setVisibility(View.INVISIBLE);
            }
            @Override
            public void onError(Exception e) {

            }
        });

    }
}
