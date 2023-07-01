package com.example.outopompomme.first;

import static android.content.ContentValues.TAG;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.outopompomme.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;


public class First1Fragment extends Fragment {
    private EditText usernikname;
    private ImageButton nextBtn;



    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first1, container, false);

        Log.d("TEST","프래그먼트 인");

        usernikname = view.findViewById(R.id.fragment1_nikname_et);
        nextBtn = view.findViewById(R.id.frament1_next_btn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputnickname();
                ((UserInfoActivity) requireActivity()).showNextFragment(2);
            }
        });


        Log.d("TEST","프래그먼트 끝");
        return view;
    }

    private void inputnickname(){
        String nickname = String.valueOf((EditText) getView().findViewById(R.id.fragment1_nikname_et));

        if(nickname.length()>0) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                    .setDisplayName(nickname)
                    .build();

            if(user != null){
                user.updateProfile(profileUpdates)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Log.d(TAG, "User profile updated.");
                                }
                            }
                        });
            }

        }else{
            Toast.makeText(this.getContext().getApplicationContext(), "닉네임을 입력해주세요",Toast.LENGTH_SHORT).show();
        }



    }
}