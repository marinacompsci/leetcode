package algoProblems;

import java.util.ArrayList;
import java.lang.Math;

public class AddTwoNumbers {
	public static void main(String[] args) {
		ArrayList<AddTwoNumbers.ListNode> nodes1 = new ArrayList<AddTwoNumbers.ListNode>();
		ListNode ln11 = new ListNode(5);
		ListNode ln21 = new ListNode(8);
		ListNode ln31 = new ListNode(3);
		ln11.next = ln21;
		ln21.next = ln31;
		
		ArrayList<AddTwoNumbers.ListNode> nodes2 = new ArrayList<AddTwoNumbers.ListNode>();
		ListNode ln12 = new ListNode(5);
		ListNode ln22 = new ListNode(6);
		ListNode ln32 = new ListNode(4);
		ln12.next = ln22;
		ln22.next = ln32;
	
		System.out.println(walkNodes(addTwoNumbers(ln11, ln12)).toString());		
	}
	
	public static ListNode addTwoNumbers(ListNode nodeList1, ListNode nodeList2) {
		ArrayList<Integer> nodeListA = walkNodes(nodeList1);
		ArrayList<Integer> nodeListB = walkNodes(nodeList2);
		int sum = 0;
		int remainder = 0;
		int nodeListAVal = 0;
		int nodeListBVal = 0;
		int amountOfNodes = Math.max(nodeListA.size(), nodeListB.size());
		ListNode node = null;
		ListNode currentNode = null;
		
		for (int i = 0; i < amountOfNodes; i++) {
			ListNode newNode = null;
			try {
				nodeListAVal = nodeListA.get(i);				
			} catch(Exception e) {
				//array out of bounds
				nodeListAVal = 0;
			}
			
			try {
				nodeListBVal = nodeListB.get(i);				
			} catch(Exception e) {
				//array out of bounds
				nodeListBVal = 0;
			}			
			sum = nodeListAVal + nodeListBVal + remainder; //actual node values plus remainder from last 2 nodes				
			remainder = splitDigits(sum)[0]; 
			sum = splitDigits(sum)[1];
			if(i == 0) {
			//create new node
				node = new ListNode(sum);					
				currentNode = node;
			} else {
				//append a new node to the last one
				newNode = new ListNode(sum);
				currentNode.next = newNode;
				currentNode = newNode;
			}
			//debug
			//System.out.print("res: " + currentNode.val + " ");
		}
		
		//create new nodes for the remaining numbers after there are no more nodes from the input left to walk
		//attach them to the last node created
		while(remainder != 0) {
			ListNode newNode = null;
			sum = splitDigits(remainder)[1];			
			remainder = splitDigits(remainder)[0]; 
			newNode = new ListNode(sum);
			currentNode.next = newNode;
			currentNode = newNode;
			//debug
			//System.out.println("last: " + currentNode.val + " ");
		}
		
		return node;
	}

	
	public static ArrayList<Integer> walkNodes(ListNode list) {
		int value;
		ArrayList<Integer> nodesArray = new ArrayList<Integer>();
		while(list != null) {
			value = list.val;
			nodesArray.add(value);
			//System.out.println("test: " + value);
			list = list.next;
		}
		return  nodesArray;
	}
	
	//7 -> 7 / 10 = 0 , R = 7 ==> [0, 7]
	//10 -> 10 / 10  = 1, R = 0 ==> [1, 0]
	public static int[] splitDigits(int num) {
		int firstDigit = num / 10;
		int secDigit = num % 10;
		int[] result = {firstDigit, secDigit}; 
		return result;
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
