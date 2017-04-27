package adev.parisdinner.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import adev.parisdinner.fragment.EventListFragment;

/**
 * Created by Aldric ANDRE
 * on 27/04/2017.
 */

public class SectionPagerAdapter extends FragmentPagerAdapter {

    private List<String> mSections;

    public SectionPagerAdapter(FragmentManager fm, List<String> sectionList) {
        super(fm);
        this.mSections = new ArrayList<>();
        this.mSections.addAll(sectionList);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = new EventListFragment().setSection();
        return fragment;
    }

    @Override
    public int getCount() {
        return mSections.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mSections.get(position);
    }
}
