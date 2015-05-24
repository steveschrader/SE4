package be.odisee.pajotter.controller;

import be.odisee.pajotter.domain.*;
import be.odisee.pajotter.service.*;
import be.odisee.pajotter.utilities.RolNotFoundException;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Pajotter")
public class PajotterController {
	
	@Autowired
    protected PajottersSessieService pajottersSessieService = null;
	@Autowired
	protected UserContextService userContextService = null;
    //---------------------------------------------Antwoord-----------------------------------------------------------------
    
    //lijst van alle antwoord
    @RequestMapping(value={"/antwoordLijst.html"}, method = RequestMethod.GET)
    public String indexAntwoord(ModelMap model){
    	Partij partij = userContextService.getAuthenticatedPersoon();
        List<Antwoord> deLijst = pajottersSessieService.geefAlleAntwoorden(partij.getId(), "partij_id");
        model.addAttribute("antwoord", deLijst);
        return "/Pajotter/antwoordLijst";
    }
    
    //details van de producite
    @RequestMapping(value={"/antwoord.html"}, method = RequestMethod.GET)
    public String antwoordDetail(@RequestParam("id") Integer id, ModelMap model) {
        Antwoord antwoord = pajottersSessieService.zoekAntwoordMetId(id);
        model.addAttribute("antwoord", antwoord);
        return "/Pajotter/antwoord";
    }
    
    //om een antwoord toe te voegen
    @RequestMapping(value={"/nieuweAntwoord.html"}, method = RequestMethod.GET)
    public String antwoordFormulier(ModelMap model) {
        Antwoord antwoord = new Antwoord();
        model.addAttribute("deantwoord", antwoord);
        return "/Pajotter/nieuweAntwoord";
    }
    
    //om de antwoord te verwijderen
    @RequestMapping(value={"/verwijderAntwoord.html"}, method = RequestMethod.GET)
    public String antwoordDelete(@RequestParam("id") Integer id, ModelMap model) {
        pajottersSessieService.verwijderAntwoord(id);
    	Partij partij = userContextService.getAuthenticatedPersoon();
        List<Antwoord> deLijst = pajottersSessieService.geefAlleAntwoorden(partij.getId(), "partij_id");
        model.addAttribute("antwoord", deLijst);
        return "/Pajotter/antwoordLijst";
    }
    
    //om de antwoord up te daten
    @RequestMapping(value={"/updateAntwoord.html"}, method = RequestMethod.POST)
    public String antwoordUpdate(@ModelAttribute("deantwoord") @Valid Antwoord antwoord, BindingResult result, ModelMap model){
    	pajottersSessieService.updateAntwoord(antwoord);
        model.addAttribute("antwoord", antwoord);
        return "/Pajotter/antwoord";
    }
    
    //om naar de update pagina te gaan en de antwoord info mee te geven
    @RequestMapping(value={"/updateAntwoord.html"}, method = RequestMethod.GET)
    public String antwoordEditpagina(@RequestParam("id") Integer id, ModelMap model) {
    	Antwoord antwoord = pajottersSessieService.zoekAntwoordMetId(id);
        model.addAttribute("deantwoord", antwoord);
        return "/Pajotter/editAntwoord";
    }
    
    //nieuwe antwoord te maken
    @RequestMapping(value={"/nieuweAntwoord.html"}, method = RequestMethod.POST)
    public String producteiToevoegen(@ModelAttribute("deantwoord") @Valid Antwoord antwoord, @RequestParam("vraagid") Integer vraagid, BindingResult result, ModelMap model){
    	if (result.hasErrors()) return "/Pajotter/nieuweAntwoord"; 
    	//Partij partijDatVerzend = pajottersSessieService.zoekPartijMetId(PartijId);
    	Bericht oorsprongBericht = pajottersSessieService.zoekVraagMetId(vraagid);
    	Partij partijDatVerzend = userContextService.getAuthenticatedPersoon();
    	Antwoord toegevoegdAntwoord = pajottersSessieService.VoegAntwoordToe("actief",partijDatVerzend, oorsprongBericht,antwoord.getTekst());
        System.out.println("DEBUG AntwoordGegevens Tekstst: " + antwoord.getTekst() );
        return "redirect:/Pajotter/antwoord.html?id=" + toegevoegdAntwoord.getId();
    }
    
    
 //---------------------------------------------Vraag-----------------------------------------------------------------
    
