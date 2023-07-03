public class BalancedParenthesis {

    public static boolean BalancedParentheses(String input) {
        int count = 0;

        for (char c : input.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }

    public static void main(String[] args) {
        String input1 = "((())())";
        String input2 = "(()))(";

        boolean result1 = BalancedParentheses(input1);
        boolean result2 = BalancedParentheses(input2);

        System.out.println("Input 1 has balanced parentheses: " + result1);
        System.out.println("Input 2 has balanced parentheses: " + result2);
    }



}
