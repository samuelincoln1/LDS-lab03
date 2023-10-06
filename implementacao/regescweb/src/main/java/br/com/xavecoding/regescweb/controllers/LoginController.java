package br.com.xavecoding.regescweb.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.xavecoding.regescweb.models.Aluno;
import br.com.xavecoding.regescweb.repositories.AlunoRepository;
import br.com.xavecoding.regescweb.services.CookieService;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;


@Controller
public class LoginController {
      @Autowired
    private AlunoRepository rep;

    @GetMapping("/login")
    public String login() {
        return "login";
    } 

    @PostMapping("/logar")
    public String logar(Model model, Aluno alunoParam, String lembrar, HttpServletResponse response) {
        Aluno aluno = this.rep.Login(alunoParam.getEmail(), alunoParam.getSenha());
        if (aluno != null) {
            int tempoLogado = 60*60;
            if (lembrar != null) tempoLogado = (60*60*24*365); // se lembrar senha, dura 1 ano
            CookieService.setCookie(response, "id", String.valueOf(aluno.getId()), tempoLogado);
            CookieService.setCookie(response, "emailUsuario", aluno.getEmail(), tempoLogado);
            CookieService.setCookie(response, "nomeUsuario", aluno.getNome(), tempoLogado);
            return "redirect:/vantagens";
        }

        model.addAttribute("erro", "Usuário ou senha inválidos");
        
        return "login";
    }
}
