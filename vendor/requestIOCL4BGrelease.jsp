<%-- 
    Document   : requestIOCL4BGrelease
    Created on : Dec 17, 2017, 5:58:36 PM
    Author     : 00023569
--%>

<%@page import="globals.GlobalVariables"%>
<%@page import="utils.snUtils"%>
<%@page import="utils.snUtilsConstants"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
  String rootPath = "../";
  GlobalVariables GV = new GlobalVariables();
  %>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="<%=rootPath%>javascripts/datetimepicker-master/jquery.datetimepicker.css"/>
    <script type="text/javascript" src="<%=rootPath%>javascripts/jquery-1.11.0.min.js"></script>
    <script src="<%=rootPath%>javascripts/datetimepicker-master/jquery.js"></script>
    <script src="<%=rootPath%>javascripts/datetimepicker-master/jquery.datetimepicker.js"></script>
  <h2> IOCL </h2>
  </head>
  <body>
    <form action="<%=rootPath%>requestIOCL4BGrelease" method="POST">
      <table><tr><td>
            Request IOCL for BG Release :
          </td><td><%=GV.getIOCLListHTML()%>
          </td></tr>
        <tr><td>
            BG Issued by Bank :
          </td><td><%=GV.getBankListHTML()%>
          </td></tr>
        <tr><td>
            BG No. to be Released : 
          </td><td>
            <input name="bgNo" type='text' value="BG04M2494953303" size="50"/>
          </td></tr><tr><td>
            Valid upto :
          </td><td>
            <%
              String str = "$('#validupto').datetimepicker({ "
                      + "datepicker:true,"
                      + "timepicker:false,"
                      + "defaultSelect:false,"
                      + "formatDate:'Y-m-d',"
                      + "minDate:'2000-01-01',"
                      + "maxDate: 0,"//today is maximum date calendar
                      /*
             + "maxDate: new Date,"//today is maximum date calendar
             + "maxDate: new Date(),"//today is maximum date calendar
             + "maxDate:'+1970/01/02',"//today is maximum date calendar
             All are working
                       */
                      + "format:'Y-m-d',"
                      //+ "format:'Y-m-d '," 
                      + "onChangeDateTime:function(dp,$input){"
                      + " var ival = $input.val();"
                      + " var dd = 1 * ival.substr(8, 2);"
                      + " var mm = 1 * ival.substr(5, 2);"
                      + " var yy = 1 * ival.substr(0, 4);"
                      + " var hh = 1 * ival.substr(11,2);"
                      + " var mi = 1 * ival.substr(14,2);"
                     // + " var ndt = new Date(yy,mm-1,dd);"
                      + " var ndt = new Date(yy,mm-1,dd,hh,mi,0,0);"
                      + " yy = ndt.getFullYear();"
                      + " mm = (ndt.getMonth()+1);"
                      + " dd = ndt.getDate();"
                      + " hh = ndt.getHours();"
                      + " mi = ndt.getMinutes();"
                      + " if (yy < 1000) yy = 2000 + yy;"
                      + " if (mm < 10) mm = '0' + mm;"
                      + " if (dd < 10) dd = '0' + dd;"
                      + " if (hh < 10) hh = '0' + hh;"
                      + " if (mi < 10) mi = '0' + mi;"
                      + " var ndtStr = '' + yy + '-' + mm + '-' + dd;"
                  //    + " ndtStr += ' ' + hh + ':' + mi;"
                      + " document.getElementById('validupto').value = ndtStr;"
                      + " return true;"
                      + " },"
                      + "closeOnWithoutClick: true,closeOnDateSelect: true,"
                      + " yearStart:2014, yearEnd:2090, "
                      + " step:5"
                      + "});";
              snUtilsConstants snUC = new snUtilsConstants();
              snUtils snU = new snUtils();
              snUC.getDateTimeNow();
              String dtTm = snU.dmy2ymd(snUC.DATE_NOW).replace(".", "-");// + " " + snUC.TIME_NOW.substring(0, 5).replace(".", ":");
%>
            <input align="center" placeholder="YYYY-MM-DD" type="text" readonly="true" name="validupto" id="validupto" value="<%=dtTm%>"  />
            <script><%=str%></script> 
          </td></tr>
        <tr><td colspan='2'>
            <input name="submit" type='submit' value="Request IOCL to release above BG >>">
          </td></tr>
      </table>
    </form>
    <br/>
  </body>
</html>

