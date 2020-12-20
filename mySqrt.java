import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:x 的平方根
 * OJ链接：https://leetcode-cn.com/problems/sqrtx/
 * 注意：这里为什么使用的是 (left + right + 1) >>> 1 ， 而不是跟之前一样使用 (left + right) >>> 1 ？
 *      因为我们下面需要的是 right = mid - 1 而不是 left = mid + 1，如果 (left + right) >>> 1 的话 left = mid 可能会造成死循环
 *      为什么使用 right = mid - 1？
 *      在不存在 一个整数平方等于 x 的情况下，比如 x = 8，有以下情况：
*       因为我们要求的是 相邻的两个数 x1 和 x2 ，x1 的平方比 x 小， x2 的平方比 x 大
*       比如 x = 8，那么 x1 = 2, x2 = 3
*       而我们需要返回的是 x1 = 2，即较小的值，因此，当我们遇到大值的时候，需要跳过该大值，往小值方向找
*       与以往的跳过小值，找大值不同
*       如果是以往的二分查找模板，那么当 break 找到的就会是 x2 = 3*int mid=(left+right+1)>>>1;
*       注意：有案例是 2147395599，求得 mid 平方会超过 int ，因此需要将平方结果转为 long
 */
public class mySqrt {
    public static void main(String[] args) {
        int x = 8;
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
