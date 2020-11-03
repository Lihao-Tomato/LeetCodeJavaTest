/**
 * Created with IntelliJ IDEA.
 * Description:在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
 * 如果小镇的法官真的存在，那么：
 * 小镇的法官不相信任何人。
 * 每个人（除了小镇法官外）都信任小镇的法官。
 * 只有一个人同时满足属性 1 和属性 2 。
 * OJ链接：https://leetcode-cn.com/problems/find-the-town-judge
 */
public class FindJudge {
    public static void main(String[] args) {
        System.out.println("找到法官...");
    }

    public static int findJudge(int N, int[][] trust) {
        int inDegree[] = new int[N + 1];    //标记了N个人
        int outDegree[] = new int[N + 1];
        for (int[] path : trust) {
            int start = path[0];
            int end = path[1];
            outDegree[start]++; //标记信任多少个人
            inDegree[end]++;    //标记一共被多少个人信任
        }
        for (int i = 1; i <= N; i++) {
            if (outDegree[i] == 0 && inDegree[i] == N - 1) {    //只有法官是被N-1人信任，信任0个人
                return i;
            }
        }
        return -1;
    }
}
