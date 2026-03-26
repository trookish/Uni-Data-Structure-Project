public class Tree {

	private TreeNode root;
	private int size;

	public Tree() {
		root = null;
		size = 0;
	}

	public TreeNode addRoot(TreeNode e) {
		if (root == null) {
			root = e;
			size++;
			return e;
		} else {
			return null;
		}
	}
}