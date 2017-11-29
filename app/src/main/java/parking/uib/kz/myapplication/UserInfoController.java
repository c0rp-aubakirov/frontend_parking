package parking.uib.kz.myapplication;

import okhttp3.ResponseBody;
import parking.uib.kz.myapplication.model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by c0rp on 29.11.17.
 */

public interface UserInfoController {

    @GET("/user/getUserInfo/{phoneNumber}/{token}")
    public Call<ResponseBody> getUserInfo(@Path("phoneNumber") String phoneNumber,
                                          @Path("token") String token);
}
