import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        boolean[] inSpoilerRange = new boolean[message.length()];
        for(int[] spoilerRange : spoiler_ranges) {
            for(int i=spoilerRange[0];i<=spoilerRange[1];i++) {
                inSpoilerRange[i] = true;
            }
        }
        String[] words = message.trim().split(" ");
        int[] indexWordIndexMapping = new int[message.length()];
        Arrays.fill(indexWordIndexMapping, -1);
        int wordIndex = -1;
        for(int i=0;i<message.length();i++) {
            if (message.charAt(i) == ' ') {
                continue;
            }
            if (i == 0 || message.charAt(i-1) == ' ') {
                wordIndex++;
            }
            indexWordIndexMapping[i] = wordIndex;
        }
        boolean[] isSpoiler = new boolean[words.length];
        for(int i=0;i<message.length();i++) {
            if (inSpoilerRange[i]) {
                if (indexWordIndexMapping[i] == -1) continue;
                isSpoiler[indexWordIndexMapping[i]] = true;
            }
        }
        Set<String> importantWords = new HashSet<>();
        Set<String> noSpoilerWords = new HashSet<>();
        for(int i=0;i<words.length;i++) {
            if (!isSpoiler[i]) {
                noSpoilerWords.add(words[i]);
            }
        }
        for(int i=0;i<words.length;i++) {
            if (isSpoiler[i] && !noSpoilerWords.contains(words[i])) {
                importantWords.add(words[i]);
            }
        }
        return importantWords.size();
    }
}