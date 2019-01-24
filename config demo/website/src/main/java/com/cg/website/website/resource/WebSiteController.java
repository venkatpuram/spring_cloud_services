package com.cg.website.website.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@RefreshScope
@Controller
public class WebSiteController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/hello")
	public String display(Model model) {
		ResponseEntity<String> entity = restTemplate.getForEntity("http://helloworld/hello", String.class);
		String hello = entity.getBody();
		model.addAttribute("hello", hello);
		return "hello";
	}
}
