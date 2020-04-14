package com.example.lifecounter2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        LifeCounterFragment lifeCounterFragment = new LifeCounterFragment();
        position = position + 1;
        Bundle bundle = new Bundle();
        bundle.putString("message", "Fragment : "+position);
        lifeCounterFragment.setArguments(bundle);
        return lifeCounterFragment;
    }

    @Override
    public int getCount() {
        return 1;
    }
    @Override
    public CharSequence getPageTitle(int position){
        position = position + 1;
        return "Frament: " + position;
    }
}
