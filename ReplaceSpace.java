/* *
题目：替换空格
题目描述：请实现一个函数，将一个字符串中的每个空格替换成“%20”。
        例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
OJ链接：https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?
解题思路：虽然是替换问题，但是生成的字符串整体变长了，因替换内容比被替换内容长，所以，一定涉及到字符串中字符的移动问题
        移动方向一定是向后移动，所以现在的问题无非是移动多少的问题
        因为是 ' ' -> "%20",是1换3，所以可以先统计原字符串中空格的个数(设为n)，然后可以计算出新字符串的长度
        所以：new_length = old_length + 2*n
        最后，定义新老索引（或者指针），各自指向新老空间的结尾，然后进行old->new的移动
        如果是空格，就连续放入“%20”,其他平移即可
 */

public class ReplaceSpace {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer(" We Are Happy ");
        String newStr = replaceSpace(str);
        System.out.println(newStr);
    }

    public static String replaceSpace(StringBuffer str){
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                count++;
            }
        }
        int newStrLength = str.length() + count * 2;  //将空格替换后新字符串的长度
        int old_end = str.length()-1; //旧字符串最后一个字符的索引
        int new_end = newStrLength-1; //新字符串最后一个字符的索引
        str.setLength(newStrLength); //将字符串长度设置为新字符串的长度
        while (old_end>=0 && new_end>=0){
            if (str.charAt(old_end) == ' '){
                str.setCharAt(new_end--, '0');
                str.setCharAt(new_end--, '2');
                str.setCharAt(new_end--,'%');
                old_end--;
            }
            else {
                str.setCharAt(new_end--, str.charAt(old_end));
                old_end--;
            }
        }
        return str.toString();
    }
}
