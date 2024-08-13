package com.example.dailysales.utils;

import java.text.DecimalFormat;

public class GlobalUtil {

    public static String roundOff2Decimal(double value) {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return twoDForm.format(value);
    }
}
