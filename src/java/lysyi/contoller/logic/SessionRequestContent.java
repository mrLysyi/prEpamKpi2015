/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lysyi.contoller.logic;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Lysyi Andrii
 */
public class SessionRequestContent {

    private HashMap<String, Object> requestAttributes;
    private HashMap<String, String[]> requestParameters;
    private HashMap<String, Object> sessionAttributes;
// конструкторы
// метод извлечения информации из запроса

    public void extractValues(HttpServletRequest request) {
// реализация
    }
// метод добавления в запрос данных для передачи в jsp

    public void insertAttributes(HttpServletRequest request) {
// реализация
    }
// some methods
}

