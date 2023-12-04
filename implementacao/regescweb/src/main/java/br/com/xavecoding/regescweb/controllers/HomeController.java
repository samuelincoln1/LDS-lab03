// package br.com.xavecoding.regescweb.controllers;

// import java.util.List;

// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.servlet.ModelAndView;

// import br.com.xavecoding.regescweb.models.Instituicao;
// import br.com.xavecoding.regescweb.models.Professor;
// import br.com.xavecoding.regescweb.repositories.ProfessorRepository;

// @Controller
// public class HomeController {
//     private ProfessorRepository professorRepository;

//     @GetMapping("/")
//     public ModelAndView index() {
//         ModelAndView mv = new ModelAndView("home");
//         Professor joao = new Professor("Joao", (long) 0.0, Instituicao.PUC, "Exatas");
//         mv.addObject("professor", joao);
//         return mv;  // renderiza o arquivo templates/home.html
//     }
// }
