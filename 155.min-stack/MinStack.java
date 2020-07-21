import java.util.Stack;

/**
https://leetcode.com/problems/min-stack/

Design a stack that supports push, pop, top, and retrieving the minimum
element in constant time.

- push(x) -- push element x onto stack
- pop() -- removes the element on top of the stack
- top() -- get the top element
- getMin() -- retrieve the minimum element in the stack

Constraints:
- Methods pop, top, and getMin will always be called on non-empty stacks
*/

public class MinStack {

    // My first attempt invovled having both a stack and a priority queue.
    // The PQ took in all the elements the stack did, but stored them in
    // ascending order so as to easily pull the min. This however requires
    // at worst O(n) inserts (push) and removals (pop).

    // I realized I may have misunderstood the question, maybe the problem
    // description meant that only the retrieval of the min needed to be done
    // in constant time, rather than all the operations.

    // My second idea was to keep track of the min while adding new elements,
    // but was unsure how to update the min on removals (ie: the min value
    // is removed via pop(), how do I know what the next min val is?). The
    // clever solution involves pushing extra copies of the min (when min is
    // updated on insert) onto the stack such that when the last min is removed
    // you can pop again to get the next min. You can also just use a second
    // stack for only keeping track of mins.

    // One edge case: if the min is added multiple times, still need to add the
    // extra copy (ie: on push(), if x <= this.min, push extra min copy).

    private Stack<Integer> stack;
    private Stack<Integer> mins;

    public MinStack() {
        stack = new Stack<>();
        mins = new Stack<>();
    }

    public void push(int x) {
        if (mins.empty() || x <= mins.peek()) {
            mins.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop().equals(mins.peek())) {
            mins.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return mins.peek();
    }
}