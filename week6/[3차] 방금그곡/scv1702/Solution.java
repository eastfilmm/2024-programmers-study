import java.util.*;
import java.util.stream.*;
import static java.util.Comparator.comparing;

class Solution {
    public int parseTime(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
    
    public List<String> parseSheet(String sheet) {
        List<String> result = new ArrayList<>();
        String[] notes = sheet.split("#");
        
        for (int i = 0; i < notes.length; i++) {
            String note = notes[i];
            for (int j = 0; j < note.length() - 1; j++) {
                result.add(Character.toString(note.charAt(j)));
            }
            if (i == notes.length - 1 && sheet.charAt(sheet.length() - 1) != '#') {
                result.add(Character.toString(note.charAt(note.length() - 1)));
            } else {
                result.add(note.charAt(note.length() - 1) + "#");
            }
        }
        
        return result;
    }
    
    public List<String> iterateSheet(List<String> sheet, int time) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < time; i++) {
            result.add(sheet.get(i % sheet.size()));
        }
        return result;
    }
    
    class MusicInfo {
        int start;
        int end;
        String title;
        List<String> playedSheet;
        
        MusicInfo(String start, String end, String title, String sheet) {
            this.start = parseTime(start);
            this.end = parseTime(end);
            this.title = title;
            this.playedSheet = iterateSheet(parseSheet(sheet), this.end - this.start);
        }
        
        public int getPlaytime() {
            return end - start;
        }
        
        public String getTitle() {
            return title;
        }
        
        public boolean contains(List<String> m) {
            return Collections.indexOfSubList(playedSheet, m) >= 0;
        }
    }
    
    public String solution(String m, String[] musicinfos) {
        List<MusicInfo> musicInfos = Arrays.stream(musicinfos)
            .map(musicinfo -> {
                String[] info = musicinfo.split(",");
                return new MusicInfo(info[0], info[1], info[2], info[3]);
            })
            .collect(Collectors.toList());
        
        List<String> parsed = parseSheet(m);
        
        List<String> filtered = musicInfos.stream()
            .filter(musicInfo -> musicInfo.contains(parsed))
            .sorted(comparing(MusicInfo::getPlaytime).reversed())
            .map(MusicInfo::getTitle)
            .collect(Collectors.toList());
        
        if (filtered.size() > 0) {
            return filtered.get(0);
        }
        
        return "(None)";
    }
}