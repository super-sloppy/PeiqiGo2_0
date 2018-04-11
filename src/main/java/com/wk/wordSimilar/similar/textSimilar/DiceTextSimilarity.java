package com.wk.wordSimilar.similar.textSimilar;

import com.wk.wordSimilar.tokenizer.Word;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 文本相似度计算
 * 判定方式：Sorensen–Dice系数（Sorensen–Dice coefficient），通过计算两个集合交集的大小的2倍除以两个集合的大小之和来评估他们的相似度
 * 算法步骤描述：
 * 1、分词
 * 2、求交集（去重），计算交集的不重复词的个数 intersectionSize
 * 3、两个集合的大小分别为 set1Size 和 set2Size
 * 4、相似度分值 = 2*intersectionSize/(set1Size+set2Size)
 * 完整计算公式：
 * double score = 2*intersectionSize/(set1Size+set2Size);
 *
 * Created by 锴 on 2018/3/2.
 */
public class DiceTextSimilarity extends TextSimilarity {
    /**
     * 计算相似度分值
     *
     * @param words1 词列表1
     * @param words2 词列表2
     * @return 相似度分值
     */
    @Override
    protected double getSimilarityImpl(List<Word> words1, List<Word> words2) {
        if (words1.isEmpty() && words2.isEmpty()) {
            return 1.0;
        }
        //转变为不重复的集合
        Set<Word> words1Set = new HashSet<>(words1);
        Set<Word> words2Set = new HashSet<>(words2);
        // 两个集合的大小
        int set1Size = words1Set.size();
        int set2Size = words2Set.size();

        // 求交集（去重），计算交集的不重复词的个数
        words1Set.retainAll(words2Set);
        int intersectionSize = words1Set.size();

        //相似度分值
        double score = 2 * intersectionSize / (double) (set1Size + set2Size);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("集合1：" + words1);
            LOGGER.debug("集合2：" + words2);
            LOGGER.debug("集合1的大小：" + set1Size);
            LOGGER.debug("集合2的大小：" + set2Size);
            LOGGER.debug("交集的大小：" + intersectionSize);
            LOGGER.debug("相似度分值=2*" + intersectionSize + "/(double)(" + set1Size + "+" + set2Size + ")=" + score);
        }
        return score;
    }

}