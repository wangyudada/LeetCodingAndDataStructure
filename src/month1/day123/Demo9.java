package month1.day123;

public class Demo9 {
    public static String isValid(String expStr) {
        LinkedStack<String> stack = new LinkedStack<>();
        int i = 0;
        while (i < expStr.length()) {
            char c = expStr.charAt(i);
            i++;
            switch (c) {
                case '(':
                    stack.push(c + "");
                    break;
                case ')':
                    if (stack.isEmpty() || !stack.pop().equals("(")) {
                        return ")";
                    }
            }
        }
        if (stack.isEmpty()) {
            return "pass";
        } else {
            return "exception";
        }
    }

    public static void main(String[] args) {
        String str = "1+3*(9-2)+9";
        System.out.println(str + "  " + isValid(str));
    }
}
