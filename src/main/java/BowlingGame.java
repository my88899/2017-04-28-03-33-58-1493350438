import java.util.*;

public class BowlingGame {
    public int getBowlingScore(String bowlingCode) {
        String[] grids = bowlingCode.split("\\||\\|\\|");
        int score = 0;
        int next1 = 1, next2 = 1;
        for (int i=0; i<10; i++) {
            String e = grids[i];
            int scoreTemp = 0;
            int scoreOnePoint = 0;
            for (int j=0; j<e.length(); j++) {
                char ball = e.charAt(j);
                if (ball == '-') ball = '0';
                if (ball == 'X') {
                    scoreTemp = 10*next1;
                    next1 = next2+1;
                    next2 = 2;
                } else if (ball == '/') {
                    scoreTemp += (10 - scoreOnePoint) * next1;
                    next1 = next2+1;
                    next2 = 1;
                }
                else{
                    scoreOnePoint =  ball - '0';
                    scoreTemp +=  scoreOnePoint*next1;
                    next1 = next2;
                    next2 = 1;

                }
            }
            score += scoreTemp;
        }
        next1-=1;next2-=1;
        if(grids.length>10){
            switch (grids[11].charAt(0)){
                case 'X':
                    score += 10*next1;
                    break;
                case '-':
                    break;
                default:
                    score += (grids[11].charAt(0)-'0') * next1;
                    break;
            }
            if(next2 !=0) {
                switch (grids[11].charAt(1)) {
                    case 'X':
                        score += 10 * next2;
                        break;
                    case '-':
                        break;
                    default:
                        score += (grids[11].charAt(1) - '0') * next2;
                        break;
                }
            }
        }
        return score;
    }
}
