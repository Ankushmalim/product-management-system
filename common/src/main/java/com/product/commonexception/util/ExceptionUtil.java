package com.product.commonexception.util;

import jakarta.servlet.http.HttpServletRequest;

public class ExceptionUtil {

    private ExceptionUtil() {
    }

    public static String getPath(
            HttpServletRequest request) {

        return request.getRequestURI();
    }
}
