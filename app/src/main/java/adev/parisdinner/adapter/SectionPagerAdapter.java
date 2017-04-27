package adev.parisdinner.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import adev.parisdinner.fragment.EventListFragment;
import adev.parisdinner.model.Food;

/**
 * Created by Aldric ANDRE
 * on 27/04/2017.
 */

public class SectionPagerAdapter extends FragmentPagerAdapter {

    private List<Food> mFoods;

    public SectionPagerAdapter(FragmentManager fm, List<Food> foods) {
        super(fm);
        this.mFoods = new ArrayList<>();
        this.mFoods.addAll(foods);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = new EventListFragment().setFoodType(mFoods.get(position).getId());
        return fragment;
    }

    @Override
    public int getCount() {
        return mFoods.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFoods.get(position).getTitle();
    }
}
