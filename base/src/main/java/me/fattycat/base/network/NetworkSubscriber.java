package me.fattycat.base.network;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.JsonSyntaxException;

import java.lang.ref.WeakReference;
import java.net.SocketTimeoutException;

import rx.Subscriber;

/**
 * Author: Kelvinkun
 * Date: 16/8/29
 */

public class NetworkSubscriber<T> extends Subscriber<T> {
    private static final String TAG = NetworkSubscriber.class.getSimpleName();
    private WeakReference<Context> weakReference;

    public NetworkSubscriber(Context context) {
        weakReference = new WeakReference<>(context);
    }

    // TODO: 2017/8/29 add custom message constructor

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        Context context = weakReference.get();
        String message = null;
        if (e instanceof ApiException) {
            message = e.getMessage();
        } else if (e instanceof SocketTimeoutException) {
            message = "网络不好，请重试";
        } else if (e instanceof JsonSyntaxException) {
            message = null;
        }
        if (context != null && !TextUtils.isEmpty(message)) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        } else {
            Log.e(TAG, "" + message, e);
        }
    }

    @Override
    public void onNext(T t) {

    }
}
