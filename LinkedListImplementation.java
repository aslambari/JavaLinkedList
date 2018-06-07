/**
	Name : Node.java
	Description: A integer based linked list, we can add, remove elements from this. Append or remove elements based on some condition
	Date: 06th June, 2018
	Author: Yuvraj Lohiya (iBirds Services)
*/
import java.util.Scanner;

class Node {
	private int data;
	private Node pointer;
	
	public Node(){
		pointer = null;
		data = 0;
	}
	
	public Node(int data, Node pointer){
		this.data = data;
		this.pointer = pointer;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public void setPointer(Node pointer){
		this.pointer = pointer;
	}
	
	public Node getPointer() {
		return this.pointer;
	}
	
	public int getData() {
		return this.data;
	}
}

class LinkedList {
	private Node first;
	private Node last;
	public int size;

	public LinkedList() {
		first = null;
		last = null;
	}

	public void appendElement(int val) {
		Node newNode = new Node(val, null);
		if (first == null) {
			first = newNode;
			last = first;
		} else {
			System.out.print("here");
			last.setPointer(newNode);
			last = newNode;
		}
	}

	public void removeTailElement() {
		if(first == null)
			return;
		
		Node prev = null;
		Node next = first;

		if(next.getPointer() == null) {
			first = last = null;
			return;
		}
		do {
			prev = next;
			next = next.getPointer();
		} while (next.getPointer() != null);

		prev.setPointer(null);
		last = prev;
	}

	public Node deleteNode(Node node, Node prev) {
		
		//System.out.print(prev.getData());
		//System.out.print("@@@@@");
		//System.out.print(node.getData());
		if (node == first) {
			first = first.getPointer();
			prev = first;			
		} else {
			prev.setPointer(node.getPointer());			
			if(node == last)
				last = prev;
		}
		node.setPointer(null);
		
		return prev;
	}

	public void deleteGreaterThanTarget(int targetVal) {
		if(first == null)
			return;
		Node prev = null;
		Node scanner = first;
		do {
			if (scanner.getData() > targetVal) {
				scanner = deleteNode(scanner, prev);
				
				//System.out.print(" scanner ");
				//System.out.print(scanner.getData());
				//System.out.print(" prev ");
				//System.out.print(prev.getData());
			}else{
				prev = scanner;
				scanner = scanner.getPointer();
			}
			//display();
		} while (scanner != null);

	}

	public void display() {
		Node scanner = first;
		System.out.print("\nSingly Linked List = ");
		if (first == null) {
			System.out.println("empty list\n");
			return;
		}

		do {
			System.out.print("[");
			System.out.print(scanner.getData());
			System.out.print("]");
			scanner = scanner.getPointer();
		} while (scanner != null);

		System.out.print("\n");
	}
}


public class LinkedListImplementation {
	public static void main(String[] args)
    {             
        Scanner scan = new Scanner(System.in);
        LinkedList list = new LinkedList(); 
        System.out.println("Singly Linked List Test\n");          
        char ch;
        do
        {
            System.out.println("\nSingly Linked List Operations\n");
            System.out.println("1. append element");
            System.out.println("2. remove from tail");
            System.out.println("3. delete greater than target");
            System.out.println("4. exit");
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                list.appendElement(scan.nextInt());                     
                break;                          
            case 2 : 
                list.removeTailElement();                     
                break;                         
            case 3 : 
                System.out.println("Enter target element");
                list.deleteGreaterThanTarget(scan.nextInt());
                break;  
            case 4 :
                System.exit(0);
                break;
             default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            
            list.display();                    
        } while (true);               
    }
}
