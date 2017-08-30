package me.fattycat.base.network;

import android.os.Build;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import me.fattycat.base.BuildConfig;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author: Kelvinkun
 * Date: 16/8/29
 */

public class RetrofitClient {
    private static final String USER_AGENT_LABEL = "User-Agent";
    private static final String USER_AGENT_VALUE_JSON =
            String.format("Android: App version: %s; OS version: %s; SDK version: %s; Model: %s",
                    BuildConfig.VERSION_NAME,
                    Build.VERSION.RELEASE,
                    Build.VERSION.SDK_INT,
                    Build.MODEL);

    // TODO: 2017/8/29 user agent

    public static Retrofit defaultInstance(String host) {
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .setLenient()
                .setPrettyPrinting()
                .create();
        return new Retrofit.Builder()
                .client(defaultOkHttpClient())
                .baseUrl(host)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    private static OkHttpClient defaultOkHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Interceptor headerInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request.Builder requestBuilder = originalRequest.newBuilder()
                        .header("Content-Type", "application/json; charset=utf-8")
                        .header(USER_AGENT_LABEL, USER_AGENT_VALUE_JSON)
                        .method(originalRequest.method(), originalRequest.body());
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(headerInterceptor)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS);
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(loggingInterceptor)
                    .addNetworkInterceptor(new StethoInterceptor());
        }
        return builder.build();
    }

}