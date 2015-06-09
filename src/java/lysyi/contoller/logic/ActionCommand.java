
package lysyi.contoller.logic;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Lysyi Andrii
 */
public interface ActionCommand {
    String execute (HttpServletRequest request);
}
