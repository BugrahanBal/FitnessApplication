package co.example.fitness.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import co.example.fitness.R;

public class DetailsFragment extends Fragment {

    //cardview i tanımlamak tanımlamamak bizim elimizde
    CardView cardView;
    SeekBar radiusSeekBar;
    SeekBar elevationSeekBar;


    public static DetailsFragment newInstance(){
        return new DetailsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_details,container,false);

        radiusSeekBar = rootView.findViewById(R.id.details_fragment_seekbar_radius);
        elevationSeekBar = rootView.findViewById(R.id.details_fragment_seekbar_elevation);
        cardView = rootView.findViewById(R.id.card_view);

        radiusSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //progress tam sayısını kullanarak radius ve elevationı düzeltmiş olacagım.
                cardView.setRadius(progress);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        elevationSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cardView.setElevation(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        return rootView;

    }
}
