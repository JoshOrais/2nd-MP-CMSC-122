import java.util.Scanner;

public class PriorityQueueTester
{
	private Node[] nodes = new Node[10];
	private PriorityQueue queue;
	private int choice;

	public static void main(String[] args){
		for(int i = 0; i < nodes.length; i++){
			nodes[i] = new Node();
			nodes[i].setKey(i);
			nodes[i].setValue(i);
			System.out.print("nodes[" + i + "] = " + nodes[i].getValue());
		}

		queue = new PriorityQueue(nodes);
		Scanner scan = new Scanner(System.in);

		while(choice != 0){
			System.out.println("\nPriority Queue Tester!\n");
			System.out.println("Menu:");
			System.out.println("\t1. Enqueue");
			System.out.println("\t2. Dequeue");
			System.out.println("\t3. isLastOne");
			System.out.println("\t0. Exit");
			System.out.print("\nPlease choose a number: ");
			choice = scan.nextInt();

			switch(choice){
				case 1:
					System.out.println("--Enqueue--");
					System.out.print("\nEnter a number: ");
					int num = scan.nextInt();
					Node newNode = new Node();
					newNode.setValue(num);
					queue.enqueue(newNode);
					break;
				case 2:
					System.out.println("--Dequeue--");
					Node node = queue.dequeue();
					if(node == null){
						System.out.println("\nThe queue is empty!");
					}else{
						System.out.println("\nDequeued node: " + node.getValue());
					}
					break;
				case 3:
					System.out.println("--isLastOne--");
					System.out.println("\nisLastOne: " + queue.isLastOne());
			}
		}
	}	
}