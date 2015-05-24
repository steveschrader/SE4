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
@RequestMapping("/Teler")
public class TelerController {
	
	@Autowired
    protected PajottersSessieService pajottersSessieService = null;
	@Autowired
	protected UserContextService userContextService = null;
	
	@RequestMapping(value={"/index.html"}, method = RequestMethod.GET)
    public String Keuze(ModelMap model){
		Partij partij = userContextService.getAuthenticatedPersoon();
        List<Productie> deLijst = pajottersSessieService.geefAlleProductie(partij.getId());
        model.addAttribute("productie", deLijst);
        return "/Teler/index";
    }
    //lijst van alle productie
    @RequestMapping(value={"/productieLijst.html"}, method = RequestMethod.GET)
    public String indexProductie(ModelMap model){
		Partij partij = userContextService.getAuthenticatedPersoon();
        List<Productie> deLijst = pajottersSessieService.geefAlleProductie(partij.getId());
        model.addAttribute("productie", deLijst);
        return "/Teler/productieLijst";
    }
    
    //details van de producite
    @RequestMapping(value={"/productie.html"}, method = RequestMethod.GET)
    public String productieDetail(@RequestParam("id") Integer id, ModelMap model) {
        Productie productie = pajottersSessieService.zoekProductieMetId(id);
        model.addAttribute("productie", productie);
        return "/Teler/productie";
    }
    
    //om een productie toe te voegen
    @RequestMapping(value={"/nieuweProductie.html"}, method = RequestMethod.GET)
    public String productieFormulier(ModelMap model) {
        Productie productie = new Productie();
        model.addAttribute("deproductie", productie);
        return "/Teler/nieuweProductie";
    }
    
    //om de productie te verwijderen
    @RequestMapping(value={"/verwijderProductie.html"}, method = RequestMethod.GET)
    public String productieDelete(@RequestParam("id") Integer id, ModelMap model) {
        pajottersSessieService.verwijderProductie(id);
		Partij partij = userContextService.getAuthenticatedPersoon();
        List<Productie> deLijst = pajottersSessieService.geefAlleProductie(partij.getId());
        model.addAttribute("productie", deLijst);
        return "/Teler/productieLijst";
    }
    
    //om de productie up te daten
    @RequestMapping(value={"/updateProductie.html"}, method = RequestMethod.POST)
    public String productieUpdate(@ModelAttribute("deproductie") @Valid Productie productie, BindingResult result, ModelMap model){
    	pajottersSessieService.updateProductie(productie);
        model.addAttribute("productie", productie);
        return "/Teler/productie";
    }
    
    //om naar de update pagina te gaan en de productie info mee te geven
    @RequestMapping(value={"/updateProductie.html"}, method = RequestMethod.GET)
    public String telerEditpagina(@RequestParam("id") Integer id, ModelMap model) {
    	Productie productie = pajottersSessieService.zoekProductieMetId(id);
        model.addAttribute("deproductie", productie);
        return "/Teler/editProductie";
    }
    
    //nieuwe productie te maken
    @RequestMapping(value={"/nieuweProductie.html"}, method = RequestMethod.POST)
    public String producteiToevoegen(@ModelAttribute("deproductie") @Valid Productie productie, BindingResult result, ModelMap model, @RequestParam int PartijId){
    	if (result.hasErrors()) return "/Teler/nieuweProductie"; 
    	Partij partijDatVerzend = pajottersSessieService.zoekPartijMetId(PartijId);
    	Productie toegevoegdProductie = pajottersSessieService.VoegProductieToe("actief",partijDatVerzend, productie.getTekst(), productie.getAantal());
        System.out.println("DEBUG ProductieGegevens Tekstst: " + productie.getTekst() );
        return "redirect:/Teler/productie.html?id=" + toegevoegdProductie.getId();
    }
    
    //---------------------------------------------BESTELLING-----------------------------------------------------------------
    
    //lijst van alle bestelling
    @RequestMapping(value={"/bestellingLijst.html"}, method = RequestMethod.GET)
    public String indexBestelling(ModelMap model){
    	Partij partij = userContextService.getAuthenticatedPersoon();
        List<Bestelling> deLijst = pajottersSessieService.geefAlleBestellingen(partij.getId(), "partij_id");
        model.addAttribute("bestelling", deLijst);
        return "/Teler/bestellingLijst";
    }
    
    //details van de producite
    @RequestMapping(value={"/bestelling.html"}, method = RequestMethod.GET)
    public String bestellingDetail(@RequestParam("id") Integer id, ModelMap model) {
        Bestelling bestelling = pajottersSessieService.zoekBestellingMetId(id);
        model.addAttribute("bestelling", bestelling);
        return "/Teler/bestelling";
    }
    
    //om een bestelling toe te voegen
    @RequestMapping(value={"/nieuweBestelling.html"}, method = RequestMethod.GET)
    public String bestellingFormulier(ModelMap model) {
        Bestelling bestelling = new Bestelling();
        model.addAttribute("debestelling", bestelling);
        return "/Teler/nieuweBestelling";
    }
    
    //om de bestelling te verwijderen
    @RequestMapping(value={"/verwijderBestelling.html"}, method = RequestMethod.GET)
    public String bestellingDelete(@RequestParam("id") Integer id, ModelMap model) {
        pajottersSessieService.verwijderBestelling(id);
    	Partij partij = userContextService.getAuthenticatedPersoon();
        List<Bestelling> deLijst = pajottersSessieService.geefAlleBestellingen(partij.getId(), "partij_id");
        model.addAttribute("bestelling", deLijst);
        return "/Teler/bestellingLijst";
    }
    
    //om de bestelling up te daten
    @RequestMapping(value={"/updateBestelling.html"}, method = RequestMethod.POST)
    public String bestellingUpdate(@ModelAttribute("debestelling") @Valid Bestelling bestelling, BindingResult result, ModelMap model){
    	pajottersSessieService.updateBestelling(bestelling);
        model.addAttribute("bestelling", bestelling);
        return "/Teler/bestelling";
    }
    
    //om naar de update pagina te gaan en de bestelling info mee te geven
    @RequestMapping(value={"/updateBestelling.html"}, method = RequestMethod.GET)
    public String bestellingEditpagina(@RequestParam("id") Integer id, ModelMap model) {
    	Bestelling bestelling = pajottersSessieService.zoekBestellingMetId(id);
        model.addAttribute("debestelling", bestelling);
        return "/Teler/editBestelling";
    }
    
    //nieuwe bestelling te maken
    @RequestMapping(value={"/nieuweBestelling.html"}, method = RequestMethod.POST)
    public String producteiToevoegen(@ModelAttribute("debestelling") @Valid Bestelling bestelling, BindingResult result, ModelMap model, @RequestParam int PartijId){
    	if (result.hasErrors()) return "/Teler/nieuweBestelling"; 
    	//Partij partijDatVerzend = pajottersSessieService.zoekPartijMetId(PartijId);
    	Partij partijDatVerzend = userContextService.getAuthenticatedPersoon();
    	Bestelling toegevoegdBestelling = pajottersSessieService.VoegBestellingToe("actief",partijDatVerzend, bestelling.getTekst(), bestelling.getAantal(), bestelling.getLeverancierId());
        System.out.println("DEBUG BestellingGegevens Tekstst: " + bestelling.getTekst() );
        return "redirect:/Teler/bestelling.html?id=" + toegevoegdBestelling.getId();
    }
}