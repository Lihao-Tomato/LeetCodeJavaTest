import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * Description:现有n个人围坐一圈，顺时针给大家编号，第一个人编号为1，然后顺时针开始报数。
 *          第一轮依次报1，2，1，2...没报1的人出局。
 *          接着第二轮再从上一轮最后一个报数的人开始依次报1，2，3，1，2，3...没报1的人都出局。
 *          以此类推直到剩下以后一个人。
 *          现给定一个int n，要求返回最后一个人的编号。
 * OJ链接：https://www.nowcoder.com/practice/ff063da83b1a4d91913dd1b1e8b01466
 */
public class Joseph {
    public static int getResult(int n) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        int round = 2, cur = 0;
        for (int i = 1; i <= n; i++) {
            res.add(i);
        }
        while (res.size() > 1){
            int j = 0;
            while (res.size()>1 && j<res.size()){
                cur = (cur+1)%round;
                if (cur != 1){ //没有报到1的人
                    res.remove(j);
                } else {
                    j++;
                }
            }
            round++;
            cur = 0;
            if (res.size() > 1){
                res.addFirst(res.removeLast()); //将上一次最后一个数放到开头
            }
        }
        return res.pop();
    }

    public static void main(String[] args) {
        System.out.println(getResult(10));
    }
}