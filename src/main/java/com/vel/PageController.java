package com.vel;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vel.model.StatusUpdate;
import com.vel.service.StatusUpdateService;

@Controller
public class PageController {
	
	@Autowired
	private StatusUpdateService statusUpdateService;

	@RequestMapping("/")
	String home() {
		return "app.addStatus";
	}
	
	@RequestMapping("/about")
	String about() {
		return "app.about";
	}
	
	
	@RequestMapping(value="/addStatus",method=RequestMethod.GET)
	ModelAndView addStatus(ModelAndView modelAndView) {
		modelAndView.setViewName("app.addStatus");
		
		StatusUpdate statusUpdate = new StatusUpdate();
		StatusUpdate latestStatus = statusUpdateService.getLatest();
		modelAndView.getModel().put("statusUpdate", statusUpdate);
		modelAndView.getModel().put("latestStatus", latestStatus);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/addStatus",method=RequestMethod.POST)
	ModelAndView addStatus(ModelAndView modelAndView,StatusUpdate statusUpdate) {
		modelAndView.setViewName("app.addStatus");
		statusUpdateService.save(statusUpdate);
		StatusUpdate latestStatus = statusUpdateService.getLatest();
		modelAndView.getModel().put("latestStatus", latestStatus);
		
		return modelAndView;
	}

}
