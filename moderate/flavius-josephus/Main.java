import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split("\\s+");

			if (lineArray.length > 0) {
				int numberOfPeople = Integer.valueOf(lineArray[0]);
				int interval = Integer.valueOf(lineArray[1]);

				for (int i = 0; i < numberOfPeople; i++) {
					Node
				}
			}
		}
	}

	public class Node {
		public int numberOfPeople = 0;

		Node next;

		public Node(int numberOfPeople, Node next) {
			this.numberOfPeople = numberOfPeople;
			this.next = next;
		}
	}

	public class CircularLinkedList {
		private Node head = null;
		private int numberOfElements = 0;
		private Node actualElement = null;
		private int index = 0;

		public void insertAtEnd(int id) {
			Node node = new Node(id, actualElement.next);

			actualElement.next = node;

			numberOfElements++;
		}


	}
}