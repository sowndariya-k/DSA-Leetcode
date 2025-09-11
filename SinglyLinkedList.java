package zoho1;
import java.util.*;
class LinkedList {
	Node head;
	LinkedList(){
		head=null;
	}
class Node{
	int data;
	Node next;
	
	Node(int data){
		this.data=data;
		this.next=null;
	}
}

//insert begin
public void insertAtBegin(int data) {
	Node newNode=new Node(data);
	if(head==null) {
		head=newNode;
	}
	else {
		newNode.next=head;
		head=newNode;
	}
}

//display
public void display() {
	Node temp=head;
	while(temp!=null) {
		System.out.print(temp.data+" ");
		temp=temp.next;
	}
	System.out.println("null");
}

//insert position
public void insertAtpos(int pos,int data) {
	if(pos==0) {
		insertAtBegin(data);
		return;
	}
	Node newNode=new Node(data);
	Node temp=head;
	for(int i=1; temp!=null && i<pos;i++) {
		temp=temp.next;
		if(temp==null) {
			System.out.print("invalid");
		}
	}
		newNode.next=temp.next;
		temp.next=newNode;
}

//insertAtEnd
public void insertAtEnd(int data) {
	Node newNode=new Node(data);
	if(head==null) {
		head=newNode;
		return;
	}
	Node temp=head;
	while(temp.next!=null) {
		temp=temp.next;
	}
	temp.next=newNode;
}


//delete head
public void deleteAtBegin() {
	if(head==null) {
		System.out.print("Invalid");
		return;
	}
	head=head.next;
}


//deleteAtEnd
public void deleteAtEnd() {
	if(head==null)return;
	if(head.next==null) {
		head=null;
		return;
	}
	Node temp=head;
	while(temp.next.next!=null) {
		temp=temp.next;
	}
	temp.next=null;
}


//delete at position

public void deleteAtPos(int pos) {
	if(head==null) {//empty
		return;
	}
	if(pos==0) {//first
		deleteAtBegin();
		return;
	}
	
	Node temp=head;
	for(int i=1;temp.next!=null && i<pos;i++) {
		temp=temp.next;
		if(temp==null) {
			System.out.print("invalid");
		}}
			temp.next=temp.next.next;
	}
}



public class SinglyLinkedList{
	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		System.out.print("Insert at begin: ");
		list.insertAtBegin(10);
		list.insertAtBegin(20);
		list.insertAtBegin(30);
		list.display();
		
		System.out.print("Insert at position: ");
		list.insertAtpos(2,35);
		list.display();
		
		System.out.print("delete at begin: ");
		list.deleteAtBegin();
		list.display();
		
		System.out.print("Insert at end: ");
		list.insertAtEnd(40);
		list.display();
		
		System.out.print("delete at end: ");
		list.deleteAtEnd();
		list.display();
		
		System.out.print("delete at position: ");
		list.deleteAtPos(1);
		list.display();
	}

}
