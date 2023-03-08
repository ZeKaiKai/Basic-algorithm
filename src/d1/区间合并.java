package d1;

import java.util.*;

//剑指 Offer II 074. 合并区间
/**
 * 根据左端点排序，使用二维数组存储
 * 排序后有三种情况：
 * 1、区间不相交，即下一个区间的左端点 > 上一个区间的右端点
 *     此时直接将新区间加入结果集
 * 2、区间相交，将右端点更新为两区间右端点最大值即可
 */
public class 区间合并 {
    public static ArrayList<Map<Integer, Integer>> segs = new ArrayList<>();

    public static void main(String[] args) {
        // intervals初始化
        int[][] intervals = new int[100010][2];
        Scanner in = new Scanner(System.in);
        int i = 0;
        while(!in.hasNext("#")) {
            intervals[i][0] = in.nextInt();
            intervals[i][1] = in.nextInt();
            i++;
        }
        // 按照左端点排序
        Arrays.sort(intervals, 0, i, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });


        ArrayList<int[]> merged = new ArrayList<int[]>();
        for (int j = 0; j < i; j++) {
            int L = intervals[j][0], R = intervals[j][1];
            int lastSegIndex = merged.size()-1;
            if (merged.size()==0 || merged.get(lastSegIndex)[1] < L) {
                // 不包含，直接加入
                merged.add(intervals[j]);
            } else {
                // 包含，合并区间，更新右端点
                merged.get(lastSegIndex)[1]= Math.max(R, merged.get(lastSegIndex)[1]);
                merged.set(lastSegIndex, new int[]{L, merged.get(lastSegIndex)[1]});
            }
        }

        // 输出结果
        for (int j = 0; j < merged.size(); j++) {
            System.out.println(merged.get(j)[0] + " "+ merged.get(j)[1]);
        }
    }
}
