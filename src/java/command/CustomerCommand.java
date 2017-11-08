/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import classes.RoleContains;
import entity.Customer;
import entity.Role;
import entity.User;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import session.CustomerFacade;
import session.RoleFacade;


/**
 *
 * @author Melnikov
 */
public class CustomerCommand implements ActionCommand {
    private CustomerFacade customerFacade;
    private RoleFacade roleFacade;
    public CustomerCommand() {
        Context context;
        try {
            context = new InitialContext();
            this.customerFacade = (CustomerFacade) context.lookup("java:module/CustomerFacade");
            this.roleFacade = (RoleFacade) context.lookup("java:module/RoleFacade");
        } catch (NamingException ex) {
            Logger.getLogger(CustomerCommand.class.getName()).log(Level.SEVERE,"Не удалось найти сессионный бин", ex);
        }
    }

    @Override
    public String execute(HttpServletRequest request) {
        //Доступ к странице ограничен ролью ADMIN
        HttpSession session = request.getSession(false);
        User regUser = null;
        boolean isAuth = session.getAttribute("regUser") != null;
        boolean isRole = false;
        if(isAuth){
            regUser = (User) session.getAttribute("regUser");
            RoleContains rc = new RoleContains();
            isRole=rc.contains("ADMIN", regUser) || rc.contains("USER", regUser);
        }
        
        List<Customer> customers = customerFacade.findAll();
        request.setAttribute("customers", customers);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
       
        String page = null;
        if(isRole==false){
           request.setAttribute("error", "Для входа требуется доступ разрешенного уровня");
           return page = resourceBundle.getString("page.login");
        }
        return page = resourceBundle.getString("page.customer");
                     

    }
    
}
