
<%-- 
    Document   : showChain
    Created on : Dec 17, 2017, 6:00:01 PM
    Author     : 00023569
--%>

<%@page import="utils.snUtils"%>
<%@page import="utils.snUtilsConstants"%>
<%@page import="globals.BCuser"%>
<%@page import="globals.GlobalVariables"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
  String rootPath = "";
  %>
<html>
  <head>
    <%--meta http-equiv="Content-Type" content="text/html; charset=UTF-8"--%>
    <meta name = "viewport" content = "initial-scale=1.0, maximum-scale=2.0" >
    <%
      //String responseList = "";
      boolean showTable = false;
      String reqStr = request.getParameter("cmd");
      if (reqStr != null && reqStr.equals("01")) {
    %>    
    <link rel="stylesheet" type="text/css" href="<%=rootPath%>javascripts/datetimepicker-master/jquery.datetimepicker.css"/>
    <script type="text/javascript" src="<%=rootPath%>javascripts/jquery-1.11.0.min.js"></script>
    <script src="<%=rootPath%>javascripts/datetimepicker-master/jquery.js"></script>
    <script src="<%=rootPath%>javascripts/datetimepicker-master/jquery.datetimepicker.js"></script>
    <!--  date time picker-->
    <%
      GlobalVariables GV = new GlobalVariables();
      BCuser bcUser = BCuser.getUser(session);
      if (bcUser != null) {
        showTable = true;
        //responseList = bcUser.getURLresponse(bcUser.getUserPort(), GV.CMD_SHOWCHAIN);
        //if (responseList.length() > 0) {
        if (true) {
          //refreshTable = "$('#chainDetails').DataTable().ajax.reload(null, false).draw();";
    %>
    <link rel = "stylesheet" type = "text/css" href = "<%=rootPath%>javascripts/media/css/jquery.dataTables.css" >
    <link rel = "stylesheet" type = "text/css" href = "<%=rootPath%>javascripts/media/syntax/shCore.css" >
    <link rel = "stylesheet" type = "text/css" href = "<%=rootPath%>javascripts/media/demo.css" >
    <link href = "<%=rootPath%>css/calendar-blue.css" media = "screen" rel = "stylesheet" type = "text/css" />
    <script type="text/javascript" language="javascript" src="<%=rootPath%>javascripts/media/js/jquery.dataTables.js"></script>
    <style type = "text/css" >
      .objVisible {display:block; }
      .objHidden {display:none; }
    </style>
    <style type = "text/css" >
      .addRow {display:none; }
    </style>
    <style type = "text/css" class = "init" >
      td.details-control {
        background: url('javascripts/media/details_open.png') no-repeat center center;
        cursor: pointer;
      }
      tr.shown td.details-control {
        background: url('javascripts/media/details_close.png') no-repeat center center;
      }
    </style>
    <style type = "text/css" >
      .smileyfix {
        font-size:130% ; line-height:0;
      }
    </style>
    <script src = "<%=rootPath%>javascripts/imageTrail.js" type = "text/javascript" > alert('hello');</script>    
    <%--

              <link rel = "stylesheet" type = "text/css" href = "../javascripts/datetimepicker-master/jquery.datetimepicker.css" / >



    <script type="text/javascript" src="../javascripts/jquery-1.11.0.min.js"></script>
    <script src="../javascripts/datetimepicker-master/jquery.js"></script>
    <script src="../javascripts/datetimepicker-master/jquery.datetimepicker.js"></script>

    <script type="text/javascript" src="../javascripts/calendar.js"></script>
    <script type="text/javascript" src="../javascripts/calendar-en.js"></script>
    <script type="text/javascript" src="../javascripts/calendar-setup.js"></script> 


    <script type="text/javascript" language="javascript" src="../javascripts/media/js/jquery.dataTables.js"></script>
    <script type="text/javascript" language="javascript" src="../javascripts/media/syntax/shCore.js"></script>
    <%--script type="text/javascript" language="javascript" src="../javascripts/media/demo.js"></script--%>
    <%--
            <script type="text/javascript" language="javascript" class="init">
              
                /* Formatting function for row details - modify as you need */
                function format(d) {
                    var returnStr = "";
                    var respURL = encodeURI('../json/getFlatDetailsList.jsp?req=<%=myreq%>&from=<%=fromDate%>&to=<%=toDate%>&reqId='
                            + d.reqId + '&hId=' + d.hId + '&detl=full');
                    if (trailimage != null) {
                        showtrail();
                    }
                    returnStr = $.ajax({url: respURL,
                        type: 'GET',
                        dataType: "text",
                        async: false,
                        cache: false}).responseText;
                    if (trailimage != null) {
                        hidetrail();
                    }
                    return returnStr;
                }
                $(document).ready(function () {
                    //alert("inside");
                    var table = $('#detlDataTbl').DataTable({
                    ajax: {"url": "../json/getFlatDetailsList.jsp?req=<%=myreq%>&from=<%=fromDate%>&to=<%=toDate%>"},
                            "columns": [
                            {
                            "class": 'details-control',
                                    "orderable": false,
                                    "data": null,
                                    "defaultContent": ''
                            }
                <%
                for (int kk = 0; kk < columnNames.length; kk++) {
                %>, {"data": "<%=columnNames[kk]%>"}
                <%
                }
                %>
                            ]
                            /*,
                             "order"
                             : [[1, 'asc']]
                             */
                });
                //alert("after ajax");
                // Add event listener for opening and closing details
                $('#detlDataTbl tbody').on('click', 'td.details-control', function () {
                    var tr = $(this).parents('tr');
                    var row = table.row(tr);
                    if (row.child.isShown()) {
                        // This row is already open - close it
                        row.child.hide();
                        tr.removeClass('shown');
                    } else {
                        // Open this row
                        row.child(format(row.data())).show();
                        tr.addClass('shown');
                    }
                });
                });</script>
            <script><!--
              function PopupCenter(pageURL, title, w, h) {
                            var left = (screen.width / 2) - (w / 2);
                            var top = (screen.height / 2) - (h / 2);
                            var targetWin = window.open(pageURL, title, 'toolbar=no, location=no, directories=no, status=no, menubar=no,' +
                                    'scrollbars=no, resizable=no, copyhistory=no, width=' + w + ', height=' + h + ', top=' + top + ', left=' + left);
                            if (window.focus) {
                                targetWin.focus()
                            }
                            return false;
                        }
    --></script>     
    --%> 
    <%
        }
        /*else { //end if len>0
    response.setContentType("text/html");
    response.setHeader("Cache-Control", "no-cache");
    response.getWriter().write("?");
  }//end else len!>0//end else dispatched false
         */
      }
    %>

    <%
      }
    %>
  </head>
  <body>
    <form method="GET">
      <table>
        <%
          if (showTable) {
        %>
        <tr><td align="right">From Date: </td><td>
            <%
              String str = "$('#from_date').datetimepicker({ "
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
                      + " var ndt = new Date(yy,mm-1,dd);"
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
                      + " ndtStr += ' ' + hh + ':' + mi;"
                      + " document.getElementById('from_date').value = ndtStr;"
                      + " return true;"
                      + " },"
                      + "closeOnWithoutClick :false,closeOnDateSelect:false,"
                      + " yearStart:2014, yearEnd:2090, "
                      + " step:5"
                      + "});";
              snUtilsConstants snUC = new snUtilsConstants();
              snUtils snU = new snUtils();
              snUC.getDateTimeNow();
              String dtTm = snU.dmy2ymd(snUC.DATE_NOW).replace(".", "-");// + " " + snUC.TIME_NOW.substring(0, 5).replace(".", ":");
%>
            <input align="center" placeholder="YYYY-MM-DD" type="text" readonly="true" name="from_date" id="from_date" value="<%=dtTm%>"  />
            <script><%=str%></script>
          </td><td align=""right">To Date: </td><td>
            <%
              str = "$('#to_date').datetimepicker({ "
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
                      //+ "format:'Y-m-d H:i',"
                      + "onChangeDateTime:function(dp,$input){"
                      + " var ival = $input.val();"
                      + " var dd = 1 * ival.substr(8, 2);"
                      + " var mm = 1 * ival.substr(5, 2);"
                      + " var yy = 1 * ival.substr(0, 4);"
                      + " var hh = 1 * ival.substr(11,2);"
                      + " var mi = 1 * ival.substr(14,2);"
                      + " var ndt = new Date(yy,mm-1,dd);"
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
                      + " ndtStr += ' ' + hh + ':' + mi;"
                      + " document.getElementById('to_date').value = ndtStr;"
                      + " return true;"
                      + " },"
                      + "closeOnWithoutClick :false,closeOnDateSelect:false,"
                      + " yearStart:2014, yearEnd:2090, "
                      + " step:5"
                      + "});";
              snUC.getDateTimeNow();
              dtTm = snU.dmy2ymd(snUC.DATE_NOW).replace(".", "-"); // + " " + snUC.TIME_NOW.substring(0, 5).replace(".", ":");
%>
            <input align="center" placeholder="YYYY-MM-DD" type="text" readonly="true" name="to_date" id="to_date" value="<%=dtTm%>"  />
            <script><%=str%></script> 
          </td>
          <%
            }
          %>
          <td>
            <INPUT name="cmd" type="hidden" value="01" />
          </td><td>
            <input name="showChain" value="Show Block-Chain Details" 
                   <%
                     if (showTable) {
                   %>
                   type="button" onClick="javascript:$('#chainDetails').DataTable().ajax.reload(null, false).draw();"
                   <% } else { %>
                   type="submit"
                   <%
                     }
                   %>
                   />
          </td></tr>

      </table>
      <br/>
      <hr/>  
      <%
        if (showTable) {
      %> 
      <table id="chainDetails" class="display" width="100%">
        <thead>
          <tr>
            <th></th>
            <th>Index</th>
            <th>Proof</th>
            <th>TimeStamp</th> 
            <th>Previous#</th>
          </tr>
        </thead>
        <tfoot>
          <tr>
            <th></th>
            <th>Index</th>
            <th>Proof</th>
            <th>TimeStamp</th> 
            <th>Previous#</th>
          </tr>
        </tfoot>
      </table>
      <%
        }
      %> 
    </form>
    <%
      if (showTable) {
    %>
    <script type="text/javascript" ><!--
      function formatChain(d) {
        // `d` is the original data object for the row
        var mStr = '<table cellpadding="5" cellspacing="2" border="0" style="padding-left:50px;"><tr>';
        mStr += '<thead><th>Sender</th><th>Recipient</th><th>Amount</th></tr></thead><tbody>';
        var totamt = 0.0;
        for (i in d.transactions) {
          mStr += '<tr><td>' + d.transactions[i].sender + '</td><td>' +
                  d.transactions[i].recipient + '</td><td align="right">' +
                  d.transactions[i].amount + '</td></tr>';
          totamt += d.transactions[i].amount;
        }
        mStr += '<tr><td align="right" colspan="2">Total:</td><td align="right">' + totamt + '</td></tr>'; 
        mStr += '</tbody></table>';
        return (mStr);
      }
      $(document).ready(function () {
        var table = $('#chainDetails').DataTable({"processing": true,
          "serverSide": false,
          "ajax": {"url": "showChain",
            "type": "POST",
            "data": {"from": $("#from_date").val(),
              "to": $("#to_date").val(),
              "cmd": "vendor"
            }
          },
          columnDefs: [
            {type: 'date-uk', targets: [0, 1, 2, 3, 4]}
          ],
          "columns": [{"className": 'details-control',
              "orderable": false,
              "data": null,
              "defaultContent": ''
            },
            {"data": "index"},
            {"data": "proof"},
            {"data": "timestamp",
              "render": function (data, type, full, meta) {
                return (new Date(data*1000));
                //Utils.formatString(buttonTemplate, data)
              }},
            {"data": "previous_hash"}
          ],
          "order": [[1, 'asc']]
        });
        // Add event listener for opening and closing details
        $('#chainDetails tbody').on('click', 'td.details-control', function () {
          var tr = $(this).parents('tr');
          //alert(table);
          var row = table.row(tr);
          if (row.child.isShown()) {
            // This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
          } else {
            // Open this row
            row.child(formatChain(row.data())).show();
            tr.addClass('shown');
          }
        });
      <%--    
  // Add event listener for opening and closing details
  $('#chainDetails tbody').on('click', 'td.details-control', function () {
    alert('hi');
    var tr = $(this).parents('tr');
    alert(tr);
    var row = table.row(tr);
    alert('hi2');
    if (row.child.isShown()) {
      // This row is already open - close it
      row.child.hide();
      tr.removeClass('shown');
    } else {
      // Open this row
      row.child(formatChain(row.data())).show();
      tr.addClass('shown');
    }
    alert('hi3');
  });
      --%>
      });
--></script>
      <%
        }
      %>
  </body>
</html>