<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <style>
    section {
      width:1000px;
      margin:auto;
      margin-top:50px;
   }
    section #title {
      width:1000px;
      height:500px;
      margin:auto;
    }
    section #title > #left {
      width:500px;
      height:500px;
      float:left;
    }
    section #title > #right {
      width:500px;
      height:500px;
      float:right;
      position:relative;
    }
   
    section #content {
      width:1000px;
      height:600px;
      margin:auto;
      margin-top:40px;
    }
    section #hugi {
      width:1000px;
      height:200px;
      margin:auto;
      background:red;
    }
    section #mun  {
      width:1000px;
      height:200px;
      margin:auto;
      background:pink;
     
    }
    section #etc {
      width:1000px;
      margin:auto;
       text-align:center;
      margin-top:50px;
      margin-bottom:30px;
    }
    section #su {
      outline:none;
      width:40px;
      height:20px;
    }
    section #ptitle {
      font-size:20px;
      color:purple;
      font-weight:900;
    }
    section #hal {
      height:30px;
      color:grey;
    }
    section #pri {
      font-size:20px;
      color:purple;
      font-weight:900;
    }
    section #juk span {
      margin-top:10px;
      display:inline-block;
      width:134px;
      height:16px;
      border:1px solid purple;
      border-radius:8px;
      font-size:12px;
      text-align:center;
      padding:2px;
    }
    section #bae {
      margin-top:20px;
      font-size:14px;
    }
    section #date {
      margin-top:15px;
      font-size:14px;
    }
    section #made {
      margin-top:20px;
      font-size:14px;
    }
    section #suform {
      margin-top:20px;
    }
    section #btn {
      margin-top:20px;
    }
    section #btn span {
      display:inline-block;
      font-size:14px;
      width:90px;
      height:18px;
      border:1px solid purple;
      padding-top:4px;
      padding-bottom:4px;
      text-align:center;
      background:purple;
      color:white;
    }
    
    /* pcontent내 메뉴 */
    section #pmenu {
      width:1000px;
      height:40px;
      margin:auto;
      text-align:center;
    }
    section #pmenu #pul {
      padding-left:0px;
      background:yellow;
    }
    section #pmenu #pul #pli {
      float:left;
      width:246px;
      height:30px;
      border:1px solid #cccccc;
      border-top-width:3px;
      margin-left:0px;
      list-style-type:none;
      text-align:center;
      padding-top:10px;
      background:#FaFaFa;
      
    }
 </style>
 <script src="https://code.jquery.com/jquery-latest.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script> 
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"> 
 <script>
   $(function()
   {
	   $("#su").spinner(
	   {
		   min:1,
		   max:10,
		   spin:function(e,ui) // spinner의 값을 바꿀때 실행되는 함수
	       {
			    //alert(ui.value);
			    // ui.value(상품선택수)*상품가격  => 전달
			    var price=ui.value*${pvo.price-(pvo.price*(pvo.halin/100))};
			    price=comma(price);
			    document.getElementById("pri").innerText=price+"원";
	       }
	   });
   });
   
   function comma(num)
   {
	   return new Intl.NumberFormat().format(num);
   }
   
   function wish(my)
   {
	   var ck;
	   //alert(my.src.indexOf("w1.png"));
	   if(my.src.indexOf("w1.png") == -1)
	   {
		   // w2.png에서 클릭되었다 => delete
		   ck=1;
	   }	
	   else
	   {
		   // w1.png에서 클릭되었다 => insert
		   ck=2;
	   }	   
	   
	   <c:if test="${userid!=null}">
	     <c:set var="chk" value="true"/>
	   </c:if>
	   <c:if test="${userid==null}">
	     <c:set var="chk" value="false"/>
	   </c:if>
	   
	   if(${chk})
	   {
	      var chk=new XMLHttpRequest();
	      chk.onload=function()
	      {
		     //alert(chk.responseText);
		     if(chk.responseText=="0")
		     {
		    	 if(ck==1)
		    	    my.src="../resources/img/w1.png";
		    	 else
		    	    my.src="../resources/img/w2.png";
		     }
		     else
		     {
		    	 alert("예상하지 않은 오류");
		     } 	 
	      }
	      chk.open("get","wish_add?pcode=${pvo.pcode}&ck="+ck);
	      chk.send();
	   }
	   else
	   {
		   location="../login/login";
	   }	     
   }
   
   function cart_add()
   {
	   // 수량은 form태그에서 읽어온다
	   var su=document.pform.su.value;
	   var chk=new XMLHttpRequest();
	   chk.onload=function()
	   {
		   //alert(chk.responseText);
		   if(chk.responseText=="0")
		   {
			   /* 
			   if(confirm("장바구니로 이동하시겠습니까"))
			   {
				   location="cart_view";
			   }
			   */
			   // id=cart_move요소를 보이게 하기
			   document.getElementById("cart_move").style.visibility="visible";
			   setTimeout(function()
			   {
				   document.getElementById("cart_move").style.visibility="hidden";
			   } , 3000);
		   }	
		   else
		   {
			   alert("오류");
		   }	   
	   }
	   chk.open("get","cart_add?pcode=${pvo.pcode}&su="+su);
	   chk.send();
   }
   
   function gumae()
   {
	   document.pform.submit();
   }
 </script>
 <style>
   section #cart_move {
     position:absolute;
     left:20px;
     top:220px;
     width:180px;
     height:60px;
     font-size:12px;
     border:1px solid purple;
     text-align:center;
     background:white;
     visibility:hidden;
   }
   section #cart_move #btn2 {
     display:inline-block;
     width:120px;
     height:20px;
     border:1px solid black;
   }
 </style>
