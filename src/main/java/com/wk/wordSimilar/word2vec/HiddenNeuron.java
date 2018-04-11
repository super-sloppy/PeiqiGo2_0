package com.wk.wordSimilar.word2vec;

/**
 * 隐藏神经元
 *
 * Created by 锴 on 2018/3/2.
 */
public class HiddenNeuron extends Neuron {
    public double[] syn1;// 隐藏层 -> 输出层

    public HiddenNeuron(int layerSize) {
        syn1 = new double[layerSize];
    }
}
