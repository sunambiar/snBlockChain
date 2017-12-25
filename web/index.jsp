<%-- 
    Document   : index
    Created on : Dec 17, 2017, 6:51:50 PM
    Author     : 00023569
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>snBlockChain</title>
  </head>
  <body>
    <h1>Hello!!</h1>
    <h2> Welcome to IOCL Block Chain </h2>
    <hr/>
    <%
      String msg = request.getParameter("msg");
      if (msg != null && msg.equals("01")) {
    %>Message : User Id / Password Incorrectly entered !! Please try again.....
    <%
      }
    %>
    <hr/>
    <br/>
    <form name="form1" action="ValidateUser" method="POST">
      <table>
        <tr>
          <td>
            User Id : 
          </td>
          <td>
            <input name="user" type="text" value=""  size="25" >
          </td>
          <td>
            [ Bank : BANK01  / IOCL : 00012345 / Vendor : VENDOR01 ]
          </td>
        </tr>
        <tr>
          <td>
            Password : 
          </td>
          <td>
            <input name="pswd" type="password" value=""  size="25" >
          </td>
          <td>
            [ Bank : 2222  / IOCL : 1111 / Vendor : 3333 ]
          </td>
        </tr>
        <tr><td colspan="3" align="center">
            <input type="submit" value="Submit"/>
          </td></tr>
      </table> 
    </form>
  </body>
</html>
