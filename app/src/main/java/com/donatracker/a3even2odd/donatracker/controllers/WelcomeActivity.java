package com.donatracker.a3even2odd.donatracker.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.donatracker.a3even2odd.donatracker.R;
import com.donatracker.a3even2odd.donatracker.models.login.LoginSingleton;
import com.donatracker.a3even2odd.donatracker.models.parser.YamlParser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


import java.io.InputStream;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // TODO: Maybe move this
        loadConfigs();
    }

    /**
     * Load config files.
     */
    private void loadConfigs() {
        InputStream inputStream = getResources().openRawResource(R.raw.login_config);
        YamlParser parseLogin = new YamlParser(inputStream);
        List<Float> configList = parseLogin.Parse();

        LoginSingleton.getInstance().setLockoutData(configList);
    }

    /**
     * Button handler for login button.
     *
     * When the login button is pressed, go to the login page.
     *
     * @param v the button
     */
    public void onLoginPressed(View v) {
        Log.d("Login", "Go to login page");

        Intent loginIntent = new Intent(this, LoginActivity.class);

        startActivity(loginIntent);
    }

    /**
     * Button handler for registration button.
     *
     * When the registration button is pressed, go to the registration page.
     *
     * @param v the button
     */
    public void onRegisterPressed(View v) {
        Log.d("Registration","Go to Registation page");

        Intent registrationIntent = new Intent(this, RegistrationActivity.class);

        startActivity(registrationIntent);
    }

    /**
     * create an instance of FirebaseStorage
     */
    public void includesForCreateReference() {

        FirebaseStorage storage = FirebaseStorage.getInstance();
        // ## Create a Reference

        // [START create_storage_reference]
        // Create a storage reference from our app
        StorageReference storageRef = storage.getReference();
        // [END create_storage_reference]

        // [START create_child_reference]
        // Create a child reference
        // imagesRef now points to "images"
        StorageReference imagesRef = storageRef.child("images");

        // Child references can also take paths
        // spaceRef now points to "images/space.jpg
        // imagesRef still points to "images"
        StorageReference spaceRef = storageRef.child("images/space.jpg");
        // [END create_child_reference]

        // ## Navigate with References

        // [START navigate_references]
        // getParent allows us to move our reference to a parent node
        // imagesRef now points to 'images'
        imagesRef = spaceRef.getParent();

        // getRoot allows us to move all the way back to the top of our bucket
        // rootRef now points to the root
        StorageReference rootRef = spaceRef.getRoot();
        // [END navigate_references]

        // [START chain_navigation]
        // References can be chained together multiple times
        // earthRef points to 'images/earth.jpg'
        StorageReference earthRef = spaceRef.getParent().child("earth.jpg");

        // nullRef is null, since the parent of root is null
        StorageReference nullRef = spaceRef.getRoot().getParent();
        // [END chain_navigation]

        // ## Reference Properties

        // [START reference_properties]
        // Reference's path is: "images/space.jpg"
        // This is analogous to a file path on disk
        spaceRef.getPath();

        // Reference's name is the last segment of the full path: "space.jpg"
        // This is analogous to the file name
        spaceRef.getName();

        // Reference's bucket is the name of the storage bucket that the files are stored in
        spaceRef.getBucket();
        // [END reference_properties]

        // ## Full Example

        // [START reference_full_example]
        // Points to the root reference
        storageRef = storage.getReference();

        // Points to "images"
        imagesRef = storageRef.child("images");

        // Points to "images/space.jpg"
        // Note that you can use variables to create child values
        String fileName = "space.jpg";
        spaceRef = imagesRef.child(fileName);

        // File path is "images/space.jpg"
        String path = spaceRef.getPath();

        // File name is "space.jpg"
        String name = spaceRef.getName();

        // Points to "images"
        imagesRef = spaceRef.getParent();
        // [END reference_full_example]
    }
    }
