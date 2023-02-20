package kr.co.myshop.mapper;

import kr.co.myshop.vo.MemberVo;

public interface MemberMapper {
    public int userid_check(String userid);
    public void member_input_ok(MemberVo mvo);
    public MemberVo member_view(String userid);
    public MemberVo member_edit(String userid);
    public void member_edit_ok(MemberVo mvo);
}
