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
  <title>Product information</title>
</head>
<body>

 <h1>
   		Welcome to my shopping website
 </h1>
<%
  String propertiesFilePath = new File(application.getRealPath(request.getRequestURI())).getParentFile().getParent() + "/WEB-INF/product_info.txt";
  String keyword = request.getParameter("keyword");
  String addCart = request.getParameter("addCart");

  if(addCart!=null && addCart.equals("1")){

    String s = request.getParameter("s");
    if(s!=null && !s.equals("")){

      String[] carts = s.split("-");

      List<String> cartList = (List<String>)session.getAttribute("cart");
      if(cartList==null || cartList.size()==0){
        cartList = new ArrayList<String>();
      }

      boolean haveSame = false;

      for(int i = 0; i < cartList.size(); i++){

        String[] targetCarts = cartList.get(i).split("-");
        if(targetCarts==null || targetCarts.length==0 || targetCarts[0].equals(carts[0])){
          haveSame = true;
        }

      }

      if(haveSame){
        out.print("<script>alert('Product already exited in shopping cart');window.location='index.jsp';</script>");
        return;
      }

      cartList.add(s);
      session.setAttribute("cart",cartList);

      out.print("<script>alert('Added to cart successfully');window.location='index.jsp';</script>");
      return;
    }

  }

  if(keyword==null){
    keyword = "";
  }

  if(!"".equals(keyword)) {
    keyword = new String(keyword.getBytes("iso-8859-1"), "utf-8");
  }
%>
<div style="width:800px; height:40px; margin-bottom: 10px;">
  <form action="index.jsp" method="get" style="width:400px; float: left;">
    search keyword:
    <input type="text" name="keyword" id="keyword" value="<%=keyword%>" />
    <input type="submit" name="btnSubmit" id="btnSubmit" value="submit" />
  </form>
  <div style="float: right;"><a href="cart.jsp" target="_blank">Shopping Cart</a></div>
</div>
<table width="800" border="1">
  <tr height="40">
    <td width="50">ID</td>
    <td width="410">Name of Product</td>
    <td width="120">Price</td>
    <td width="120">Place of Origin</td>
    <td width="120">Expiration Date</td>
    <td width="120">Action</td>
  </tr>
<%

  File propertiesFile = new File(propertiesFilePath);
  if(propertiesFile==null || propertiesFile.exists()==false){
    out.print("<tr><td width=\"100%\" colspan=\"6\" height=\"40\" style=\"text-align:center;\">No product exists</td></tr>");
  }else{
    int resultCount = 0;
    try{
      BufferedReader br = new BufferedReader(new FileReader(new File(propertiesFilePath)));
      String s = null;
      while((s = br.readLine())!=null){
        String[] ss = s.split("-");
        if(!"".equals(keyword)){
          if(ss[1].indexOf(keyword) < 0){
            continue;
          }
        }

%>
  <tr height="40">
    <td width="50"><%=ss[0]%></td>
    <td width="410"><%=ss[1]%></td>
    <td width="120"><%=ss[2]%></td>
    <td width="120"><%=ss[3]%></td>
    <td width="120"><%=ss[4]%></td>
    <td width="120"><a href="index.jsp?addCart=1&s=<%=s%>">Add to cart</a></td>
  </tr>
<%
        resultCount++;
      }
      br.close();
    }catch(Exception e){
      e.printStackTrace();
    }
    if(resultCount==0) {
      out.print("<tr><td width=\"100%\" colspan=\"6\" height=\"40\" style=\"text-align:center;\">no search result</td></tr>");
    }
  }
%>
</table>
</body>
</html>