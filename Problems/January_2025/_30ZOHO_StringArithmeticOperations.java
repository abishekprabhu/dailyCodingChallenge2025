/*  
 * You are given a string expression that contains only digits and the +, -, *, / operators. Evaluate the expression and return the result. You may assume that the expression contains no parentheses.
 * don't use any inbuilt functions
 * Example 1:
 */ //Input : String str = "12345+-*/"
/*Output : 1 
Explanation : 1 + 2 - 3 * 4 / 5 = 1
 * Example 2:
 * Input : String str = "123+*8-"
 * Output : -3
 * Explanation : 1 + 2 * 3 - 8 = -3
 * 
 */

//  public class _30ZOHO_StringArithmeticOperations {
//     public static void main(String[] args) {
//         String str = "12345+-*/";
//         System.out.println(evaluateExpression(str));
//         str = "123+*8-";
//         System.out.println(evaluateExpression(str));
//     }

//     public static int evaluateExpression(String str) {
//         int num1 = 0;
//         int num2 = 0;
//         int res = 0;
//         char op = '+';
//         for (int i = 0; i < str.length(); i++) {
//             if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/') {
//                 op = str.charAt(i);
//             } else {
//                 if (op == '+') {
//                     num1 = num1 * 10 + (str.charAt(i) - '0');
//                 } else if (op == '-') {
//                     num2 = num2 * 10 + (str.charAt(i) - '0');  
//                 } else if (op == '*') {
//                     num1 = num1 * (str.charAt(i) - '0');
//                 } else if (op == '/') {
//                     num2 = num2 / (str.charAt(i) - '0');
//                 }
//             }
//         }
//         if (op == '+') {
//             res = num1 + num2;
//         } else if (op == '-') {
//             res = num1 - num2;
//         } else if (op == '*') {
//             res = num1 * num2;
//         } else if (op == '/') {
//             res = num1 / num2;
//         }
//         return res;
//         }
//  }

 // Time Complexity: O(n)
// Space Complexity: O(1)

// Output:
// 1
// -3

//try with stack 

import java.util.Stack;

public class _30ZOHO_StringArithmeticOperations {
    public static int evaluatePostfix(String str) {
        Stack<Integer> stack = new Stack<>();
        
        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(ch - '0'); // Convert character to integer 48 - '0' = 0, 49 - '0' = 1, ..., 57 - '0' = 9
            } else {
                // Pop two elements from the stack
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid Expression");
                }
                int b = stack.pop(); // Second operand
                int a = stack.pop(); // First operand
                
                switch (ch) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': 
                        if (b == 0) throw new ArithmeticException("Division by zero");
                        stack.push(a / b); // Integer division
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid Operator: " + ch);
                }
            }
        }
        
        // The final result should be the only value in the stack
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid Expression");
        }
        
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evaluatePostfix("12345+-*/")); // Output: 1
        System.out.println(evaluatePostfix("123+*8-"));   // Output: -3
    }
}
