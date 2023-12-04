package br.com.xavecoding.regescweb.services;

import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Optional;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieService {
  
        public static void setCookie(HttpServletResponse response, String key, String value, int segundos) {
            try {
                Cookie cookie = new Cookie(key, URLEncoder.encode(value, "UTF-8"));
                cookie.setHttpOnly(true);
                cookie.setMaxAge(segundos);
                response.addCookie(cookie);
            } catch (Exception e) {
                e.printStackTrace();
            }
       
    }
    
    public static String getCookie(HttpServletRequest request, String key) {
        return Optional.ofNullable(request.getCookies())
            .flatMap(cookies -> Arrays.stream(cookies)
            .filter(cookie -> key.equals(cookie.getName()))
            .findAny()
            ).map(e -> e.getValue())
            .orElse(null);
    }
}
