class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        int num1,num2;  //参与运算的数
        for (String str : tokens) {
            switch (str){
                case "+":
                    num1 = numStack.pop();
                    num2 = numStack.pop();
                    numStack.push(num2 + num1);
                    break; 
                case "-":
                    num1 = numStack.pop();
                    num2 = numStack.pop();
                    numStack.push(num2 - num1);
                    break;
                case "*":
                    num1 = numStack.pop();
                    num2 = numStack.pop();
                    numStack.push(num2 * num1);
                    break;
                case "/":
                    num1 = numStack.pop();
                    num2 = numStack.pop();
                    numStack.push(num2 / num1);
                    break;
                default:
                    numStack.push(Integer.valueOf(str));
                    break;
            }
        }
        return numStack.pop();
    }
}