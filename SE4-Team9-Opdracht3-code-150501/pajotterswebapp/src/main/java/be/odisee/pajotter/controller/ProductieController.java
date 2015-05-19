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
public class ProductieController {
	@Autowired
    protected PajottersSessieService pajottersSessieService = null;
	
    //lijst van alle productie
    @RequestMapping(value={"/productieLijst.html"}, method = RequestMethod.GET)
    public String index(ModelMap model){
        List<Productie> deLijst = pajottersSessieService.geefAlleProductie();
        model.addAttribute("productie", deLijst);
        return "/productieLijst";
    }
    
    //details van de producite
    @RequestMapping(value={"/productie.html"}, method = RequestMethod.GET)
    public String productieDetail(@RequestParam("id") Integer id, ModelMap model) {
        Productie productie = pajottersSessieService.zoekProductieMetId(id);
        model.addAttribute("productie", productie);
        return "/productie";
    }
    
    //om een productie toe te voegen
    @RequestMapping(value={"/nieuweProductie.html"}, method = RequestMethod.GET)
    public String productieFormulier(ModelMap model) {
        Productie productie = new Productie();
        model.addAttribute("deproductie", productie);
        return "/nieuweProductie";
    }
    
    //om de productie te verwijderen
    @RequestMapping(value={"/verwijderProductie.html"}, method = RequestMethod.GET)
    public String productieDelete(@RequestParam("id") Integer id, ModelMap model) {
        pajottersSessieService.verwijderProductie(id);
        List<Productie> deLijst = pajottersSessieService.geefAlleProductie();
        model.addAttribute("productie", deLijst);
        return "/productieLijst";
    }
    
    //om de productie up te daten
    @RequestMapping(value={"/updateProductie.html"}, method = RequestMethod.POST)
    public String productieUpdate(@ModelAttribute("deproductie") @Valid Productie productie, BindingResult result, ModelMap model){
    	pajottersSessieService.updateProductie(productie);
        model.addAttribute("productie", productie);
        return "/productie";
    }
    
    //om naar de update pagina te gaan en de productie info mee te geven
    @RequestMapping(value={"/updateProductie.html"}, method = RequestMethod.GET)
    public String telerEditpagina(@RequestParam("id") Integer id, ModelMap model) {
    	Productie productie = pajottersSessieService.zoekProductieMetId(id);
        model.addAttribute("deproductie", productie);
        return "/editProductie";
    }
    
    //nieuwe productie te maken
    @RequestMapping(value={"/nieuweProductie.html"}, method = RequestMethod.POST)
    public String producteiToevoegen(@ModelAttribute("deproductie") @Valid Productie productie, BindingResult result, ModelMap model, @RequestParam int PartijId){
    	if (result.hasErrors()) return "/nieuweProductie"; 
    	Partij partijDatVerzend = pajottersSessieService.zoekPartijMetId(PartijId);
    	Productie toegevoegdProductie = pajottersSessieService.VoegProductieToe("actief",partijDatVerzend, productie.getTekst(), productie.getAantal());
        System.out.println("DEBUG ProductieGegevens Tekstst: " + productie.getTekst() );
        return "redirect:productie.html?id=" + toegevoegdProductie.getId();
    }
}