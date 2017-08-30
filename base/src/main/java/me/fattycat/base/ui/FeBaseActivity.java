package me.fattycat.base.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Author: Kelvin
 * Date: 2017/8/29
 */

public abstract class FeBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView();
        initView(savedInstanceState);
    }

    public void setView() {
        setContentView(getLayoutId());
    }

    public abstract int getLayoutId();

    public abstract void initView(Bundle savedInstanceState);

}
