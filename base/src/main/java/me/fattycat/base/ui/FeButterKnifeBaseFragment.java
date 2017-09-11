package me.fattycat.base.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Author: Kelvin
 * Date: 2017/9/4
 */

public abstract class FeButterKnifeBaseFragment extends FeBaseFragment {
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainLayout = getView(inflater, container);
        unbinder = ButterKnife.bind(this, mainLayout);
        initView(savedInstanceState);
        return mainLayout;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
