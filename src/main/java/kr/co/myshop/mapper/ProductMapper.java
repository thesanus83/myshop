package kr.co.myshop.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.myshop.vo.BaesongVo;
import kr.co.myshop.vo.DaeVo;
import kr.co.myshop.vo.GumaeVo;
import kr.co.myshop.vo.JungVo;
import kr.co.myshop.vo.MemberVo;
import kr.co.myshop.vo.ProductVo;
import kr.co.myshop.vo.SoVo;

public interface ProductMapper {
	// 대분류 테이블 내용가져오기
    public ArrayList<DaeVo> getDae();
    public ArrayList<JungVo> getJung(String daecode);
    public ArrayList<SoVo> getSo(String daejung);
    public int getCode(String pcode);
    public void product_ok(ProductVo pvo);
    public ArrayList<ProductVo> plist(String pcode,int index);
    public int getChong(String pcode);
    public ProductVo pcontent(String pcode);
    public void wish_add(String pcode, String userid);
    public void wish_del(String pcode, String userid);
    public int getWish(String pcode, String userid);
    public void cart_add(String pcode, String su, String userid);
    public int cart_check(String pcode,String userid);
    public void cart_up(String su,String pcode,String userid);
    public MemberVo getMember(String userid);
    public BaesongVo getJuso(String userid);
    public void setBaesong(BaesongVo bvo);
    public void member_phone(String phone,String userid);
    public ArrayList<BaesongVo> baeview(String userid);
    public void jusoadd_ok(BaesongVo bvo);
    public BaesongVo baeup(String id);
    public void baeup_ok(BaesongVo bvo);
    public void gibon(String userid);
    public void baedel(String id);
    public void gibonchg(String userid);
    public void chg_ok(String cla,String id);
    public void gumae_ok(GumaeVo gvo);
    public int getJcode(String jumuncode);
    public GumaeVo getGumae(String jumuncode);
    public ProductVo getProduct(String pcode);
    public BaesongVo getBaesong(int id);
    public ArrayList< HashMap<String,String> > getTotal(String jumuncode);
    public ArrayList< HashMap<String,String> > imsi(String jumuncode);
}
