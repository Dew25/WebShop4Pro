/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import entity.Product;
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

/**
 *
 * @author Melnikov
 */
public class ProductCommand implements ActionCommand {
    private ProductFacade productFacade;
    
    public ProductCommand() {
        Context context;
        try {
            context = new InitialContext();
            this.productFacade = (ProductFacade) context.lookup("java:module/ProductFacade");
        } catch (NamingException ex) {
            Logger.getLogger(ProductCommand.class.getName()).log(Level.SEVERE,"Не удалось найти сессионный бин", ex);
        }
    }

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        RoleEnum role = RoleEnum.ADMIN;
        boolean isAuth = session.getAttribute("regUser") != null;
        List<Product>products = productFacade.findAll();
        request.setAttribute("products", products);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
        String page;
        if(!isAuth){
            page = resourceBundle.getString("page.login");  
        }else{
            page = resourceBundle.getString("page.product");
        }
        
        return page;
    }
    
}
