/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import command.ActionCommand;
import command.CommandEnum;
import command.EmptyCommand;
import command.ErrorCommand;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Melnikov
 */
public class ActionFactory {

    public ActionFactory() {
    }
    public ActionCommand defineCommand(String command){
        ActionCommand current = new EmptyCommand();
        
        if(command == null || command.isEmpty()){
            return current;
        }
        try {
            CommandEnum commandEnum = CommandEnum.valueOf(command.toUpperCase());
            current = commandEnum.getCurrentCommand();
            return current;
        } catch (Exception e) {
            return current = new ErrorCommand();
        }
        
    }
}
