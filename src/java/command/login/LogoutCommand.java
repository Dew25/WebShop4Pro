/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.login;

import command.ActionCommand;
import java.util.ResourceBundle;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Melnikov
 */
public class LogoutCommand  implements ActionCommand  {
   
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
        request.setAttribute("info", "Вы вышли");
        String page = resourceBundle.getString("page.index");
        return page;
            
    }
    
}
