import org.junit.*;
import static org.junit.Assert.*;

import java.util.*;

public class IntUnbalancedBSTTest{
	
	IntUnbalancedBST bst;

	public IntUnbalancedBSTTest() {
		bst = new IntUnbalancedBST();
	}

	@Test
	public void insertSearchTest() {
		Random random = new Random();
		for(int i = 0; i < 20; i++) {
			int num = random.nextInt();
			bst.insert(num);
			assertTrue(num + " is absent after insert." , bst.search(num));
		}
	}

	//To check if the tree is a proper BST
	@Test
	public void roamBST() {
		ArrayList<Integer> randomNums = new ArrayList<>();
		Random random = new Random();
		for(int i = 0; i < 20; i++) {
			int num = random.nextInt();
			randomNums.add(num);
			bst.insert(num);
			assertTrue(num + " is absent after insert." , bst.search(num));
		}
		Collections.sort(randomNums);
		ArrayList<Integer> sortedBST = new ArrayList<>();
		IntUnbalancedBST.IntBSTNode in = bst.getRoot();
		helperRoamBST(in, sortedBST);
		for(int i = 0; i < 20; i++) {
			assertEquals("Tree is not proper BST", randomNums.get(i), sortedBST.get(i));
		}
	}

	public void helperRoamBST(IntUnbalancedBST.IntBSTNode currentNode, ArrayList<Integer> sortedBST) {
		if(currentNode == null) {
			return;
		}
		helperRoamBST(currentNode.getLeft(), sortedBST);
		sortedBST.add(currentNode.getValue());
		helperRoamBST(currentNode.getRight(), sortedBST);
	}
}