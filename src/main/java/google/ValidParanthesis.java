package google;

import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args) {
//        System.out.println(isValid("()"));
//        System.out.println(isValid("{()"));
//        System.out.println(isValid("{()}"));
        System.out.println(isValid("]"));
    }

    public static boolean isValid(String str){

        Stack<Character> stack = new Stack();

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='(' || str.charAt(i)=='{' || str.charAt(i)=='[')
                stack.push(str.charAt(i));
            else if (str.charAt(i)==')' || str.charAt(i)=='}' || str.charAt(i)==']'){
                switch (str.charAt(i)){
                    case ')':
                        if(!stack.isEmpty() && stack.peek()=='('){
                            stack.pop();
                        }else return false;
                        break;
                    case '}':
                        if(!stack.isEmpty() && stack.peek()=='{'){
                            stack.pop();
                        }else return false;
                        break;
                    case ']':
                        if(!stack.isEmpty() && stack.peek()=='['){
                            stack.pop();
                        }else return false;
                        break;
                }
            }
                else{
                return false;
                }
            }
            return stack.isEmpty();
        }
    }
