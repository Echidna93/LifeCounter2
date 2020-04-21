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
        switch(position){
            case 0:
                return new LifeCounterFragment();
            case 1:
                return new PoisonCounterFragment();
            case 2:
                return new CommanderDamageFragment();
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
    @Override
    public CharSequence getPageTitle(int position){
        String title = "";
        switch (position){
            case 0:
                title = "Life";
                break;
            case 1:
                title = "Poison";
                break;
                case 2:
                title = "Commander Damage";
                break;
        }
    return title;
    }
}
