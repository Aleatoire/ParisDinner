package adev.parisdinner.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import adev.parisdinner.R;
import adev.parisdinner.adapter.SectionPagerAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity {

    @BindView(R.id.pager)
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        List<String> titles = new ArrayList<>();
        titles.add("French");
        titles.add("Jap");
        titles.add("Italian");
        mViewPager.setAdapter(new SectionPagerAdapter(getSupportFragmentManager(), titles));
    }

}