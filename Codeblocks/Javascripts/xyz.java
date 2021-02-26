package Javascripts;

import java.io.*;
import java.util.*;

public class xyz {
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader x = new BufferedReader(new InputStreamReader(System.in));
        // String input=x.readLine();

        String input = "abc";

        char inp[] = input.toCharArray();
        answer(inp, 0, "");
    }

    static void answer(char[] arr, int index, String ans) {
        if (ans.length() == arr.length) {
            System.out.println(count + ": " + ans);
            ++count;
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            answer(arr, index + 1, ans + arr[index]);
            swap(arr, i, index);
        }
    }

    static void swap(char[] arr, int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}