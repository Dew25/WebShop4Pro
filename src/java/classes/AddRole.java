/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Role;
import entity.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import session.RoleFacade;
import session.UserFacade;

/**
 *
 * @author Melnikov
 */
public class AddRole {
    private String role;
    private String userId;
    private RoleFacade roleFacade;
    private UserFacade userFacade;

    public AddRole(String role, String userId) {
        
        this.role = role;
        this.userId = userId;
        
        Context context;
        try {
            context = new InitialContext();
            this.roleFacade = (RoleFacade) context.lookup("java:module/RoleFacade");
            this.userFacade = (UserFacade) context.lookup("java:module/UserFacade");
        } catch (NamingException ex) {
            Logger.getLogger(AddRole.class.getName()).log(Level.SEVERE,"Не удалось найти сессионный бин", ex);
        }
        
    }
    
    public boolean add(){
        if(this.userId == null || this.role == null || this.userId.isEmpty() || this.role.isEmpty()) {return false;}
        User user = userFacade.find(new Long(this.userId));
        RoleContains rc = new RoleContains();
        if(rc.contains(role, user)){ return false; }
        Role newRole= null;
        if("ADMIN".equals(role)){
            newRole = new Role(user, "ADMIN");
            roleFacade.create(newRole);
            newRole = new Role(user, "USER");
            roleFacade.create(newRole);
        }
        if("USER".equals(role)){
            newRole = new Role(user, "USER");
            roleFacade.create(newRole);
        }
        return true;
    }
}
