package kr.co.myshop.controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.myshop.service.ProductService;
import kr.co.myshop.vo.BaesongVo;
import kr.co.myshop.vo.GumaeVo;

@Controller
public class ProductController {

	@Autowired
	@Qualifier("ps")
	private ProductService service;
	
	@RequestMapping("/product/product")
	public String product(Model model)
	{
		return service.product(model);
	}
	
	@RequestMapping("/product/getjung")
	public void getjung(HttpServletRequest request,PrintWriter out)
	{
		service.getJung(request,out);
	}
	
	@RequestMapping("/product/getso")
	public void getso(HttpServletRequest request,PrintWriter out)
	{
		service.getSo(request,out);
	}
	
	@RequestMapping("/product/getcode")
	public void getcode(HttpServletRequest request,PrintWriter out)
	{
		service.getCode(request,out);
	}
	
	@RequestMapping("/product/product_ok")
	public String product_ok(HttpServletRequest request) throws Exception
	{
		return service.product_ok(request);
	}
	
	@RequestMapping("/product/plist")
	public String plist(HttpServletRequest request, Model model)
	{
		return service.plist(request,model);
	}
	
	@RequestMapping("/product/pcontent")
	public String pcontent(HttpServletRequest request, Model model, HttpSession session)
	{
		return service.pcontent(request,model,session);
	}
	
	@RequestMapping("/product/wish_add")
	public void wish_add(HttpSession session, HttpServletRequest request, PrintWriter out) 
	{
		/*
	      if(session.getAttribute("userid")==null)
	    	return "redirect:/login/login";
	      else
	    	return service.wish_add(request,session);
	    */
		service.wish_add(request,session,out);
	}
	
	@RequestMapping("/product/cart_add")
	public void cart_add(HttpServletRequest request,HttpSession session,PrintWriter out)
	{
		service.cart_add(request,session,out);
	}
	
	@RequestMapping("/product/gumae")
	public String gumae(HttpServletRequest request, HttpSession session ,Model model)
	{
		return service.gumae(request,session,model);
	}
	
	@RequestMapping("/product/member_phone")
	public void member_phone(HttpServletRequest request,PrintWriter out,HttpSession session)
	{
		service.member_phone(request,out,session);
	}
	
	@RequestMapping("/product/baeview")
	public String baeview(HttpSession session, Model model)
	{
		return service.baeview(session,model);
	}
	
	@RequestMapping("/product/jusoadd")
	public String jusoadd()
	{
		return service.jusoadd();
	}
	
	@RequestMapping("/product/jusoadd_ok")
	public String jusoadd_ok(BaesongVo bvo,HttpSession session)
	{
		return service.jusoadd_ok(bvo,session);
	}
	
	@RequestMapping("/product/baeup")
	public String baeup(HttpServletRequest request,Model model)
	{
		return service.baeup(request,model);
	}
	
	@RequestMapping("/product/baeup_ok")
	public String baeup_ok(BaesongVo bvo,HttpSession session)
	{
		return service.baeup_ok(bvo,session);
	}
	
	@RequestMapping("/product/baedel")
	public String baedel(HttpServletRequest request,HttpSession session)
	{
		return service.baedel(request,session);
	}
	/*
	@RequestMapping("/product/chgcla")
	public String chgcla()  // 배송사항 변경창 띄우기
	{
		return service.chgcla();
	}
	*/
	@RequestMapping("/product/chgcla")
	public String chgcla(HttpServletRequest request,Model model)   
	{
		return service.chgcla(request,model);
	}
	
	@RequestMapping("/product/chg_ok") // 배송요청사항을 변경
	public void chg_ok(HttpServletRequest request,PrintWriter out)
	{
		service.chg_ok(request,out);
	}
	
	@RequestMapping("/product/gumae_ok")
	public String gumae_ok(int id,GumaeVo gvo,HttpSession session)
	{
		return service.gumae_ok(id, gvo,session);
	}
	
	/*  // 3개의 vo를 이용하여 jumun내용보기
	@RequestMapping("/product/jumun")
	public String jumun(HttpServletRequest request,Model model)
	{
		return service.jumun(request,model);
	}
	*/
	
	@RequestMapping("/product/jumun")
	public String jumun(HttpServletRequest request,Model model)
	{
		return service.jumun2(request,model);
	}
	
	
	// 임시
	@RequestMapping("/trtd")
	public String trtd(Model model)
	{
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0;i<24;i++)
		{
			list.add(i+"");
		}
		model.addAttribute("list",list);
		return "/trtd";
	}
}




