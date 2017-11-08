/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import command.login.CheckLoginCommand;
import command.login.LoginFormCommand;
import command.login.LogoutCommand;
import command.login.RegistrationCommand;

/**
 *
 * @author Melnikov
 */
public enum CommandEnum {
    PRODUCT{{this.command = new ProductCommand();}},
    CUSTOMER{{this.command = new CustomerCommand();}},
    LOGIN{{this.command = new LoginFormCommand();}},
    LOGOUT{{this.command = new LogoutCommand();}},
    CHECKLOGIN{{this.command = new CheckLoginCommand();}},
    REGISTRATION{{this.command = new RegistrationCommand();}},
    ADMIN{{this.command = new AdminCommand();}},
    ADDNEWUSER{{this.command = new NewUserCommand();}};
    
    ActionCommand command;
    
    public ActionCommand getCurrentCommand(){
        return this.command;
    }
}
