package com.wk.wordSimilar.tendency;

/**
 * 语义倾向性（情感分析）
 *
 * Created by 锴 on 2018/3/2.
 */
public interface IWordTendency {
    /**
     * 获取词语的语义倾向性，
     * 词语的语义倾向性为一个介于[-1, 1]之间的实数，数值越大，褒义性越强，否则，贬义性越强
     *
     * @param word
     * @return
     */
    double getTendency(String word);
}
