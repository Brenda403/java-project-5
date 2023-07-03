import java.util.Stack;
import java.util.HashMap;

public class BalancedBrackets {

    public static boolean balancedParentheses(String s) {
        int numUnclosedOpenParens = 0;
        for (int i = 0; i < s.length(); i += 1) {
            if (s.charAt(i) == '(') {
                numUnclosedOpenParens += 1;
            }
            else if (s.charAt(i) == ')') {
                numUnclosedOpenParens -= 1;
            }

            if (numUnclosedOpenParens < 0) {
                return false;
            }
        }

        return numUnclosedOpenParens == 0;
    }

    public static boolean balancedBrackets(String s) {

        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> bracketPairs = new HashMap<Character, Character>();
        bracketPairs.put(')', '(');
        bracketPairs.put(']', '[');
        bracketPairs.put('}', '{');
        bracketPairs.put('>', '<');

        for (int i = 0; i < s.length(); i += 1) {

            // If character is opening bracket
            if (bracketPairs.containsValue(s.charAt(i))) {
                stack.push(s.charAt(i));
            }
            // Else, if character is closing bracket
            else if (bracketPairs.containsKey(s.charAt(i))) {
                // Closing bracket without matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }
                // Check that most recent bracket on stack matches
                Character mostRecentBracket = stack.pop();
                if (!mostRecentBracket.equals(bracketPairs.get(s.charAt(i)))) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {


        String balancedParens = "(1)";
        String tooManyOpenParens = "((1";
        String tooManyOpenParens1 = "(1)(";
        String tooManyClosedParens = "(1))";
        String startClosedParens = ")(";
        String emptyString = "";

        System.out.println("Balanced Parantheses Testing: TTFFFF");
        System.out.println(balancedParentheses(balancedParens));
        System.out.println(balancedParentheses(emptyString));
        System.out.println(balancedParentheses(tooManyOpenParens));
        System.out.println(balancedParentheses(tooManyOpenParens1));
        System.out.println(balancedParentheses(tooManyClosedParens));
        System.out.println(balancedParentheses(startClosedParens));

        String balancedAngleBrackets = "<<>>";
        String balancedComboBrackets = "<({})>";
        String mismatchedBrackets = "<({)}>";

        System.out.println("Balanced Brackets Testing: TTFFFFTTF");
        System.out.println(balancedBrackets(emptyString));
        System.out.println(balancedBrackets(balancedParens));
        System.out.println(balancedBrackets(tooManyOpenParens));
        System.out.println(balancedBrackets(tooManyOpenParens1));
        System.out.println(balancedBrackets(tooManyClosedParens));
        System.out.println(balancedBrackets(startClosedParens));
        System.out.println(balancedBrackets(balancedAngleBrackets));
        System.out.println(balancedBrackets(balancedComboBrackets));
        System.out.println(balancedBrackets(mismatchedBrackets));


        MissingNumber mn = new MissingNumber();
        int[] missingMax = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println(mn.missingNumber(missingMax, 10));
    }


//    public static boolean hasBalancedBrackets(String input) {
//        Stack<Character> stack = new Stack<>();
//
//        for (char c : input.toCharArray()) {
//            if (isOpenBracket(c)) {
//                stack.push(c);
//            } else if (isCloseBracket(c)) {
//                if (stack.isEmpty() || !isMatchingBracket(stack.peek(), c)) {
//                    return false;
//                }
//                stack.pop();
//            }
//        }
//
//        return stack.isEmpty();
//    }
//
//    private static boolean isOpenBracket(char c) {
//        return c == '(' || c == '{' || c == '[' || c == '<';
//    }
//
//    private static boolean isCloseBracket(char c) {
//        return c == ')' || c == '}' || c == ']' || c == '>';
//    }
//
//    private static boolean isMatchingBracket(char open, char close) {
//        return (open == '(' && close == ')') ||
//                (open == '{' && close == '}') ||
//                (open == '[' && close == ']') ||
//                (open == '<' && close == '>');
//    }
//
//    public static void main(String[] args) {
//        String input1 = "{[()]<>}";
//        String input2 = "({[}])";
//
//        boolean result1 = hasBalancedBrackets(input1);
//        boolean result2 = hasBalancedBrackets(input2);
//
//        System.out.println("Input 1 has balanced brackets: " + result1);
//        System.out.println("Input 2 has balanced brackets: " + result2);
//    }



}
