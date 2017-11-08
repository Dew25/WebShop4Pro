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
public class EmptyCommand implements ActionCommand{

    @Override
    public String execute(HttpServletRequest request) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
        String page = resourceBundle.getString("page.index");
        return page;
    }
    
}
