// Sabreena Abedin (sa7cx)
public class BinaryTreeNode<T> {

	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	private T data;

	public BinaryTreeNode() {
		this(null, null, null);
	}

	public BinaryTreeNode(T theData) {
		this(theData, null, null);
	}

	public BinaryTreeNode(T theData, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild) {
		data = theData;
		left = leftChild;
		right = rightChild;
	}

	public int size() {
		int size = 0; // the size of the tree

		// The size of the tree rooted at this node is one more than the
		// sum of the sizes of its children.
		if (left != null) {
			size = size + left.size();
		}
		if (right != null) {
			size = size + right.size();
		}
		return size + 1; // add one to account for the current node
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BinaryTreeNode<T> deepCopy() {
		BinaryTreeNode<T> ans = new BinaryTreeNode<T>();
		ans.left = null;
		ans.right = null;
		ans.data = null;

		if (this.getLeft() != null) {
			ans.left = this.getLeft().deepCopy();
		}
		if (this.getRight() != null) {
			ans.right = this.getRight().deepCopy();
		}
		if (this.getData() != null) {
			ans.data = this.getData();
		}

		return ans;

	}

	@Override
	public boolean equals(Object o) {

		if (o instanceof BinaryTreeNode) {

			BinaryTreeNode test = (BinaryTreeNode) o;

			if ((left == null) && (right != null)) {
				return (this.getRight().equals(test.getRight()) && this.getData().equals(test.getData()));
			} else if ((left != null) && (right == null)) {
				return (this.getLeft().equals(test.getLeft()) && this.getData().equals(test.getData()));
			} else if ((left == null) && (right == null)) {
				return this.getData().equals(test.getData());
			} else {
				return this.getData().equals(test.getData()) && this.getLeft().equals(test.getLeft())
						&& this.getRight().equals(test.getRight());
			}
		} else {
			return false;

		}
	}

	public int height() {

		if (this.left != null && this.right == null) {
			return 1 + this.getLeft().height();
		} else if (this.right != null && this.left == null) {
			return 1 + this.getRight().height();
		} else if (this.right != null && this.left != null) {
			return 1 + Math.max(this.getRight().height(), this.getLeft().height());
		} else if (this.right == null && this.left == null) {
			return 1;
		} else {
			return 0;
		}

	}

	public boolean full() {
		boolean ans = false;
		if ((this.left != null) && (this.right != null)) {
			ans = true;

		}
		return ans;
	}

	public void mirror() {
		BinaryTreeNode<T> copy = new BinaryTreeNode<T>();

		if (this.left == null && this.right != null) {
			copy = this.getRight().deepCopy();
			this.setLeft(copy);
			this.setRight(null);
			this.left.mirror();
		} else if (this.left != null && this.right == null) {
			copy = this.getLeft().deepCopy();
			this.setLeft(null);
			this.setRight(copy);
			this.right.mirror();
		} else if (this.left != null && this.right != null) {
			copy = this.getLeft().deepCopy();
			this.setLeft(this.getRight().deepCopy());
			this.setRight(copy);
			this.right.mirror();
			this.left.mirror();
		}

	}

	public String inOrder() {
		// left, root, right
		String ans = "";

		if (this.left != null) {
			ans = ans + this.getLeft().inOrder();
		}

		ans = ans + "(" + this.getData() + ")";

		if (this.right != null) {
			ans = ans + this.getRight().inOrder();
		}

		return ans;

	}

}