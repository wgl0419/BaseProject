package me.fattycat.base.ui;

import android.content.Context;

/**
 * Author: Kelvinkun
 * Date: 16/8/30
 */

public interface BaseView<T> {
    Context getContext();

    void setPresenter(T presenter);
}
