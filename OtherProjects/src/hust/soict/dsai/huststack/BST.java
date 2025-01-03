package hust.soict.dsai.huststack;

import java.util.Scanner;

class Main {
    // Định nghĩa Node cho BST
    static class BSTNode {
        int key;
        BSTNode left, right;

        public BSTNode(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }

    // Cây nhị phân tìm kiếm
    static class BST {
        private BSTNode root;

        // Hàm chèn phần tử vào cây
        public void insert(int key) {
            root = insertRec(root, key);
        }

        private BSTNode insertRec(BSTNode node, int key) {
            if (node == null) {
                return new BSTNode(key);
            }
            if (key < node.key) {
                node.left = insertRec(node.left, key);
            } else if (key > node.key) {
                node.right = insertRec(node.right, key);
            }
            return node;
        }

        // Hàm duyệt cây theo thứ tự Pre-order
        public void preorder() {
            preorderRec(root);
        }

        private void preorderRec(BSTNode node) {
            if (node != null) {
                System.out.print(node.key + " ");
                preorderRec(node.left);
                preorderRec(node.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BST bst = new BST();

        while (true) {
            String command = scanner.nextLine().trim();
            if (command.equals("#")) {
                break;
            } else if (command.startsWith("insert")) {
                String[] parts = command.split(" ");
                int key = Integer.parseInt(parts[1]);
                bst.insert(key);
            }
        }

        // In kết quả duyệt Pre-order
        bst.preorder();
        scanner.close();
    }
}
