package be.odisee.pajotter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import be.odisee.pajotter.domain.Teler;
import be.odisee.pajotter.service.PajottersSessieService;

@Controller (value="detailController")
@RequestMapping("VIEW")
public class DetailController {
	
    @Autowired
    protected PajottersSessieService pajottersSessieService = null;

	@RenderMapping(params = "myaction=telerDetail")
    public String persoonDetail(@RequestParam("id") Integer id, ModelMap model){
        Teler teler = pajottersSessieService.zoekTelerMetId(id);
        model.addAttribute("teler", teler);
        return "/teler";
    }	
}
