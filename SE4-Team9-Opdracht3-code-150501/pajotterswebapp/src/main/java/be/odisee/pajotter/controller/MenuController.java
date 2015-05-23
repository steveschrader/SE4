package be.odisee.pajotter.controller;

import be.odisee.pajotter.domain.Partij;
import be.odisee.pajotter.domain.Rol;
import be.odisee.pajotter.*;
import be.odisee.pajotter.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MenuController {

    @Autowired
    protected PajottersSessieService PajottersSessieService = null; // ready for dependency injection
    
    @Autowired
    protected UserContextService userContextService = null;

    @RequestMapping(value = {"/login","/login.html"}, method = RequestMethod.GET)
    public String login(ModelMap model){
    	System.out.println("NAAR DE LOGIN");
    	return "/login";
    }
    // je zal naar login.jsp gaan

    @RequestMapping(value={"/logout","/logoutSuccess.html"}, method = RequestMethod.GET)
    public String logout(ModelMap model){
    	return "/logoutSuccess";
    }
    // je zal naar logoutSuccess.jsp gaan

    @RequestMapping(value={"/accessDenied","/accessDenied.html"}, method = RequestMethod.GET)
    public String accessDenied(ModelMap model){
    	return "/accessDenied";
    }
    // je zal naar accessDenied.jsp gaan

    @RequestMapping(value={"/jquery.js","/jquery"}, method = RequestMethod.GET)
    public String jquery(ModelMap model){
    	return "js/jquery-2.1.3.min.js";
    }
    @RequestMapping(value={"/opmaak.css","/opmaak"}, method = RequestMethod.GET)
    public String opmaak(ModelMap model){
    	return "css/Opmaak.css";
    }
    
    @RequestMapping(value={"/","/menu.html","/index.html"}, method = RequestMethod.GET)
    @PostAuthorize("#model.get('rol').partij.emailadres == authentication.principal.username")
    public String menu(ModelMap model){
        Partij dePartij = userContextService.getAuthenticatedPersoon();
        model.addAttribute("partij", dePartij);
        //return "/menu";
        Rol deRol = PajottersSessieService.zoekRolMetId(dePartij.getId());
        model.addAttribute("rol",deRol);
        if (deRol.getType().equals("Administrator"))
        	return "redirect:/Administrator/index.html?rolid=" + deRol.getId();
        else if (deRol.getType().equals("Koper"))
        	return "redirect:/Koper/index.html?rolid=" + deRol.getId();
        else if (deRol.getType().equals("Teler"))
        	return "redirect:/Teler/index.html?rolid=" + deRol.getId();
        else if (deRol.getType().equals("Leverancier"))
        	return "redirect:/Leverancier/index.html?rolid=" + deRol.getId();
        else if (deRol.getType().equals("Industrie"))
        	return "redirect:/Industrie/index.html?rolid=" + deRol.getId();
        else if (deRol.getType().equals("Pajotter"))
        	return "redirect:/Pajotter/index.html?rolid=" + deRol.getId();
        return "opmaak.css";
    }

    //Deze methode wordt dus nooit gebruikt omdat elke partij maar één rol kan hebben tot nu toe
    @RequestMapping(value={"/rol.html"},method=RequestMethod.GET)
    @PostAuthorize("#model.get('rol').partij.emailadres == authentication.principal.username")
    public String indexVoorRol(@RequestParam("id") Integer id, ModelMap model){
        Rol deRol = PajottersSessieService.zoekRolMetId(id);
        model.addAttribute("rol",deRol);
        if (deRol.getType().equals("Administrator")) return "redirect:/Administrator/index.html?rolid="+deRol.getId();
        else if (deRol.getType().equals("Koper")) return "redirect:/koper/index.html?rolid="+deRol.getId();
        else if (deRol.getType().equals("Teler")) return "redirect:/teler/index.html?rolid="+deRol.getId();
        else if (deRol.getType().equals("Leverancier")) return "redirect:/Leverancier/aanbiedingLijst.html?rolid="+deRol.getId();
        return "redirect:/accessDenied.html"+deRol.getId(); // voor de andere rollen
    }
    // je zal gaan naar de pagina conform uw rol
}
