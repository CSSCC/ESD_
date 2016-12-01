package Controller;

import Models.Jdbc;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            throws ServletException, IOException, SQLException {
        String id = request.getRequestURI().substring(request.getContextPath().length());
        String page = "/WEB-INF/docs/mainMember.jsp";
        HttpSession session = request.getSession(true);
        String username = (String) session.getAttribute("username");
        Jdbc Jbean = new Jdbc();

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
        String qry;
        String msg;
        
        switch (id) {
            case "/Front":
                include = "loginPage.jsp";
                break;
                
            case "/docs/index":
                include = "index.jsp";
                break;
                
            case "/docs/listAllMembers":
                qry = "select * from members";
                msg = Jbean.retrieve(qry);   
                request.setAttribute("query", msg);
                include = "listAllMembers.jsp";
                break;
                
            case "/docs/listClaims":
                include = "listClaims.jsp";
                break;
                
            case "/docs/listOutstandingBalances":
                include = "listOutstandingBalances.jsp";
                break;
                
            case "/docs/listProvApps":
                qry = "select * from members";
                msg = Jbean.retrieve(qry);   
                request.setAttribute("query", msg);
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
            
            case "/docs/listPaymentsMade":
                include = "listPaymentsMade.jsp";
            break;
            
            case "/docs/registrationSuccessful":
                include = "registrationSuccessful.jsp";
            break;
            
            case "/docs/paymentSuccessful":
                include = "paymentSuccessful.jsp";
            break;
                        
            case "/docs/calculateAnnualCharge":
                include = "calculateAnnualCharge.jsp";
            break;
            
            case "/docs/changesMade":
                include = "changesMade.jsp";
            break;
            
            case "/docs/claimSubmitted":
                include = "claimSubmitted.jsp";
            break;
            
            case "/docs/chargeSubFee":
                include = "chargeSubFee.jsp";
            break;
        }

        request.setAttribute("pagee", include);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
