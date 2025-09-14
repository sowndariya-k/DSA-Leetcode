package zoho1;
import java.util.*;

class Node{
	int data;
	Node left;
	Node right;
	
	Node(int data){
		this.data=data;
		left=null;
		right=null;
	}
}

class BinarySearchTree{
	Node root=null;
	
	void insert(int data) {
		Node newNode=new Node(data);
		if(root==null) {
			root=newNode;
		}
		else {
			Node temp=root;
			while(true) {
				if(temp.data<data) {
					if(temp.right==null) {
						temp.right=newNode;
						break;
					}
					else {
						temp=temp.right;
					}
				}
				else {
					if(temp.left==null) {
						temp.left=newNode;
						break;
					}
					else {
						temp=temp.left;
					}
				}
			}
		}
	}
	
	void inOrder(Node root) {
		if(root!=null) {
			inOrder(root.left);
			System.out.print(root.data+" ");
			inOrder(root.right);
		}
	}
	
	void preOrder(Node root) {
		if(root!=null) {
			System.out.print(root.data+" ");
			inOrder(root.left);
			inOrder(root.right);
		}
	}
	
	void postOrder(Node root) {
		if(root!=null) {
			inOrder(root.left);
			inOrder(root.right);
			System.out.print(root.data+" ");
		}
	}
		
	void search(int e) {
		
		if(root==null) {
			System.out.println("Tree is empty");
			return;
		}
		else {
			Node temp=root;
			while(true) {
				if(temp.data==e) {
					System.out.println("Found");
					return;
				}
				else if(temp.data<e) {
					if(temp.right==null) {
						System.out.println("Not Found");
						return;
					}
					else {
						temp=temp.right;
					}
				}
				else {
					if(temp.left==null) {
						System.out.println("Not Found");
						return;
					}
					else {
						temp=temp.left;
					}
				}
			}
		}
	}
}

public class Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		BinarySearchTree bst=new BinarySearchTree();
		bst.insert(5);
		bst.insert(10);
		bst.insert(25);
		bst.insert(35);
		bst.insert(7);
		bst.insert(9);
		bst.insert(4);
		bst.insert(2);
		System.out.print("\nInorder Traversal ");
		bst.inOrder(bst.root);
		System.out.print("\npreorder Traversal ");
		bst.preOrder(bst.root);
		System.out.print("\npostorder Traversal ");
		bst.postOrder(bst.root);
		System.out.print("\nEnter number to search: ");
		int e=sc.nextInt();
		bst.search(e);
	}

}