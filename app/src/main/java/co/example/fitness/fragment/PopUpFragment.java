package co.example.fitness.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.squareup.picasso.Picasso;

import co.example.fitness.FitnessMoveClass;
import co.example.fitness.R;

public class PopUpFragment extends Fragment {


    TextView nameText;
    TextView descriptionText;
    TextView calorieText;
    ImageView imageView;
    ProgressBar progressBar;
    private FitnessMoveClass fitnessMoveClass;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_pop_up,container,false);

        nameText = rootView.findViewById(R.id.pop_up_name);
        descriptionText =rootView.findViewById(R.id.pop_up_description);
        calorieText = rootView.findViewById(R.id.pop_up_calorie);
        imageView = rootView.findViewById(R.id.pop_up_image);
        progressBar = rootView.findViewById(R.id.recy_progress_bar);

        //fitnessmove parcelable oldugu icin obje gibi sağa sola yollayabiliyoruz.
        //fitnesmove u almak icin aktivite olustururuz.
        //her hangi bir yere tıklandıgınında intent yaparız.
        //intent ile parcelable olarak hangi fitness move a tıklandıysa onu yollayabilecegim.


        nameText.setText(fitnessMoveClass.getFitnessName());
        descriptionText.setText(fitnessMoveClass.getFitnessDescription());
        calorieText.setText(""+ fitnessMoveClass.getFitnessCalorie());
        // texte cevirme taktiği (to String gibi bir sey)

        Picasso.get().load(fitnessMoveClass.getFitnessPicture()).fit().centerCrop().into(imageView);


        return rootView;
    }

    public static PopUpFragment newInstance(){
        return new PopUpFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fitnessMoveClass = getActivity().getIntent().getParcelableExtra("Info");

        // 1. yollanılan fitnesmoove u poopaktivitedeki methodla yolluyoruz
        // 2. popup fragment icinde bunu alabiliyorız.

    }
}
