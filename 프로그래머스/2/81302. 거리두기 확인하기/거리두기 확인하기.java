class Solution {
    
    private final static int[] dx = {0, 1, -1, 0};
    private final static int[] dy = {-1, 0, 0, 1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int c = 0;c < places.length;c++) {
            String[] place = places[c];
            char[][] room = new char[5][5];
            for(int i=0;i<5;i++) {
                for(int j=0;j<5;j++) {
                    room[i][j] = place[i].charAt(j);
                }
            }
            answer[c] = (isDistanced(room) ? 1:0);
        } 
        return answer;
    }
    
    private boolean isDistanced(char[][] room) {
        for(int i=0;i<room.length;i++) {
            for(int j=0;j<room[i].length;j++) {
                if (room[i][j] != 'P') {
                    continue;
                }
                if (!isDistanced(room, j, i)) return false;
            }
        }
        return true;
    }
    
    private static boolean isDistanced(char[][] room, int x, int y){
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>4||ny>4||nx<0||ny<0) continue;
            if (room[ny][nx] == 'P') {
                return false;
            }
            if (room[ny][nx] == 'O') {
                if(isNextToVolunteer(room,nx,ny,3-i)) return false;
            }
        }
        return true;
    }
    
    private static boolean isNextToVolunteer(char[][] room, int x, int y, int exclude){
        for(int i=0;i<4;i++){
            if(i==exclude)continue;

            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>4||ny>4||nx<0||ny<0) continue;
            if(room[ny][nx] == 'P') return true;
        }
        return false;
    }
}