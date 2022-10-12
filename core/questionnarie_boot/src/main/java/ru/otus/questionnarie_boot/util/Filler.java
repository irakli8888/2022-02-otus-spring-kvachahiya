package ru.otus.questionnarie_boot.util;

import java.util.List;

/**
 * @author IrklKvch
 */
public interface Filler <T>{

    public List<T> fill(String [] questStr);
}
