package com.wk.wordSimilar.word2vec;

import com.wk.wordSimilar.train.Learn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.wk.wordSimilar.word2vec.WordEntry;
import com.wk.wordSimilar.train.Learn;
import com.wk.wordSimilar.word2vec.ModelParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Word2vec java版 工具包
 *
 * Created by 锴 on 2018/3/2.
 */
public class Word2vec {
    private static final Logger logger = LoggerFactory.getLogger(Word2vec.class);

    public static String trainModel(String inputfilePath, String modelPath) throws IOException {
        File inputfile = new File(inputfilePath);
        if (inputfile == null) {
            return "";
        }
        String out = inputfile.getPath() + ".model";
        if (modelPath != null && modelPath.trim().length() > 0) out = modelPath;
        File outFile = new File(out);
        Learn learn = new Learn();
        learn.learnFile(inputfile);
        learn.saveModel(outFile);
        return out;
    }

    public static float[] parser(String modelPath, String word) throws IOException {
        ModelParser parser = new ModelParser();
        parser.loadModel(modelPath);
        float[] result = parser.getWordVector(word);
        return result;
    }

    public static List<String> getHomoionym(String modelPath, String word, int topN) throws IOException {
        //modelPath训练好的文本路径，word词语，topN返回相似词汇的条数
        List<String> result = new ArrayList<>(topN);
        ModelParser parser = new ModelParser();
        parser.loadModel(modelPath);
        parser.setTopNSize(topN);
        Set<WordEntry> wordEntrySet = parser.distance(word);
        result.addAll(wordEntrySet.stream().map(wordEntry -> wordEntry.name).collect(Collectors.toList()));
        return result;
    }
}
