package co.wideo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import co.wideo.demo.model.WideoListVO;
import co.wideo.demo.model.WideoVO;
import co.wideo.demo.service.WideoManager;

@Controller
@RequestMapping("/wideo-module")
@EnableWebMvc
public class WideoController 
{
	@Autowired
	WideoManager manager;

	@RequestMapping(value = "/getAllWideos", method = RequestMethod.GET)
	public String getAllWideos(Model model)
	{
		model.addAttribute("wideos", manager.getAllWideos());
		return "wideosListDisplay";
	}

	
    @RequestMapping(value = "/saveWideo", method = RequestMethod.GET)
    public String saveWideo(@ModelAttribute("wideo") WideoVO wideo, ModelMap model) {
        model.addAttribute("name", wideo.getName());
        model.addAttribute("json", wideo.getJson());
		return "saveWideo";
    }
     
    @RequestMapping(value = "/saveWideo", method = RequestMethod.POST)
    public String processWideo(@ModelAttribute("wideo") WideoVO wideo, ModelMap model) {
        manager.saveWideo(wideo);
        return "saveSuccess";
    }
    
    @RequestMapping(value = "/getAllJsonWideos", produces="application/json", method = RequestMethod.GET)
    @ResponseBody
    public WideoListVO getWideosInJsonFormat(Model model) {
    	WideoListVO resultList = new WideoListVO(manager.getAllWideos());
        return resultList;
    }
}