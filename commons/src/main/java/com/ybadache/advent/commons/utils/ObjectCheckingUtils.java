package com.ybadache.advent.commons.utils;

import java.util.List;

public class ObjectCheckingUtils {

    public static boolean isListNullOrEmpty(List<?> input)  {
        return input == null || input.size() == 0;
    }
}
