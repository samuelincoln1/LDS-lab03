package br.com.xavecoding.regescweb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.xavecoding.regescweb.models.Aluno;
import br.com.xavecoding.regescweb.models.AlunoPossuiVantagem;
import br.com.xavecoding.regescweb.models.Transacao;
import br.com.xavecoding.regescweb.models.Vantagem;
import br.com.xavecoding.regescweb.repositories.AlunoPossuiVantagemRepository;
import br.com.xavecoding.regescweb.repositories.AlunoRepository;
import br.com.xavecoding.regescweb.repositories.TransacaoRepository;
import br.com.xavecoding.regescweb.repositories.VantagensRepository;
import br.com.xavecoding.regescweb.services.CookieService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class VantagensController {
    @Autowired
    public AlunoPossuiVantagemRepository alunoPossuiVantagemRepository;
    @Autowired
    public VantagensRepository vantagensRepository;
    @Autowired AlunoRepository alunoRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @GetMapping("/vantagens")
    public String vantagens(Model model,HttpServletRequest request) {
        String nomeUsuario = CookieService.getCookie(request, "nomeUsuario");
        List<Vantagem> vantagens = vantagensRepository.findAll();
        Aluno aluno = alunoRepository.BuscaPorNome(nomeUsuario);
        List<Transacao> transacoesDoAluno = transacaoRepository.findByAluno(aluno);

        if (nomeUsuario != null) {
            model.addAttribute("logado", true);
            model.addAttribute("nomeUsuario", nomeUsuario);
            model.addAttribute("listaVantagens", vantagens);
            model.addAttribute("aluno", aluno);
            model.addAttribute("transacoesDoAluno", transacoesDoAluno);
            return "vantagens";
        }
        return "redirect:/login";
    }

    @PostMapping("/obter-vantagem")
    public String obterVantagem(Model model, HttpServletRequest request, @RequestParam("idVantagem") int idVantagem){
        String nomeUsuario = CookieService.getCookie(request, "nomeUsuario");
        Aluno aluno = alunoRepository.BuscaPorNome(nomeUsuario);
        Vantagem vantagem = vantagensRepository.ListarVantagemPorId(idVantagem);
        if(aluno.saldo >= vantagem.custo){
            alunoPossuiVantagemRepository.save(new AlunoPossuiVantagem(aluno.id, vantagem.id));
            aluno.saldo = aluno.saldo - vantagem.custo;
            alunoRepository.save(aluno);
        }
        return "redirect:/vantagens";
    }
    
}