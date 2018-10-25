package com.donatracker.a3even2odd.donatracker.controllers;

import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.TextInputEditText;
import android.view.View;

import com.donatracker.a3even2odd.donatracker.R;
import com.donatracker.a3even2odd.donatracker.models.category.Category;

public class AddCategoryActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);
    }

    /**
     * Handler for "Add Category" button.
     *
     * @param v the button
     */
    public void onAddCategoryPressed(View v) {
        TextInputEditText name = findViewById(R.id.inputName);

        new Category(name.getText().toString());

        finish();
    }
}
