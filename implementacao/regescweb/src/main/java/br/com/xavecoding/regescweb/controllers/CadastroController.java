package br.com.xavecoding.regescweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.xavecoding.regescweb.models.Aluno;
import br.com.xavecoding.regescweb.models.Empresa;
import br.com.xavecoding.regescweb.repositories.AlunoRepository;
import br.com.xavecoding.regescweb.repositories.EmpresaRepository;



@Controller
public class CadastroController {

    @Autowired
    private AlunoRepository rep;

    @Autowired
    private EmpresaRepository repEmp;

    @GetMapping("/cadastro")
    public String index() {
        return "cadastro";
    }

     @GetMapping("/cadastro-empresa")
    public String cadastroEmpresa() {
        return "cadastro-empresa";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(Aluno aluno, Model model) {
        try {
            rep.save(aluno);
            return "redirect:/login";
        } catch (Exception e) {
            System.out.println("Erro!");
            model.addAttribute("erro", "Erro ao realizar cadastro");
            e.printStackTrace();
        }
        return "cadastro";
    }

     @PostMapping("/cadastrarEmpresa")
    public String cadastrarEmpresa(Empresa empresa, Model model) {
        try {
            repEmp.save(empresa);
            return "redirect:/login";
        } catch (Exception e) {
            System.out.println("Erro!");
            model.addAttribute("erro", "Erro ao realizar cadastro");
            e.printStackTrace();
        }
        return "cadastro";
    }

}
