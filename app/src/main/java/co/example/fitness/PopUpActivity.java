package co.example.fitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import co.example.fitness.fragment.PopUpFragment;

public class PopUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up);

        // bunun altında pop up fragmenta bu intenti vermek icin gerekli işlemi yapacagım.
        //pop up icinde sadece bir fragment olacak
        // fragment manageri rootview kullanır gibi kullanacagız.

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.pop_up_layout);

        //fragment managerlarla layoutların icerisinde bu sekilde fraaagment var mı tararızz?

        if(fragment == null){

            fragment = PopUpFragment.newInstance();
            //anladıgım kadarılya popup fragmentı popup aktivitenin icinde yazdık ama neden ? :)
            //pop layout popup aktivitenin icinde bulunan bir alan

            // ilk defa popup fragmenti kullandım ve popup aktivite ile bagladım.

            fragmentManager.beginTransaction().add(R.id.pop_up_layout,fragment).commit();

            //fragment managerlarla layoutların icerisinde bu sekilde fraaagment var mı tararızz?
            // yoksa bu sekilde ekleriz.

        }

    }


    public static Intent newIntent(Context context, FitnessMoveClass fitnessMoveClass){

        //pop up aktiviteye bir intent var.İçinde bulundugumuz aktiviteye intent yapmak sacma bir sey
        // böyle olmayacak zaten bu statik olarak olustu bunu baska bir yerden cagıracagız.

        Intent intent = new Intent(context, PopUpActivity.class);
        intent.putExtra("Info", fitnessMoveClass);
        // parcalebla oldugu icin komple intentle yollayabiliriz.
        return intent;

    }

}