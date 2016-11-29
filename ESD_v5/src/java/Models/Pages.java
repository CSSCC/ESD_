/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author RickyL
 */
public class Pages {

    HashMap<String, String> pages;     //creates 2 column hash map of string data type

    public Pages() {
        pages = new HashMap<String, String>();

        pages.put("/login.do", "mainMember.jsp");
        pages.put("/index.jsp", "mainMember.jsp");
        pages.put("/index", "mainMember.jsp");
        
        pages.put("/test", "test.jsp");
        pages.put("/loginreg", "loginreg.jsp");

        pages.put("/listAllMembers", "listAllMembers.jsp");
    }

    // Check if page is allowed 
    public boolean pageAllowed(String input) {
        if (pages.containsKey(input)) {
            return true;
        } else {
            return false;
        }
    }

    // Mapping from request URI to resource
    public String redirect(String input) {
        return pages.get(input);
    }

    // Reroutes to login if login object is not valid or not found
//    public String loginReroute(HttpServletRequest request, String appendUri, String currentPage) {
//        HttpSession session = request.getSession();
//        serv.Login loginInfo = (serv.Login) session.getAttribute("login");
//        
//        if (loginInfo == null) {
//            request.getSession().setAttribute("originalPage", appendUri + currentPage);
//            request.setAttribute("alert", "Session has timed out, please re-login");
//            return "loginreg.jsp";
//        } else {
//            if (!loginInfo.isLoggedIn()) {
//                request.getSession().setAttribute("originalPage", appendUri + currentPage);
//                request.setAttribute("alert", "Session has timed out, please re-login");
//                return "loginreg.jsp";
//            }
//        }
//        return currentPage;
//    }
 

}
