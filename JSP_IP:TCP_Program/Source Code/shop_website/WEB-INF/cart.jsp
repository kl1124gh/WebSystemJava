<%@ page import="java.io.File" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.FileReader" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="zh">
<head>
  <meta charset="UTF-8">
  <title>Shopping Cart</title>
</head>
<body>
 <h2>
                Welcome to the shopping cart page<br/>
	 <a href="index.jsp">back</a>
	 <br/>
 </h2>
 <br/>
<%
  List<String> cartList = (List<String>)session.getAttribute("cart");
  if(cartList==null || cartList.size()==0){
    cartList = new ArrayList<String>();
  }
  String delCart = request.getParameter("delCart");
  if(delCart!=null && delCart.equals("1")){
    String id = request.getParameter("id");
    if(id!=null && !id.equals("")){

      List<String> newList = new ArrayList<String>();

      for(int i = 0; i < cartList.size(); i++){
        String[] targetCarts = cartList.get(i).split("-");
        if(!targetCarts[0].equals(id)){
          newList.add(cartList.get(i));
        }
      }

      session.setAttribute("cart",newList);
      out.print("<script>alert('delete successfully');window.location='cart.jsp';</script>");
    }
  }
%>
<table width="800" border="1">
  <tr height="40">
    <td width="50">ID</td>
    <td width="410">Name of Product</td>
    <td width="120">Price</td>
    <td width="120">Product of Origin</td>
    <td width="120">Expiration Date</td>
    <td width="120">Action</td>
  </tr>
<%

  for(int i = 0; i < cartList.size(); i++){

    String s = new String(cartList.get(i).getBytes("iso-8859-1"), "utf-8");
    String[] targetCarts = s.split("-");

%>
  <tr height="40">
    <td width="50"><%=targetCarts[0]%></td>
    <td width="410"><%=targetCarts[1]%></td>
    <td width="120"><%=targetCarts[2]%></td>
    <td width="120"><%=targetCarts[3]%></td>
    <td width="120"><%=targetCarts[4]%></td>
    <td width="120"><a href="cart.jsp?delCart=1&id=<%=targetCarts[0]%>">delete</a></td>
  </tr>
<%
    }
    if(cartList.size()==0) {
      out.print("<tr><td width=\"100%\" colspan=\"6\" height=\"40\" style=\"text-align:center;\">No product added to cart</td></tr>");
    }
%>
</table>
</body>
</html>