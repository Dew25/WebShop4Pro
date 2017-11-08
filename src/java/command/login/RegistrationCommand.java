/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.login;

import command.ActionCommand;
import java.util.ResourceBundle;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Melnikov
 */
public class RegistrationCommand implements ActionCommand  {

    @Override
    public String execute(HttpServletRequest request) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
        String page = resourceBundle.getString("page.registration");
        return page;
    }
    
}
