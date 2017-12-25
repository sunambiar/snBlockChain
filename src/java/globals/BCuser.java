/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globals;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author 00023569
 */
public class BCuser {

  private int userType = 0;
  private int userPort = 80;
  private String mainPage = "";
  private static GlobalVariables GV = new GlobalVariables();

  /**
   *
   * @param userName
   * @param pswd
   */
  public BCuser(String userName, String pswd) {
    if (userName.equals(GV.BANK_USER_NAME) && pswd.equals(GV.BANK_USER_PWD)) {
      userType = GV.BANK_USER;
      mainPage = GV.BANK_PATH  + GV.BANK_PAGE;
      userPort = GV.BANK_NODE_PORT;
    } else if (userName.equals(GV.IOCL_USER_NAME) && pswd.equals(GV.IOCL_USER_PWD)) {
      userType = GV.IOCL_USER;
      mainPage = GV.VENDOR_PATH   + GV.IOCL_PAGE;
      userPort = GV.IOCL_NODE_PORT;
    } else if (userName.equals(GV.VENDOR_USER_NAME) && pswd.equals(GV.VENDOR_USER_PWD)) {
      userType = GV.VENDOR_USER;
      mainPage = GV.VENDOR_PATH   + GV.VENDOR_PAGE;
      userPort = GV.VENDOR_NODE_PORT;
    }
  }

  private static final Logger log = LoggerFactory.getLogger(BCuser.class);

  /**
   *
   * @param session
   * @return
   */
  public static BCuser getUser(HttpSession session) {
    BCuser bcu = (BCuser) session.getAttribute(GV.BC_USER);
    if (bcu != null && bcu.userType <= 0) {
      bcu = null;
    }
    return (bcu);
  }

  /**
   *
   * @return
   */
  public int getUserPort() {
    return userPort;
  }

  /**
   *
   * @param user_Port
   * @param cmdString
   * @param jsonStr
   * @return
   */
  public static String postURLresponse(int user_Port, String cmdString, String jsonStr) {
    String urlString = GV.HOST_NAME_HTTP + ":" + user_Port + cmdString;
    URL url = null;
    StringBuilder sb = new StringBuilder();
    InputStreamReader isr = null;
    BufferedReader br = null;
    OutputStream os = null;
    HttpURLConnection urlConn = null;
    try {
      url = new URL(urlString);
      urlConn = (HttpURLConnection) url.openConnection();
      urlConn.setConnectTimeout(5000);
      urlConn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
      urlConn.setDoOutput(true);
      urlConn.setDoInput(true);
      urlConn.setRequestMethod("POST");

      os = urlConn.getOutputStream();
      os.write(jsonStr.getBytes("UTF-8"));
      os.close();
      os = null;

      int respCode = urlConn.getResponseCode();
      if (200 <= respCode && respCode <= 299) {
        isr = new InputStreamReader(urlConn.getInputStream());
        br = new BufferedReader(isr);
      } else {
        isr = new InputStreamReader(urlConn.getErrorStream());
        br = new BufferedReader(isr);
      }
      sb = new StringBuilder();
      String output;
      while ((output = br.readLine()) != null) {
        sb.append(output);
      }
    } catch (Exception ignore) {
      ignore.printStackTrace();
    } finally {
      if (urlConn != null) {
        try {
          urlConn.disconnect();
        } catch (Exception ig) {
        }
      }
      if (os != null) {
        try {
          os.close();
        } catch (Exception ig) {
        }
      }
      if (isr != null) {
        try {
          isr.close();
        } catch (Exception ig) {
        }
      }
      if (br != null) {
        try {
          br.close();
        } catch (Exception ig) {
        }
      }
    }
    return (sb.toString());
  }

