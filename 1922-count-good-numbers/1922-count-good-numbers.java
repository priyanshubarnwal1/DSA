class Solution {
    static final long MOD = 1000000007;
    public long findPower(long a, long b){
        if(b==0){
            return 1;
        }
        long half = findPower(a,b/2);
        long result = (half * half) % MOD;
        if(b%2 == 1){
            result = (result * a) % MOD;
        }
        return result;
    }
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = n/2;

        long ans = (findPower(5,even)*findPower(4,odd))%MOD;

        return (int) ans;
    }
}