package me.fattycat.base.ui;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Author: Kelvin
 * Date: 2017/8/30
 */

public abstract class FeDataBindingBaseFragment<T extends ViewDataBinding> extends FeBaseFragment {
    private ViewDataBinding binding;

    @Override
    public View getView(LayoutInflater inflater, @Nullable ViewGroup container) {
        try {
            binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
            mainLayout = binding.getRoot();
        } catch (NoClassDefFoundError error) {
            mainLayout = inflater.inflate(getLayoutId(), container, false);
        }

        return mainLayout;
    }

    public T getBinding() {
        return (T) binding;
    }
}
