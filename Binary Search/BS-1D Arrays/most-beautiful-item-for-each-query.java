//Problem: https://leetcode.com/problems/most-beautiful-item-for-each-query/description/



import java.io.*;
import java.util.*;

class MostBeautifulItem {
	public int[] maximumBeauty(int[][] items, int[] queries) {
		Arrays.sort(items, (x,y)->Integer.compare(x[0], y[0]));
		int maxBeauty = items[0][1];
		for(int i=0; i<items.length; i++) {
			if(items[i][1] > maxBeauty) {
				maxBeauty = items[i][1];
			}
			items[i][1] = maxBeauty;
		}

		int[] answer = new int[queries.length];
		for(int i=0; i<queries.length; i++) {
			answer[i] = maxBeautyForQuery(items, queries[i]);
		}
		return answer;
	}

	public int maxBeautyForQuery(int[][] items, int query) {
		int l=0, r=items.length-1, beauty=0;
		while(l<=r) {
			int mid = l + (r-l)/2;
			if(items[mid][0] <= query) {
				beauty = Math.max(beauty, items[mid][1]);
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return beauty;
	}

	public void display(int[] ans) {
		for(int i: ans) {
			System.out.print(i + " ");
		}
		System.out.print("\n");
	}
}

class Main {
	public static void main(String[] args) {
		int[][] items = {{1,2},{3,2},{2,4},{5,6},{3,5}};
		int[] queries = {1,2,3,4,5,6};
		MostBeautifulItem beauty = new MostBeautifulItem();
		int[] ans = beauty.maximumBeauty(items,queries);
		beauty.display(ans);

		int[][] items2 = {{1,2},{1,2},{1,3},{1,4}};
		int[] queries2 = {1};
		int[] ans2 = beauty.maximumBeauty(items2,queries2);
		beauty.display(ans2);

      
        int[][] items3 = {{10,1000}};
        int[] queries3 = {5};
        int[] ans3 = beauty.maximumBeauty(items3,queries3);
        beauty.display(ans3);
	}
}
