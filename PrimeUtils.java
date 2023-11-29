
import java.util.HashMap;
import java.util.Map;

public class PrimeUtils {

    public static Map<Integer, Integer> getPrimes(int number) throws IllegalArgumentException{
        if(number <= 0){
            throw new IllegalArgumentException("Number must be positive!");
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        if(number == 1 || number == 2)
            return map;

        int org = number;

        if(number % 2 == 0) {
            map.put(2, 0);
            while (number % 2 == 0) {
                number /= 2;
                map.put(2, map.get(2) + 1);
            }
        }

        for(int i = 3; i <= org/2; i += 2) {
            if(number % i == 0) {
                map.put(i, 0);
                while (number % i == 0) {
                    number /= i;
                    map.put(i, map.get(i) + 1);
                }
            }
        }

        return map;
    }

    public static boolean isPrime(int number)  throws IllegalArgumentException{
        if(number <= 0){
            throw new IllegalArgumentException("Number must be positive!");
        }

        if(number == 2) {
            return true;
        }

        if( number == 1 || number % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
