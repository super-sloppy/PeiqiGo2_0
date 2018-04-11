package com.wk.wordSimilar.similar;

import com.wk.wordSimilar.similar.ISimilarity;
import com.wk.wordSimilar.tokenizer.Word;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * Created by 锴 on 2018/3/2.
 */
public interface ITextSimilarity extends ISimilarity {
    // 阈值
    float thresholdRate = 0.5f;

    /**
     * 词列表1和词列表2的相似度分值
     *
     * @param words1 词列表1
     * @param words2 词列表2
     * @return 相似度分值
     */
    double getSimilarity(List<Word> words1, List<Word> words2);

    default double getSimilarity(Map<Word, Float> weights1, Map<Word, Float> weights2) {
        List<List<Word>> words = Arrays.asList(weights1, weights2).parallelStream()
                .map(weights -> weights.keySet().parallelStream()
                        .map(word -> {
                            word.setWeight(weights.get(word));
                            return word;
                        })
                        .collect(Collectors.toList())).collect(Collectors.toList());

        return getSimilarity(words.get(0), words.get(1));
    }


}
