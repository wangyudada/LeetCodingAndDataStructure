package month1.day21;

/**
 * 贪心算法做剪绳子问题
 * 给你一个长度为n的绳子，请把绳子剪成m段（m，n都是整数，且都大于1）
 * 每段绳子的长度即为K[0],K[1],K[2]...K[m]。请问K[0]*k[1]..*k[m]可能的最大乘积是多少？
 */
public class greedyCutRope {
    public static void main(String[] args) {
        System.out.println(greedyCutRope2(8));
    }

    /**
     * 迭代法做
     *
     * @param n
     * @return
     */
    public static int greedyCutRope1(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }
        /*
        尽量多剪长度为3的绳子，因为当n>=5的时候，只有3*(n-3)和2(n-2)才会大于等于n
        这边可以理解为，先剪出来了一个3，剩下的部分长度即为n-3(2同理)，如果n>=5，剪3的永远大于剪2的
        其他剪4、5的，可以分化成剪2、3的情况
         */
//        计算总共可以剪出来几个3
        int timesOf3 = n / 3;

//        当绳子最后剩下的长度为4的时候，不能再剪去长度为3的绳子段
        if (n - timesOf3 * 3 == 1) {
//            如果最后只剩一个1，则需要留下一个3，和这个1组成两个2，2*2>1*3
            timesOf3 -= 1;
        }

//        保证剩下的一定是4或者2或者0,计算一下能剪出几个2来(只有2/1/0三种情况)。
        int timesOf2 = (n - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }

    /**
     * 递归做
     *
     * @param n
     * @return
     */
    public static int greedyCutRope2(int n) {
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 3;
        }
        if (n < 2) {
            return 1;
        }
        if (n == 4) {
            return 4;
        }
        return 3 * greedyCutRope2(n - 3);
    }
}
