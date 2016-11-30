package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author RickyL
 */
public class FrontController extends HttpServlet {

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
        String id = request.getRequestURI().substring(request.getContextPath().length());
        String page = "/WEB-INF/docs/mainMember.jsp";
        HttpSession session = request.getSession(true);
        String username = (String) session.getAttribute("username");

        if (id != "RegistrationController") {
            //if user is admin display main else mainPage
            if (username.equals("admin")) {
                page = "/WEB-INF/docs/mainAdmin.jsp";
            } else {
                page = "/WEB-INF/docs/mainMember.jsp";
            }
        } else {
            page = "/WEB-INF/docs/mainMember.jsp";
        }
        //if id equals " " include specific jsp
        String include = "";
       

        switch (id) {
            case "/Front":
                include = "loginPage.jsp";
                break;
            case "/docs/index":
                include = "index.jsp";
                break;
            case "/docs/listAllMembers":
                include = "listAllMembers.jsp";
                break;
            case "/docs/listClaims":
                include = "listClaims.jsp";
                break;
            case "/docs/listOutstandingBalances":
                include = "listOutstandingBalances.jsp";
                break;
            case "/docs/listProvApps":
                include = "listProvApps.jsp";
                break;
            case "/docs/checkOutBalance":
                include = "checkOutBalance.jsp";
                break;
            case "/docs/submitClaim":
                include = "submitClaim.jsp";
                break;
            case "/docs/paymentError":
                include = "paymentError.jsp";
                break;
            case "/docs/listAllClaimsMember":
                include = "listAllClaimsMember.jsp";
                break;
            case "/docs/mainMember":
                include = "mainMember.jsp";
            break;
        }

        getServletContext().log("Front received a request for " + id);
        request.setAttribute("doco", include);
        request.setAttribute("user", username);
        request.getRequestDispatcher(page).forward(request, response);

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
