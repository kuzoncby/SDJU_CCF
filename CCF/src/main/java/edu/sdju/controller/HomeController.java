package edu.sdju.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.sdju.file.ReadWriteCVS;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/")
	public ModelAndView getHome() {
		ModelAndView mv = new ModelAndView("index");
		ReadWriteCVS cvs = new ReadWriteCVS();
		String result = cvs.run();
		logger.info(result);
		mv.addObject("message", result);
		return mv;
	}

}
