package be.odisee.pajotter.controller;

import be.odisee.pajotter.domain.Teler;
import be.odisee.pajotter.service.PajottersSessieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class TelerController {
	//Dit is nu de partij controller geworden

  /*  @Autowired
    protected PajottersSessieService brainstormSessieService=null; // ready for dependency injection
    //lijst van alle telers
    @RequestMapping(value={"/home.html","/index.html","/lijst.html"}, method = RequestMethod.GET)
    public String index(ModelMap model){
        List<Teler> deLijst = brainstormSessieService.geefAlleTelers();
        model.addAttribute("telers", deLijst);
        return "/index";
    }*/
    // details van de teler

   /* @RequestMapping(value={"/teler.html"}, method = RequestMethod.GET)
    public String telerDetail(@RequestParam("id") Integer id, ModelMap model){
        Teler teler = brainstormSessieService.zoekTelerMetId(id);
        model.addAttribute("teler", teler);
        return "/teler";
    }
    // om een teler toe te voegen
    
    @RequestMapping(value={"/nieuweTeler.html"},method=RequestMethod.GET)
    public String telerFormulier(ModelMap model){
        Teler teler = new Teler();
        model.addAttribute("deteler", teler);
        return "/nieuweTeler";
    }
    
    //om de teler te verwijderen
    @RequestMapping(value={"/verwijderTeler.html"},method=RequestMethod.GET)
    public String telerDelete(@RequestParam("id") Integer id, ModelMap model){
        brainstormSessieService.verwijderTeler(id);
        List<Teler> deLijst = brainstormSessieService.geefAlleTelers();
        model.addAttribute("telers", deLijst);
        return "/index";
    }
    //om de teler up te daten
    @RequestMapping(value={"/updateTeler.html"},method=RequestMethod.POST)
    public String telerUpdate(@ModelAttribute("deteler") Teler teler, ModelMap model){
    	brainstormSessieService.updateTeler(teler);
        model.addAttribute("teler", teler);
        return "/teler";
    }
    //om naar de update pagina te gaan en de teler info mee te geven
    @RequestMapping(value={"/updateTeler.html"},method=RequestMethod.GET)
    public String telerEditpagina(@RequestParam("id") Integer id, ModelMap model){
    	Teler teler = brainstormSessieService.zoekTelerMetId(id);
        model.addAttribute("deteler", teler);
        return "/editTeler";
    }
    
    // nieuwe teler te maken

    @RequestMapping(value={"/nieuweTeler.html"},method=RequestMethod.POST)
    public String telerToevoegen(@ModelAttribute("deteler") Teler teler, ModelMap model){
        Teler toegevoegdTeler = brainstormSessieService.voegTelerToe(teler.getVoornaam(),
                                                                            teler.getFamilienaam(),
                                                                            teler.getEmailadres(),
                                                                            teler.getPaswoord(),
                                                                            teler.getAdres(),
                                                                            teler.getTelefoon());
        System.out.println("DEBUG telergegevens familienaam: " + teler.getFamilienaam());
        return "redirect:teler.html?id=" + toegevoegdTeler.getId();
    }
    
    @RequestMapping(value={"/jquery.js"},method=RequestMethod.GET)
    public String geefjQuery() {
    	return "/jquery-2.1.3.min.js";
    }
    
    @RequestMapping(value={"/opmaak.css"},method=RequestMethod.GET)
    public String geefCss() {
    	return "/Opmaak.css";
    }*/
}
