package com.example.demo.tools;

/**
 * Java订单号生成（雪花算法生成分布式唯一id）
 * 因为生成的位数是17位，若想增加位数的话，再加个时间就好了，好比20181111+idWorker.nextId()前面的20181111通过java生成的，就可以获取你想要的位数了，切记不能切割掉后几位了，否则重复
 */
public class RecordNoUtils {
    //这里的0，0分别是      * @param workerId 工作ID (0~31)     * @param datacenterId 数据中心ID (0~31)，可以写在配置文件中。
    private static UniqueOrderGenerate idWorker = new UniqueOrderGenerate(0, 0);

    public static RecordNoUtils getInstance() {
        return new RecordNoUtils();
    }

    public static  String get() {
        return String.valueOf(idWorker.nextId());

    }

    public static void main(String[] args) {
        System.out.println(get());
    }
}