package month1.day123;

public class CalculateExpression {
    /**
     * 中缀表达式转后缀表达式
     *
     * @param expStr
     * @return
     */
    public static String toPostfix(String expStr) {
        SeqStack<String> seqStack = new SeqStack<>(expStr.length());
        //用于存储后缀表达式的字符串str
        String str = "";
        int i = 0;
        while (i < expStr.length()) {
            char ch = expStr.charAt(i);
            switch (ch) {
                case '+':
                case '-':
                    while (!seqStack.isEmpty() && !seqStack.peek().equals("(")) {
                        str += seqStack.pop();
                    }
                    seqStack.push(ch + "");
                    i++;
                    break;
                case '*':
                case '/':
                    while (!seqStack.isEmpty() && (seqStack.peek().equals("*") || seqStack.peek().equals("/"))) {
                        str += seqStack.pop();
                    }
                    seqStack.push(ch + "");
                    i++;
                    break;
                case '(':
                    seqStack.push(ch + "");
                    i++;
                    break;
                case ')':
                    String pop = seqStack.pop();
                    while (pop != null && !pop.equals("(")) {
                        str += pop;
                        pop = seqStack.pop();
                    }
                    i++;
                    break;
                default:
                    while (ch >= '0' && ch <= '9') {
                        str += ch;
                        i++;
                        if (i < expStr.length()) {
                            ch = expStr.charAt(i);
                        } else {
                            ch = '=';
                        }
                    }
                    str += " ";
                    break;
            }
        }
        while (!seqStack.isEmpty()) {
            str += seqStack.pop();
        }
        return str;
    }

    /**
     * 计算后缀表达式的值
     *
     * @param str
     * @return
     */
    public static int calculatePostfixValue(String str) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        int i = 0;
        int result = 0;
        while (i < str.length()) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9') {
                result = 0;
                while (ch != ' ') {
                    result = result * 10 + Integer.parseInt(ch + "");
                    i++;
                    ch = str.charAt(i);
                }
                i++;
                stack.push(result);
            } else {
                int y = stack.pop();
                int x = stack.pop();
                switch (ch) {
                    case '+':
                        result = x + y;
                        break;
                    case '-':
                        result = x - y;
                        break;
                    case '*':
                        result = x * y;
                        break;
                    case '/':
                        result = x / y;
                        break;
                }
                stack.push(result);
                i++;
            }
        }

        return stack.pop();
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String args[]) {
        String expstr = "1+3*(9-2)+90";
        String postfix = toPostfix(expstr);
        System.out.println("中缀表达式->expstr=  " + expstr);
        System.out.println("后缀表达式->postfix= " + postfix);
        System.out.println("计算结果->value= " + calculatePostfixValue(postfix));
    }
}
