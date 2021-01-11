package com.charannarukulla.cnotify;

import android.app.Activity;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Notify {
    Activity activity;
  String serverkey;
    public Notify(Activity activity, String serverkey) {
        this.activity = activity;
        this.serverkey=serverkey;
    }




    public void notificate(String to,String title,String head){
        Sendnotification sendnotification=new Sendnotification();
        sendnotification.setTo(to);
        sendnotification.notification.setTitle(title);
        sendnotification.notification.setBody(head);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
                                      @Override
                                      public okhttp3.Response intercept(Chain chain) throws IOException {
                                          Request original = chain.request();

                                          Request request = original.newBuilder()
                                                  .header("Content-Type", "application/json")
                                                  .header("Authorization", "key="+serverkey)
                                                  .method(original.method(), original.body())
                                                  .build();

                                          return chain.proceed(request);
                                      }
                                  });
        OkHttpClient client = httpClient.build();
        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://fcm.googleapis.com/").addConverterFactory(GsonConverterFactory.create()).client(client).build();

        API api=retrofit.create(API.class);

        Call<Sendnotification> sendnotificationCall=api.getf(sendnotification );
        sendnotificationCall.enqueue(new Callback<Sendnotification>() {
            @Override
            public void onResponse(Call<Sendnotification> call, Response<Sendnotification> response) {

            }

            @Override
            public void onFailure(Call<Sendnotification> call, Throwable t) {

            }
        });

    }
}
