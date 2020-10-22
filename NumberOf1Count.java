import java.util.Scanner;

public class NumberOf1Count {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int count = 0;
        for (int i=0;i<=num;i++){
            for (int j=i;j>0;j/=10){
                if (j%10 == 1){
                    count++;
                }
            }
        }
        System.out.println("OneOfCount="+count);
    }
}
