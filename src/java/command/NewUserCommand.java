/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import classes.NewUser;
import java.util.ResourceBundle;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Melnikov
 */
public class NewUserCommand implements ActionCommand{

    @Override
    public String execute(HttpServletRequest request) {
        NewUser newUser = new NewUser(request);
        if(newUser.addNewUser()){
            request.setAttribute("info", "Новый пользователь добавлен");
        }else{
            request.setAttribute("info", "Добавить вользователя не удалось!");
        }
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");
        String page = resourceBundle.getString("page.index");
        return page;
    }
    
}
