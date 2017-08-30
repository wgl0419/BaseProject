package me.fattycat.base.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Author: Kelvin
 * Date: 2017/8/30
 */

public abstract class FeBaseFragment extends Fragment {
    public View mainLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainLayout = getView(inflater, container);
        initView(savedInstanceState);
        return mainLayout;
    }

    public View getView(LayoutInflater inflater, @Nullable ViewGroup container) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    public abstract int getLayoutId();

    public abstract void initView(Bundle savedInstanceState);

}
