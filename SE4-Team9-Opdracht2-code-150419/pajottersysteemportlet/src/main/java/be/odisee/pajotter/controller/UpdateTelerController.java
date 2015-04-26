package be.odisee.pajotter.controller;

import javax.portlet.ActionResponse;
import javax.portlet.RenderResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import be.odisee.pajotter.domain.Teler;
import be.odisee.pajotter.service.PajottersSessieService;


@Controller (value="updateController")
@RequestMapping("VIEW")
//@SessionAttributes("teler")
public class UpdateTelerController {

	@Autowired
    protected PajottersSessieService pajottersSessieService = null;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	}
	
	@ActionMapping(params = "myaction=telerUpdate")
	public void telerUpdate(@ModelAttribute(value="teler") Teler teler, ModelMap model, SessionStatus status, ActionResponse response){
    	pajottersSessieService.updateTeler(teler);
        model.addAttribute("teler", teler);
        response.setRenderParameter("id", Integer.toString(teler.getId()));
        response.setRenderParameter("myaction", "telerDetail");
    }
}
