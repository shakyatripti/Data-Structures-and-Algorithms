//Problem: https://leetcode.com/problems/get-watched-videos-by-your-friends/description/


import java.io.*;
import java.util.*;

class WatchedVideosByFriends {
    public List<String> watchedVideos(int id, int[][] friends, List<List<String>> videos, int level) {
        int n=friends.length, depth = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        visited[id] = true;
        while(!q.isEmpty() && level!=depth) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int frnd = q.poll();
                for(int f: friends[frnd]) {
                    if(!visited[f]) {
                        q.add(f);
                        visited[f] = true;
                    }
                }
            }
            depth++;
        }
        
        HashMap<String, Integer> mp = new HashMap<>();
        while(!q.isEmpty()) {
            int t = q.poll();
            for(String vid: videos.get(t)) {
                mp.put(vid, mp.getOrDefault(vid, 0) + 1);
            }
        }
        List<String> ans = new ArrayList<>(mp.keySet());
        Collections.sort(ans, (x,y)-> mp.get(x)==mp.get(y) ? x.compareTo(y) : Integer.compare(mp.get(x), mp.get(y)));
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] friends = {{1,2},{0,3},{0,3},{1,2}};
        List<List<String>> videos = Arrays.asList(
            Arrays.asList("A", "B", "D"),
            Arrays.asList("C"),
            Arrays.asList("B", "C"),
            Arrays.asList("A", "B")
        );
        WatchedVideosByFriends vid = new WatchedVideosByFriends();
        List<String> ans = vid.watchedVideos(1, friends, videos, 1);
        for(String ch: ans) {
            System.out.print(ch + " ");
        }
    }
}