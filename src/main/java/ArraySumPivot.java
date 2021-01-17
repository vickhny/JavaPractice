public class ArraySumPivot {
    static int sum = 0;
    static int index = -1;
    public static void main(String args[]){
        int a[] = {3,5,7,10,7,15,1,4,2,3};
        int b[] = new int[a.length];

        System.out.println(findPivotIndex(a,b));
    }

    private static int findPivotIndex(int[] a, int[] b) {

        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
            b[i] = sum;
        }

        for (int i = 0; i < b.length; i++) {
            if ((b[i] - a[i]) == ((b[b.length-1]-a[i])/2)){
                return i;
            }
        }
        return -1;
    }
}
