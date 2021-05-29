package co.example.fitness.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import co.example.fitness.FitnessMoveClass;
import co.example.fitness.PopUpActivity;
import co.example.fitness.R;
import co.example.fitness.recyclerview.Adapter;

public class FitnessPictureFragment extends Fragment  implements Adapter.MyListener {

    private Adapter adapter;
    private RecyclerView recyclerView;
    private ArrayList <FitnessMoveClass> fitnessMoveClasses;


    public static FitnessPictureFragment newInstance(){
        return new FitnessPictureFragment();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_fitness_picture,container,false);

        adapter = new Adapter((AppCompatActivity)getActivity(),this);
        fitnessMoveClasses = adapter.getFitnessMoveClasses();
        recyclerView=rootView.findViewById(R.id.recy);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

       // fragment aktiviteye eklendi mi is added
        if(isAdded()) {
            recyclerView.setAdapter(adapter);
        }

        getFitnessMoves2(fitnessMoveClasses);

        return rootView;
    }

    private ArrayList <FitnessMoveClass> getFitnessMoves2(ArrayList< FitnessMoveClass > fitnessMoveClasses2){

        fitnessMoveClasses2.add(new FitnessMoveClass("Move 1",
                "https://i.pinimg.com/originals/a9/76/af/a976af5c7bf3cc5b05a1b301334e0f68.jpg",
                "Description",
                100));

        return fitnessMoveClasses2;
    }

    @Override
    public void MyListener(FitnessMoveClass fitnessMoveClass) {
        //hangisine tıklandıgına ne yapacagımızı burada.
        //fragment yapacagız icine pop up penceresi yapacagız.
        //pop up penceresinde ne görünmesini sitiyorsak fragmentta onu gösteriririz
        // kullanıcı tıklayınca pop up cagır
        Intent intent = PopUpActivity.newIntent(getActivity(), fitnessMoveClass);
        startActivity(intent);

    }
}
