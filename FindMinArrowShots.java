import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * Description:在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。
 *      由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 *      一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，
 *      若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可
 *      以射出的弓箭的数量没有限制。
 *      弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 *      给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 * OJ链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons
 * 解题思路：将数组按开始坐标排序，然后判断下一个是否能被一箭射穿：
 *              是：则更新start和end坐标，取交集
 *              否：更新start和end的坐标，为新数组的范围
 */
public class FindMinArrowShots {

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        System.out.println(Arrays.deepToString(points));
        int start = points[0][0];
        int end = points[0][1];
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if ((points[i][0]>=start && points[i][0]<=end) || (points[i][1]>=start && points[i][1]<=end)){
                start = Math.max(start,points[i][0]);
                end = Math.min(end,points[i][1]);
            } else {
                count++;
                start = points[i][0];
                end = points[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points = {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
        System.out.println(findMinArrowShots(points));
    }
}
