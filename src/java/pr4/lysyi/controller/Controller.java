package pr4.lysyi.controller;

import pr4.lysyi.contoller.logic.ActionCommand;
import pr4.lysyi.contoller.logic.ActionFactory;
import pr4.lysyi.resources.ConfigurationManager;
import pr4.lysyi.resources.MessageManager;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lysyi Andrii
 */
//@WebServlet(name = "Controller", urlPatterns = {"/controller"} )
@WebServlet("/controller")
public class Controller extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            processRequest(request, response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            processRequest(request, response);
        }

        private void processRequest(HttpServletRequest request,
                HttpServletResponse response)
                throws ServletException, IOException {
            String page = null;
            // определение команды, пришедшей из JSP
            ActionFactory client = new ActionFactory();
            ActionCommand command = client.defineCommand(request);
            /*
             * вызов реализованного метода execute() и передача параметров
             * классу-обработчику конкретной команды
             */
            page = command.execute(request);
            // метод возвращает страницу ответа
//             page = null; // поэксперементировать!
            if (page != null) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            // вызов страницы ответа на запрос
                dispatcher.forward(request, response);
            } else {
            // установка страницы c cообщением об ошибке
                page = ConfigurationManager.getProperty(ConfigurationManager.LOGIN);
                request.getSession().setAttribute("nullPage",
                        MessageManager.getProperty("message.nullpage"));
                response.sendRedirect(request.getContextPath() + page);
            }
        }
    }

//@WebServlet ("/Controller")
//public class Controller extends HttpServlet {
//
////
////     <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
// 
//    private void processRequest(HttpServletRequest request,
//            HttpServletResponse response)
//            throws ServletException, IOException {
//        String page = null;
//// определение команды, пришедшей из JSP
//        ActionFactory client = new ActionFactory();
//        ActionCommand command = client.defineCommand(request);
//        /*
//         * вызов реализованного метода execute() и передача параметров
//         * классу-обработчику конкретной команды
//         */
//        page = command.execute(request);
//// метод возвращает страницу ответа
// page = null; // поэксперементировать!
//        if (page != null) {
////            System.out.println("111");
//            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
//// вызов страницы ответа на запрос
//            dispatcher.forward(request, response);
//        } else {
//// установка страницы c cообщением об ошибке
//            page = ConfigurationManager.getProperty("path.page.index");
//            request.getSession().setAttribute("nullpage",
//                    MessageManager.getProperty("message.nullpage"));
//            response.sendRedirect(request.getContextPath() + page);
//        }
//    }
//
//}
