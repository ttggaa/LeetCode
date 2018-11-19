package t48;

import java.util.ArrayList;
import java.util.Arrays;

import t17.ListNode;

public class T48_Solution {
	/**
	 * @author yukunlee
	 * @Description quicksort
	 * @date 2018年11月15日
	 * @param arr
	 * @return
	 */
	public int[] Solution(int[] arr) {
		return helper(arr, 0, arr.length-1);
	}

	private int[] helper(int[] arr, int head, int tail) {
		if (head > tail)
			return arr;
		int cur = head;
		int val;
		for (int i = head; i <= tail; ++i) {
			if (arr[i] < arr[cur]) {
				val = arr[i];
				for(int j = i ; j > cur ; --j) {
					arr[j] = arr[j-1];
				}
				arr[cur] = val;
			/*	val = arr[cur];
				arr[cur] = arr[i];
				arr[i] = val;
				cur = i;*/
			}
		}
		//if(cur == head) return arr;
		helper(arr, head, cur - 1);
		helper(arr, cur +1, tail);
		return arr;
	}
	
    /**
     * @author yukunlee
     * @Description reverse-linked-list-ii
     * @date 2018年11月16日
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre , last;
        int val =0 ;
        last = pre = head;
        while(n - m > 1) {
            for(int i = 1 ; i < n ; ++i) {
            	if( i == m) pre = last;
            	last = last.next;
            }
            val = pre.val;
            pre.val = last.val;
            last.val = val;
            ++m;
            --n;
        }
    	return head;
    }
    
    /**
     * @author yukunlee
     * @Description subsets
     * @date 2018年11月16日
     * @param S
     * @return
     */
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
    	ArrayList<Integer> list = new ArrayList<>();
    	Arrays.sort(S);
    	for(int len = 0; len <= S.length ; ++len) {
    		backtracking(S, len, 0 , list);
    	}
        return res;
    }
    private void backtracking(int[] s ,int len, int head , ArrayList<Integer> list) {
    	if(len < 0) {
    		return;
    	}else if(len == 0){
    		res.add(new ArrayList<>(list));
    	}else {
    		for(int i = head ; i < s.length ; ++i) {
    			list.add(s[i]);
    			backtracking(s, len-1, i + 1, list);
    			list.remove(list.size() - 1);
    		}
    	}	
    }
    
    /**
     * @author yukunlee
     * @Description TODO
     * @date 2018年11月19日
     * @param num
     * @return
     */
    ArrayList<ArrayList<Integer>> res1;
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        if (num == null || num.length <= 0)
            return res1;
    	ArrayList<Integer> list = new ArrayList<>();
    	Arrays.sort(num);
    	for(int len = 0; len <= num.length ; ++len) {
    		backtracking_1(num, len, 0 , list);
    	}
    	return res1;
    }
    private void backtracking_1(int[] s ,int len, int head , ArrayList<Integer> list) {
    	if(len < 0) {
    		return;
    	}else if(len == 0){
    		res1.add(new ArrayList<>(list));
    	}else {
    		for(int i = head ; i < s.length ; ++i) {
                if (i > head && s[i] == s[i - 1])
                    continue;
    			list.add(s[i]);
    			backtracking_1(s, len-1, i + 1, list);
    			list.remove(list.size() - 1);
    		}
    	}	
    }

}
