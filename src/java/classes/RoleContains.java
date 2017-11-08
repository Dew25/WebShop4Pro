/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import command.CustomerCommand;
import entity.Role;
import entity.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import session.CustomerFacade;
import session.RoleFacade;

/**
 *
 * @author Melnikov
 */
public class RoleContains {
    private RoleFacade roleFacade;
    public RoleContains() {
        Context context;
        try {
            context = new InitialContext();
            this.roleFacade = (RoleFacade) context.lookup("java:module/RoleFacade");
        } catch (NamingException ex) {
            Logger.getLogger(RoleContains.class.getName()).log(Level.SEVERE,"Не удалось найти сессионный бин", ex);
        }
    }
    public boolean contains(String role, User regUser){
        List<Role> roles = roleFacade.findUserRole(regUser);
        for (int i = 0; i < roles.size(); i++) {
            Role get = roles.get(i);
            if(role.equals(get.getRole())){
                return true;
            }
        }
        return false;
        
    }
    
}
