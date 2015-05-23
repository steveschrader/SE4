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
//@RequestMapping("/Partij")
public class AdministratorController {
	
	@Autowired
    protected PajottersSessieService pajottersSessieService = null;
	
    //lijst van alle partijen
    @RequestMapping(value={"/Administrator/home.html","/Administrator/index.html","/Administrator/lijst.html"}, method = RequestMethod.GET)
    public String index(ModelMap model){
        List<Partij> deLijst = pajottersSessieService.geefAllePartijen();
        model.addAttribute("partijen", deLijst);
        return "/Administrator/index";
    }
    
    //details van de partij
    @RequestMapping(value={"/Administrator/partij.html"}, method = RequestMethod.GET)
    public String partijDetail(@RequestParam("id") Integer id, ModelMap model) {
    	Partij partij = pajottersSessieService.zoekPartijMetId(id);
    	Rol rol = pajottersSessieService.zoekRolMetId(id);
        model.addAttribute("partij", partij);
        model.addAttribute("rol", rol);
        return "/Administrator/partij";
    }
    
    //om een teler toe te voegen
    @RequestMapping(value={"/Administrator/nieuwePartij.html"}, method = RequestMethod.GET)
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
        return "/Administrator/nieuwePartij";
    }
    
    //om de teler te verwijderen
    @RequestMapping(value={"/Administrator/verwijderPartij.html"}, method = RequestMethod.GET)
    public String partijDelete(@RequestParam("id") Integer id, ModelMap model){
        pajottersSessieService.verwijderPartij(id);
        List<Partij> deLijst = pajottersSessieService.geefAllePartijen();
        model.addAttribute("partijen", deLijst);
        return "/Administrator/index";
    }
    
    //om de teler up te daten
    @RequestMapping(value={"/Administrator/updatePartij.html"}, method = RequestMethod.POST)
    public String telerUpdate(@ModelAttribute("departij") @Valid Partij partij, BindingResult result, ModelMap model, @RequestParam String rol){
    	if (result.hasErrors()) return "/editPartij"; 
    	pajottersSessieService.verwijderRol(partij.getId());
    	pajottersSessieService.updatePartij(partij);
    	try {
			pajottersSessieService.voegRolToe(rol, partij.getId(), partij.getEmailadres());
		}
    	catch (RolNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	Rol rol1 = pajottersSessieService.zoekRolMetId(partij.getId());
        model.addAttribute("partij", partij);
        model.addAttribute("rol", rol1);

        return "/Administrator/partij";
    }
    
    //om naar de update pagina te gaan en de teler info mee te geven
    @RequestMapping(value={"/Administrator/updatePartij.html"}, method = RequestMethod.GET)
    public String telerEditpagina(@RequestParam("id") Integer id, ModelMap model){
    	Partij partij = pajottersSessieService.zoekPartijMetId(id);
    	Rol rol = pajottersSessieService.zoekRolMetId(id);
        model.addAttribute("departij", partij);
        model.addAttribute("rol", rol);
        return "/Administrator/editPartij";
    }
    
    // nieuwe teler te maken
    @RequestMapping(value={"/Administrator/nieuwePartij.html"}, method = RequestMethod.POST)
    public String partijToevoegen(@ModelAttribute("departij") @Valid Partij partij, BindingResult result, ModelMap model, @RequestParam String rol){
    	if (result.hasErrors()) return "/Administrator/nieuwePartij"; 
    	//Partij toegevoegdPartij = pajottersSessieService.voegPartijToe(partij.getVoornaam(), partij.getFamilienaam(), partij.getEmailadres(), partij.getPaswoord());
    	//Rol toegevoegdRol = pajottersSessieService.voegRolToe()
    	Partij toegevoegdPartij = null;
        
		try {
			toegevoegdPartij = pajottersSessieService.voegPartijToe(partij.getVoornaam(), partij.getFamilienaam(), partij.getEmailadres(), partij.getPaswoord());
			Rol nieuweRol = pajottersSessieService.voegRolToe(rol, toegevoegdPartij.getId(), partij.getEmailadres());
			//pajottersSessieService.voegRolToe("pajotter", toegevoegdPartij.getId(), partij.getEmailadres());
		}
		catch (RolNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("probleem hier!!!");
		}
        System.out.println("DEBUG partijgegevens familienaam: " + partij.getFamilienaam() +" rol:"+ rol);
        return "redirect:/Administrator/partij.html?id=" + toegevoegdPartij.getId();
    }
}