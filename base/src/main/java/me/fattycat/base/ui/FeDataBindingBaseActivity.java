package me.fattycat.base.ui;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;

/**
 * Author: Kelvin
 * Date: 2017/8/30
 */

public abstract class FeDataBindingBaseActivity<T extends ViewDataBinding> extends FeBaseActivity {
    private ViewDataBinding binding;

    @Override
    public void setView() {
        //super.setView();
        try {
            binding = DataBindingUtil.setContentView(this, getLayoutId());
            if (binding == null) {
                setContentView(LayoutInflater.from(this).inflate(getLayoutId(), null));
            }
        } catch (NoClassDefFoundError e) {
            setContentView(LayoutInflater.from(this).inflate(getLayoutId(), null));
        }
    }

    public T getBinding() {
        return (T) binding;
    }
}
