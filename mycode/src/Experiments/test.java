package Experiments;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Stack;

public class test {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < 7; ++i) {
            s.push(i);
        }
        for(int i: s) {
            System.out.println(i);
        }
    }
}
