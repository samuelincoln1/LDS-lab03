package br.com.xavecoding.regescweb.controllers;

import org.springframework.stereotype.Controller;
import br.com.xavecoding.regescweb.services.CookieService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PerfilEmpresaController {
    @GetMapping("/perfil-empresa")
    public String perfil(Model model,HttpServletRequest request) {
        String nomeEmpresa = CookieService.getCookie(request, "nomeEmpresa");
        if (nomeEmpresa != null) {
            model.addAttribute("logado", true);
            model.addAttribute("nomeEmpresa", nomeEmpresa);
            return "perfil-empresa";
        }
        return "redirect:/login-empresa";
    }
}
