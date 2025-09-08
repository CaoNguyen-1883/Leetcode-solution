
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        char stack[] = new char[s.length()];
        int ptr = 0;

        for(char c : s.toCharArray()){
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack[ptr++] = c;
                    break;
                case ')':
                    if(ptr == 0 || stack[--ptr] != '(') return false;
                    break;
                case ']':
                    if(ptr == 0 || stack[--ptr] != '[') return false;
                    break;
                case '}':
                    if(ptr == 0 || stack[--ptr] != '{') return false;
                    break;
            }
        }

        return ptr == 0;
    }
    public boolean isValid_old(String s) {
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        stack.add('.');

        for(char c : s.toCharArray()){
            switch (c) {
                case '[':
                    stack.add(']');
                    break;
                case '(':
                    stack.add(')');
                    break;
                case '{':
                    stack.add('}');
                    break;
                default:
                    char st = stack.pop();
                    System.out.println(c + " " + st);

                    if(st != c) return false;
                    break;
            }
        }

        if(stack.size() > 1) return false;


        return true;
    }
}