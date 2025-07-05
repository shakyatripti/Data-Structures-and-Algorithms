//Problem: https://leetcode.com/problems/keys-and-rooms/description/




import java.io.*;
import java.util.*;

class KeysAndRooms {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int count = 0;
		boolean[] visited = new boolean[rooms.size()];
		for(int i=0; i<rooms.size(); i++) {
			if(visited[i]==false) {
				findBFS(rooms, i, visited);
				count++;
			}
		}
		if(count==1) {
			return true;
		}
		return false;
	}

	public void findBFS(List<List<Integer>> rooms, int room, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		q.add(room);
		visited[room] = true;
		while(!q.isEmpty()) {
			int keys = q.poll();
			for(int i=0; i<rooms.get(keys).size(); i++) {
				int val = rooms.get(keys).get(i);
				if(visited[val]==false) {
					visited[val] = true;
					q.add(val);
				}
			}
		}
	}
}

class Main {
	public static void main(String[] args) {
		KeysAndRooms obj = new KeysAndRooms();
		List<List<Integer>> rooms = new ArrayList<>();
		rooms.add(new ArrayList<>(Arrays.asList(1)));
		rooms.add(new ArrayList<>(Arrays.asList(2)));
		rooms.add(new ArrayList<>(Arrays.asList(3)));
		rooms.add(new ArrayList<>());
		System.out.println(obj.canVisitAllRooms(rooms));

        List<List<Integer>> rooms1 = new ArrayList<>();
        rooms1.add(new ArrayList<>(Arrays.asList(1,3)));
        rooms1.add(new ArrayList<>(Arrays.asList(3,0,1)));
        rooms1.add(new ArrayList<>(Arrays.asList(2)));
        rooms1.add(new ArrayList<>(Arrays.asList(0)));
        System.out.println(obj.canVisitAllRooms(rooms1));

        List<List<Integer>> rooms2 = new ArrayList<>();
        rooms2.add(new ArrayList<>(Arrays.asList(1,2)));
        rooms2.add(new ArrayList<>(Arrays.asList(2,3,5)));
        rooms2.add(new ArrayList<>(Arrays.asList(4,6,7)));
        rooms2.add(new ArrayList<>(Arrays.asList(3)));
        rooms2.add(new ArrayList<>(Arrays.asList(5,6)));
        rooms2.add(new ArrayList<>(Arrays.asList(7)));
        rooms2.add(new ArrayList<>(Arrays.asList(2,4)));
        rooms2.add(new ArrayList<>(Arrays.asList(5,3,6)));
        System.out.println(obj.canVisitAllRooms(rooms2));
	}
}