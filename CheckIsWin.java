/* *
题目：井字棋
题目描述：给定一个二维数组board，代表棋盘，其中元素为1的代表是当前玩家的棋子，0表示没有棋子，-1代表是对方玩家的棋子。
        当一方棋子在横竖斜方向上有连成排的及获胜（及井字棋规则），返回当前玩家是否胜出。
OJ链接：https://www.nowcoder.com/practice/e1bb714eb9924188a0d5a6df2216a3d1?tpId=8&&tqId=11055&rp=1&ru=/activity/oj&qru=/ta/cracking-the-coding-interview/question-ranking
 */

public class CheckIsWin {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 0, 1},
                {1, -1, -1},
                {1, -1, 0}
        };
        boolean isWin = checkWin(mat);
        System.out.println(isWin);
    }

    public static boolean checkWin(int[][] mat){
        if (mat[0][0]==1 && mat[1][1]==1 && mat[2][2]==1){  //交叉获胜
            return true;
        }
        if (mat[0][2]==1 && mat[1][1]==1 && mat[2][0]==1){  //交叉获胜
            return true;
        }
        for (int i = 0; i < 3; i++) {
            if (mat[i][0]==1 && mat[i][1]==1 && mat[i][2]==1){  //同行取胜
                return true;
            }
            if (mat[0][i]==1 && mat[1][i]==1 && mat[2][i]==1){  //同列取胜
                return true;
            }
        }
        return false;
    }
}
