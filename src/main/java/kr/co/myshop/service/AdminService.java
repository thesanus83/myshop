package kr.co.myshop.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface AdminService {
    public String admingumae(Model model);
    public String chgstate(HttpServletRequest request);
}
