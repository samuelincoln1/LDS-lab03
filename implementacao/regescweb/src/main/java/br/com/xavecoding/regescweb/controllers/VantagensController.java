package br.com.xavecoding.regescweb.controllers;

import org.springframework.stereotype.Controller;



import br.com.xavecoding.regescweb.services.CookieService;
import jakarta.servlet.http.HttpServletRequest;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class VantagensController {
    @GetMapping("/vantagens")
    public String vantagens(Model model,HttpServletRequest request) {
        String nomeUsuario = CookieService.getCookie(request, "nomeUsuario");
        if (nomeUsuario != null) {
            model.addAttribute("logado", true);
            model.addAttribute("nomeUsuario", nomeUsuario);
            return "vantagens";
        }
        return "redirect:/login";
    }
    
}