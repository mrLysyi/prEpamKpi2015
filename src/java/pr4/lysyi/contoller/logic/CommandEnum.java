package pr4.lysyi.contoller.logic;

import pr4.lysyi.command.autorization.LoginCommand;
import pr4.lysyi.command.autorization.LogoutCommand;
import pr4.lysyi.command.autorization.RegistrationCommand;
import pr4.lysyi.command.user.AddFacultetUser;
import pr4.lysyi.command.user.AdminCommand;
import pr4.lysyi.command.user.UserCommand;
import pr4.lysyi.contoller.logic.ActionCommand;

/**
 *
 * @author Lysyi Andrii
 */
public enum CommandEnum {

    LOGIN {
                {
                    this.command = new LoginCommand();
                }
            },
    LOGOUT {
                {
                    this.command = new LogoutCommand();
                }
            },
    REGISTRATION {

                {
                    this.command = new RegistrationCommand();
                }
            },
    USER {
                {
                    this.command = new UserCommand();
                }

            },
    ADMIN {

                {
                    this.command = new AdminCommand();
                }
            },
    ADD_FACULTET_USER {
                {
                    this.command = new AddFacultetUser();
                }
            };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
