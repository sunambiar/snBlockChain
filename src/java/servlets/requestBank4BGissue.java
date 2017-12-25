/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.google.gson.Gson;
import globals.BCuser;
import globals.GlobalVariables;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 00023569 
 * @date Dec 20, 2017 8:16:05 PM 
 */
public class requestBank4BGissue extends HttpServlet {

  class DataJSON {

    double timestamp = 0.0d;
    String sender, recipient, infavourof, validupto;

    private DataJSON(String sender, String bankName, String ioclName, String validupto) {
      this.recipient = bankName;
      this.infavourof = ioclName;
      this.validupto = validupto;
      this.sender = sender;
      this.timestamp = (new Timestamp(System.currentTimeMillis())).getTime();
    }
  }

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    GlobalVariables GV = new GlobalVariables();
    /*
    {
 "sender": "d4ee26eee15148ee92c6cd394edd974e",
 "recipient": "someone-other-address",
 "amount": 5
}
     */
    BCuser bcUser = BCuser.getUser(request.getSession());
    if (bcUser != null) {
      Gson gson = new Gson();
      String bankName = request.getParameter("bankName");
      String ioclName = request.getParameter("ioclName");
      String validupto = request.getParameter("validupto");
      DataJSON dataJ = new DataJSON("" + bcUser.getUserType(), bankName, ioclName, validupto);
      String jsonCmd = null;
      String outStr = "", outStrMine = "";
      try {
        jsonCmd = gson.toJson(dataJ);
        if (bcUser != null) {
          outStr = bcUser.postURLresponse(GV.VENDOR_NODE_PORT, GV.CMD_TXN_NEW, jsonCmd);
          if (outStr.length() > 5) {
            outStrMine = bcUser.getURLresponse(GV.VENDOR_NODE_PORT, GV.CMD_MINE);
          }
        }
      } catch (Exception ignore) {
      } finally {
      }
      try {
        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet requestBank4BGissue</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<input type='button' value='<< Back' onClick='javascript:window.history.go(-1);' >");
        out.println("<h2>Bank4BGissue at " + request.getContextPath() + "</h2>");
        out.println("<br/><hr/>New Transaction:-<br/>");
        out.println(outStr);
        out.println("<hr/><br/>");
        out.println("Mining:-<br/>");
        out.println(outStrMine);
        out.println("<hr/><br/>");
        out.println("<br/>");
        out.println("</body>");
        out.println("</html>");
      } finally {
        out.close();
      }
    }
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
