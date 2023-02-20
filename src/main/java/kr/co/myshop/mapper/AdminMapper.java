package kr.co.myshop.mapper;

import java.util.ArrayList;
import java.util.HashMap;

public interface AdminMapper {
   public ArrayList< HashMap<String,String> > admingumae();
   public void chgstate(String state,String id);
}
