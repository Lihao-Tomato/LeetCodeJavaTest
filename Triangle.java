import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * OJ链接：https://leetcode-cn.com/problems/pascals-triangle/
 */
public class Triangle {
    public static void main(String[] args) {
        System.out.println("****");
    }
}

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if(numRows == 0){
            return ret;
        }
        //第一行
        List<Integer> one = new ArrayList<>();
        one.add(1);
        ret.add(one);
        for(int i=1;i<numRows;i++){
            //当前行
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);
            //上一行
            List<Integer> preRow = ret.get(i-1);
            for(int j=1;j<i;j++){
                curRow.add(preRow.get(j-1) + preRow.get(j));
            }
            //该行的最后一个1
            curRow.add(1);
            ret.add(curRow);
        }
        return ret;
    }
}