import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, List<int[]>> playMap = new HashMap<>();
        Map<String, Integer> genreMap = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
            
            if(!playMap.containsKey(genres[i])) {
                playMap.put(genres[i], new ArrayList<int[]>());
            }
            
            playMap.get(genres[i]).add(new int[] {i, plays[i]});
        }
        
        List<String> list = new ArrayList<>(genreMap.keySet());
        
        Collections.sort(list, (a, b) -> {
            return genreMap.get(b) - genreMap.get(a);
        });
        
        for(String key : playMap.keySet()) {
            Collections.sort(playMap.get(key), (a, b) -> {
                if(a[1] == b[1]) {
                    return a[0] - b[0];
                }
                
                return b[1] - a[1];
            });
        }
        
        List<Integer> temp = new ArrayList<>();
        
        for(String s : list) {
            List<int[]> songs = playMap.get(s);
            
            int count = Math.min(2, songs.size());
            
            for(int i = 0; i < count; i++) {
                temp.add(songs.get(i)[0]);
            }
        }
        
        int[] answer = new int[temp.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = temp.get(i);
        }
        
        return answer;
    }
}