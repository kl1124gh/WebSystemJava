<%@ page import="java.io.File" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.FileReader" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="zh">
<head>
  <meta charset="UTF-8">
  <title>商品信息</title>
</head>
<body>
<%
  String propertiesFilePath = new File(application.getRealPath(request.getRequestURI())).getParentFile().getParent() + "/WEB-INF/product_info.txt";
  String keyword = request.getParameter("keyword");

  if(keyword==null){
    keyword = "";
  }

  if(!"".equals(keyword)) {
    keyword = new String(keyword.getBytes("iso-8859-1"), "utf-8");
  }
%>
<div style="width:800px; height:40px; margin-bottom: 10px;">
  <form action="index.jsp" method="get">
    搜索关键字：
    <input type="text" name="keyword" id="keyword" value="<%=keyword%>" />
    <input type="submit" name="btnSubmit" id="btnSubmit" value="提交" />
  </form>
</div>
<table width="800" border="1">
  <tr height="40">
    <td width="50">ID</td>
    <td width="410">商品名称</td>
    <td width="120">价格</td>
    <td width="120">产地</td>
    <td width="120">保质期</td>
  </tr>
<%

  File propertiesFile = new File(propertiesFilePath);
  if(propertiesFile==null || propertiesFile.exists()==false){
    out.print("<tr><td width=\"100%\" colspan=\"5\" height=\"40\" style=\"text-align:center;\">商品配置文件不存在</td></tr>");
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
  </tr>
<%
        resultCount++;
      }
      br.close();
    }catch(Exception e){
      e.printStackTrace();
    }
    if(resultCount==0) {
      out.print("<tr><td width=\"100%\" colspan=\"5\" height=\"40\" style=\"text-align:center;\">暂无搜索结果</td></tr>");
    }
  }
%>
</table>
</body>
</html>