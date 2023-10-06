package br.com.xavecoding.regescweb.services.authentication;
import org.springframework.web.servlet.HandlerInterceptor;

import br.com.xavecoding.regescweb.services.CookieService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       
        if (CookieService.getCookie(request, "id") != null) {
            return true; 
        }
        response.sendError(403, "Acesso negado");
        return false;
        
    }
}
