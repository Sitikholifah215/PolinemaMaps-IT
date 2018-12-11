package com.example.ulfa.itmaps;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ulfa.itmaps.Models.ResultUser;
import com.example.ulfa.itmaps.Models.User;
import com.example.ulfa.itmaps.Models.UserModel;
import com.example.ulfa.itmaps.Rest.ApiClient;
import com.example.ulfa.itmaps.Rest.ApiInterface;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity_login extends AppCompatActivity {
    Dialog popup;
    Button btn_login;
    TextView txt_username, txt_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        txt_username = (TextView)findViewById(R.id.editTextUsername);
        txt_password = (TextView)findViewById(R.id.editTextPassword);
        btn_login = (Button)findViewById(R.id.buttonLogin) ;

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ApiInterface mApiInterface = ApiClient.getClient().create(ApiInterface.class);

//                RequestBody reqUsername = MultipartBody.create(MediaType.parse("multipart/form-data"),
//                        txt_username.getText().toString());
//                RequestBody resPassword = MultipartBody.create(MediaType.parse("multipart/form-data"),
//                        txt_password.getText().toString());
                Call<ResultUser> mLogin =  mApiInterface.loginRequest(txt_username.getText().toString());
                mLogin.enqueue(new Callback<ResultUser>() {
                    @Override
                    public void onResponse(Call<ResultUser> call, Response<ResultUser> response) {
                        String status = response.body().getStatus();
                        if (status.equals("success"))
                        {
                            User user = response.body().getUser();
                            Intent i = new Intent(MainActivity_login.this, MainActivity_Home.class);
                            i.putExtra("username", user.getUsername());

                            startActivity(i);

                        }
//                        Log.d("Status", response.body().getStatus());
//                        List<UserModel> mUser = response.body().getData();

                    }

                    @Override
                    public void onFailure(Call<ResultUser> call, Throwable t) {
//                        Log.d("Status", t.getMessage());
                        Toast.makeText(getApplicationContext(),"fail login", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

        popup = new Dialog(this);

        TextView textView = findViewById(R.id.textView);

        String text = "Jika ada masalah silakan Klik Disini";

        Spannable ss = new SpannableString(text);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                TextView txtclose;
                popup.setContentView(R.layout.popwindow);
                txtclose = (TextView) popup.findViewById(R.id.textViewOKE);
                txtclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popup.dismiss();
                    }
                });
                popup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                popup.show();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(true);
            }
        };
        ss.setSpan(clickableSpan,30,36,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
