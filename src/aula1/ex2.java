package aula1;

import java.util.Stack;

public class ex2 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        String[] arg = args[0].replace('\"',' ').trim().split(" ");
        for (var item : arg) {
            if (item.equals("+"))
                stack.push(stack.pop() + stack.pop());
            else if (item.equals("/"))
                stack.push(stack.pop() / stack.pop());
            else if (item.equals("*"))
                stack.push(stack.pop() * stack.pop());
            else if (item.equals("-"))
                stack.push(stack.pop() - stack.pop());
            else
                stack.push(Integer.parseInt(item));
            System.out.println(stack);

        }
        System.out.println(stack.pop());
    }
}
