package com.cxyzy.androidutils;

import android.support.annotation.Nullable;
import android.text.TextUtils;

public class StringUtil {
    private static final int CHINA_PHONE_NUMBER_LENGTH = 11;
    /**
     * 为手机号增加空格
     * XXXYYYYZZZZ-->XXX YYYY ZZZZ
     *
     * @param phoneNumber
     */
    @Nullable
    public static String addBlankForPhoneNumber(@Nullable String phoneNumber) {
        if (TextUtils.isEmpty(phoneNumber) || phoneNumber.length() != CHINA_PHONE_NUMBER_LENGTH) {
            return phoneNumber;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(phoneNumber.substring(0, 3));
            sb.append(" ");
            sb.append(phoneNumber.substring(3, 7));
            sb.append(" ");
            sb.append(phoneNumber.substring(7, 11));
            return sb.toString();
        }
    }
}
