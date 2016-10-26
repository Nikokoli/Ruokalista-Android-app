package koli.kaarre.Mobiiliohjelmointi_2016.Activity;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.ListView;

import java.util.List;
import java.util.Vector;

import koli.kaarre.Mobiiliohjelmointi_2016.R;
import koli.kaarre.Mobiiliohjelmointi_2016.Fragments.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create tabs for each of the categories and associate each fragment with their corresponding tab
        List<Fragment> fragments = new Vector<>();
        fragments.add(FavoriteFragment.newInstance(0, "Favs"));
        fragments.add(TayFragment.newInstance(1, "TAY"));
        fragments.add(TaysFragment.newInstance(2, "TAYS"));
        fragments.add(TtyFragment.newInstance(3, "TTY"));

        koli.kaarre.Mobiiliohjelmointi_2016.PagerAdapter adapter = new koli.kaarre.Mobiiliohjelmointi_2016.PagerAdapter(getSupportFragmentManager(), fragments);
        ViewPager pager = (ViewPager) findViewById(R.id.container);
        pager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);

    }

}
