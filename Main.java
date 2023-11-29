import java.util.Formatter;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        if(args.length != 1){
            System.err.println("Please enter only one non-prime integer! Multiple commandline arguments are not allowed!");
            System.exit(-1);
        }

        int i = 0;
        try {
             i = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Entered value is not an integer: " + e.getMessage());
            System.exit(-1);
        } catch( Exception e){
            System.err.println("Unexpected Exception occurred: " + e.getMessage());
            System.exit(-1);
        }

        if(i <= 0){
            System.err.println("Please enter a positive integer! " );
            System.exit(-1);
        }

        if(i == 1){
            System.err.println("1 is an exceptional non-prime number!\n1 has one and only one factor which is 1 itself. Thus, 1 is not considered a Prime number");
            System.exit(-1);
        }

        if(PrimeUtils.isPrime(i)){
            System.err.println("The entered number is already a prime number: "+ i +"\n Please enter a non-prime number!" );
            System.exit(-1);
        }

        printPrimeCountTable(PrimeUtils.getPrimes(i));
    }

    private static void printPrimeCountTable(Map<Integer, Integer> primesCountMap) {
        Formatter fmt = new Formatter();
        fmt.format("%15s %15s\n", "Prime", "Count");
        for (int n : primesCountMap.keySet())
        {
            fmt.format("%14s  %14s\n", n, primesCountMap.get(n));
        }
        System.out.println(fmt);
    }

}
