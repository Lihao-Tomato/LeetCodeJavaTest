import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:有家动物收容所只收留猫和狗，但有特殊的收养规则，收养人有两种收养方式，
 *      第一种为直接收养所有动物中最早进入收容所的，
 *      第二种为选择收养的动物类型（猫或狗），并收养该种动物中最早进入收容所的。
 *      给定一个操作序列int[][2] ope(C++中为vector<vector<int>>)代表所有事件。
 *      若第一个元素为1，则代表有动物进入收容所，第二个元素为动物的编号，正数代表狗，负数代表猫；
 *      若第一个元素为2，则代表有人收养动物，
 *      第二个元素若为0，则采取第一种收养方式，若为1，则指定收养狗，若为-1则指定收养猫。
 *      请按顺序返回收养的序列。若出现不合法的操作，即没有可以符合领养要求的动物，则将这次领养操作忽略
 * OJ链接：https://www.nowcoder.com/practice/6235a76b1e404f748f7c820583125c50
 */

class CatDogAsylum {
    public ArrayList<Integer> asylum(int[][] ope) {
        // write code here
        Queue<Integer> cat = new LinkedList<>();    //只放猫
        Queue<Integer> dog = new LinkedList<>();    //只放狗
        Queue<Integer> catAndDog = new LinkedList<>();  //猫和狗都放进去
        ArrayList<Integer> result = new ArrayList<>();   //收养的动物
        for (int i = 0; i < ope.length; i++) {
            if (ope[i][0] == 1){    //进收容所
                if (ope[i][1] > 0){ //狗进收容所
                    dog.offer(ope[i][1]);
                } else if (ope[i][1] < 0) { //猫进收容所
                    cat.offer(ope[i][1]);
                }
                catAndDog.offer(ope[i][1]);
            }
            if (ope[i][0] == 2){    //有人收养
                if (ope[i][1] == 1){ //收养最早的狗
                    if (!dog.isEmpty()){
                        int tmp = dog.poll();
                        result.add(tmp);
                        catAndDog.remove(tmp);
                    }
                }
                if (ope[i][1] == -1){ //收养最早的猫
                    if (!cat.isEmpty()){
                        int tmp = cat.poll();
                        result.add(tmp);
                        catAndDog.remove(tmp);
                    }
                }
                if(ope[i][1] == 0){    //采取第一种收养方式--->直接收养所有动物中最早进入收容所的
                    if (!catAndDog.isEmpty()){
                        int tmp = catAndDog.poll();
                        result.add(tmp);
                        if (tmp > 0){   //收养的是狗
                            dog.poll();
                        } else if (tmp < 0){ //收养的是猫
                            cat.poll();
                        }
                    }
                }
            }
        }
        return result;
    }
}

public class CatDogAsylumDemo {
    public static void main(String[] args) {
        CatDogAsylum catDogAsylum = new CatDogAsylum();
        int[][] ope = {{1,1},{1,-1},{2,0},{2,-1}};
        System.out.println(catDogAsylum.asylum(ope));

        System.out.println("猫狗收容所...");
    }
}
