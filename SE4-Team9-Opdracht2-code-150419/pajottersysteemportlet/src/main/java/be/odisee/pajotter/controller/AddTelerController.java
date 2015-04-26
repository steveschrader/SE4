package be.odisee.pajotter.controller;

import javax.portlet.ActionResponse;
import javax.portlet.RenderResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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


@Controller(value = "addTelerController")
@RequestMapping(value = "VIEW")
@SessionAttributes("teler")
public class AddTelerController {

    @Autowired
    protected PajottersSessieService pajotterSessieService = null;

	@ModelAttribute("nieuweteler")
	public Teler getCommandObject() {
		return new Teler();
	}

	
	@RenderMapping(params = "myaction=addTelerForm")
	public String telerFormulier(RenderResponse response){
        return "/nieuweTeler";
    }
   

	@InitBinder
	public void initBinder(WebDataBinder binder) {
	}

	@ActionMapping(params = "myaction=addTeler")
    public void telerToevoegen(@ModelAttribute(value="nieuweteler") Teler teler, BindingResult result,
        SessionStatus status, ActionResponse response ){
		 Teler toegevoegdTeler = pajotterSessieService.voegTelerToe(teler.getVoornaam(),
                 													teler.getFamilienaam(),
                 													teler.getEmailadres(),
                 													teler.getPaswoord(),
                 													teler.getAdres(),
                 													teler.getTelefoon());
		response.setRenderParameter("myaction", "telerDetail");
        response.setRenderParameter("id", Integer.toString(toegevoegdTeler.getId()));
        status.setComplete();
    }
}