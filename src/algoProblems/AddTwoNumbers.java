package algoProblems;
import java.util.ArrayList;

public class AddTwoNumbers {
	public static void main(String[] args) {
		ArrayList<AddTwoNumbers.ListNode> nodes = new ArrayList<AddTwoNumbers.ListNode>();
		ListNode ln1 = new ListNode(2);
		ListNode ln2 = new ListNode(4);
		ListNode ln3 = new ListNode(3);
		ln1.next = ln2;
		ln2.next = ln3;
	
		nodes.add(ln1);
		nodes.add(ln2);
		nodes.add(ln3);
		//ln3.next = null;
		System.out.println(nodes.get(2).val);
//		for(int i = 0; i < 3; i++) {
//			System.out.println(nodes[]);
//		}
	}
	
	private static class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }	//constructor
	}
}







/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//class Solution {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        
//    }
//}
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.