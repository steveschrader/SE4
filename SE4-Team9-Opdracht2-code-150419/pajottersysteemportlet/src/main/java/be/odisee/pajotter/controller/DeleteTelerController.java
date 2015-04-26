package be.odisee.pajotter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import be.odisee.pajotter.domain.Teler;
import be.odisee.pajotter.service.PajottersSessieService;


@Controller (value="deleteController")
@RequestMapping("VIEW")
public class DeleteTelerController {
	 	@Autowired
	    protected PajottersSessieService pajottersSessieService = null;
	 	
	 	@RenderMapping(params = "myaction=telerDelete")
	    public String persoonDetail(@RequestParam("id") Integer id, ModelMap model){
	 	 	pajottersSessieService.verwijderTeler(id);
	        List<Teler> deLijst = pajottersSessieService.geefAlleTelers();
	        model.addAttribute("telers", deLijst);
	        return "/index";
	        
	 	}
}
