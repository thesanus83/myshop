package kr.co.myshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.myshop.service.CustomService;
import kr.co.myshop.vo.MtmVo;

@Controller
public class CustomController {

	@Autowired
	@Qualifier("cs")
	private CustomService service;
	
	
	@RequestMapping("/custom/mtm")
	public String mtm()
	{
		return "/custom/mtm";
	}
	
	@RequestMapping("/custom/mtm_ok")
	public String mtm_ok(MtmVo mvo)
	{
		return service.mtm_ok(mvo);
	}
}










