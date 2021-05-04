package com.example.my2leafchat.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my2leafchat.MainActivity;
import com.example.my2leafchat.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginFragment extends Fragment {

    EditText et_email, et_password;
    TextView forgot_password;
    Button loginBtn;
    float v = 0;

    String email, password;
    FirebaseAuth mAuth;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        et_email = view.findViewById(R.id.log_email);
        et_password = view.findViewById(R.id.log_password);
        forgot_password = view.findViewById(R.id.forget_pass);
        loginBtn = view.findViewById(R.id.register_Account_btn);

        mAuth = FirebaseAuth.getInstance();


        et_email.setTranslationX(800);
        et_password.setTranslationX(800);
        forgot_password.setTranslationX(800);
        loginBtn.setTranslationX(800);

        et_email.setAlpha(v);
        et_password.setAlpha(v);
        forgot_password.setAlpha(v);
        loginBtn.setAlpha(v);


        et_email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        et_password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgot_password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        loginBtn.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();





        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = et_email.getText().toString();
                password = et_password.getText().toString();


                if (TextUtils.isEmpty(email)) {

                    et_email.setError("Required");

                } else if (TextUtils.isEmpty(password)) {

                    et_password.setError("Required");
                } else {
                    LoginMeIn(email, password);
                }

            }
        });





        return view;
    }



    private void LoginMeIn(String email, String password) {


        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {



                if (task.isSuccessful()) {


                    Intent intent = new Intent(getActivity(), MainActivity.class );
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    Toast.makeText(getActivity(), "Logged In Successfully", Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(getActivity(), "NOT IN", Toast.LENGTH_SHORT).show();

                }

            }
        });



    }

}