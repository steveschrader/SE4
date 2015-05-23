package be.odisee.pajotter.controller;

import be.odisee.pajotter.domain.*;
import be.odisee.pajotter.service.PajottersSessieService;
import be.odisee.pajotter.utilities.RolNotFoundException;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Leverancier")
public class LeverancierController {
	@Autowired
    protected PajottersSessieService pajottersSessieService = null;
	
	@RequestMapping(value={"/jquery.js","/jquery"}, method = RequestMethod.GET)
    public String jquery(ModelMap model){
    	return "js/jquery-2.1.3.min.js";
    }
    @RequestMapping(value={"/opmaak.css","/opmaak"}, method = RequestMethod.GET)
    public String opmaak(ModelMap model){
    	return "css/Opmaak.css";
    }
	
	@RequestMapping(value={"/index.html"}, method = RequestMethod.GET)
    public String index(ModelMap model){
        List<Aanbieding> deLijst = pajottersSessieService.geefAlleAanbiedingen();
        model.addAttribute("aanbieding", deLijst);
        return "/Leverancier/index";
    }
	
    //lijst van alle aanbieding
    @RequestMapping(value={"/aanbiedingLijst.html"}, method = RequestMethod.GET)
    public String Lijst(ModelMap model){
        List<Aanbieding> deLijst = pajottersSessieService.geefAlleAanbiedingen();
        model.addAttribute("aanbieding", deLijst);
        return "/Leverancier/aanbiedingLijst";
    }
    
    //details van de producite
    @RequestMapping(value={"/aanbieding.html"}, method = RequestMethod.GET)
    public String aanbiedingDetail(@RequestParam("id") Integer id, ModelMap model) {
        Aanbieding aanbieding = pajottersSessieService.zoekAanbiedingMetId(id);
        model.addAttribute("aanbieding", aanbieding);
        return "/Leverancier/aanbieding";
    }
    
    //om een aanbieding toe te voegen
    @RequestMapping(value={"/nieuweAanbieding.html"}, method = RequestMethod.GET)
    public String aanbiedingFormulier(ModelMap model) {
        Aanbieding aanbieding = new Aanbieding();
        model.addAttribute("deaanbieding", aanbieding);
        return "/Leverancier/nieuweAanbieding";
    }
    
    //om de aanbieding te verwijderen
    @RequestMapping(value={"/verwijderAanbieding.html"}, method = RequestMethod.GET)
    public String aanbiedingDelete(@RequestParam("id") Integer id, ModelMap model) {
        pajottersSessieService.verwijderAanbieding(id);
        List<Aanbieding> deLijst = pajottersSessieService.geefAlleAanbiedingen();
        model.addAttribute("aanbieding", deLijst);
        return "/Leverancier/aanbiedingLijst";
    }
    
    //om de aanbieding up te daten
    @RequestMapping(value={"/updateAanbieding.html"}, method = RequestMethod.POST)
    public String aanbiedingUpdate(@ModelAttribute("deaanbieding") @Valid Aanbieding aanbieding, BindingResult result, ModelMap model){
    	pajottersSessieService.updateAanbieding(aanbieding);
        model.addAttribute("aanbieding", aanbieding);
        return "/Leverancier/aanbieding";
    }
    
    //om naar de update pagina te gaan en de aanbieding info mee te geven
    @RequestMapping(value={"/updateAanbieding.html"}, method = RequestMethod.GET)
    public String telerEditpagina(@RequestParam("id") Integer id, ModelMap model) {
    	Aanbieding aanbieding = pajottersSessieService.zoekAanbiedingMetId(id);
        model.addAttribute("deaanbieding", aanbieding);
        return "/Leverancier/editAanbieding";
    }
    
    //nieuwe aanbieding te maken
    @RequestMapping(value={"/nieuweAanbieding.html"}, method = RequestMethod.POST)
    public String producteiToevoegen(@ModelAttribute("deaanbieding") @Valid Aanbieding aanbieding, BindingResult result, ModelMap model, @RequestParam int PartijId){
    	if (result.hasErrors()) return "/Leverancier/nieuweAanbieding"; 
    	Partij partijDatVerzend = pajottersSessieService.zoekPartijMetId(PartijId);
    	Aanbieding toegevoegdAanbieding = pajottersSessieService.VoegAanbiedingToe("actief",partijDatVerzend, aanbieding.getTekst(), aanbieding.getAantal());
        System.out.println("DEBUG AanbiedingGegevens Tekstst: " + aanbieding.getTekst() );
        return "redirect:/Leverancier/aanbieding.html?id=" + toegevoegdAanbieding.getId();
    }
}