package co.example.fitness.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        // hangi fragment gelecek
        //genelde switch case kullanılır pozisyona göre hangi fragment gelecek onu söyleriz.

        Fragment selectedFragment;

        switch (position){
            case 0 :
                selectedFragment = FitnessPictureFragment.newInstance();
            break;
            case 1:
                selectedFragment = DetailsFragment.newInstance();
            break;

            default:
                return null;
        }



        return selectedFragment;
    }

    @Override
    public int getCount() { //burada kaç tane fragment var

        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) { // hangi fragmentın hangi baslıkla gelecek // yazsakta olur yazmasakta

        CharSequence selectedTitle ;

        switch (position){
            case 0 :
                selectedTitle = "Fitness Picture";
                break;
            case 1:
                selectedTitle = "DetailsFragment";
                break;

            default:
                return null;
        }



        return selectedTitle;
    }
}
