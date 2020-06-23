package com.aditya.bighatti.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.aditya.bighatti.Activity.MainActivity;
import com.aditya.bighatti.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUp extends Fragment {

    public SignUp() {
        // Required empty public constructor
    }

    private TextView alreadyhaveanaccount;
    private FrameLayout parentFrameLayout;
     private EditText email;
    private EditText name;
    private EditText password;
    private  EditText confirmPassword;
    private Button signUpBTN;
    private ProgressBar progressBar;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;
    private  String emailPattern="[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sign_up, container, false);
        alreadyhaveanaccount=view.findViewById(R.id.sigbup_signinB);
        parentFrameLayout=getActivity().findViewById(R.id.register_frame_layout);
        email=view.findViewById(R.id.email_sign_up);
        name=view.findViewById(R.id.name_sign_up);
        password=view.findViewById(R.id.password_sign_up);
        confirmPassword=view.findViewById(R.id.rpassword_sign_up);
        signUpBTN=view.findViewById(R.id.sign_up_button);
        progressBar=view.findViewById(R.id.progressBar);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        alreadyhaveanaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new SignIn());
            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInput();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInput();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInput();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        confirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInput();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        signUpBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               checkEmailAndPassword();
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left,R.anim.slide_out_from_right);
        fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }

    @SuppressLint("ResourceAsColor")
    private void checkInput(){
        if (! TextUtils.isEmpty(email.getText()))
        {
          if (! TextUtils.isEmpty(name.getText()))
          {
              if (! TextUtils.isEmpty(password.getText()) && password.length()>=8)
              {
                  if (! TextUtils.isEmpty(confirmPassword.getText()))
                  {
                      signUpBTN.setEnabled(true);
                      signUpBTN.setTextColor(R.color.green);
                  }
                  else
                  {
                        signUpBTN.setEnabled(false);
                  }
              }
              else
              {
                  signUpBTN.setEnabled(false);
              }
          }
          else
          {
              signUpBTN.setEnabled(false);
          }
        }
        else
        {
            signUpBTN.setEnabled(false);
        }
    }

    private void checkEmailAndPassword(){

        Drawable customErrorIcon=getResources().getDrawable(R.drawable.error);
        customErrorIcon.setBounds(0,0,customErrorIcon.getIntrinsicWidth(),customErrorIcon.getIntrinsicHeight());

        if (email.getText().toString().matches(emailPattern)){
            if (password.getText().toString().equals(confirmPassword.getText().toString())){

                progressBar.setVisibility(View.VISIBLE);
                signUpBTN.setEnabled(false);

                firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                     if (task.isSuccessful()){

                         Map<Object,String> userData=new HashMap<>();
                         userData.put("Name",name.getText().toString());
                         firebaseFirestore.collection("USERS")
                                 .add(userData)
                                 .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                             @Override
                             public void onComplete(@NonNull Task<DocumentReference> task) {
                                 if (task.isSuccessful()){
                                     Intent mailIntent=new Intent(getActivity(), MainActivity.class);
                                     startActivity(mailIntent);
                                     getActivity().finish();
                                 }else
                                 {
                                     String error=task.getException().getMessage();
                                     Toast.makeText(getActivity(),error,Toast.LENGTH_LONG).show();
                                 }
                             }
                         });


                     }else {
                         progressBar.setVisibility(View.INVISIBLE);
                         signUpBTN.setEnabled(true);
                         String error=task.getException().getMessage();
                         Toast.makeText(getActivity(),error,Toast.LENGTH_LONG).show();
                     }
                    }
                });
            }else{
                confirmPassword.setError("Password doesn't match",customErrorIcon);
            }
        }else{
            email.setError("Email Invalid",customErrorIcon);

        }
    }
}
