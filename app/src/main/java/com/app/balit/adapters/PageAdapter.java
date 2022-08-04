package com.app.balit.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.app.balit.fragments.ParadaDetailTab;
import com.app.balit.fragments.ParadaPOITab;

public class PageAdapter extends FragmentStateAdapter {
    public PageAdapter(FragmentManager fragmentManager, Lifecycle lifecycle){
        super(fragmentManager, lifecycle);
    }

    @Override
    public Fragment createFragment(int position){
        switch (position){
            case 0:
                return new ParadaDetailTab();
            case 1:
                return new ParadaPOITab();
            default:
                return new ParadaDetailTab();
        }
    }

    @Override
    public int getItemCount(){
        return 2;
    }
}
