public class MergeSort {
    public static void sortInt(int[] arr, boolean isAscending) {
        int n = arr.length;

        if (n == 1) {
            return;
        }

        int mid = n / 2;

        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++)
            l[i] = arr[i];

        for (int i = mid; i < n; i++)
            r[i - mid] = arr[i];

        sortInt(l, isAscending);
        sortInt(r, isAscending);
        mergeInt(arr, l, r, isAscending);
    }

    private static void mergeInt(int[] arr, int[] l, int[] r, boolean isAscending) {
        int left = l.length;
        int right = r.length;
        int i = 0;
        int j = 0;
        int idx = 0;

        while (i < left && j < right) {
            if (isAscending) {
                if (l[i] < r[j]) {
                    arr[idx] = l[i];
                    i++;
                } else {
                    arr[idx] = r[j];
                    j++;
                }
                idx++;
            } else {
                if (l[i] > r[j]) {
                    arr[idx] = l[i];
                    i++;
                } else {
                    arr[idx] = r[j];
                    j++;
                }
                idx++;
            }
        }

        for (int ll = i; ll < left; ll++)
            arr[idx++] = l[ll];

        for (int rr = j; rr < right; rr++)
            arr[idx++] = r[rr];
    }

    public static void sortString(String[] arr, boolean isAscending) {
        int n = arr.length;

        if (n == 1) {
            return;
        }

        int mid = n / 2;

        String[] l = new String[mid];
        String[] r = new String[n - mid];

        for (int i = 0; i < mid; i++)
            l[i] = arr[i];

        for (int i = mid; i < n; i++)
            r[i - mid] = arr[i];

        sortString(l, isAscending);
        sortString(r, isAscending);
        mergeString(arr, l, r, isAscending);
    }

    private static void mergeString(String[] arr, String[] l, String[] r, boolean isAscending) {
        int left = l.length;
        int right = r.length;
        int i = 0;
        int j = 0;
        int idx = 0;

        while (i < left && j < right) {
            if (isAscending) {
                if (l[i].compareTo(r[j]) < 0) {
                    arr[idx] = l[i];
                    i++;
                } else {
                    arr[idx] = r[j];
                    j++;
                }
                idx++;
            } else {
                if (l[i].compareTo(r[j]) > 0) {
                    arr[idx] = l[i];
                    i++;
                } else {
                    arr[idx] = r[j];
                    j++;
                }
                idx++;
            }
        }

        for (int ll = i; ll < left; ll++)
            arr[idx++] = l[ll];

        for (int rr = j; rr < right; rr++)
            arr[idx++] = r[rr];
    }
}