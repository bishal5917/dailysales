package com.example.dailysales.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.Toast;
import android.widget.TextView;

public class CustomToast {

    public static void success(Context context, String message) {
        showToast(context, message, Color.GREEN);
    }

    public static void error(Context context, String message) {
        showToast(context, message, Color.RED);
    }

    private static void showToast(Context context, String message, int backgroundColor) {
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        TextView textView = toast.getView().findViewById(android.R.id.message);
        if (textView != null) {
            textView.setTextColor(Color.WHITE);
        }
        toast.getView().setBackground(new ColorDrawable(backgroundColor));
        toast.show();
    }
}

