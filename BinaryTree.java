//Sabreena Abedin (sa7cx)
public class BinaryTree<T> {

	private BinaryTreeNode<T> root;

	public BinaryTree() {
		this(null);
	}

	public BinaryTree(BinaryTreeNode<T> newRoot) {
		this.root = newRoot;
	}

	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}

	@Override
	public boolean equals(Object o) {

		if (o instanceof BinaryTree) {

			BinaryTree test = (BinaryTree) o;
			return this.getRoot().equals(test.getRoot());
		} else {
			return false;
		}

	}

	public BinaryTree<T> deepCopy() {
		BinaryTree<T> ans = new BinaryTree<T>();
		ans.setRoot(this.getRoot().deepCopy());
		return ans;

	}

	public BinaryTree<T> combine(BinaryTreeNode<T> newRoot, BinaryTree<T> t, boolean left) {
		BinaryTree<T> ans = new BinaryTree<T>();
		if (left) {
			ans.setRoot(newRoot.deepCopy());
			newRoot.setLeft(t.getRoot().deepCopy());
			newRoot.setRight(this.getRoot().deepCopy());

		} else {
			ans.setRoot(newRoot.deepCopy());
			newRoot.setRight(t.getRoot().deepCopy());
			newRoot.setLeft(this.getRoot().deepCopy());
		}

		return ans;
	}

	public int size() {
		if (this.getRoot() == null) {
			return 0;
		} else {
			return this.getRoot().size();
		}

	}

	public int height() {
		if (this.getRoot() == null) {
			return 0;
		} else {
			return this.getRoot().height();
		}
	}

	public boolean full() {

		return this.getRoot().getLeft().full() && this.getRoot().getRight().full();

	}

	public void mirror() {
		if (this.getRoot() != null) {
			this.getRoot().mirror();
		}

	}

	public String inOrder() {
		if (this.getRoot() != null) {
			return this.getRoot().inOrder();
		} else {
			return null;
		}
	}
}