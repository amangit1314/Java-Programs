// multiply 2 numbers represented by lls

class Problem_31 {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;

    static Node multiplyTwoLists(Node l1, Node l2) {
        long num1 = 0, num2 = 0;
        long mod = 1000000007;

        // Convert first linked list to number
        while (l1 != null) {
            num1 = (num1 * 10 + l1.data) % mod;
            l1 = l1.next;
        }

        // Convert second linked list to number
        while (l2 != null) {
            num2 = (num2 * 10 + l2.data) % mod;
            l2 = l2.next;
        }

        long resultNum = (num1 * num2) % mod;

        // Convert result number back to linked list
        if (resultNum == 0) return new Node(0);

        Node resultHead = null, resultTail = null;

        while (resultNum > 0) {
            int digit = (int)(resultNum % 10);
            Node newNode = new Node(digit);

            if (resultHead == null) {
                resultHead = newNode;
                resultTail = newNode;
            } else {
                newNode.next = resultHead;
                resultHead = newNode;
            }

            resultNum /= 10;
        }

        return resultHead;
    }
}