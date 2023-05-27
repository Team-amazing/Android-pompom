package com.example.outopompomme;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;


public class InfoFragment extends Fragment {

    private static final int GALLERY_REQUEST_CODE = 2000;

    private ImageView ivProfile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedinstanceState){

        return inflater.inflate(R.layout.fragment_main_menu_info,container,false);
    }

    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        initImageViewProfile();
    }

    private void initImageViewProfile() {
        ivProfile = requireView().findViewById(R.id.ivProfile_1);

        ivProfile.setOnClickListener(v ->{
            if (ContextCompat.checkSelfPermission(requireActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                navigateGallery();
            } else if (shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                showPermissionContextPopup();
            } else {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, GALLERY_REQUEST_CODE);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResult) {
        super.onRequestPermissionsResult(requestCode, permissions,grantResult);

        if(requestCode == GALLERY_REQUEST_CODE) {
            if(grantResult.length >0 && grantResult[0] == PackageManager.PERMISSION_GRANTED) {
                navigateGallery();
            } else {
                Toast.makeText(requireContext(), "권한을 거부하셨습니다.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void navigateGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, GALLERY_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @NonNull Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == Activity.RESULT_OK && requestCode == GALLERY_REQUEST_CODE) {
            Uri selectedImageUri = data.getData();
            if (selectedImageUri != null) {
                ivProfile.setImageURI(selectedImageUri);
            } else {
                Toast.makeText(requireContext(), "사진을 가져오지 못했습니다.", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(requireContext(), "사진을 가져오지 못했습니다.", Toast.LENGTH_SHORT).show();
        }
    }

    private void showPermissionContextPopup() {
        new AlertDialog.Builder(requireContext())
                .setTitle("권한이 필요합니다.")
                .setMessage("프로필 이미지를 바꾸기 위해서는 갤러리 접근 권한이 필요합니다.")
                .setPositiveButton("동의하기", (dialog, which) -> {
                    requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, GALLERY_REQUEST_CODE);
                })
                .setNegativeButton("취소하기",(dialog, which) -> {
                })
                .create()
                .show();
    }
}