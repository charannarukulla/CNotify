package com.charannarukulla.cnotify;

import android.app.Activity;
import android.content.Context;

public class CNotify {
  public   Notify n;
    Context context;

public CNotify(Context context, String ServerKey){

    n =new Notify((Activity) context,ServerKey);
    this.context=context;
}
  public void sendNotification (String fcm_token,String title,String body){
    n.notificate(fcm_token,title,body);
  }







}
