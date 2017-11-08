/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import command.ProductCommand;
import command.login.CheckLoginCommand;
import entity.Customer;
import entity.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import session.CustomerFacade;
import session.UserFacade;

/**
 *
 * @author Melnikov
 */
public class NewUser {
    private UserFacade userFacade;
    private CustomerFacade customerFacade;
    private HttpServletRequest request;
    private String name;
    private String surname;
    private String tel;
    private String city;
    private String money;
    private String login;
    private String password1;
    private String password2;

    public NewUser(HttpServletRequest request) {
        this.name = request.getParameter("name");
        this.surname = request.getParameter("surname");
        this.tel = request.getParameter("tel");
        this.city = request.getParameter("city");
        this.money = request.getParameter("money");
        this.login = request.getParameter("login");
        this.password1 = request.getParameter("password1");
        this.password2 = request.getParameter("password2");
        
        Context context; 
        try {
            context = new InitialContext();
            this.userFacade = (UserFacade) context.lookup("java:module/UserFacade");
            this.customerFacade = (CustomerFacade) context.lookup("java:module/CustomerFacade");
        } catch (NamingException ex) {
            Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, "Не удалось найти сессионый бин", ex);
        }
    }
    public boolean addNewUser(){
        if(!password1.equals(password2)){
            return false;
        }
        Customer newCustomer = new Customer(name, surname, new Long(money), tel, city);
        User newUser = new User(login, password2, newCustomer);
        try {
            customerFacade.create(newCustomer);
            userFacade.create(newUser);
            return true;
        } catch (Exception e) {
             Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE,"Ошибка создания пользователя", e);
            return false;
        }
    }
    
}
