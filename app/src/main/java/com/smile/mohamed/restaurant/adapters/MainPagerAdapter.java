package com.smile.mohamed.restaurant.adapters;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.smile.mohamed.restaurant.ui.fragments.AmericanFragment;
import com.smile.mohamed.restaurant.ui.fragments.AsianFragment;
import com.smile.mohamed.restaurant.ui.fragments.EuropeanFragment;
import com.smile.mohamed.restaurant.ui.fragments.MediterraneanFragment;
import com.smile.mohamed.restaurant.ui.fragments.VeganFragment;


public class MainPagerAdapter extends FragmentStatePagerAdapter {

    private static final int TAB_COUNT = 5;
    private String[] tabTitles = {"American", "Vegan", "Asian", "Mediterranean", "European"};

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag = null;
        switch (position) {
            case 0:
                frag = AmericanFragment.newInstance(tabTitles[position]);
                break;
            case 1:
                frag = VeganFragment.newInstance(tabTitles[position]);
                break;
            case 2:
                frag = AsianFragment.newInstance(tabTitles[position]);
                break;
            case 3:
                frag = MediterraneanFragment.newInstance(tabTitles[position]);
                break;
            case 4:
                frag = EuropeanFragment.newInstance(tabTitles[position]);
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
