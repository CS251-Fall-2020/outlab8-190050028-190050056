import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SieveAlternate {
    public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		List<Boolean> primes = IntStream.range(0, n + 1).boxed().map(v -> true).collect(Collectors.toList());
		List<Integer> p = IntStream.range(2, n+1).boxed().map(v -> {
			if (primes.get(v)) {
				System.out.print(v + " ");
				List<Integer> nondiv = IntStream.range(v+1, n+1).boxed().filter(val -> {
					if (val%v==0) primes.set(val, false);
					return true;
				    }).collect(Collectors.toList());
			}
			return v;
		    }).filter(v->primes.get(v)).collect(Collectors.toList());
    }
}
