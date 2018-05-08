
public class UpgradedExpressionTree{
    private Node root;
    private Node current;

    private static class Node{
        String value;
        Node parent;
        Node left;
        Node right;

        Node(String value){
            this.value = value;
        }
    }
    public UpgradedExpressionTree(String expression){
        String[] inputChr = expression.split(" ");
        for (String symbol : inputChr){
            if (root == null){
                root = new Node(inputChr[0]);
                current = root;
                continue;
            }
            if (symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/")){
                if (current.parent == null){
                    current.parent = new Node(symbol);
                    root = current.parent;
                    root.left = current;
                    current = root;
                }else {
                    if (isHigherOrEqual(symbol,current.parent.value)){
                        current.left = new Node(current.value);
                        current.left.parent = current;
                        current.value = symbol;
                    }else {

                    }
                }
            }else if (isNumber(symbol)){
                current.right = new Node(symbol);
                current.right.parent = current;
                if (! isNumber(current.value)){
                    current = current.right;
                }
            }
        }
    }

    private boolean isNumber(String s){
        char[] chars = s.toCharArray();
        for (char c : chars){
            if (!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }

    private boolean isHigherOrEqual(String op1, String op2){
        if ((op1.equals("+") || op1.equals("-")) && (op2.equals("*") || op2.equals("/"))){
            return false;
        }else if ((op2.equals("+") || op2.equals("-")) && (op1.equals("*") || op1.equals("/"))){
            return true;
        }else return true;
    }

    public int calculate(){
        return Integer.parseInt(calculate(root).value);
    }


    private Node calculate(Node root){
        Node left = getLeft(root);
        Node right = getRight(root);

        if (left != null && right != null){
            return fn(calculate(left),calculate(right));
        }else {
            return root;
        }
    }

    private Node fn(Node left, Node right){
        String operator = left.parent.value;
        int res = 0;
        switch (operator) {
            case "+":
                res += Integer.parseInt(left.value) + Integer.parseInt(right.value);
                break;
            case "-":
                res += Integer.parseInt(left.value) - Integer.parseInt(right.value);
                break;
            case "*":
                res += Integer.parseInt(left.value) * Integer.parseInt(right.value);
                break;
            case "/":
                res += Integer.parseInt(left.value) / Integer.parseInt(right.value);
                break;
        }
        left.parent.left = null;
        left.parent.right = null;
        left.parent.value = String.valueOf(res);
        return left.parent;
    }

    private Node getLeft(Node root){
        if (root != null) {
            return (root.left);
        }return null;
    }

    private Node getRight(Node root){
        if (root != null){
            return (root.right);
        }return null;
    }

}
