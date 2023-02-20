package kr.co.myshop.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.co.myshop.mapper.AdminMapper;

@Service
@Qualifier("as")
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminMapper mapper;

	@Override
	public String admingumae(Model model) {
		ArrayList<HashMap<String,String>> glist=mapper.admingumae();
		model.addAttribute("glist",glist);
		return "/admin/admingumae";
	}

	@Override
	public String chgstate(HttpServletRequest request) {
		String id=request.getParameter("id");
		String state=request.getParameter("state");
		
		mapper.chgstate(state,id);
		return "redirect:/admin/admingumae";
	}
	
	
	
}







