import java.util.Scanner;
public class FacNLastZero {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        for(int i=5;i<=n;i+=5){
            int j=i;
            while(j%5 == 0){
                count++;
                j /= 5;
            }
        }
        System.out.println(count);
    }
}
