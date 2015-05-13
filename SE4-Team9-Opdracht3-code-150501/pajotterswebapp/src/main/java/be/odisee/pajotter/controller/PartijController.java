package be.odisee.pajotter.controller;


import be.odisee.pajotter.domain.*;
//import be.odisee.pajotter.domain.Teler;
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
public class PartijController {
	@Autowired
    protected PajottersSessieService pajottersSessieService=null; // ready for dependency injection
    //lijst van alle partijen
    @RequestMapping(value={"/home.html","/index.html","/lijst.html"}, method = RequestMethod.GET)
    public String index(ModelMap model){
        List<Partij> deLijst = pajottersSessieService.geefAllePartijen();
        model.addAttribute("partijen", deLijst);
        return "/index";
    }
    // details van de partijen

    @RequestMapping(value={"/partij.html"}, method = RequestMethod.GET)
    public String partijDetail(@RequestParam("id") Integer id, ModelMap model){
        Partij partij = pajottersSessieService.zoekPartijMetId(id);
        //Dit om te proberen alle rollen dat een partij heeft te tonen
       //List<Rol> derol = pajottersSessieService.geefAlleRollen(1);
       // model.addAttribute("rollen", derol);
        //
        
        model.addAttribute("partij", partij);
        
        return "/partij";
    }
    // om een teler toe te voegen
    
    @RequestMapping(value={"/nieuwePartij.html"},method=RequestMethod.GET)
    public String partijFormulier(ModelMap model){
    	Rol rol = new Rol() {
			
			@Override
			public String getType() {
				// TODO Auto-generated method stub
				return null;
			}
		};
        Partij partij = new Partij();
        model.addAttribute("departij", partij);
        model.addAttribute("derol", rol);
        return "/nieuwePartij";
    }
    
    //om de teler te verwijderen
    @RequestMapping(value={"/verwijderPartij.html"},method=RequestMethod.GET)
    public String partijDelete(@RequestParam("id") Integer id, ModelMap model){
        pajottersSessieService.verwijderPartij(id);
        List<Partij> deLijst = pajottersSessieService.geefAllePartijen();
        model.addAttribute("partijen", deLijst);
        return "/index";
    }
    //om de teler up te daten
    @RequestMapping(value={"/updatePartij.html"},method=RequestMethod.POST)
    public String telerUpdate(@ModelAttribute("departij") @Valid Partij partij, BindingResult result, ModelMap model){
    	if (result.hasErrors()) return "/editPartij"; 
    	pajottersSessieService.updatePartij(partij);
        model.addAttribute("partij", partij);
        return "/partij";
    }
    //om naar de update pagina te gaan en de teler info mee te geven
    @RequestMapping(value={"/updatePartij.html"},method=RequestMethod.GET)
    public String telerEditpagina(@RequestParam("id") Integer id, ModelMap model){
    	Partij partij = pajottersSessieService.zoekPartijMetId(id);
        model.addAttribute("departij", partij);
        return "/editPartij";
    }
    
    // nieuwe teler te maken

    @RequestMapping(value={"/nieuwePartij.html"},method=RequestMethod.POST)
    public String partijToevoegen(@ModelAttribute("departij") @Valid Partij partij, 
            BindingResult result, ModelMap model, @RequestParam String rol){
    	if (result.hasErrors()) return "/nieuwePartij"; 
        //Partij toegevoegdPartij = pajottersSessieService.voegPartijToe(partij.getVoornaam(), partij.getFamilienaam(), partij.getEmailadres(), partij.getPaswoord());
       // Rol toegevoegdRol = pajottersSessieService.voegRolToe()
    	Partij toegevoegdPartij = null;
        
		try {
			toegevoegdPartij = pajottersSessieService.voegPartijToe(partij.getVoornaam(), partij.getFamilienaam(), partij.getEmailadres(), partij.getPaswoord());
			Rol nieuweRol = pajottersSessieService.voegRolToe(rol, toegevoegdPartij.getId(), partij.getEmailadres());
			//pajottersSessieService.voegRolToe("pajotter", toegevoegdPartij.getId(), partij.getEmailadres());
		} catch (RolNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("probleem hier!!!");
		}
        System.out.println("DEBUG partijgegevens familienaam: " + partij.getFamilienaam() +" rol:"+ rol);
        return "redirect:partij.html?id=" + toegevoegdPartij.getId();
    }
    

}
