package arraystring;

import java.util.HashMap;
import java.util.Map;

/**
 * There are three types of edits that can be performed on strings: insert a
 * character, remove a character, or replace a character. Given two strings,
 * write a function to check if they are one edit (or zero edits) away.
 * <p>
 * EXAMPLE pale, ple -> true pales, pale -> true pale, bale -> true pale, bake
 * -> false
 */
class _01_05_OneAway {
    
    boolean isOneAway(String a, String b) {
    int diffLength = Math.abs(a.length() - b.length());
    Map<Character, Integer> hashMap = new HashMap<>();
     //insert and replace 
    if(diffLength>1)   {
      return false;
    }
    else if( diffLength == 1){
        for(char c : a.toCharArray()){
            if(hashMap.containsKey(c)){
                hashMap.put(c, hashMap.get(c) + 1);
            }
            else{
                hashMap.put(c,1);
            }
        }
        for(char c : b.toCharArray()){
            if(hashMap.containsKey(c)){
                hashMap.put(c, hashMap.get(c) - 1);
            }
            else{
                hashMap.put(c,1);
            }
        }
        int count = 0;
        for(int i : hashMap.values()){
            if(i == 1 || i == -1) count++;
        }
        return count <= 1;
    }
    else {
        for(char c : a.toCharArray()){
            if(hashMap.containsKey(c)){
                hashMap.put(c, hashMap.get(c) + 1);
            }
            else{
                hashMap.put(c,1);
            }
        }
        for(char c : b.toCharArray()){
            if(hashMap.containsKey(c)){
                hashMap.put(c, hashMap.get(c) - 1);
            }
            else{
                hashMap.put(c,1);
            }
        }
        int count = 0;
        for(int i : hashMap.values()){
            if(i == 1) count++;
        }
        return count <= 2;
    }
  }
}
