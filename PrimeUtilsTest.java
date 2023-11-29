import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PrimeUtilsTest {

    @Test
    public void shouldPrimeThrowsIllegalArgumentExceptionZero(){
        assertThrows(IllegalArgumentException.class, () -> PrimeUtils.isPrime(0));
    }

    @Test
    public void shouldPrimeThrowsIllegalArgumentExceptionNegativeNumber(){
        assertThrows(IllegalArgumentException.class, () -> PrimeUtils.isPrime(-5));
    }

    @Test
    public void shouldPrimeNotThrowsIllegalArgumentExceptionPositiveNumber(){
        assertDoesNotThrow(() -> PrimeUtils.isPrime(7));
    }

    @Test
    public void shouldPrimeTrueSpecialCase(){
        assertTrue(PrimeUtils.isPrime(2));
    }

    @Test
    public void shouldPrimeTrueCase0() {
        assertTrue(PrimeUtils.isPrime(3));
    }

    @Test
    public void shouldPrimeTrueCase1() {
        assertTrue(PrimeUtils.isPrime(5));
    }

    @Test
    public void shouldPrimeTrueCase2() {
        assertTrue(PrimeUtils.isPrime(7));
    }

    @Test
    public void shouldPrimeTrueCase3() {
        assertTrue(PrimeUtils.isPrime(11));
    }

    @Test
    public void shouldPrimeTrueCase4() {
        assertTrue(PrimeUtils.isPrime(13));
    }

    @Test
    public void shouldPrimeTrueCase5() {
        assertTrue(PrimeUtils.isPrime(17));
    }

    @Test
    public void shouldPrimeTrueCase6() {
        assertTrue(PrimeUtils.isPrime(19));
    }

    @Test
    public void shouldPrimeTrueCase7() {
        assertTrue(PrimeUtils.isPrime(23));
    }

    @Test
    public void shouldPrimeTrueCaseLargeNumber() {
        assertTrue(PrimeUtils.isPrime(1009));
    }

    @Test
    public void shouldPrimeTrueCaseVeryLargeNumber() {
        assertTrue(PrimeUtils.isPrime(1000003));
    }

    @Test
    public void shouldPrimeTrueCaseLargestSigned32BitInteger(){
        assertTrue(PrimeUtils.isPrime(2147483647));
    }

    @Test
    public void shouldPrimeFalseSpecialCase(){
        assertFalse(PrimeUtils.isPrime(1));
    }

    @Test
    public void shouldPrimeFalseCaseEvenNumber1(){
        assertFalse(PrimeUtils.isPrime(4));
    }

    @Test
    public void shouldPrimeFalseCaseEvenNumber2(){
        assertFalse(PrimeUtils.isPrime(6));
    }

    @Test
    public void shouldPrimeFalseCaseEvenNumber3(){
        assertFalse(PrimeUtils.isPrime(8));
    }

    @Test
    public void shouldPrimeFalseCaseEvenNumber4(){
        assertFalse(PrimeUtils.isPrime(10));
    }

    @Test
    public void shouldPrimeFalseCaseOddNumber1(){
        assertFalse(PrimeUtils.isPrime(9));
    }

    @Test
    public void shouldPrimeFalseCaseOddNumber2(){
        assertFalse(PrimeUtils.isPrime(15));
    }

    @Test
    public void shouldPrimeFalseCaseOddNumber3(){
        assertFalse(PrimeUtils.isPrime(21));
    }

    @Test
    public void shouldPrimeFalseCaseLargestSigned32BitNonPrimeInteger(){
        assertFalse(PrimeUtils.isPrime(2147483646));
    }

    @Test
    public void shouldGetPrimesThrowsIllegalArgumentExceptionZero(){
        assertThrows(IllegalArgumentException.class, () -> PrimeUtils.getPrimes(0));
    }

    @Test
    public void shouldGetPrimesThrowsIllegalArgumentExceptionNegativeNumber(){
        assertThrows(IllegalArgumentException.class, () -> PrimeUtils.getPrimes(-5));
    }

    @Test
    public void shouldGetPrimesNotThrowsIllegalArgumentExceptionPositiveNumber(){
        assertDoesNotThrow(() -> PrimeUtils.getPrimes(7));
    }

    @Test
    public void shouldGetPrimesSpecialCaseExceptionalNonPrimeNumber1(){
        assertEquals(Collections.emptyMap(), PrimeUtils.getPrimes(1), "The returned map should be empty!");
    }

    @Test
    public void shouldGetPrimesSpecialCasePrimeNumber2(){
        assertEquals(Collections.emptyMap(), PrimeUtils.getPrimes(2), "The returned map should be empty!");
    }

    @Test
    public void shouldGetPrimesPrimeNumber0(){
        assertEquals(Collections.emptyMap(), PrimeUtils.getPrimes(3), "The returned map should be empty!");
    }

    @Test
    public void shouldGetPrimesPrimeNumber1(){
        assertEquals(Collections.emptyMap(), PrimeUtils.getPrimes(5), "The returned map should be empty!");
    }

    @Test
    public void shouldGetPrimesPrimeNumber2(){
        assertEquals(Collections.emptyMap(), PrimeUtils.getPrimes(7), "The returned map should be empty!");
    }


    @Test
    public void shouldGetPrimesPrimeNumber3(){
        assertEquals(Collections.emptyMap(), PrimeUtils.getPrimes(11), "The returned map should be empty!");
    }

    @Test
    public void shouldGetPrimesPrimeNumber4(){
        assertEquals(Collections.emptyMap(), PrimeUtils.getPrimes(13), "The returned map should be empty!");
    }

    @Test
    public void shouldGetPrimesPrimeNumber5(){
        assertEquals(Collections.emptyMap(), PrimeUtils.getPrimes(17), "The returned map should be empty!");
    }

    @Test
    public void shouldGetPrimesPrimeNumber6(){
        assertEquals(Collections.emptyMap(), PrimeUtils.getPrimes(19), "The returned map should be empty!");
    }

    @Test
    public void shouldGetPrimesPrimeNumber7(){
        assertEquals(Collections.emptyMap(), PrimeUtils.getPrimes(23), "The returned map should be empty!");
    }

    @Test
    public void shoulddGetPrimesLargePrimeNumber(){
        assertEquals(Collections.emptyMap(), PrimeUtils.getPrimes(1009), "The returned map should be empty!");
    }

    @Test
    public void shoulddGetPrimesVeryLargePrimeNumber(){
        assertEquals(Collections.emptyMap(), PrimeUtils.getPrimes(1000003), "The returned map should be empty!");
    }

    @Test
    public void shoulddGetPrimesLargest32BitPrimeNumber(){
        assertEquals(Collections.emptyMap(), PrimeUtils.getPrimes(2147483647), "The returned map should be empty!");
    }

    @Test
    public void shouldGetPrimesNonPrimeNumber0(){
        Map<Integer, Integer> map = Map.of(2,2);
        assertEquals(map, PrimeUtils.getPrimes(4));
    }

    @Test
    public void shouldGetPrimesNonPrimeNumber1(){
        Map<Integer, Integer> map = Map.of(3,1, 2, 1);
        assertEquals(map, PrimeUtils.getPrimes(6));
    }

    @Test
    public void shouldGetPrimesNonPrimeNumber2(){
        Map<Integer, Integer> map = Map.of(2,3);
        assertEquals(map, PrimeUtils.getPrimes(8));
    }

    @Test
    public void shouldGetPrimesNonPrimeNumber3(){
        Map<Integer, Integer> map = Map.of(3,2);
        assertEquals(map, PrimeUtils.getPrimes(9));
    }

    @Test
    public void shouldGetPrimesNonPrimeNumber4(){
        Map<Integer, Integer> map = Map.of(3,2);
        assertEquals(map, PrimeUtils.getPrimes(9));
    }

    @Test
    public void shouldGetPrimesNonPrimeNumber5(){
        Map<Integer, Integer> map = Map.of(5,1, 2,1);
        assertEquals(map, PrimeUtils.getPrimes(10));
    }

    @Test
    public void shouldGetPrimesNonPrimeNumber6(){
        Map<Integer, Integer> map = Map.of(2,2, 3,1);
        assertEquals(map, PrimeUtils.getPrimes(12));
    }

    @Test
    public void shouldGetPrimesNonPrimeNumber7(){
        Map<Integer, Integer> map = Map.of(7,1, 2,1);
        assertEquals(map, PrimeUtils.getPrimes(14));
    }

    @Test
    public void shouldGetPrimesNonPrimeLargeOddNumber(){
        Map<Integer, Integer> map = Map.of(13,1, 5,2);
        assertEquals(map, PrimeUtils.getPrimes(325));
    }

    @Test
    public void shouldGetPrimesNonPrimeLargeEvenNumber(){
        Map<Integer, Integer> map = Map.of(3,4, 2,2);
        assertEquals(map, PrimeUtils.getPrimes(324));
    }

    @Test
    public void shouldGetPrimesNonPrimeVeryLargeEvenNumber(){
        Map<Integer, Integer> map = Map.of(2,1, 3,2, 151, 1, 7,1, 11 , 1, 331 , 1, 31 , 1);
        assertEquals(map, PrimeUtils.getPrimes(2147483646));
    }
}

