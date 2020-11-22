import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
 * OJ链接：https://leetcode-cn.com/problems/most-common-word/
 * 解题思路：统计每一个单词出现的次数放入map中，每次放入的时候需要查看banned中是否包含这个字符串，从而实现一次遍历解决
 */
public class MostCommonWord {

    public static String mostCommonWord(String paragraph, String[] banned){
        Map<String,Integer> map = new HashMap<>();  //存放paragraph中的单词频率
        Set<String> set = new HashSet<>(); //存放banned中的单词
        for (String str : banned) {
            set.add(str);
        }
        StringBuffer sb = new StringBuffer();
        int max = 0; //单词出现频率最大的值
        String maxStr = "";
        for (int i = 0; i < paragraph.length(); i++) {
            char ch = paragraph.charAt(i);
            if ((ch>='a' && ch<='z') || (ch>='A' && ch<='Z')){
                sb.append(ch);  //提取出paragraph中的单词
                continue;
            } else {
                if (sb.length() > 0) {
                    String res = sb.toString().toLowerCase();
                    map.put(res, map.getOrDefault(res, 0) + 1);    //设置当前单词的频率
                    if ((set.isEmpty() || !set.contains(res)) && map.get(res) > max) {
                        max = map.get(res); //重新设置最大值
                        maxStr = res;
                    }
                    sb = new StringBuffer();   //清空sb
                }
            }
        }
        if (sb.length() != 0){ //考虑到paragraph中最后一个单词结束的情况
            String res = sb.toString().toLowerCase();
            map.put(res, map.getOrDefault(res,0)+1);    //设置当前单词的频率
            if ((set.isEmpty() || !set.contains(res)) && map.get(res)>max){
                max = map.get(res); //重新设置最大值
                maxStr = res;
            }
            sb.delete(0,sb.length());
        }
        return maxStr;
    }

    public static void main(String[] args) {
        String paragraph = "L, P! X! C; u! P? w! P. G, S? l? X? D. w? m? f? v, x? i. z; x' m! U' M! j? " +
                "V; l. S! j? r, K. O? k? p? p, H! t! z' X! v. u; F, h; s? X? K. y, Y! L; q! y? j, o? D' y? " +
                "F' Z; E? W; W' W! n! p' U. N; w? V' y! Q; J, o! T? g? o! N' M? X? " +
                "w! V. w? o' k. W. y, k; o' m! r; i, n. k, w; U? S? t; O' g' z. V. N? z, " +
                "W? j! m? W! h; t! V' T! Z? R' w, w? y? y; O' w; r? q. G, V. x? n, Y; Q. s? S. G. f, s! U? l. o! i. L; Z' X! u. y, Q. q; Q, D; V. m. q. s? Y, U; p? u! q? h? O. W' y? Z! x! r. E, R, r' X' V, b. z, x! Q; y, g' j; j. q; W; v' X! J' H? i' o? n, Y. X! x? h? u; T? l! o? z. K' z' s; L? p? V' r. L? Y; V! V' S. t? Z' T' Y. s? i? Y! G? r; Y; T! h! K; M. k. U; A! V? R? C' x! X. M; z' V! w. N. T? Y' w? n, Z, Z? Y' R; V' f; V' I; t? X? Z; l? R, Q! Z. R. R, O. S! w; p' T. u? U! n, V, M. p? Q, O? q' t. B, k. u. H' T; T? S; Y! S! i? q! K' z' S! v; L. x; q; W? m? y, Z! x. y. j? N' R' I? r? V! Z; s, O? s; V, I, e? U' w! T? T! u; U! e? w? z; t! C! z? U, p' p! r. x; U! Z; u! j; T! X! N' F? n! P' t, X. s; q'";
        String[] banned = {"m","i","s","w","y","d","q","l","a","p","n","t","u","b","o","e","f","g","c","x"};
        System.out.println(mostCommonWord(paragraph, banned));
    }
}