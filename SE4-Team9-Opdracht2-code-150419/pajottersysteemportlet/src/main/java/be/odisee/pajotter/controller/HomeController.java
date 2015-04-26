package be.odisee.pajotter.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import be.odisee.pajotter.domain.Teler;
import be.odisee.pajotter.service.PajottersSessieService;

@Controller
@RequestMapping("VIEW")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
    @Autowired
    protected PajottersSessieService pajottersSessieService = null;

    @RenderMapping
    public String index(ModelMap model){
    	List<Teler> deLijst = pajottersSessieService.geefAlleTelers();
        model.addAttribute("telers", deLijst);
        return "/index";
    }
}
