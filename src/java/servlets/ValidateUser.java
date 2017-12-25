/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import globals.BCuser;
import globals.GlobalVariables;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 00023569
 */
public class ValidateUser extends HttpServlet {

  private GlobalVariables GV = new GlobalVariables();

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
    HttpSession session = request.getSession();
    //BCuser username = (String)request.getAttribute("un");
    session.setAttribute(GV.BC_USER, null);
    RequestDispatcher rd = null;
    //response.setContentType("text/html;charset=UTF-8");
    //PrintWriter out = response.getWriter();
    try {
      String user = request.getParameter("user");
      String pswd = request.getParameter("pswd");
      if (user != null && pswd != null) {
        BCuser bcUser = new BCuser(user, pswd);
        if (bcUser.getUserType() > 0) {
          session.setAttribute(GV.BC_USER, bcUser);
        }
        rd = request.getRequestDispatcher(bcUser.getMainPage());
      } else {
        response.sendRedirect("index.jsp?msg=01");
      }
      /* TODO output your page here. You may use following sample code. * /
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet ValidateUser</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet ValidateUser at " + request.getContextPath() + "</h1>");
      out.println("</body>");
      out.println("</html>");
       */
    } finally {
      //out.close(); 
    }
    if (rd != null) {
      rd.forward(request, response);
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
