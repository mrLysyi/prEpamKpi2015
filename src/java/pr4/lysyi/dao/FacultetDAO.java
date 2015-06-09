/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr4.lysyi.dao;

import pr4.lysyi.dto.Facultet;

/**
 *
 * @author Lysyi Andrii
 */
public abstract class FacultetDAO extends AbstractDAO<Integer, Facultet> {

    /**
     *
     * @param name
     * @return
     */
    public abstract Facultet read(String name);
    public abstract boolean setExamNames(String facultetName, String examNames);
     public abstract String getExamNames (String facultetName);
}
