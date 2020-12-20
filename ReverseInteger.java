import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:整数反转
 * OJ链接：https://leetcode-cn.com/problems/reverse-integer/
 * 注意：reversN * 10 + tmp > MAX_VALUE这个溢出条件来看
 *      当出现 reversN > MAX_VALUE / 10 且 还有tmp需要添加 时，则一定溢出
 *      当出现 reversN == MAX_VALUE / 10 且 tmp > 7 时，则一定溢出，7是2^31 - 1的个位数
 *      reversN * 10 + tmp < MIN_VALUE这个溢出条件来看
 *      当出现 reversN < MIN_VALUE / 10 且 还有tmp需要添加 时，则一定溢出
 *      当出现 reversN == MIN_VALUE / 10 且 tmp < -8 时，则一定溢出，8是-2^31的个位数
 */
public class ReverseInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int reversN = 0;
        int tmp;
        while (n != 0){
            tmp = n % 10;
            if(reversN>Integer.MAX_VALUE/10 || (reversN==Integer.MAX_VALUE/10 && tmp>7)){
                break;
            }
            if(reversN<Integer.MIN_VALUE/10 || (reversN==Integer.MIN_VALUE/10 && tmp<-8)){
                break;
            }
            n /= 10;
            reversN = reversN*10+tmp;
        }
        System.out.println(reversN);
    }
}
