package trees.binarySearchTree;

class Binary{
    public static void sum(int i){
        if (i <= 10) {
            System.out.printf("%d ", i);
            sum(i+1);
        }
    }
        public static void main(String[] args) {
            int i = 0;
            sum(i);
        }
}