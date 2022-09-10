package trees.binaryTree;
import java.util.*;

/*
 * Title: Find LCA in a Binary tree
 */

class Solution{
	
	@SuppressWarnings("unused")
	private BT_Problem_31 ans;
	
	public Solution() {
		this.ans = null;
	}
	
	@SuppressWarnings("unused")
	private boolean recurseTree(BT_Problem_31 currentNode, BT_Problem_31 p, BT_Problem_31 q) {
		
		if(currentNode == null) 
			return false;
		
		int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;
		int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;
		int mid = (currentNode == p || currentNode == q) ? 1 : 0;
		
		if(mid + left + right >= 2) 
			this.ans = currentNode;
		
		return (mid + left + right > 0);
	}
	
	public BT_Problem_31 lowestCommonAncestor(BT_Problem_31 root, BT_Problem_31 p, BT_Problem_31 q) {
		
		Deque<BT_Problem_31> stack = new ArrayDeque<>();
		Map<BT_Problem_31, BT_Problem_31> parent = new HashMap<>();
		
		parent.put(root, null);
		stack.push(root);
		
		while(!parent.containsKey(p) || !parent.containsKey(q)) {
			BT_Problem_31 node = stack.pop();
			
			if(node.left != null) {
				parent.put(node.left, node);
				stack.push(node.left);
			}
			
			if(node.right != null) {
				parent.put(node.right, node);
				stack.push(node.right);
			}
		}
		
		Set<BT_Problem_31> ancestors = new HashSet<>();
		
		while(p != null) {
			ancestors.add(p);
			p = parent.get(p);
		}
		
		while(!ancestors.contains(q))
			q = parent.get(q);
		
		return q;
	}	
}

public class BT_Problem_31{
	int val;
	BT_Problem_31 left;
	BT_Problem_31 right;
	BT_Problem_31(int x){
		val = x;
	}
}
