package be.odisee.pajotter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import be.odisee.pajotter.domain.Teler;
import be.odisee.pajotter.service.PajottersSessieService;


@Controller (value="updatepageController")
@RequestMapping("VIEW")
public class UpdatePageTelerController {

	@Autowired
    protected PajottersSessieService pajottersSessieService=null; // ready for dependency injection
	
	@RenderMapping(params = "myaction=telerUpdatePage")
    public String telerEditpagina(@RequestParam("id") Integer id, ModelMap model){
    	Teler teler = pajottersSessieService.zoekTelerMetId(id);
        model.addAttribute("teler", teler);
        return "/editTeler";
    }
	
}
