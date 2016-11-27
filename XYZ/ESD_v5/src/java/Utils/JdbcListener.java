package Utils;

import Models.Jdbc;
import java.sql.Connection;
import javax.servlet.*;
import javax.servlet.http.*;


/**
 *
 *
 * @author RickyL
 */
public class JdbcListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String url = context.getInitParameter("url");
        Jdbc db = new Jdbc();
        Connection con
                = db.makeConnection(url);
        context.setAttribute("Database", con);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("A session is created");
        }    
    

    public void sessionDestroyed(HttpSessionEvent se) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