  /**
   *
   * @param user_Port
   * @param cmdString
   * @return
   */
  public static String getURLresponse(int user_Port, String cmdString) {
    if (false && cmdString.equals(GV.CMD_SHOWCHAIN)) {
    return ("{\n" +
"  \"chain\": [\n" +
"    {\n" +
"      \"index\": 1,\n" +
"      \"previous_hash\": \"1\",\n" +
"      \"proof\": 100,\n" +
"      \"timestamp\": 1513512536.4694264,\n" +
"      \"transactions\": []\n" +
"    },\n" +
"    {\n" +
"      \"index\": 2,\n" +
"      \"previous_hash\": \"9d474b5cffc1cc27f8d88e01aaea92b1c57265218473de0f9eef8e05eae9ad10\",\n" +
"      \"proof\": 35293,\n" +
"      \"timestamp\": 1513512599.8719664,\n" +
"      \"transactions\": [\n" +
"        {\n" +
"          \"amount\": 1.35,\n" +
"          \"recipient\": \"1132f7bb377d489a8168bd9373e8563c\",\n" +
"          \"sender\": \"0\"\n" +
"        },\n" +
"        {\n" +
"          \"amount\": 108.25,\n" +
"          \"recipient\": \"1132f7bb377d489a8168bd9373e8563c\",\n" +
"          \"sender\": \"0\"\n" +
"        },\n" +
"        {\n" +
"          \"amount\": 980.25,\n" +
"          \"recipient\": \"1132f7bb377d489a8168bd9373e8563c\",\n" +
"          \"sender\": \"0\"\n" +
"        },\n" +
"        {\n" +
"          \"amount\": 100.75,\n" +
"          \"recipient\": \"1132f7bb377d489a8168bd9373e8563c\",\n" +
"          \"sender\": \"0\"\n" +
"        }\n" +
"      ]\n" +
"    },\n" +
"    {\n" +
"      \"index\": 3,\n" +
"      \"previous_hash\": \"a5370810e1e094b2b99aca5929e3632af4480b2fcbff4c0e39fba1b041ba18dc\",\n" +
"      \"proof\": 35089,\n" +
"      \"timestamp\": 1513512600.024103,\n" +
"      \"transactions\": [\n" +
"        {\n" +
"          \"amount\": 1,\n" +
"          \"recipient\": \"1132f7bb377d489a8168bd9373e8563c\",\n" +
"          \"sender\": \"0\"\n" +
"        }\n" +
"      ]\n" +
"    },\n" +
"    {\n" +
"      \"index\": 4,\n" +
"      \"previous_hash\": \"adf8eea75348b9bcd06130ce05ace3e77205e945ddb8facfe0fdd72c85e9238b\",\n" +
"      \"proof\": 119678,\n" +
"      \"timestamp\": 1513512600.389852,      \"transactions\": [\n" +
"        {\n" +
"          \"amount\": 1,\n" +
"          \"recipient\": \"1132f7bb377d489a8168bd9373e8563c\",\n" +
"          \"sender\": \"0\"\n" +
"        }\n" +
"      ]\n" +
"    },\n" +
"    {\n" +
"      \"index\": 5,\n" +
"      \"previous_hash\": \"b39c0ff56ecdc92aca7419bf681186175ed6b001543a732d646bb2c045418f2a\",\n" +
"      \"proof\": 146502,\n" +
"      \"timestamp\": 1513512600.7388787,\n" +
"      \"transactions\": [\n" +
"        {\n" +
"          \"amount\": 1,\n" +
"          \"recipient\": \"1132f7bb377d489a8168bd9373e8563c\",\n" +
"          \"sender\": \"0\"\n" +
"        },\n" +
"        {\n" +
"          \"amount\": 100.25,\n" +
"          \"recipient\": \"1132f7bb377d489a8168bd9373e8563c\",\n" +
"          \"sender\": \"0\"\n" +
"        },\n" +
"        {\n" +
"          \"amount\": 89541.65,\n" +
"          \"recipient\": \"1132f7bb377d489a8168bd9373e8563c\",\n" +
"          \"sender\": \"0\"\n" +
"        }\n" +
"      ]\n" +
"    }\n" +
"  ],\n" +
"  \"length\": 5\n" +
"}");
    }
    String urlString = GV.HOST_NAME_HTTP + ":" + user_Port + cmdString;
    URL url = null;
    StringBuilder sb = new StringBuilder();
    InputStreamReader isr = null;
    BufferedReader br = null;
    HttpURLConnection urlConn = null;
    try {
      url = new URL(urlString);
      urlConn = (HttpURLConnection) url.openConnection();
      int respCode = urlConn.getResponseCode();
      if (200 <= respCode && respCode <= 299) {
        isr = new InputStreamReader(urlConn.getInputStream());
        br = new BufferedReader(isr);
      } else {
        isr = new InputStreamReader(urlConn.getErrorStream());
        br = new BufferedReader(isr);
      }
      sb = new StringBuilder();
      String output;
      while ((output = br.readLine()) != null) {
        sb.append(output);
      }
    } catch (Exception ignore) {
      ignore.printStackTrace();
    } finally {
      if (urlConn != null) {
        try {
          urlConn.disconnect();
        } catch (Exception ig) {
        }
      }
      if (isr != null) {
        try {
          isr.close();
        } catch (Exception ig) {
        }
      }
      if (br != null) {
        try {
          br.close();
        } catch (Exception ig) {
        }
      }
    }
    return (sb.toString());
  }

  /**
   *
   * @return
   */
  public String getMainPage() {
    return mainPage;
  }

  /**
   *
   * @return
   */
  public int getUserType() {
    return userType;
  }

}
