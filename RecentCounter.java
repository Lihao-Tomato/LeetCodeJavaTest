import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:写一个 RecentCounter 类来计算特定时间范围内最近的请求。
 *      请你实现 RecentCounter 类：
 *      RecentCounter() 初始化计数器，请求数为 0 。
 *      int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
 *      保证每次对 ping 的调用都使用比之前更大的 t 值。
 * OJ链接：https://leetcode-cn.com/problems/number-of-recent-calls/
 * 题解：使用一个队列就可以解决，每次收到一个请求把该请求放入队列中，然后查看队首元素是否满足[t-3000,t]这个条件，不满足就把弹出，
 *      满足则返回现在的队列长度，即为发生的请求数
 */

public class RecentCounter {

    Queue<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList();
    }

    public int ping(int t) {
        queue.offer(t);   //每次进来t，都将其添加到队列中
        while(!queue.isEmpty()){
            if(t-queue.peek() > 3000){ //不满足[t-3000,t]
                queue.poll();
            }
            else{
                break;
            }
        }
        return queue.size(); //队列长度即是满足条件的请求数
    }


    public static void main(String[] args) {
        System.out.println("最近的请求次数");
    }
}

