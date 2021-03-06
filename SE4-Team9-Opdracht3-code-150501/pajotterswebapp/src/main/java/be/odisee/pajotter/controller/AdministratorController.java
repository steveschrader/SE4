package be.odisee.pajotter.controller;

import be.odisee.pajotter.domain.*;
import be.odisee.pajotter.service.PajottersSessieService;
import be.odisee.pajotter.utilities.RolNotFoundException;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Administrator")
public class AdministratorController {
	
	@Autowired
    protected PajottersSessieService pajottersSessieService = null;
	
	@RequestMapping(value = {"/jquery.js","/jquery"}, method = RequestMethod.GET)
    public String jquery(ModelMap model) {
    	return "js/jquery-2.1.3.min.js";
    }
    @RequestMapping(value = {"/opmaak.css","/opmaak"}, method = RequestMethod.GET)
    public String opmaak(ModelMap model) {
    	return "css/Opmaak.css";
    }
	
    //Lijst van alle partijen, meteen op het hoofdsherm
    @RequestMapping(value = {"/home.html", "/home", "/index.html", "/index", "/lijst.html", "/lijst"}, method = RequestMethod.GET)
    //@PostAuthorize("#model.get('rol').partij.emailadres == authentication.principal.username")
    public String index(/*@RequestParam("rolid") int id,*/ ModelMap model) {
    	//Rol rolAuth = pajottersSessieService.zoekRolMetId(id);
    	//model.addAttribute("rol", rolAuth);
        List<Partij> partijlijst = pajottersSessieService.geefAllePartijen();
        model.addAttribute("partijen", partijlijst);
        return "/Administrator/index";
    }
    
    //Geef details van de geselecteerde partij op basis van zijn id
    @RequestMapping(value = {"/partij.html", "/partij"}, method = RequestMethod.GET)
    public String partijDetail(@RequestParam("id") int id, ModelMap model) {
    	Partij partij = pajottersSessieService.zoekPartijMetId(id);
    	Rol rol = pajottersSessieService.zoekRolMetId(id);
        model.addAttribute("partij", partij);
        model.addAttribute("rol", rol);
        return "/Administrator/partij";
    }
    
    //Om een partij toe te voegen roepen we de juiste jsp op met een lege partij en rol
    @RequestMapping(value = {"/nieuwePartij.html", "/nieuwePartij"}, method = RequestMethod.GET)
    public String partijFormulier(ModelMap model) {
    	String rolnaam = new String();
        Partij partij = new Partij();
        PartijWrapperVoorForm partijwrapper = new PartijWrapperVoorForm(partij, rolnaam);
        model.addAttribute("departij", partijwrapper);
        return "/Administrator/nieuwePartij";
    }
    
    //Om een nieuwe partij te maken, de ingevulde partij krijgen we binnen en persisteren 
    @RequestMapping(value = {"/nieuwePartij.html", "/nieuwePartij"}, method = RequestMethod.POST)
    public String partijToevoegen(@ModelAttribute("departij") @Valid PartijWrapperVoorForm partij, BindingResult result, ModelMap model) {
    	if (result.hasErrors()) return "/Administrator/nieuwePartij";
        
		try {
			Partij toegevoegdPartij = pajottersSessieService.voegPartijToe(partij.getPartij());
			Rol nieuweRol = pajottersSessieService.voegRolToe(partij.getRol(), toegevoegdPartij.getId(), partij.getPartij().getEmailadres());
			System.out.println("DEBUG Partij toegevoegd met familienaam: " + partij.getPartij().getFamilienaam() + " rol:" + partij.getRol());
	        return "redirect:/Administrator/partij.html?id=" + toegevoegdPartij.getId();
		}
		catch (RolNotFoundException e) {
			System.out.println("Probleem bij het toevoegen van een partij!!!");
		}
		List<Partij> deLijst = pajottersSessieService.geefAllePartijen();
        model.addAttribute("partijen", deLijst);
        return "redirect:/Administrator/index";
    }
    
    //Om de partij te verwijderen
    @RequestMapping(value = {"/verwijderPartij.html", "/verwijderPartij"}, method = RequestMethod.GET)
    public String partijDelete(@RequestParam("id") int id, ModelMap model) {
        //pajottersSessieService.verwijderRol(id);
    	pajottersSessieService.verwijderPartij(id);
        List<Partij> deLijst = pajottersSessieService.geefAllePartijen();
        model.addAttribute("partijen", deLijst);
        return "/Administrator/index";
    }
    
    //Om de partij up te daten
    @RequestMapping(value = {"/updatePartij.html", "/updatePartij", "/editPartij.html", "/editPartij"}, method = RequestMethod.POST)
    public String telerUpdate(@ModelAttribute("departij") @Valid Partij partij, BindingResult result, ModelMap model, @RequestParam String rol) {
    	if (result.hasErrors()) return "/Administrator/editPartij"; 
    	
    	pajottersSessieService.verwijderRol(partij.getId());
    	pajottersSessieService.updatePartij(partij);
    	
    	try {
			pajottersSessieService.voegRolToe(rol, partij.getId(), partij.getEmailadres());
		}
    	catch (RolNotFoundException e) {
			e.printStackTrace();
		}
    	
    	Rol rol1 = pajottersSessieService.zoekRolMetId(partij.getId());
        model.addAttribute("partij", partij);
        model.addAttribute("rol", rol1);

        return "/Administrator/partij";
    }
    
    //Om naar de update pagina te gaan en de partij info mee te geven
    @RequestMapping(value = {"/updatePartij.html", "/updatePartij", "/editPartij", "/editPartij.html"}, method = RequestMethod.GET)
    public String telerEditpagina(@RequestParam("id") int id, ModelMap model){
    	Partij partij = pajottersSessieService.zoekPartijMetId(id);
    	Rol rol = pajottersSessieService.zoekRolMetId(id);
        model.addAttribute("departij", partij);
        model.addAttribute("rol", rol);
        return "/Administrator/editPartij";
    }
}
