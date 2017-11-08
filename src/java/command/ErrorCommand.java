/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import java.util.ResourceBundle;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Melnikov
 */
public class ErrorCommand implements ActionCommand{

    @Override
    public String execute(HttpServletRequest request) {
        
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
        String page = resourceBundle.getString("page.error");
        request.setAttribute("error", "Такой странички не существует");
        return page;
    }
    
}
