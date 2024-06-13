public class Calculator {
    Item[] expr;
    int p;
    StaticStack stack;
    /*Dynamic dynamic;*/

    public Calculator(Item[] expr, boolean dynamic) {
        this.expr = expr;
        this.p = 0;
        this.stack = new StaticStack(5);
    }

    public int run() {
        while (p < expr.length) {
            step(p);
            p++;
        }
        return stack.pop();
    }

    public void step(int p) {
        switch (expr[p].getType()) {
            case ADD: {
                int y = stack.pop();
                int x = stack.pop();
                int a = x + y;

                stack.push(a);
                break;
            }
            case SUB: {
                int y = (int) stack.pop();
                int x = (int) stack.pop();
                int a = x - y;

                stack.push(a);
                break;
            }
            case MUL: {
                int y = stack.pop();
                int x = stack.pop();
                int a = x * y;

                stack.push(a);
                break;
            }
            case DIV: {
                int y = stack.pop();
                int x = stack.pop();
                int a = x / y;

                stack.push(a);
                break;
            }
            case VALUE: {
                stack.push(expr[p].getValue());
                break;
            }
        }
    }
}