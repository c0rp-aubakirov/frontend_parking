package parking.uib.kz.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "UIB_2017";

    @BindView(R.id.login)
    EditText loginText;

    @BindView(R.id.password)
    EditText passwordText;

    @BindView(R.id.button)
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendRequest();
            }
        });

        sendRequest();
    }

    private void sendRequest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.23:8090")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserInfoController userInfoController = retrofit.create(UserInfoController.class);

        Call<ResponseBody> login1 = userInfoController.getUserInfo("Login1", "1234");

        login1.enqueue(callback);
    }

    Callback<ResponseBody> callback = new Callback<ResponseBody>() {

        @Override
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            try {
                Log.d(TAG, response.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onFailure(Call<ResponseBody> call, Throwable t) {
            t.printStackTrace();
            t.getMessage();
            Log.d(TAG, "FAil");
        }
    };

}
