package com.example.android.viewpagerexample;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fragments;

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<>();
        fragments.add(new MondayFragment());
        fragments.add(new TuesdayFragment());
        fragments.add(new WednesdayFragment());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return  fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = fragments.get(position).getClass().getName();
        return title.subSequence(title.lastIndexOf(".") + 1, title.indexOf("Fragment"));
    }
}
