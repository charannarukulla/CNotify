package com.charannarukulla.cnotify;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface API {


    @POST("/fcm/send")

  //@Headers({"Content-Type:application/json","Authorization:"})



    Call<Sendnotification> getf( @Body Sendnotification sendnotification);
}
