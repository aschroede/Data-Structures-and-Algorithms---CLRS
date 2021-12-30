import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

class binarySearchTree {

    public class Node{

        Node right;
        Node left;
        Node parent;
        int key;

        public Node(int Value){
            key = Value;
            right = null;
            left = null;
            parent = null;
        }
    }

    Node root;
    public binarySearchTree(int key){
        root = new Node(key);
    }

    public Node search(int key, Node x){
        if (x == null)
            return null;
        if (x.key == key)
            return x;
        if (key < x.key)
            return search(key, x.left);
        else return search(key, x.right);
    }

    public Node minimum(Node x){
        while (x.left !=null)
            x = x.left;
        return x;
    }

    public Node maximum(Node x){
        while (x.right !=null)
            x = x.right;
        return x;
    }

    public Node predecessor(Node x){
        Node y = null;
        if (x.left != null)
            return maximum(x.left);
        y = x.parent;
        while(y != null && x == y.left){
            x=y;
            y=y.parent;
        }
        return y;

    }

    public Node successor(Node x){
        Node y = null;
        if (x.right != null)
            return minimum(x.right);
        y = x.parent;
        while(y != null && x == y.right){
            x=y;
            y=y.parent;
        }
        return y;
    }

    public void insert(int key){
        Node z = new Node(key);
        Node y = null;
        Node x = root;
        while (x != null){
            y=x;
            if (z.key < x.key)
                x = x.left;
            else x = x.right;
        }
        z.parent = y;
        if(y==null)
            root = z;
        else if(z.key < y.key)
            y.left = z;
        else y.right = z;
    }

    public void insertRecursive(int key){
        Node z = new Node(key);
        if(root == null)
            root = z;
        else insert2(null, root, z);
    }

    private void insert2(Node y, Node x, Node z) {
        if(x == null){
            z.parent = y;

            if(z.key < y.key)
                y.left = z;
            else y.right = z;
        }
        else if(z.key < x.key)
            insert2(x, x.left, z);
        else insert2(x, x.right, z);
    }


    public void transplant(Node u, Node v){
        if (u==root)
            root = v;
        else if(u==u.parent.left)
            u.parent.left = v;
        else
            u.parent.right = v;
        if(v != null)
            v.parent=u.parent;
    }

    public void delete(int key){

        Node z = search(key, root);

        if(z==null){
            System.out.println("No such node exists.");
            return;
        }

        //Case 1: Z just has a right child (possibly nil)
        if(z.left == null)
            transplant(z, z.right);
        //Case 2: Z just has a left child
        else if(z.right == null)
            transplant(z, z.left);

        //Case 3: Z has both a left and right child. Find Z's successor Y and replace Z with Y
        else{
            Node y = successor(z);

            // 3.1 Y is not the right child of z. In this case replace Y with its child. Then make Y
            // the parent of Z's right child and replace Z with Y
            if(y.parent != z){
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }

            // 3.2: Y is the right child of Z. In this case just replace Z with Y
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
        }
    }

    // Runtime: O(n)
    public void inorderRecursive(Node x){
        if (x != null){
            inorderRecursive(x.left);
            System.out.print(x.key + " ");
            inorderRecursive(x.right);
        }
    }

    // Runtime: O(nlog(n))
    public void inorderSuccessor(Node x){
        x = minimum(x);
        while(x != null){
            System.out.print(x.key + " ");
            x = successor(x);
        }
    }

    public void preOrderRecursivePrint(Node x){
        if(x != null){
            System.out.print((x.key +" "));
            preOrderRecursivePrint(x.left);
            preOrderRecursivePrint(x.right);
        }

    }

    public void postOrderRecursivePrint(Node x){
        if(x != null){
            postOrderRecursivePrint(x.left);
            postOrderRecursivePrint(x.right);
            System.out.print((x.key +" "));
        }

    }

    public void random(int size, boolean useRecursive){
        Random rand = new Random();
        Integer randomNum = null;
        for (int i=0; i<size; i++){
            randomNum = ThreadLocalRandom.current().nextInt(-100, 100);
            if(!useRecursive){
                insert(randomNum);
            }
            else insertRecursive(randomNum);

        }
    }
}

public class BST{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("***** BST Implementation *****");

        // create object of hash table
        binarySearchTree BST = new binarySearchTree(1);
        boolean exit = false;

        //  Perform HashTable operations
        while (!exit) {
            System.out.println(
                    "** BST Operations **");
            System.out.println("0. Random BST");
            System.out.println("1. insert");
            System.out.println("2. delete");
            System.out.println("3. minimum");
            System.out.println("4. maximum");
            System.out.println("5. inorderRecursive");
            System.out.println("6. inorderSuccessor");
            System.out.println("7. successor");
            System.out.println("8. predecessor");
            System.out.println("9. preorder");
            System.out.println("10. postorder");
            System.out.println("11. Random BST (using recursive insert)");

            int choice = sc.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("Enter size of BST");
                    BST.random(sc.nextInt(), false);
                    break;

                case 1:
                    System.out.println("Enter key");
                    BST.insert(sc.nextInt());
                    break;

                case 2:
                    System.out.println("Enter key");
                    BST.delete(sc.nextInt());
                    System.out.println(
                            "Removed Successfully...");
                    break;

                case 3:
                    System.out.println(
                            "Minimum node in the BST is : ");
                    System.out.println(BST.minimum(BST.root).key);
                    break;

                case 4:
                    System.out.println(
                            "Maximum node in the BST is : ");
                    System.out.println(BST.maximum(BST.root).key);
                    break;

                case 5:
                    long startTime = System.nanoTime();
                    BST.inorderRecursive(BST.root);
                    System.out.println("");
                    long endTime = System.nanoTime();
                    long duration = (endTime - startTime);
                    System.out.println("Execution time: " + duration);
                    break;

                case 6:
                    startTime = System.nanoTime();
                    BST.inorderSuccessor(BST.root);
                    System.out.println("");
                    endTime = System.nanoTime();
                    duration = (endTime - startTime);
                    System.out.println("Execution time: " + duration);
                    break;

                case 7:
                    System.out.println("Enter key");
                    binarySearchTree.Node x = BST.successor(BST.search(sc.nextInt(), BST.root));
                    if(x!=null){
                        System.out.println(
                                "Successor is : ");
                        System.out.println(x.key);
                    }
                    else{
                        System.out.println("No successor found.");
                    }
                    break;

                case 8:
                    System.out.println("Enter key");
                    x = BST.predecessor(BST.search(sc.nextInt(), BST.root));
                    if(x!=null){
                        System.out.println(
                                "Predecessor is : ");
                        System.out.println(x.key);
                    }
                    else{
                        System.out.println("No predecessor found.");
                    }
                    break;

                case 9:
                    System.out.println(
                            "Preorder is : ");
                    BST.preOrderRecursivePrint(BST.root);
                    break;
                case 10:
                    System.out.println(
                            "Postorder is : ");
                    BST.postOrderRecursivePrint(BST.root);
                    break;
                case 11:
                    System.out.println("Enter size of BST");
                    BST.random(sc.nextInt(), true);
                    break;

                default:
                    exit = true;
                    System.out.println(
                            "Exited Successfully...");
            }
        }
        sc.close();
    }
}