import java.util.*;

class Solution {
    
    Set<String> set = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        Set<String> banSet = new HashSet<>();
        dfs(0, banSet, user_id, banned_id);
        
        return set.size();
    }

    private void dfs(int index, Set<String> banSet, String[] user_id, String[] banned_id) {
        if (index == banned_id.length) {
            List<String> list = new ArrayList<>(banSet);
            Collections.sort(list);
            set.add(list.toString());
            return;
        }

        String temp = banned_id[index];

        for (int i = 0; i < user_id.length; i++) {
            String user = user_id[i];

            if (banSet.contains(user)) continue;

            if (check(user, temp)) {
                banSet.add(user);
                dfs(index + 1, banSet, user_id, banned_id);
                banSet.remove(user);
            }
        }
    }

    private boolean check(String user, String ban) {
        if (user.length() != ban.length()) return false;
        
        boolean temp = true;
        for (int k = 0; k < ban.length(); k++) {
            if (ban.charAt(k) != '*' && ban.charAt(k) != user.charAt(k)) {
                temp = false;
                break;
            }
        }
        return temp;
    }
}