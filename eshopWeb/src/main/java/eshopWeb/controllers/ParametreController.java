package eshopWeb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/param")
public class ParametreController {

	@GetMapping("")
	public String demoParam(@RequestParam String prenom,
			@RequestParam(name = "age", required = false, defaultValue = "0") Integer age, Model model) {
		// System.out.println(prenom + " " + age);
		model.addAttribute("prenom", prenom);
		model.addAttribute("age", age);
		return "param";
	}
}
