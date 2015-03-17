import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main (String[] args) throws IOException {
		Node rootNode = new Node(30);

		Node secondTierLeftNode = new Node(8);
		Node secondTierRightNode = new Node(52);

		Node thirdTierLeftNode = new Node(3);
		Node thirdTierRightNode = new Node(20);

		Node fourthTierLeftNode = new Node(10);
		Node fourthTierRightNode = new Node(29);

		rootNode._left = secondTierLeftNode;
		rootNode._right = secondTierRightNode;

		secondTierLeftNode._left = thirdTierLeftNode;
		secondTierLeftNode._right = thirdTierRightNode;

		thirdTierRightNode._left = fourthTierLeftNode;
		thirdTierRightNode._right = fourthTierRightNode;

		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split("\\s+");

			int firstNode = Integer.valueOf(lineArray[0]);
			int secondNode = Integer.valueOf(lineArray[1]);

			Node lowestCommonAncestor = findLowestCommonAncestor(
				rootNode, firstNode, secondNode);

			System.out.println(lowestCommonAncestor._digit);
		}
	}

	private static Node findLowestCommonAncestor(
		Node rootNode, int firstNode, int secondNode) {

		int rootDigit = rootNode._digit;

		if ((rootDigit > firstNode) && (rootDigit > secondNode)) {
			return findLowestCommonAncestor(
				rootNode._left, firstNode, secondNode);
		}

		if ((rootDigit < firstNode) && (rootDigit < secondNode)) {
			return findLowestCommonAncestor(
				rootNode._right, firstNode, secondNode);
		}

		return rootNode;
	}

	private static class Node {
		private int _digit;
		private Node _left;
		private Node _right;

		private Node(int digit) {
			_digit = digit;
		}
	}
}