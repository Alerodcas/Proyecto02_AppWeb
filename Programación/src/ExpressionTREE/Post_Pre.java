package ExpressionTREE;

import com.sun.source.tree.Tree;

import java.util.Stack;

public class Post_Pre {
    // Java Program to convert postfix to prefix
    public class PostFixToPreFix {

        static boolean isOperator(char x){
            switch (x){
                case '-':
                case '+':
                case '/':
                case '*':
                case '^':
                    return true;
            }
            return false;
        }
        public static String convert(String expression){

            Stack<String> stack = new Stack<>();
            for (int i = 0; i <expression.length() ; i++) {

                char c = expression.charAt(i);

                if(isOperator(c)){
                    String s1 = stack.pop();
                    String s2 = stack.pop();
                    String temp = c + s2 + s1;
                    stack.push(temp);
                }else{
                    stack.push(c+"");
                }
            }
            String result = stack.pop();
            return result;
        }
    }

    public static void main(String[] args) {
        String postfix = "793/5*+82/-62/5*+";
        System.out.println("Postfix Expression: " + postfix);
        String prefix = PostFixToPreFix.convert(postfix);
        System.out.println("Prefix Expression: " + prefix);

        ExpressionTree.main(prefix);
    }
}
