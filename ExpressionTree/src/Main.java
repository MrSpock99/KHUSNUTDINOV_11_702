public class Main {
    public static void main(String[] args) {
        //String input = "(((2+4)*7)+3*4-2))";
        String input = "2 + 2 * 4";
        /*String[] inputChr = input.split("");
        ExpressionTree tree = new ExpressionTree();

        for (String symbol : inputChr){
            if (symbol.equals("(") ){
                tree.createLeft();
            }else if (Character.isDigit(symbol.charAt(0))){
                tree.insertDigit(symbol);
            }else if (symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/")){
                tree.insertOperation(symbol);
            }else if (symbol.equals(")")){
                tree.jumpToParent();
            }
        }*/
        UpgradedExpressionTree tree = new UpgradedExpressionTree(input);
        System.out.println(tree);






    }



}
