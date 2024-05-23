package com.example.dono.classes;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dono.FrameLayoutActivity;
import com.example.dono.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

public class PersonalpageActivity extends AppCompatActivity {

    private EditText username, phonenumber;
    private Button Addtousers;
    private ImageView PesonalPicture;
   // private FireBaseServises fbs;
    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    private FirebaseStorage fbs=FirebaseStorage.getInstance();

    public static final int PICK_IMAGE = 1;
    Bitmap Perphoto = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalpage);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(PersonalpageActivity.this.getContentResolver(), data.getData());
                        PesonalPicture.setImageBitmap(bitmap);
                        Perphoto = bitmap;
                        PesonalPicture.setRotation(90);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(PersonalpageActivity.this, "Canceled", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void add(View view)
    {
        // check if any field is empty
        String etuserName, etphonenum,  etpersonalPhoto;
        etuserName = username.getText().toString();
        etphonenum = phonenumber.getText().toString();


        if (PesonalPicture.getDrawable() == null)
            etpersonalPhoto = "no_image";
        else
            etpersonalPhoto = UploadImageToFirebase();

        if (etuserName.trim().isEmpty() && etphonenum.trim().isEmpty()
                && etpersonalPhoto.trim().isEmpty()&&PesonalPicture.getDrawable() == null)
        {
            Toast.makeText(this, "error fields empty", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            personaldetailspenefactor per = new personaldetailspenefactor(etuserName, etphonenum, etpersonalPhoto);

            //public Product(String productName, String proInfo, String proCompany, String proPhoto, String proPrice) {
            db.collection("users")
                    .add(per)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                            Toast.makeText(PersonalpageActivity.this, "UPLODED SUCCESFULLY", Toast.LENGTH_SHORT).show();
                            Intent myIntent = new Intent(PersonalpageActivity.this, FrameLayoutActivity.class);
                            PersonalpageActivity.this.startActivity(myIntent);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Error adding document", e);
                            Toast.makeText(PersonalpageActivity.this, "not uploded", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }
    private String UploadImageToFirebase()
    {

        if(PesonalPicture.getDrawable() == null){
            Toast.makeText(this, "somting failed ! the photo is null", Toast.LENGTH_SHORT).show();
            return null;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Perphoto.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] data = baos.toByteArray();
        StorageReference ref = fbs.getReference("PesonalPicture/" + UUID.randomUUID().toString());
        UploadTask uploadTask = ref.putBytes(data);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
            }
        });
        return ref.getPath();
    }


    public void ConnectException()
    {
        username = findViewById(R.id.namebenefactorr);
        phonenumber = findViewById(R.id.phonebenefactorr);
        PesonalPicture = findViewById(R.id.perphoto);
        PesonalPicture.setImageResource(R.drawable.perphoto);
        Addtousers = findViewById(R.id.finishbtn);
        PesonalPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        ConnectException();
        Addtousers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                add(view);
            }
        });
    }
}