/**
 * Created by a123 on 2017/10/11.
 */

public class Median {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        int total = m + n;
        if(total % 2 == 1)
            return findMedian(A, 0, m, B, 0, n, total / 2 + 1);
        else
            //无论是奇数还是偶数都可以满足
            return (findMedian(A, 0, m, B, 0, n, total / 2) +
                    findMedian(A, 0, m, B, 0, n, total / 2 + 1)) / 2.0;
    }

    private double findMedian(int[] a, int al, int ar, int[] b, int bl, int br, int k) {
        if(ar > br) return findMedian(b, bl, br, a, al, ar, k);
        if(ar == 0) return b[bl + k - 1];
        if(k == 1) return Math.min(a[al], b[bl]);
        int pa = Math.min(k / 2, ar);
        int pb = k - pa;
        if(a[al + pa - 1] == b[bl + pb - 1])
            return a[al + pa - 1];
        else if(a[al + pa - 1] < b[bl + pb - 1])
            return findMedian(a, al + pa, ar - pa, b, bl, br, k - pa);
        else
            return findMedian(a, al, ar, b, bl + pb, br - pb, k - pb);
    }
}