import lombok.Data;
import org.junit.Test;

import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.*;

public class CollectionTest {

    @Test
    public void myTest() {
        int setNum = 20; // 集合总数
        int setSize = 1200000; // 每个集合包含的数字数量
        int randomRange = 2000000; // 生成随机数的范围

        // 用bitSet保存
        BitSet[] bitSetArray = new BitSet[setNum];

        // 随机生成数据
        for (int i = 0; i < setNum; i++) {
            Set<Integer> set = new HashSet<Integer>();

            BitSet bitSet = new BitSet(randomRange);
            for (int j = 0; j < setSize; j++) {
                /**
                 * 随机生成 randomRange 内的数
                 * 每个set存放 setSize 个数
                 */
                int randomNum = new Random().nextInt(randomRange);
                // 保证不重复
                while (set.contains(randomNum))
                    randomNum = new Random().nextInt(randomRange);
                // 把bitset对应的位设为true
                bitSet.set(randomNum, true);
            }
            bitSetArray[i] = bitSet;
        }


        /**
         * 方案三
         * 使用bitSet查找，只需要用一个bitSet依次与剩余的做逻辑与（AND）操作即可。
         * 例如求s1:{1, 2, 4, 8, 10, 11, 20}和s2:{3, 8, 10, 11, 15, 17, 20}的交集
         * 这两个用bitSet表示即为
         * s1:011010001011000000001
         * s2:000100001011000101001;
         * s1 AND s2 = 000000001011000000001;
         * 这个集合表示数集{8, 10, 11, 20};
         * 用bitSet来存储可以压缩存储空间，一位即可表示一个数字，且求交集简单，运算速度快，
         * 缺点是当集合的数比较散列时（即不是集中在某一个范围），则会占用比较多的空间。
         * 计算后的bitSet即保存了交集的结果---即为true的位所对应的数。
         */
        long beginTime = System.nanoTime();
        BitSet resultSet = bitSetArray[0];
        // 用第一个bitSet依次与剩下的bitSet做逻辑与操作
        for (int i = 1; i < setNum; i++) {

            resultSet.and(bitSetArray[i]);
        }
        long endTime = System.nanoTime();
        System.out.println();
        System.out.println("使用bitSet方法，运行时间：" + (endTime - beginTime));
        System.out.println("交集里的数有" + resultSet.cardinality() + "个。 如下：");
        for (int i = 0; i < resultSet.size(); i++) {

            if (resultSet.get(i))
                System.out.print(i + " ");
        }
    }

    @Data
    class MyData {
        Integer o;
        MyData set(Integer o) {
            this.o = o;
            return this;
        }

        Integer get() {
            return o;
        }
    }

    final int _1500W = 1500 * 10000;
    final long start = 10000000000000000L;

    @Test
    public void myTestHashMa(){
        System.out.println("測試2");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        System.out.println("初始化数据");
        List<Long> list1= new ArrayList<Long>(_1500W);
        List<Long> list2= new ArrayList<Long>(_1500W);
        List<Long> list3 = new ArrayList<Long>(_1500W);
        List<Long> list4 = new ArrayList<Long>(_1500W);

        HashMap<Long,MyData> map = new HashMap<Long, MyData>(_1500W);
        for(Long l = start; l<start + _1500W; l++){
            list1.add(l);
        }
        for(Long l = start; l<start + _1500W; l++){
            list2.add(l);
        }
        for(Long l = start; l<start + _1500W; l++){
            list3.add(l);
        }
        for(Long l = start; l<start + _1500W; l++){
            list4.add(l);
        }
        System.out.println("初始化数据结束");
        System.out.println(sdf.format(new Date()));

        for(Long temp:list1){
            map.put(temp,new MyData().set(1));
        }
        for(Long temp:list2){
            if(map.containsKey(temp)){
                MyData value = map.get(temp);
//                Integer integer = value.get();
//                value.set(++integer);
            }
        }
        for(Long temp:list3){
            if(map.containsKey(temp)){
                MyData value = map.get(temp);
//                Integer integer = value.get();
//                value.set(++integer);
            }
        }
        for(Long temp:list4){
            if(map.containsKey(temp)){
                MyData value = map.get(temp);
//                Integer integer = value.get();
//                value.set(++integer);
            }
        }
        //System.out.println(map);
        System.out.println("取交集结束");
        System.out.println(sdf.format(new Date()));

//        ThreadLocal
//        Proxy.newProxyInstance(String.class.getClassLoader(), )
    }
}
