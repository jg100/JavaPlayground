package bitwise;

public class ConcatBinary {

    /**
     * Disecting code to understand. Not mine.
     * @param n
     * @return
     */

    public int concatenatedBinary(int n) {
        //calculate the length of binary string
        long MOD = 1000_000_007;

        StringBuilder sb = new StringBuilder();
        int length = 0;
        long sum = 0;
        for(int i=1; i<=n; i++)
        {
            if((i & i-1) == 0)
            {
                length++;
            }
            //System.out.println(length);
            sum <<= length;
            sum += i;

            if(sum > MOD)
            {
                sum %= MOD;
            }



        }

        return (int)(sum % MOD);
    }
}
