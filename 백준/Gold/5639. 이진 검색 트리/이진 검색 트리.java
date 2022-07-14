// 이진 검색 트리 gold5

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        void insert(int n) {
            if (n < this.value) {
                if (this.left == null)
                    this.left = new Node(n);

                else this.left.insert(n);
            } 
            
            else {
                if (this.right == null)
                    this.right = new Node(n);
                
                else this.right.insert(n);
            }
        }
    }

    static void postOrder(Node node) {  //후위 순회
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));

        String num;
        while(true) {
            num = br.readLine();
            if (num == null || num == "") break;

            root.insert(Integer.parseInt(num));
        }

        postOrder(root);

    }
}
