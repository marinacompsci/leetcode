package algoProblems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TwoSumTest {
	@Test 
	void test() {
		int[] num = {2, 7, 11, -1};
		int target = 13;
		int[] res = {0, 2};		
		assertArrayEquals(res, algoProblems.TwoSum.findingSum(num, target));
	}
//	void test() {
//		fail("Not yet implemented");
//	}

}

