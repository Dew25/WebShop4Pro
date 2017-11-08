/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import entity.Product;
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
import secure.RoleEnum;

import session.ProductFacade;
import session.UserFacade;

/**
 *
 * @author Melnikov
 */
public class AdminCommand implements ActionCommand {
    private UserFacade userFacade;
    
    public AdminCommand() {
        Context context;
        try {
            context = new InitialContext();
            this.userFacade = (UserFacade) context.lookup("java:module/UserFacade");
        } catch (NamingException ex) {
            Logger.getLogger(AdminCommand.class.getName()).log(Level.SEVERE,"Не удалось найти сессионный бин", ex);
        }
    }

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        RoleEnum role = RoleEnum.ADMIN;
        boolean isAuth = session.getAttribute("regUser") != null;
        List<User> users = userFacade.findAll();
        request.setAttribute("users", users);
        request.setAttribute("roles", RoleEnum.values());
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
        String page;
        if(!isAuth){
            page = resourceBundle.getString("page.login");  
        }else{
            page = resourceBundle.getString("page.admin");
        }
        
        return page;
    }
    
}
