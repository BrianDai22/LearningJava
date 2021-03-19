package SatAndWedClass20182020;

import java.util.Stack;

public class MinStack {
    // Initialize your data structure here.

    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();

    public void push(int x) {
        if(x <= min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.pop() == min) {
            min=stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack155 = new MinStack();
        minStack155.push(-2);
        minStack155.push(0);
        minStack155.push(-3);
        minStack155.push(4);
        System.out.println(minStack155.getMin());
        minStack155.pop();
        minStack155.top();
        System.out.println(minStack155.getMin());
    }
}
/*

        Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

        push(x) -- Push element x onto stack.
        pop() -- Removes the element on top of the stack.
        top() -- Get the top element.
        getMin() -- Retrieve the minimum element in the stack.


        Example 1:

        WednesdayClass.MinStack minStack = new WednesdayClass.MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2


        Constraints:

        Methods pop, top and getMin operations will always be called on non-empty stacks.
*/
