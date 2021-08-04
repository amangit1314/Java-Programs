package miscellaneous;
import java.util.*;

class TreeNode {
    public boolean isNull;
    int data;
    TreeNode LC, RC;

    public TreeNode(int x) {
        data = x;
        LC = null;
        RC = null;
    }
    public TreeNode() {
    }
}

public class TreeDeserialize {

    public static void insert(TreeNode root, int i) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            TreeNode u = q.poll();

            if(u.LC == null) {
                u.LC = new TreeNode();
                break;
            }

            if(u.RC == null) {
                u.RC = new TreeNode();
                break;
            }

            if(!u.LC.isNull)
                q.offer(u.LC);

            if(!u.RC.isNull)
                q.offer(u.RC);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        TreeNode root = new TreeNode(x);

        while(true) {
            String str = input.next();
            insert(root, Integer.parseInt(str));
        }
    }
}