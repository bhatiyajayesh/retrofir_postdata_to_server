package com.example.pratik.postdatatoserver;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pratik.postdatatoserver.Model.AddPostRequest;
import com.example.pratik.postdatatoserver.Model.AddPostResponse;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ProgressDialog pd;
    String url = "https://jsonplaceholder.typicode.com";
    @Bind(R.id.tv_title)
    EditText tvTitle;
    @Bind(R.id.tv_body)
    EditText tvBody;
    @Bind(R.id.tv_id)
    EditText tvId;
    @Bind(R.id.btn_post)
    Button btnPost;
    @Bind(R.id.tv_postdata)
    TextView tvPostdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }



    private void callAddPostAPI() {
        if (isNetworkAvailable()) {

            pd = new ProgressDialog(MainActivity.this);
            pd.setMessage("loading");
            pd.show();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            RetrofitObjectAPI service = retrofit.create(RetrofitObjectAPI.class);

            AddPostRequest addPostRequest = new AddPostRequest(tvTitle.getText().toString().trim(),
                    tvBody.getText().toString().trim(),
                    Long.parseLong(tvId.getText().toString().trim()));

            Call<AddPostResponse> call = service.addPost(addPostRequest);
            call.enqueue(new Callback<AddPostResponse>() {
                @Override
                public void onResponse(Call<AddPostResponse> call, Response<AddPostResponse> response) {
                    pd.dismiss();
                    if (response != null && response.body() != null) {
                        AddPostResponse addPostResponse = response.body();

                        tvPostdata.setText("Result ---> \nTitle - " + addPostResponse.getTitle() +
                                "\nBody - " + addPostResponse.getBody() +
                                "\nPost Id - " + addPostResponse.getId());
                    }
                }


                @Override
                public void onFailure(Call<AddPostResponse> call, Throwable t) {

                    pd.dismiss();

                }
            });
        }
    }

        @OnClick(R.id.btn_post)
        public void onClick () {
            callAddPostAPI();
        }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    }


