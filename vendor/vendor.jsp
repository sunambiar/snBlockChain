<%-- 
    Document   : index
    Created on : Dec 17, 2017, 5:48:54 PM
    Author     : 00023569
--%>

<%@page import="globals.GlobalVariables"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title> Vendor </title>
  </head>
</head>
<% GlobalVariables GV = new GlobalVariables(); %>
<frameset rows="10%,20%,70%">
  <frame name="heading" src="<%=GV.VENDOR_PATH%>vendor_title.jsp"/>
  <frameset cols="50%,50%" >
    <frame name="top1" src="<%=GV.VENDOR_PATH%>requestBank4BGissue.jsp" />
    <frame name="top2" src="<%=GV.VENDOR_PATH%>requestIOCL4BGrelease.jsp" />
  </frameset>
  <frame name="bottom" src="showChain.jsp" scrolling="yes"/>
  <noframes>
    <body>Your browser does not support frames.</body>
  </noframes>
</frameset>

</html>

