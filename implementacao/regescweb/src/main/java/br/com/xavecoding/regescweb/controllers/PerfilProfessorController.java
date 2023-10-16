package br.com.xavecoding.regescweb.controllers;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.xavecoding.regescweb.models.Aluno;
import br.com.xavecoding.regescweb.models.Professor;
import br.com.xavecoding.regescweb.models.Transacao;
import br.com.xavecoding.regescweb.repositories.AlunoRepository;
import br.com.xavecoding.regescweb.repositories.ProfessorRepository;
import br.com.xavecoding.regescweb.repositories.TransacaoRepository;
import br.com.xavecoding.regescweb.services.CookieService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PerfilProfessorController {

    
    @Autowired ProfessorRepository professorRepository;
    
    @Autowired AlunoRepository alunoRepository;

    @Autowired TransacaoRepository transacaoRepository;

    @GetMapping("/perfil-professor")
    public String perfil(Model model,HttpServletRequest request) {
        String nomeProfessor = CookieService.getCookie(request, "nomeProfessor");
        Professor professor = professorRepository.BuscaPorNome(nomeProfessor);
        if (nomeProfessor != null) {
            model.addAttribute("logado", true);
            model.addAttribute("nomeProfessor", nomeProfessor);
            model.addAttribute("professor", professor);
            model.addAttribute("transacoesDoProfessor", transacaoRepository.findByProfessor(professor));
            return "perfil-professor";
        }
        return "redirect:/login-professor";
    }

    @PostMapping("/distribuir-saldo")
    public String distribuirSaldo(Model model, HttpServletRequest request, @RequestParam("idAluno") Long idAluno, @RequestParam("saldo") int saldo){
        String nomeProfessor = CookieService.getCookie(request, "nomeProfessor");
        Professor professor = professorRepository.BuscaPorNome(nomeProfessor);
        Aluno aluno = alunoRepository.findById(idAluno).get();
        if(professor.saldo > saldo){
            aluno.setSaldo(aluno.getSaldo() + saldo);
            professor.setSaldo(professor.getSaldo() - saldo);

             Transacao transacao = new Transacao();
                transacao.setData(LocalDateTime.now());
                transacao.setValor(saldo);
                transacao.setProfessor(professor);
                transacaoRepository.save(transacao);

            professorRepository.save(professor);
            alunoRepository.save(aluno);
        }
        return "redirect:/perfil-professor";
    }

}
