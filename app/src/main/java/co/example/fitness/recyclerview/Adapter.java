package co.example.fitness.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import co.example.fitness.FitnessMoveClass;
import co.example.fitness.R;

public class Adapter extends RecyclerView.Adapter<ViewHolder> implements View.OnClickListener {

    private ArrayList <FitnessMoveClass> fitnessMoveClasses;
    private LayoutInflater layoutInflater;
    private AppCompatActivity appCompatActivity;
    private MyListener myListener;

    //layout inflater ve arraylisti değişmez olarak tanımlayacagımdan
    //listener ve appcompa icin konstruktur olusturuyorum ki
    //onlardan input alayım sadece
    //appcompact aktiviteyi layout inflater icin yaptık.
    //hangi aktiviteden geliyorsa onun layout inflaterını alabilmek icin
    //tüm apilarda olması icin appcompact deriz activity yerine 23 api sorunsalı


    public Adapter(AppCompatActivity appCompatActivity, MyListener myListener) {
        this.appCompatActivity = appCompatActivity;
        this.myListener = myListener;
        layoutInflater = appCompatActivity.getLayoutInflater();
        fitnessMoveClasses = new ArrayList<>();
    }

    public ArrayList <FitnessMoveClass> getFitnessMoveClasses(){
        return fitnessMoveClasses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View listview = layoutInflater.inflate(R.layout.recyclerview_fitness_pic,parent,false);
        listview.setOnClickListener(this);
        return new ViewHolder(listview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.getMoves(appCompatActivity, fitnessMoveClasses.get(position));

    }

    @Override
    public int getItemCount() {
        return fitnessMoveClasses.size();
    }

    @Override
    public void onClick(View v) {

        if(v.getTag() instanceof FitnessMoveClass) {
            //aldıgım tag yani viewe tıklarken o etiket fitnessmove a aitse
            FitnessMoveClass fitnessMoveClass = (FitnessMoveClass) v.getTag();
            myListener.MyListener(fitnessMoveClass);
        }
    }

    public interface MyListener{
        public void MyListener(FitnessMoveClass fitnessMoveClass);
    }
}
