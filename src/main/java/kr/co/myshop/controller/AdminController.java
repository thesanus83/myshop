package kr.co.myshop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.myshop.service.AdminService;

@Controller
public class AdminController {
     
	@Autowired
	@Qualifier("as")
	private AdminService service;
	
	@RequestMapping("/admin/adminmain")
	public String main()
	{
		return "/admin/adminmain";
	}
	
	@RequestMapping("/admin/admingumae")
	public String admingumae(Model model)
	{
		return service.admingumae(model);
	}
	
	@RequestMapping("/admin/chgstate")
	public String chgstate(HttpServletRequest request)
	{
		return service.chgstate(request);
	}
	
	
	
	
	
	
	
	
}
