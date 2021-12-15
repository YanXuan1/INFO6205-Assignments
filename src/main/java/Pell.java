public class Pell {
    public Pell() {
    }

    public long get(int n) {
        if (n < 0)
            throw new UnsupportedOperationException("Pell.get is not supported for negative n");
        if (n < 2) {
            return n;
        }

        long[] temp = new long[n + 1];
        temp[0] = 0;
        temp[1] = 1;

        for (int i = 2; i <(n + 1);i++) {
            temp[i] = 2*temp[i - 1]+temp[i - 2];
        }
        return temp[n];
    }
}
