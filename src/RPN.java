import java.util.Stack;

public class RPN {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> evaluation= new Stack<>();

        for(int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+" :
                    evaluation.push(evaluation.pop()+evaluation.pop());
                    break;
                case "-" :
                    evaluation.push(-evaluation.pop() + evaluation.pop());
                    break;
                case "/" :
                    int temp1 = evaluation.pop();
                    int temp2 = evaluation.pop();
                    int temp3 = temp2 / temp1;
                    evaluation.push(temp3);
                    break;
                case "*" :
                    evaluation.push(evaluation.pop() * evaluation.pop());
                    break;
                default:
                    evaluation.push(Integer.parseInt(tokens[i]));
            }
        }

        return evaluation.pop();
    }
    public static void main(String[] args) {
        String[] s = new String[]{"13","5","/"};
        System.out.println(evalRPN(s));
    }
}
