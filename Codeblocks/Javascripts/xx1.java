package Javascripts;

import java.io.*;

public class xx1 {
    static int counter = 0;

    public static void main(String[] args) throws IOException {
        System.out.println("OUTPUT: ");
        int size = 15;
        int direction = 1;
        String pattern = "#";
        System.out.println(pattern(pattern, size, 1, "", direction) + "\n" + pattern(pattern, size, 1, " ", -1));
    }

    static String pattern(String pat, int size, int i, String space, int direction) {
        if (direction == -1) {
            if (size <= 0)
                return "";
            else if (i > size) {
                return "\n" + space + pattern(pat, size - 2, 1, space + " ", direction);
            }
            return pat + pattern(pat, size, i + 1, space, direction);
        } else {
            if (size <= 0)
                return "";
            else if (i > size) {
                return pattern(pat, size - 2, 1, space + " ", direction) + "\n" + space;
            }
            return pattern(pat, size, i + 1, space, direction) + pat;
        }
    }
}