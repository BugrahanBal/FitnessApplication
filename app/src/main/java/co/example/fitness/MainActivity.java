package co.example.fitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import co.example.fitness.fragment.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bir aktivitede birden fazla fragment kullanarak farklı görünümler elde etmek amacımız.
        //oncreate = fragmenti ilk olustrudugunda cagrılan method
        //oncreateView = kullanıcı arayüzünü olusturmaya basladıgında cagrılan method



        viewPager = findViewById(R.id.main_activity_view_pager);
        tabLayout = findViewById(R.id.main_activity_tab_layout);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager()); // viewpager ile adapteri ve tabloyoyutu baglarız

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


    }
}