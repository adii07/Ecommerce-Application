package com.aditya.bighatti.Fragments;

import android.content.Intent;
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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import static com.aditya.bighatti.Activity.Register.onResetPasswordFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignIn extends Fragment {

    public SignIn() {
        // Required empty public constructor
    }

    private TextView donthaveanaccount;
    private FrameLayout parentFrameLayout;
    private EditText email;
    private EditText password;
    private ProgressBar progressBar;
    private Button signinBTN;
    private FirebaseAuth firebaseAuth;
    private TextView forgotPassword;
    private  String emailPattern="[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sign_in, container, false);
        donthaveanaccount=view.findViewById(R.id.sign_up_button);
        parentFrameLayout=getActivity().findViewById(R.id.register_frame_layout);
        email=view.findViewById(R.id.sign_in_email);
        password=view.findViewById(R.id.sign_in_password);
        signinBTN=view.findViewById(R.id.sign_in_button);
        progressBar=view.findViewById(R.id.progressBar2);
        forgotPassword=view.findViewById(R.id.forgot_password);
        firebaseAuth=FirebaseAuth.getInstance();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        donthaveanaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new SignUp());
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onResetPasswordFragment=true;
                setFragment(new ResetPassword());
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

        signinBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkEmailAndPassword();
            }
        });
    }

    private void checkEmailAndPassword() {
        if (email.getText().toString().matches(emailPattern)){
            if (password.length()>=8){

                progressBar.setVisibility(View.VISIBLE);
                signinBTN.setEnabled(false);
                firebaseAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Intent intent=new Intent(getActivity(), MainActivity.class);
                                    startActivity(intent);
                                    getActivity().finish();
                                }else{
                                    progressBar.setVisibility(View.INVISIBLE);
                                    signinBTN.setEnabled(true);
                                    String error=task.getException().getMessage();
                                    Toast.makeText(getActivity(),error,Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }else{
                Toast.makeText(getActivity(),"Incorrect Password",Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getActivity(),"Incorrect Email",Toast.LENGTH_LONG).show();
        }

    }

    private void checkInput() {
        if (! TextUtils.isEmpty(email.getText())){
              if (! TextUtils.isEmpty(password.getText())){
                  signinBTN.setEnabled(true);
              }else {
                  signinBTN.setEnabled(false);
              }
        }
        else
        {
            signinBTN.setEnabled(false);
        }
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right,R.anim.slide_out_from_left);
        fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}
