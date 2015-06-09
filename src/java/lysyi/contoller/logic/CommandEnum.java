package lysyi.contoller.logic;

import lysyi.command.autorization.LoginCommand;
import lysyi.command.autorization.LogoutCommand;
import lysyi.command.autorization.RegistrationCommand;
import lysyi.command.user.AddFacultetUser;
import lysyi.command.user.AdminCommand;
import lysyi.command.user.UserCommand;
import lysyi.contoller.logic.ActionCommand;

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
