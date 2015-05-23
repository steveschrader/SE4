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
@RequestMapping("/")
public class AanbiedingController {
	@Autowired
    protected PajottersSessieService pajottersSessieService = null;
	
    //lijst van alle aanbieding
    @RequestMapping(value={"/Leverancier/aanbiedingLijst.html","/Leverancier/index.html"}, method = RequestMethod.GET)
    public String index(ModelMap model){
        List<Aanbieding> deLijst = pajottersSessieService.geefAlleAanbiedingen();
        model.addAttribute("aanbieding", deLijst);
        return "/Leverancier/aanbiedingLijst";
    }
    
    //details van de producite
    @RequestMapping(value={"/Leverancier/aanbieding.html"}, method = RequestMethod.GET)
    public String aanbiedingDetail(@RequestParam("id") Integer id, ModelMap model) {
        Aanbieding aanbieding = pajottersSessieService.zoekAanbiedingMetId(id);
        model.addAttribute("aanbieding", aanbieding);
        return "/Leverancier/aanbieding";
    }
    
    //om een aanbieding toe te voegen
    @RequestMapping(value={"/Leverancier/nieuweAanbieding.html"}, method = RequestMethod.GET)
    public String aanbiedingFormulier(ModelMap model) {
        Aanbieding aanbieding = new Aanbieding();
        model.addAttribute("deaanbieding", aanbieding);
        return "/Leverancier/nieuweAanbieding";
    }
    
    //om de aanbieding te verwijderen
    @RequestMapping(value={"/Leverancier/verwijderAanbieding.html"}, method = RequestMethod.GET)
    public String aanbiedingDelete(@RequestParam("id") Integer id, ModelMap model) {
        pajottersSessieService.verwijderAanbieding(id);
        List<Aanbieding> deLijst = pajottersSessieService.geefAlleAanbiedingen();
        model.addAttribute("aanbieding", deLijst);
        return "/Leverancier/aanbiedingLijst";
    }
    
    //om de aanbieding up te daten
    @RequestMapping(value={"/Leverancier/updateAanbieding.html"}, method = RequestMethod.POST)
    public String aanbiedingUpdate(@ModelAttribute("deaanbieding") @Valid Aanbieding aanbieding, BindingResult result, ModelMap model){
    	pajottersSessieService.updateAanbieding(aanbieding);
        model.addAttribute("aanbieding", aanbieding);
        return "/Leverancier/aanbieding";
    }
    
    //om naar de update pagina te gaan en de aanbieding info mee te geven
    @RequestMapping(value={"/Leverancier/updateAanbieding.html"}, method = RequestMethod.GET)
    public String telerEditpagina(@RequestParam("id") Integer id, ModelMap model) {
    	Aanbieding aanbieding = pajottersSessieService.zoekAanbiedingMetId(id);
        model.addAttribute("deaanbieding", aanbieding);
        return "/Leverancier/editAanbieding";
    }
    
    //nieuwe aanbieding te maken
    @RequestMapping(value={"/Leverancier/nieuweAanbieding.html"}, method = RequestMethod.POST)
    public String producteiToevoegen(@ModelAttribute("deaanbieding") @Valid Aanbieding aanbieding, BindingResult result, ModelMap model, @RequestParam int PartijId){
    	if (result.hasErrors()) return "/Leverancier/nieuweAanbieding"; 
    	Partij partijDatVerzend = pajottersSessieService.zoekPartijMetId(PartijId);
    	Aanbieding toegevoegdAanbieding = pajottersSessieService.VoegAanbiedingToe("actief",partijDatVerzend, aanbieding.getTekst(), aanbieding.getAantal());
        System.out.println("DEBUG AanbiedingGegevens Tekstst: " + aanbieding.getTekst() );
        return "redirect:/Leverancier/aanbieding.html?id=" + toegevoegdAanbieding.getId();
    }
}