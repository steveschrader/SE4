package be.odisee.pajotter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

	@Controller
	@RequestMapping("/")
	public class HomeController {
	
	@RequestMapping(method = RequestMethod.GET)
	  public String home(Model model) {
	    return "home";
	  }
	
	@RequestMapping(value={"/jquery.js"},method=RequestMethod.GET)
	public String geefjQuery() {
		return "/js/jquery-2.1.3.min.js";
	}
	
	@RequestMapping(value={"/opmaak.css"},method=RequestMethod.GET)
	public String geefCss() {
		return "/css/Opmaak.css";
	}

}