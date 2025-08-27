import java.util.Stack;

class Solution {
    class Node {
        int value;
        int cost;
        Node(int value, int cost) {
            this.value = value;
            this.cost = cost;
        }
    }

    public int minOperationsToFlip(String expression) {
        Stack<Object> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == '(') {
                stack.push('(');
            } else if (c == '&' || c == '|') {
                stack.push(c);
            } else if (c == ')') {
                Node node = (Node) stack.pop();
                stack.pop(); // pop the '('
                while (!stack.isEmpty() && stack.peek() instanceof Character && (char) stack.peek() != '(') {
                    char op = (Character) stack.pop();
                    Node left = (Node) stack.pop();
                    node = combine(left, op, node);
                }
                stack.push(node);
            } else {
                Node node = new Node(c - '0', 1);
                while (!stack.isEmpty() && stack.peek() instanceof Character && (char) stack.peek() != '(') {
                    char op = (Character) stack.pop();
                    Node left = (Node) stack.pop();
                    node = combine(left, op, node);
                }
                stack.push(node);
            }
        }
        return ((Node) stack.pop()).cost;
    }

    private Node combine(Node left, char op, Node right) {
        if (op == '&') {
            if (left.value == 1 && right.value == 1) {
                return new Node(1, Math.min(left.cost, right.cost));
            } else if (left.value == 1 && right.value == 0) {
                return new Node(0, Math.min(right.cost, 1));
            } else if (left.value == 0 && right.value == 1) {
                return new Node(0, Math.min(left.cost, 1));
            } else {
                return new Node(0, Math.min(left.cost + right.cost, 1 + Math.min(left.cost, right.cost)));
            }
        } else {
            if (left.value == 0 && right.value == 0) {
                return new Node(0, Math.min(left.cost, right.cost));
            } else if (left.value == 0 && right.value == 1) {
                return new Node(1, Math.min(right.cost, 1));
            } else if (left.value == 1 && right.value == 0) {
                return new Node(1, Math.min(left.cost, 1));
            } else {
                return new Node(1, Math.min(left.cost + right.cost, 1 + Math.min(left.cost, right.cost)));
            }
        }
    }
}