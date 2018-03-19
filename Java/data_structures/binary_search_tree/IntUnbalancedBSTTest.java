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

	//To check if find minimum is working
	@Test
	public void findMinTest() {
		int min = -1;
		try{
			bst.findMin();
		}catch(ItemDoesNotExistsException idne){
			assertEquals("Exception failed", idne.getMessage(), "Min does not exists");
		}
		ArrayList<Integer> randomNums = new ArrayList<>();
		Random random = new Random();
		for(int i = 0; i < 20; i++) {
			int num = random.nextInt();
			randomNums.add(num);
			bst.insert(num);
			assertTrue(num + " is absent after insert." , bst.search(num));
		}
		Collections.sort(randomNums);
		try{
			min = bst.findMin();
		}catch(ItemDoesNotExistsException idne){
			assertEquals("Exception failed", idne.getMessage(), "Min does not exists");
		}
		assertEquals("Find Min is not working", new Integer(min), randomNums.get(0)); 
	}

	//To check if find maximum is working
	@Test
	public void findMaxTest() {
		int max = -1;
		try{
			bst.findMax();
		}catch(ItemDoesNotExistsException idne){
			assertEquals("Exception failed", idne.getMessage(), "Max does not exists");
		}
		ArrayList<Integer> randomNums = new ArrayList<>();
		Random random = new Random();
		for(int i = 0; i < 20; i++) {
			int num = random.nextInt();
			randomNums.add(num);
			bst.insert(num);
			assertTrue(num + " is absent after insert." , bst.search(num));
		}
		Collections.sort(randomNums);
		try{
			max = bst.findMax();
		}catch(ItemDoesNotExistsException idne){
			assertEquals("Exception failed", idne.getMessage(), "Max does not exists");
		}
		assertEquals("Find Max is not working", new Integer(max), randomNums.get(randomNums.size() - 1)); 
	}

	//To check if find height is working
	@Test
	public void findHeightTest() {
		int height = bst.findHeight();
		assertEquals("Find height didnt return -1 when null", -1, height);
		int[] nums = {10, 8, 4, 18, 15, 25, 9, 6, 30, 33};
		for(int i = 0; i < nums.length; i++) {
			bst.insert(nums[i]);
			assertTrue(nums[i] + " is absent after insert." , bst.search(nums[i]));
			if(i == 0) {
				height = bst.findHeight();
				assertEquals("Find height didnt return 0 with just root", 0, height);
			}
		}
		height = bst.findHeight();
		assertEquals("Find height returned incorrect result", 4, height);
	}
}