package com.cxyzy.androidutils;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

public class TimeCostUtil {
    private static Map<String, Long> startTimeMap = new HashMap<>();
    private static final String DEFAULT_KEY = "DEFAULT_KEY";

    public static void startTick() {
        startTick(DEFAULT_KEY);
    }

    public static void startTick(@NonNull String actionId) {
        startTimeMap.put(actionId, System.currentTimeMillis());
    }

    public final long getTimeCost() {
        return getTimeCost(DEFAULT_KEY);
    }

    public static long getTimeCost(@NonNull String actionId) {
        long timeCost = 0L;
        if (startTimeMap.containsKey(actionId)) {
            timeCost = System.currentTimeMillis() - startTimeMap.get(actionId);
        }
        return timeCost;
    }

    public static void clear() {
        startTimeMap = new HashMap<>();
    }


}