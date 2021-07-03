package br.edu.usj.ads.lojadecarros;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class VeiculoController {

    @Autowired
    ContatoRepository VeiculoRepository;
    
    @GetMapping(value="/")
    public ModelAndView getListaTodos() {
        List<veiculo> lista = VeiculoRepository.findAll();

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject ("lista", lista);
        return modelAndView;
    }
    
    @GetMapping(value="/cadastro")
    public ModelAndView getCadastro () {
        Veiculo veiculo = new Veiculo();

        ModelAndView modelAndView = new ModelAndView("cadastro");
        modelAndView.addObject("veiculo", veiculo);
        return modelAndView;
    }
    
    @GetMapping(value="/detalhes/{id}")
    public ModelAndView getMontrarPorId(@PathVariable Long id) {
        // ler do banco
        Veiculo veiculo = VeiculoRepository.findById(placa).get();


        ModelAndView modelAndView = new ModelAndView("detalhes");
        // acrescentar na model
        modelAndView.addObject("veiculo", veiculo);

        return modelAndView;
    }
    
    @GetMapping(value="/deletar/{id}")
    public String getDeletar(@PathVariable Long placa) {
        VeiculoRepository.deleteById(placa);
        return "redirect:/";
    }
    
    @GetMapping(value="/editar/{id}")
    public ModelAndView getEditar (@PathVariable Long placa) {
        Veiculo veiculo = VeiculoRepository.findById(placa).get();

        ModelAndView modelAndView = new ModelAndView("cadastro");
        modelAndView.addObject("veiculo", veiculo);
        return modelAndView;
    }
    

    @PostMapping(value="/adicionar")

    public String postAdicionaVeiculo(Veiculo veiculo) {
        VeiculoRepository.save(veiculo);
        return "redirect:/";
       
    }
    

    @GetMapping(value="/pesquisar")
    public String getPesquisar() {
        return "pesquisar";
    }
    

    @PostMapping(value="/pesquisar")
    public ModelAndView postMethodName(@RequestParam String placa) {
        List<Veiculo> lista = VeiculoRepository.findByNomeContainingIgnoreCase(carro);
        ModelAndView modelAndView = new ModelAndView("pesquisar");
        modelAndView.addObject ("carro", carro);
        modelAndView.addObject ("lista", lista);
    return modelAndView;
    }
     
}
