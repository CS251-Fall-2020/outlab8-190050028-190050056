import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.ArrayList;
public class seive{
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        List<Integer>list=IntStream.range(2, n).boxed().collect(ArrayList::new,(ans,num)-> {
                if(ans.stream()
                    .filter(num2-> num2*num2<=num)
                    .noneMatch(num2->  num%num2 == 0)){
                        ans.add(num);
                        System.out.print(num+" ");
                    }
        },List::addAll);
    }

}
