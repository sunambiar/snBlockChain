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
import java.util.HashMap;
import java.util.List;
//import java.io.StringReader;
//import javax.json.Json;
//import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

//import org.json.JSONException;
//import org.json.JSONObject;
/**
 *
 * @author 00023569
 */
public class showChain extends HttpServlet {

  /*
  class Record {

    double amount = 0.0d;
    String recipient = "";
    String sender = "";
  }

  class Txn {

    int index = 1;
    String previous_hash = "";
    long proof = 0;
    double timestamp = 0.0d;
    List<Record> transactions = null;
  }

  class Chain {

    List<String> chain;
    int length = 0;
  }

  class DataJSON {

    int draw = 1;
    int recordsTotal = 0;
    int recordsFiltered = 0;
    String data;

    DataJSON(String dataStr, int recs) {
      recordsTotal = recs;
      recordsFiltered = recs;
      data = dataStr;
    }
  }
   */

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
    GlobalVariables GV = new GlobalVariables();
    PrintWriter out = response.getWriter();
    JSONObject jObject = null, jData = null;
    String responseList = null;
    try {
      BCuser bcUser = BCuser.getUser(request.getSession());
      if (bcUser != null) {
        responseList = bcUser.getURLresponse(bcUser.getUserPort(), GV.CMD_SHOWCHAIN);
        if (responseList.length() > 0) {
          /*
          //JsonObject json = Json.createReader(new StringReader(responseList)).readObject();
          Gson gson = new Gson();
          //String json = gson.toJson(obj);
          Chain chainObj = gson.fromJson(responseList, Chain.class);
          String chainStr = chainObj.chain.toString();
          DataJSON data = new DataJSON(chainStr, chainObj.length);
          //JSONObject json = (JSONObject) new JSONParser().parse(Data);
          String outStr = gson.toJson(data);
          out.write(outStr);
           */
          jObject = new JSONObject(responseList);
          Object jsonObj = jObject.get("chain");
          HashMap hM = new HashMap(1);
          hM.put("data", jsonObj);
          //System.out.println(hM.toString());
          jData = new JSONObject(hM);
          String outStr = jData.toString();
          /*
          String outStr1 = null;
//          outStr = "{\n"
//                  + "  \"data\": [\n"
//                  + "    [\n"
//                  + "      \"Tiger Nixon\",\n"
//                  + "      \"System Architect\",\n"
//                  + "      \"Edinburgh\",\n"
//                  + "      \"5421\",\n"
//                  + "      \"2011/04/25\",\n"
//                  + "      \"$320,800\"\n"
//                  + "    ],\n"
//                  + "    [\n"
//                  + "      \"Garrett Winters\",\n"
//                  + "      \"Accountant\",\n"
//                  + "      \"Tokyo\",\n"
//                  + "      \"8422\",\n"
//                  + "      \"2011/07/25\",\n"
//                  + "      \"$170,750\"\n"
//                  + "    ]]}";

          outStr1 = "{\n"
                  + "  \"data\": [\n"
                  + "    {\n"
                  + "      \"index\": 1,\n"
                  + "      \"previous_hash\": \"1\",\n"
                  + "      \"proof\": 100,\n"
                  + "      \"timestamp\": 1513512536.4694264,\n"
                  + "      \"transactions\": []\n"
                  + "    },\n"
                  + "    {\n"
                  + "      \"index\": 2,\n"
                  + "      \"previous_hash\": \"9d474b5cffc1cc27f8d88e01aaea92b1c57265218473de0f9eef8e05eae9ad10\",\n"
                  + "      \"proof\": 35293,\n"
                  + "      \"timestamp\": 1513512599.8719664,\n"
                  + "      \"transactions\": [\n"
                  + "        {\n"
                  + "          \"amount\": 1,\n"
                  + "          \"recipient\": \"1132f7bb377d489a8168bd9373e8563c\",\n"
                  + "          \"sender\": \"0\"\n"
                  + "        }\n"
                  + "      ]\n"
                  + "    }"
                  + "]}\n";
          outStr1 = "{\"data\":\"[{\\\"index\\\":1,\\\"proof\\\":100,\\\"transactions\\\":[],\\\"previous_hash\\\":\\\"1\\\",\\\"timestamp\\\":1.5135125364694264E9},{\\\"index\\\":2,\\\"proof\\\":35293,\\\"transactions\\\":[{\\\"amount\\\":1,\\\"sender\\\":\\\"0\\\",\\\"recipient\\\":\\\"1132f7bb377d489a8168bd9373e8563c\\\"}],\\\"previous_hash\\\":\\\"9d474b5cffc1cc27f8d88e01aaea92b1c57265218473de0f9eef8e05eae9ad10\\\",\\\"timestamp\\\":1.5135125998719664E9},{\\\"index\\\":3,\\\"proof\\\":35089,\\\"transactions\\\":[{\\\"amount\\\":1,\\\"sender\\\":\\\"0\\\",\\\"recipient\\\":\\\"1132f7bb377d489a8168bd9373e8563c\\\"}],\\\"previous_hash\\\":\\\"a5370810e1e094b2b99aca5929e3632af4480b2fcbff4c0e39fba1b041ba18dc\\\",\\\"timestamp\\\":1.513512600024103E9},{\\\"index\\\":4,\\\"proof\\\":119678,\\\"transactions\\\":[{\\\"amount\\\":1,\\\"sender\\\":\\\"0\\\",\\\"recipient\\\":\\\"1132f7bb377d489a8168bd9373e8563c\\\"}],\\\"previous_hash\\\":\\\"adf8eea75348b9bcd06130ce05ace3e77205e945ddb8facfe0fdd72c85e9238b\\\",\\\"timestamp\\\":1.513512600389852E9},{\\\"index\\\":5,\\\"proof\\\":146502,\\\"transactions\\\":[{\\\"amount\\\":1,\\\"sender\\\":\\\"0\\\",\\\"recipient\\\":\\\"1132f7bb377d489a8168bd9373e8563c\\\"}],\\\"previous_hash\\\":\\\"b39c0ff56ecdc92aca7419bf681186175ed6b001543a732d646bb2c045418f2a\\\",\\\"timestamp\\\":1.5135126007388787E9}]\"}\n";
           */
          System.out.println(outStr);
          out.write(outStr);
        } else { //end if len>0
          response.setContentType("text/html");
          response.setHeader("Cache-Control", "no-cache");
          out.write("{\"data\" : \"\"}");
        }//end else len!>0//end else dispatched false
      }
    } catch (Exception ee) {
      System.out.println(ee);
    } finally {
      out.close();
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
