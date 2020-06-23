    package com.aditya.bighatti.Fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.aditya.bighatti.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

    /**
 * A simple {@link Fragment} subclass.
 */
public class ResetPassword extends Fragment {

    public ResetPassword() {
        // Required empty public constructor
    }
    FrameLayout parentFrameLayout;
    private EditText registeredEmail;
    private Button reset;
    private TextView goback;
    FirebaseAuth firebaseAuth;
    private  String emailPattern="[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_reset_password, container, false);

        registeredEmail=view.findViewById(R.id.forgotPasswordEmail);
        reset=view.findViewById(R.id.ResetPasswordBtn);
        goback=view.findViewById(R.id.goBack);
        parentFrameLayout=getActivity().findViewById(R.id.register_frame_layout);
        firebaseAuth =FirebaseAuth.getInstance();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        registeredEmail.addTextChangedListener(new TextWatcher() {
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

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new SignIn());
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset.setEnabled(false);
                reset.setTextColor(Color.argb(50,255,255,255));
            firebaseAuth.sendPasswordResetEmail(registeredEmail.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){

                                //todo
                                Toast.makeText(getActivity(),"Email sent Successfully",Toast.LENGTH_LONG).show();
                            }else {
                                String e=task.getException().getMessage();
                                Toast.makeText(getActivity(),e,Toast.LENGTH_SHORT).show();
                                reset.setEnabled(true);
                                reset.setTextColor(Color.rgb(255,255,255));
                            }

                        }
                    });
            }
        });
    }

    private void checkInput() {
        if (! TextUtils.isEmpty(registeredEmail.getText())){
         reset.setEnabled(true);
        }
        else
        {
            reset.setEnabled(false);
            reset.setTextColor(Color.rgb(255,255,255));
        }
    }
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left,R.anim.slide_out_from_right);
        fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}
