/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globals;

import config.snConfigVars;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author 00023569
 */
public class GlobalVariables {

  private static String makeSelectHTML(String name, String id, ArrayList<Participant> mstList) {
    StringBuffer sb = new StringBuffer(50);
    sb.append("<select name='");
    sb.append(name);
    sb.append("' id='");
    sb.append(id);
    sb.append("' >");
    for (int i = 0; i < mstList.size(); i++) {
      sb.append("<option value='");
      sb.append(mstList.get(i).code);
      sb.append("' > ");
      sb.append(mstList.get(i).name);
      sb.append("</option>");
    }
    sb.append("</select>");
    return (sb.toString());
  }

  public GlobalVariables() {
    if (!mastersRead) init();
  }

  public static int IOCL_USER = 1,
          /**
           *
           */
          BANK_USER = 2,
          /**
           *
           */
          VENDOR_USER = 3;
  public static String IOCL_USER_PWD = "1111",
          /**
           *
           */
          BANK_USER_PWD = "2222",
          /**
           *
           */
          VENDOR_USER_PWD = "3333";
  public static String IOCL_USER_NAME = "00012345",
          /**
           *
           */
          BANK_USER_NAME = "BANK01",
          /**
           *
           */
          VENDOR_USER_NAME = "VENDOR01";

  /**
   *
   */
  public static String BC_USER = "BCuser";
  public static int IOCL_NODE_PORT = 5000,
          /**
           *
           */
          BANK_NODE_PORT = 5001,
          /**
           *
           */
          VENDOR_NODE_PORT = 5002;
  public static String IOCL_PAGE = "iocl.jsp",
          /**
           *
           */
          BANK_PAGE = "bank.jsp",
          /**
           *
           */
          VENDOR_PAGE = "vendor.jsp";
  public static String IOCL_PATH = "iocl/",
          /**
           *
           */
          BANK_PATH = "bank/",
          /**
           *
           */
          VENDOR_PATH = "vendor/";

  public static String CMD_SHOWCHAIN = "/chain",
          /**
           *
           */
          CMD_MINE = "/mine",
          /**
           *
           */
          CMD_TXN_NEW = "/transactions/new",
          /**
           *
           */
          CMD_NODES_REG = "/nodes/register",
          /**
           *
           */
          CMD_RESOLVE = "/nodes/resolve";
  //public static String data;

  //public static String HOST_NAME_HTTP = "http://localhost"; 
  /**
   *
   */
  public static String HOST_NAME_HTTP = "http://10.52.185.118";

  private static class Participant {

    public Participant(String code, String user, String pwd, String name) {
      this.code = code;
      this.user = user;
      this.pwd = pwd;
      this.name = name;
    }

    String code, user, pwd, name;
  }

  private static String bankListHTML = "", ioclListHTML = "", vendorListHTML = "";
  private static ArrayList<Participant> bankList = new ArrayList<Participant>();
  private static ArrayList<Participant> ioclList = new ArrayList<Participant>();
  private static ArrayList<Participant> vendorList = new ArrayList<Participant>();
  private static String bankFile = "masters/banks.mst", ioclFile = "masters/iocl.mst", vendorFile = "masters/vendors.mst";

  private static boolean mastersRead = false;
  private static snConfigVars V = snConfigVars.getInstance();

  public static String getBankListHTML() {
    return bankListHTML;
  }

  public static String getIOCLListHTML() {
    return ioclListHTML;
  }

  public static String getVendorListHTML() {
    return vendorListHTML;
  }
  
  public static void init() {
    if (!mastersRead) {
      bankFile = V.getExternalVariable("BankMasterFile", "/user1/snConfig/snBlockChain/masters/banks.mst");
      ioclFile = V.getExternalVariable("IOCLMasterFile", "/user1/snConfig/snBlockChain/masters/iocl.mst");
      vendorFile = V.getExternalVariable("VendorMasterFile", "/user1/snConfig/snBlockChain/masters/vendors.mst");
      mastersRead = readMaster(bankFile, bankList)
              && readMaster(ioclFile, ioclList)
              && readMaster(vendorFile, vendorList);
      if (mastersRead) {
        bankListHTML = makeSelectHTML("bankName", "bankName", bankList);
        ioclListHTML = makeSelectHTML("ioclName", "ioclName", ioclList);
        vendorListHTML = makeSelectHTML("vendorName", "vendorName", vendorList);
      }
    }
  }

  private static boolean readMaster(String readFileName, ArrayList<Participant> mst) {
    BufferedReader br = null;
    int row = 0;
    try {
      br = new BufferedReader(new FileReader(readFileName));
      Participant participant;
      for (String line = br.readLine(); line != null && line.charAt(0) != '#'; line = br.readLine()) {
        row++;
        String[] strArr = line.split("\\|@\\|");
        participant = new Participant(strArr[0], strArr[1], strArr[2], strArr[3]);
        mst.add(participant);
      }
    } catch (Exception ign) {
      System.out.println(ign);
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (Exception ign) {
        }
      }
    }
    return (row > 0);
  }
}
