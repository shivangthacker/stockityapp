package com.currencyinformation.currencyinfo;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class Fragmentadaforsub extends FragmentStatePagerAdapter
{
    List<Fragment> fragmentlist_sub=new ArrayList<>();
    List<String>   stringList_sub=new ArrayList<>();


    public Fragmentadaforsub(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentlist_sub.get(position);
    }

    @Override
    public int getCount() {
        return fragmentlist_sub.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return stringList_sub.get(position);
    }
    public void addtab_sub(Fragment tab_sub, String title_sub)
    { fragmentlist_sub.add(tab_sub);
        stringList_sub.add(title_sub);

    }
}
