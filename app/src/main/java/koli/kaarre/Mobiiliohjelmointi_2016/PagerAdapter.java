package koli.kaarre.Mobiiliohjelmointi_2016;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Arttu on 4.5.2016.
 */
public class PagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    public PagerAdapter (FragmentManager fm, List<Fragment> fragments){
        super(fm);

        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int item) {
        return fragments.get(item);
    }

    @Override
    public int getCount(){

        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Suosikit";
            case 1:
                return "TAY";
            case 2:
                return "TAYS";
            case 3:
                return "TTY";
        }
        return null;
    }
}
