import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        m = convert(m);
        List<Music> correctMusics = new ArrayList<>();
        for(String infos : musicinfos) {
            String[] infoArr = infos.split(",");
            String rawStartTime = infoArr[0];
            int startTime = Integer.parseInt(rawStartTime.split(":")[0]) * 60 + Integer.parseInt(rawStartTime.split(":")[1]);
            String rawEndTime = infoArr[1];
            int endTime = Integer.parseInt(rawEndTime.split(":")[0]) * 60 + Integer.parseInt(rawEndTime.split(":")[1]);
            String title = infoArr[2];
            String melody = convert(infoArr[3]);
            String allMelody = "";
            int index = 0;
            for(int i=startTime;i<=endTime;i++) {
                String now = String.valueOf(melody.charAt(index));
                if(index != melody.length() -1 && melody.charAt(index + 1) == '#') {
                    index++;
                    now += melody.charAt(index);
                }
                allMelody += now;
                index++;
                if (index == melody.length()) index = 0;
            }
            if (allMelody.contains(m)) {
                correctMusics.add(new Music(endTime - startTime, title, startTime));
            }
        }
        correctMusics.sort((a, b) -> a.duration == b.duration ? a.startTime - b.startTime : b.duration - a.duration);
        if (correctMusics.isEmpty()) {
            return "(None)";
        }
        return correctMusics.get(0).title;
    }
    
    private static class Music {
        int duration;
        String title;
        int startTime;
        
        Music(int duration, String title, int startTime) {
            this.duration = duration;
            this.title = title;
            this.startTime = startTime;
        }
    }
    
    private String convert(String origin) {
        origin = origin.replace("C#", "H");
        origin = origin.replace("D#", "I");
        origin = origin.replace("F#", "J");
        origin = origin.replace("G#", "K");
        origin = origin.replace("A#", "J");

        return origin;
    }
}