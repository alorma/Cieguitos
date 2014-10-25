package com.tempos21.cieguitos.ui.adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.wearable.view.FragmentGridPagerAdapter;
import android.support.wearable.view.ImageReference;

import com.example.sergibc.sdk.data.MuseumData;
import com.tempos21.cieguitos.BuildConfig;
import com.tempos21.cieguitos.R;
import com.tempos21.cieguitos.ui.fragment.BASCardFragment;
import com.tempos21.cieguitos.ui.fragment.PlantaFragment;

/**
 * Created by Bernat on 24/10/2014.
 */
public class MuseumGridPagerAdapter extends FragmentGridPagerAdapter {

    private Context context;

    public MuseumGridPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getFragment(int row, int column) {
        Fragment fragment = null;
        if (column == 0) {
            fragment = PlantaFragment.newInstance(row);
        } else {
//			fragment = CardFragment.create("Expo: " + column, "AAh aah ahh");
            fragment = BASCardFragment.newInstance("Expo: " + column, " Eeoeoeoeoe");
        }
        return fragment;
    }

    @Override
    public int getRowCount() {
        return MuseumData.getInstance().getPlantas().size();
    }

    @Override
    public int getColumnCount(int i) {
        return MuseumData.getInstance().getPlantas().get(i).getExpos().size();
    }

    @Override
    public ImageReference getBackground(int row, int column) {
        String name;
        int id = R.drawable.expo_01;
        if (column == 0) {
            name = "planta_" + row;
        } else {
            name = "expo_" + row + column;
        }

        int resId = context.getResources().getIdentifier(name, "drawable", BuildConfig.APPLICATION_ID);
        if (resId != 0) {
            id = resId;
        }
        ImageReference ir = ImageReference.forDrawable(id);
        return ir;
    }
}