package com.wk.wordSimilar.similar.textSimilar;


import com.wk.wordSimilar.tokenizer.Word;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * 文本相似度计算
 * 判定方式：Jaccard相似性系数（Jaccard similarity coefficient） ，通过计算两个集合交集的大小除以并集的大小来评估他们的相似度
 * 算法步骤描述：
 * 1、分词
 * 2、求交集（去重），计算交集的不重复词的个数 intersectionSize
 * 3、求并集（去重），计算并集的不重复词的个数 unionSize
 * 4、2中的值除以3中的值 intersectionSize/(double)unionSize
 * 完整计算公式：
 * double score = intersectionSize/(double)unionSize;
 * Created by 锴 on 2018/3/2.
 */
public class JaccardTextSimilarity extends TextSimilarity {
    /**
     * 判定相似度的方式：Jaccard相似性系数
     * @param words1 词列表1
     * @param words2 词列表2
     * @return 相似度分值
     */
    @Override
    protected double getSimilarityImpl(List<Word> words1, List<Word> words2) {
        if (words1.isEmpty() && words2.isEmpty()) {
            return 1.0;
        }
        //HashSet的contains性能要大于ArrayList的contains
        Set<Word> words2Set = new HashSet<>();
        words2Set.addAll(words2);
        //求交集
        Set<String> intersectionSet = new ConcurrentSkipListSet<>();
        words1.parallelStream().forEach(word -> {
            if (words2Set.contains(word)) {
                intersectionSet.add(word.getName());
            }
        });
        //交集的大小
        int intersectionSize = intersectionSet.size();
        //求并集
        Set<String> unionSet = new HashSet<>();
        words1.forEach(word -> unionSet.add(word.getName()));
        words2.forEach(word -> unionSet.add(word.getName()));
        //并集的大小
        int unionSize = unionSet.size();
        //相似度分值
        double score = intersectionSize / (double) unionSize;
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("交集的大小：" + intersectionSize);
            LOGGER.debug("并集的大小：" + unionSize);
            LOGGER.debug("相似度分值=" + intersectionSize + "/(double)" + unionSize + "=" + score);
        }
        return score;
    }


}
