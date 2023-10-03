package br.com.outflux.regesc.web.controllers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.outflux.regesc.web.models.Instituicao;
import br.com.outflux.regesc.web.models.Professor;
import br.com.outflux.regesc.web.models.TipoTransacao;
import ch.qos.logback.core.model.Model;

@Controller
public class ProfessorController {
    
    @GetMapping("/professores")
    public ModelAndView index(){
        Instituicao puc = new Instituicao("Puc", (long) 1);
        Professor prof = new Professor("2345678900", "Joao", puc);
        prof.setSaldo(100000.0);

        ModelAndView mv = new ModelAndView("professores/index");
        mv.addObject("professores", prof);
        return mv;
    }
}