    //lijst van alle bestelling
    @RequestMapping(value={"/index", "/vraagLijst.html"}, method = RequestMethod.GET)
    public String indexVraag(ModelMap model){
    	Partij partij = userContextService.getAuthenticatedPersoon();
        List<Vraag> deLijst = pajottersSessieService.geefAlleVraagen();
        model.addAttribute("vraag", deLijst);
        return "/Pajotter/vraagLijst";
    }
    
    //details van de producite
    @RequestMapping(value={"/vraag.html"}, method = RequestMethod.GET)
    public String vraagDetail(@RequestParam("id") Integer id, ModelMap model) {
        Vraag vraag = pajottersSessieService.zoekVraagMetId(id);
        Antwoord antwoord = pajottersSessieService.zoekAntwoordMetId(vraag.getId());
        model.addAttribute("antwoord", antwoord);
        model.addAttribute("vraag", vraag);
        return "/Pajotter/vraag";
    }
    
    //om een vraag toe te voegen
    @RequestMapping(value={"/nieuweVraag.html"}, method = RequestMethod.GET)
    public String vraagFormulier(ModelMap model) {
        Vraag vraag = new Vraag();
        model.addAttribute("devraag", vraag);
        return "/Pajotter/nieuweVraag";
    }
    
    //om de vraag te verwijderen
    @RequestMapping(value={"/verwijderVraag.html"}, method = RequestMethod.GET)
    public String vraagDelete(@RequestParam("id") Integer id, ModelMap model) {
        pajottersSessieService.verwijderVraag(id);
    	Partij partij = userContextService.getAuthenticatedPersoon();
        List<Vraag> deLijst = pajottersSessieService.geefAlleVraagen(partij.getId(), "partij_id");
        model.addAttribute("vraag", deLijst);
        return "/Pajotter/vraagLijst";
    }
    
    //om de vraag up te daten
    @RequestMapping(value={"/beantwoordVraag.html"}, method = RequestMethod.POST)
    public String vraagUpdate(@ModelAttribute("devraag") @Valid Vraag vraag, @RequestParam("antwoord") String antwoord, BindingResult result, ModelMap model){
    	//pajottersSessieService.updateVraag(vraag);
    	
    	Bericht oorsprongBericht = pajottersSessieService.zoekVraagMetId(vraag.getId());
    	Partij partijDatVerzend = userContextService.getAuthenticatedPersoon();
    	System.out.println("Debug" + vraag.getId());
    	Antwoord toegevoegdAntwoord = pajottersSessieService.VoegAntwoordToe("beantwoord", partijDatVerzend, oorsprongBericht, antwoord);
        model.addAttribute("vraag", vraag);
        model.addAttribute("antwoord", toegevoegdAntwoord);
        return "/Pajotter/vraag";
    }
    
    //om naar de update pagina te gaan en de vraag info mee te geven
    @RequestMapping(value={"/beantwoordVraag.html"}, method = RequestMethod.GET)
    public String vraagEditpagina(@RequestParam("id") Integer id, ModelMap model) {
    	Vraag vraag = pajottersSessieService.zoekVraagMetId(id);
        Antwoord antwoord = pajottersSessieService.zoekAntwoordMetId(vraag.getId());
        model.addAttribute("antwoord", antwoord);
        model.addAttribute("devraag", vraag);
        return "/Pajotter/beantwoordVraag";
    }
    
    //nieuwe vraag te maken
    @RequestMapping(value={"/nieuweVraag.html"}, method = RequestMethod.POST)
    public String producteiToevoegen(@ModelAttribute("devraag") @Valid Vraag vraag, BindingResult result, ModelMap model){
    	if (result.hasErrors()) return "/Pajotter/nieuweVraag"; 
    	//Partij partijDatVerzend = pajottersSessieService.zoekPartijMetId(PartijId);
    	Partij partijDatVerzend = userContextService.getAuthenticatedPersoon();
    	Vraag toegevoegdVraag = pajottersSessieService.VoegVraagToe("actief",partijDatVerzend, vraag.getTekst());
        System.out.println("DEBUG VraagGegevens Tekstst: " + vraag.getTekst() );
        return "redirect:/Pajotter/vraag.html?id=" + toegevoegdVraag.getId();
    }
    
 
}