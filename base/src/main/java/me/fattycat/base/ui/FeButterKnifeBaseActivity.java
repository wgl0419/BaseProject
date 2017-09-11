package me.fattycat.base.ui;

import butterknife.ButterKnife;

/**
 * Author: Kelvin
 * Date: 2017/9/4
 */

public abstract class FeButterKnifeBaseActivity extends FeBaseActivity {

    @Override
    public void setView() {
        super.setView();
        ButterKnife.bind(this);
    }
}
