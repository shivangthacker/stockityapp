package com.currencyinformation.currencyinfo;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class Fragmentadapter extends FragmentStatePagerAdapter {

    List<Fragment> fragmentlist=new ArrayList<>();
    List<String>   stringList=new ArrayList<>();
    public Fragmentadapter(@NonNull FragmentManager fm) {
        super(fm);
    }
    @Override
    public int getCount() {
        return fragmentlist.size();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentlist.get(position);
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return stringList.get(position);
    }

    public void addtab(Fragment tab, String title)
    { fragmentlist.add(tab);
    stringList.add(title);

    }
}
