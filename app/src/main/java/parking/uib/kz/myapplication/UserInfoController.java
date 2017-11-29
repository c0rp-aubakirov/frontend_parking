package parking.uib.kz.myapplication;

import okhttp3.ResponseBody;
import parking.uib.kz.myapplication.model.GetUserInfoRequest;
import parking.uib.kz.myapplication.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by c0rp on 29.11.17.
 */

public interface UserInfoController {

    @POST("/getUserInfo")
    public Call<ResponseBody> getUserInfo(@Body GetUserInfoRequest body);
}
