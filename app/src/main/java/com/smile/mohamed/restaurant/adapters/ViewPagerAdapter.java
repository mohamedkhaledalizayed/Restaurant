package com.smile.mohamed.restaurant.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.smile.mohamed.restaurant.models.Recipe;
import com.smile.mohamed.restaurant.ui.fragments.ViewDirectionsFragment;
import com.smile.mohamed.restaurant.ui.fragments.ViewIngredientsFragment;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private static final int TAB_COUNT = 2;
    private final Recipe recipe;
    private String[] tabTitles = {"Ingredients", "Add Ons"};

    public ViewPagerAdapter(FragmentManager fm, Recipe recipe) {
        super(fm);
        this.recipe = recipe;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        switch (position) {
            case 0:
                frag = ViewIngredientsFragment.newInstance(recipe.getIngredients());
                break;
            case 1:
                frag = ViewDirectionsFragment.newInstance(recipe.getDirections());
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