</head>
<body>
   <section>
      
      <div id="title">
        <div id="left" align="center"> <img src="../resources/pro/${pvo.pimg}" width="400"> </div>
        <div id="right">
          <div id="cart_move">
            <span>상품이 장바구니에 담겼습니다</span> <p>
            <span id="btn2" onclick="location='../mypage/cartview'" style="cursor:pointer"> 장바구니로 가기 </span>
          </div>
          <form name="pform" method="post" action="gumae">
           <input type="hidden" name="pcode" value="${pvo.pcode}">
           <div id="ptitle"> ${pvo.title}</div>
           <div> 
             <c:forEach begin="1" end="${pvo.star}">
              <img src="../resources/img/star1.png" width="16">
             </c:forEach>
             <c:forEach begin="1" end="${5-pvo.star}">
              <img src="../resources/img/star2.png" width="16">
             </c:forEach>
           </div>
           <hr>
           <div id="hal"> ${pvo.halin}% <s> <fmt:formatNumber value="${pvo.price}" type="number"/>원 </s></div>
           <div id="pri"> <fmt:formatNumber value="${pvo.price-(pvo.price*(pvo.halin/100))}" pattern="#,###" type="number"/>원 </div>
           <div id="juk"> <span> 최대적립 <fmt:formatNumber value="${pvo.price*(pvo.juk/100)}" pattern="#,###" type="number"/>원 적립 </span></div>
           <div id="bae"> 
             <c:if test="${pvo.baesong==0}">
                              무료배송
             </c:if>
             <c:if test="${pvo.baesong!=0}">
                           배송비 : <fmt:formatNumber value="${pvo.baesong}" pattern="#,###" type="number"/>원
             </c:if>
           </div>
           <c:choose>
             <c:when test="${pvo.yoil==1}">
               <c:set var="yoil2" value="일"/>
             </c:when>
             <c:when test="${pvo.yoil==2}">
               <c:set var="yoil2" value="월"/>
             </c:when>
             <c:when test="${pvo.yoil==3}">
               <c:set var="yoil2" value="화"/>
             </c:when>
             <c:when test="${pvo.yoil==4}">
               <c:set var="yoil2" value="수"/>
             </c:when>
             <c:when test="${pvo.yoil==5}">
               <c:set var="yoil2" value="목"/>
             </c:when>
             <c:when test="${pvo.yoil==6}">
               <c:set var="yoil2" value="금"/>
             </c:when>
             <c:when test="${pvo.yoil==7}">
               <c:set var="yoil2" value="토"/>
             </c:when>
           </c:choose>
           <div id="date"> [${yoil2}] ${pvo.bday}배송예정</div>
           <div id="made"> 제조사 : ${pvo.made}</div>
           <div id="suform"> 
               <input type="text" name="su" id="su" value="1" readonly>
           </div>
           <div id="btn" style="clear:both;">
           <c:if test="${wcnt==0 || wcnt==null}">
            <img style="cursor:pointer" src="../resources/img/w1.png" width="32" valign="bottom" onclick="wish(this)"> 
           </c:if>
           <c:if test="${wcnt!=0 && wcnt!=null}">
            <img style="cursor:pointer" src="../resources/img/w2.png" width="32" valign="bottom" onclick="wish(this)"> 
           </c:if>
             <span onclick="cart_add()" style="cursor:pointer"> 장바구니 </span>
             <span onclick="gumae()"> 구매하기 </span>
            </div>
           </form>
        </div>
      </div>
      <div id="pmenu">
        <ul id="pul">
          <li id="pli"> 상품상세 </li>
          <li id="pli"> 상품후기 </li>
          <li id="pli"> 상품문의 </li>
          <li id="pli"> 배송/교환/반품 안내</li>
        </ul>
      </div>      
      <div id="content" align="center">
         <img src="../resources/pro/${pvo.cimg}" width="850" height="600">
      </div>
      <div id="hugi"></div>
      <div id="mun"></div>
      <div id="etc"> <img src="../resources/img/etc.png"> </div>
      
   </section>
</body>
</html>



