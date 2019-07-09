/**
 * Created by lizhen on 2019-07-09
 */
public class Main {

    public static void main(String args[]) {

        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);

        BinarySearchTree.Node node = tree.find(1);
        System.out.println(node.getRight().getData());

        System.out.println("-----------------------------");
        System.out.println("binary Tree max value =" + tree.findMax().getData());

        System.out.println("-------------前序遍历----------------");
        tree.preOrder(tree.getTree());

        System.out.println("-------------中序遍历----------------");
        tree.inOrder(tree.getTree());

        System.out.println("-------------后序遍历----------------");
        tree.posOrder(tree.getTree());

    }
}
