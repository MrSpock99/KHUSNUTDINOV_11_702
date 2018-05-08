
public class ExpressionTree {

    private Node root;
    private Node current;

    public ExpressionTree(Node root) {
        this.root = root;
    }

    private static class Node{
        String value;
        Node parent;
        Node left;
        Node right;
    }

    public ExpressionTree(String expression){
        root = new Node();
        current = root;

        String[] inputChr = expression.split(" ");
        for (String symbol : inputChr){
            if (symbol.equals("(") ){
                createLeft();
            }else if (isNumber(symbol)){
                insertDigit(symbol);
            }else if (symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/")){
                insertOperation(symbol);
            }else if (symbol.equals(")")){
                jumpToParent();
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

    public void createLeft() {
        Node node = new Node();
        node.parent = current;
        current.left = node;
        current = current.left;
    }

    public void insertDigit(String symbol) {
        current.value = symbol;
        current = current.parent;
    }

    public void insertOperation(String symbol) {
        current.value = symbol;
        Node node = new Node();
        node.parent = current;
        current.right = node;
        current = current.right;
    }

    public boolean jumpToParent() {
        if (current != null){
            current = current.parent;
            return true;
        }else {
            return false;
        }
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
