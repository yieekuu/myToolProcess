package liye.carlos.myToolProcess.algorithm;

import java.util.Arrays;

/**
 * Created by liye3 on 2018/3/2.
 */
public class CriminalInvestigation {
    private static int[] res = new int[11];
    private static int[] num = new int[5];

    public static void main(String[] args) {

        Long start = System.currentTimeMillis();
        for (int i1 = 1; i1 < 5; i1++) {
            res[1]=i1;
            for (int i2 = 1; i2 < 5; i2++) {
                res[2]=i2;
                for (int i3 = 1; i3 < 5; i3++) {
                    res[3]=i3;
                    for (int i4 = 1; i4 < 5; i4++) {
                        res[4]=i4;
                        for (int i5 = 1; i5 < 5; i5++) {
                            res[5]=i5;
                            for (int i6 = 1; i6 < 5; i6++) {
                                res[6]=i6;
                                for (int i7 = 1; i7 < 5; i7++) {
                                    res[7]=i7;
                                    for (int i8 = 1; i8 < 5; i8++) {
                                        res[8]=i8;
                                        for (int i9 = 1; i9 < 5; i9++) {
                                            res[9]=i9;
                                            for (int i10 = 1; i10 < 5; i10++) {
                                                res[10]=i10;
                                                if (test1(i1) &&
                                                        test2(i2) &&
                                                        test3(i3) &&
                                                        test4(i4) &&
                                                        test5(i5) &&
                                                        test6(i6) &&
                                                        test7(i7) &&
                                                        test8(i8) &&
                                                        test9(i9) &&
                                                        test10(i10)) {
                                                    System.out.println(Arrays.toString(res));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        Long end = System.currentTimeMillis();
        System.out.println(end-start);

    }

    private static boolean test1(int x) {
        return res[1] == x;
    }

    private static boolean test2(int x) {
        if (x == 1) {
            return res[5] == 3;
        }
        if (x == 2) {
            return res[5] == 4;
        }
        if (x == 3) {
            return res[5] == 1;
        }
        if (x == 4) {
            return res[5] == 2;
        }
        return false;
    }

    private static boolean test3(int x) {
        if (x == 1) {
            return ((res[2] == res[4] && res[4] == res[6]) && (res[3] != res[2]));
        }
        if (x == 2) {
            return ((res[2] == res[3] && res[3] == res[4]) && (res[6] != res[2]));
        }
        if (x == 3) {
            return ((res[3] == res[4] && res[4] == res[6]) && (res[3] != res[2]));
        }
        if (x == 4) {
            return ((res[2] == res[3] && res[3] == res[6]) && (res[4] != res[2]));
        }
        return false;
    }

    private static boolean test4(int x) {
        if (x == 1) {
            return res[1] == res[5];
        }
        if (x == 2) {
            return res[2] == res[7];
        }
        if (x == 3) {
            return res[1] == res[9];
        }
        if (x == 4) {
            return res[6] == res[10];
        }
        return false;
    }

    private static boolean test5(int x) {
        if (x == 1) {
            return res[5] == res[8];
        }
        if (x == 2) {
            return res[5] == res[4];
        }
        if (x == 3) {
            return res[5] == res[9];
        }
        if (x == 4) {
            return res[5] == res[7];
        }
        return false;
    }

    private static boolean test6(int x) {
        if (x == 1) {
            return res[2] == res[4] && res[4] == res[8];
        }
        if (x == 2) {
            return res[1] == res[6] && res[6] == res[8];
        }
        if (x == 3) {
            return res[3] == res[10] && res[10] == res[8];
        }
        if (x == 4) {
            return res[5] == res[9] && res[9] == res[8];
        }
        return false;
    }

    private static boolean test7(int x) {
        calcNum();
        int min = 1;
        int temp = num[1];
        for (int i = 1; i < 5; i++) {
            min = temp < num[i] ? min : i;
            temp = num[min];
        }
        switch (x) {
            case 1:
                return min == 3;
            case 2:
                return min == 2;
            case 3:
                return min == 1;
            case 4:
                return min == 4;
            default:
                return false;
        }
    }

    private static boolean test8(int x) {
        switch (x) {
            case 1:
                return isNearBy(7);
            case 2:
                return isNearBy(5);
            case 3:
                return isNearBy(2);
            case 4:
                return isNearBy(10);
            default:
                return false;
        }
    }

    private static boolean test9(int x) {
        switch (x) {
            case 1:
                return isTrueOrFalse(6);
            case 2:
                return isTrueOrFalse(10);
            case 3:
                return isTrueOrFalse(2);
            case 4:
                return isTrueOrFalse(9);
            default:
                return false;
        }
    }

    private static boolean test10(int x) {
        int max = 0;
        int min = 10;
        for (int i = 1; i < 5; i++) {
            max = max > num[i] ? max : num[i];
            min = min < num[i] ? min : num[i];
        }
        int aa = max - min;
        switch (x) {
            case 1:
                return aa == 3;
            case 2:
                return aa == 2;
            case 3:
                return aa == 4;
            case 4:
                return aa == 1;
            default:
                return false;
        }
    }

    private static void calcNum() {
        //初始化统计数组
        for (int i = 1; i < 5; i++) {
            num[i] = 0;
        }
        for (int i = 1; i < 11; i++) {
            num[res[i]]++;
        }
    }

    private static boolean isNearBy(int x) {
        return !(((res[1] + 1) == res[x]) || ((res[1] - 1) == res[x]));
    }

    private static boolean isTrueOrFalse(int x) {
        boolean a = res[1] == res[6];
        boolean b = res[x] == res[5];
        return a ^ b;
    }

    private static void init() {
        for (int i = 0; i < 11; i++) {
            res[i] = 0;
        }
    }
}
