package com.wk.wordSimilar.similar.textSimilar;


import com.wk.util.AtomicFloat;
import com.wk.wordSimilar.tokenizer.Word;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 文本相似度计算
 * 判定方式：曼哈顿距离（Manhattan Distance），通过计算两个点在标准坐标系上的绝对轴距总和来评估他们的相似度
 * 曼哈顿距离原理：
 * 设A(x1, y1)，B(x2, y2)是平面上任意两点
 * 两点间的距离dist(A,B)=|x1-x2|+|y1-y2|
 * Created by 锴 on 2018/3/2.
 */
public class ManhattanDistanceTextSimilarity extends TextSimilarity {
    /**
     * 判定相似度的方式：曼哈顿距离
     * 曼哈顿距离原理：
     * 设A(x1, y1)，B(x2, y2)是平面上任意两点
     * 两点间的距离dist(A,B)=|x1-x2|+|y1-y2|
     * @param words1 词列表1
     * @param words2 词列表2
     * @return 相似度分值
     */
    @Override
    protected double getSimilarityImpl(List<Word> words1, List<Word> words2) {
        //用词频来标注词的权重
        taggingWeightByFrequency(words1, words2);
        //构造权重快速搜索容器
        Map<String, Float> weights1 = getFastSearchMap(words1);
        Map<String, Float> weights2 = getFastSearchMap(words2);
        //所有的不重复词
        Set<Word> words = new HashSet<>();
        words.addAll(words1);
        words.addAll(words2);
        //向量的维度为words的大小，每一个维度的权重是词频
        //manhattanDistance=|x1-x2|+|y1-y2|
        AtomicFloat manhattanDistance = new AtomicFloat();
        //计算
        words
                .parallelStream()
                .forEach(word -> {
                    Float x1 = weights1.get(word.getName());
                    Float x2 = weights2.get(word.getName());
                    if (x1 == null) {
                        x1 = 0f;
                    }
                    if (x2 == null) {
                        x2 = 0f;
                    }
                    //|x1-x2|
                    float oneOfTheDimension = Math.abs(x1 - x2);
                    //+
                    manhattanDistance.addAndGet(oneOfTheDimension);
                });
        double score = 0;
        if (manhattanDistance.get() == 0) {
            //距离为0，表示完全相同
            score = 1.0;
        } else {
            //使用BigDecimal保证精确计算浮点数
            //score = 1 / (double)(manhattanDistance.get()+1);
            score = BigDecimal.valueOf(1).divide(BigDecimal.valueOf(manhattanDistance.get() + 1), 9, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("文本1和文本2的曼哈顿距离：" + manhattanDistance.get());
            LOGGER.debug("文本1和文本2的相似度分值：1 / (double)(" + manhattanDistance.get() + "+1)=" + score);
        }
        return score;
    }


}
