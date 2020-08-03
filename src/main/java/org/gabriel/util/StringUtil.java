package org.gabriel.util;

/**
 * @author daohn on 02/08/2020
 * @project ExercicioMapeamentoJPA
 */
public class StringUtil {
    public static String center(String str, int line) {
        var isEven = line - str.length() % 2 == 0;
        int pad = Math.round((line - str.length()) / 2);
        int padIfOdd = line - (str.length() + pad);
        return " ".repeat(pad) + str + (isEven ? " ".repeat(pad) : " ".repeat(padIfOdd));
    }
}
