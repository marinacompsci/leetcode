package algoProblems;

public class TwoSum {
	public static void main(String[] args) {
		int[] num = {2, 7, 11, -1};
		int target = 13;
		int[] result = findingSum(num, target);		
		System.out.format("Result: [%d, %d]",result[0], result[1]);
	}
	
	public static int[] findingSum(int[] nums, int target) {
		int[] targetNotFoundArray = {-1 ,-1};
		int sum = 0;
	    for(int i = 0; i < nums.length; i++) {
	    	for(int j = i+1; j < nums.length; j++) {
	    		sum += nums[i] + nums[j];
	    		int[] indices = {i,j};
	    		if(sum == target){ 
	    			return indices; 
	    		} else {
	    			sum = 0;	    			
	    		}
	    	}
	    }	    
	    return targetNotFoundArray;
	}		
	
}

//Given nums = [2, 7, 11, 15], target = 9,
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].
