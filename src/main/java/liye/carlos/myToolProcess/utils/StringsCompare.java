package liye.carlos.myToolProcess.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by liye3 on 2017/9/20.
 */
public class StringsCompare {
    /**
     * 许家印身价达391亿美元 压马云成中国新首富
     许家印身价达391亿美元 力压马云成中国新首富
     许家印身价达391亿美元 成中国新首富(图)
     许家印身家达391亿美元 超过马化腾成中国新首富
     身价391亿美元超马化腾马云 许家印成中国新首富
     许家印身价达391亿美元 成中国新首富(图)

     许家印崛起!一度力压二马成中国首富,背后是他的恒大足球帝国
     */
    public static void main(String[] arg) {
//        String s1 = "身价391亿美元超马化腾马云 许家印成中国新首富";
//        String s2 = "许家印崛起!一度力压二马成中国首富,背后是他的恒大足球帝国";
//        String s2 = "许家印资产比去年翻四倍 力压马云成中国新首富";

        String s1 = "传统的 hash 算法只负责将原始内容尽量均匀随机地映射为一个签名值，"
                + "原理上相当于伪随机数产生算法。产生的两个签名，如果相等，说明原始内容在一定概 率 下是相等的；"
                + "如果不相等，除了说明原始内容不相等外，不再提供任何信息，因为即使原始内容只相差一个字节，"
                + "所产生的签名也很可能差别极大。从这个意义 上来 说，要设计一个 hash 算法，"
                + "对相似的内容产生的签名也相近，是更为艰难的任务，因为它的签名值除了提供原始内容是否相等的信息外，"
                + "还能额外提供不相等的 原始内容的差异程度的信息。";

        String s2 ="在前一篇文章 《海量数据相似度计算之simhash和海明距离》 介绍了simhash的原理，大家应该感觉到了算法的魅力。但是随着业务的增长 simhash的数据也会暴增，如果一天100w，10天就1000w了。我们如果插入一条数据就要去比较1000w次的simhash，计算量还是蛮大，普通PC 比较1000w次海明距离需要 300ms ，和5000w数据比较需要1.8 s。看起来相似度计算不是很慢，还在秒级别。给大家算一笔账就知道了";
        int dis = StringUtils.getLevenshteinDistance(s1, s2);
        double dis2 = StringUtils.getJaroWinklerDistance(s1, s2);
        System.out.println(dis);
        System.out.println(dis2);
        System.out.println(dis);
    }

}