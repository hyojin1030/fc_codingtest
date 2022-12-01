package data_structure;

import java.util.ArrayList;

public class Stack<T> {
    private ArrayList<T> stack = new ArrayList<>();

    private void push(T item) {
        stack.add(item);
    }

    private T pop() {
        if (stack.isEmpty()) return null;
        return stack.remove(stack.size() - 1);
    }

    private boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.isEmpty());
    }
}
