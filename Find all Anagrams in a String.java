import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        if (s == null || s.length() == 0 || p == null || p.length() == 0)
            return result;
        
        int[] charCountP = new int[26];
        for (char c : p.toCharArray()) {
            charCountP[c - 'a']++;
        }
        
        int left = 0, right = 0, count = p.length();
        
        while (right < s.length()) {
            if (charCountP[s.charAt(right) - 'a'] > 0) {
                count--;
            }
            
            charCountP[s.charAt(right) - 'a']--;
            right++;
            
            if (count == 0) {
                result.add(left);
            }
            
            if (right - left == p.length()) {
                if (charCountP[s.charAt(left) - 'a'] >= 0) {
                    count++;
                }
                
                charCountP[s.charAt(left) - 'a']++;
                left++;
            }
        }
        
        return result;
    }
}