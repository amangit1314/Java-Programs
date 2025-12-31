// Find the first non repeating character from a stream of characters

class Problem_35 {
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;

    static String firstNonRepeatingCharacter(String stream) {
        int[] freq = new int[26];
        StringBuilder result = new StringBuilder();
        Node front = null, rear = null;

        for (char ch : stream.toCharArray()) {
            freq[ch - 'a']++;

            if (freq[ch - 'a'] == 1) {
                Node newNode = new Node(ch);
                if (front == null) {
                    front = rear = newNode;
                } else {
                    rear.next = newNode;
                    rear = newNode;
                }
            }

            while (front != null && freq[front.data - 'a'] > 1) {
                front = front.next;
            }

            if (front != null) {
                result.append(front.data);
            } else {
                result.append('#');
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String stream = "abadbc";
        String result = firstNonRepeatingCharacter(stream);
        System.out.println("First non-repeating characters in the stream: " + result);
    }
}