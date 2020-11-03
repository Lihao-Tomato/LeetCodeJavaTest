import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
 * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
 * OJ链接：https://leetcode-cn.com/problems/online-stock-span
 * 解题思路：单调栈，栈内存储（数值，小于等于其的个数），如果当前 price >= 栈顶，把计数累积，弹栈，直到遇到比当前大的，停止
 */

class StockSpanner {

    Stack<Integer> stackPrice;
    Stack<Integer> day;
    public StockSpanner() {
        stackPrice = new Stack<>();
        day = new Stack<>();
    }

    public int next(int price) {
        int w = 1;  //包含自己，初始化为1
        while (!stackPrice.isEmpty() && stackPrice.peek()<=price){
            w += day.pop();
            stackPrice.pop();
        }
        stackPrice.push(price); //将这个price压入栈
        day.push(w);    //将w压入栈，将弹出的天数跨度已经统计
        return w;
    }
}

public class StockSpannerDemo {
    public static void main(String[] args) {
        System.out.println("");
    }
}
