package com.wk.wordSimilar.similar.wordSimilar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.wk.wordSimilar.Similarity;
import com.wk.util.DicReader;
import com.wk.util.FileUtil;
import com.wk.util.StringUtil;
import com.wk.util.TraverseEvent;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;

/**
 * 词林编码
 *
 * Created by 锴 on 2018/3/2.
 */
public class CilinDictionary {
    private static Logger logger = LoggerFactory.getLogger(CilinDictionary.class);
    private final static String path = Similarity.Config.CilinPath;
    // 以词语为索引
    private final Map<String, Set<String>> wordIndex = new HashMap<>();
    // 以编码为索引
    private final Map<String, Set<String>> codeIndex = new HashMap<>();
    private static CilinDictionary instance;

    public static CilinDictionary getInstance() {
        if (instance == null) {
            try {
                instance = new CilinDictionary();
            } catch (IOException e) {
                logger.error("exception:{}", e.getMessage());
            }
        }
        return instance;
    }

    private CilinDictionary() throws IOException {
        InputStream inputStream = new GZIPInputStream(DicReader.getInputStream(path));
        TraverseEvent<String> event = line -> {
            String[] items = line.split(" ");
            Set<String> set = new HashSet<>();
            for (int i = 2; i < items.length; i++) {
                String code = items[i].trim();
                if (StringUtil.isNotBlank(code)) {
                    set.add(code);
                    // add to codeIndex
                    Set<String> codeWords = codeIndex.get(code);
                    if (codeWords == null) {
                        codeWords = new HashSet<>();
                    }
                    codeWords.add(items[0]);
                    codeIndex.put(code, codeWords);
                }
            }
            wordIndex.put(items[0], set);
            return false;
        };
        logger.info("loading cilin dictionary...");
        long start = System.currentTimeMillis();
        FileUtil.traverseLines(inputStream, "UTF-8", event);
        logger.info("loading ciling dictionary complete! time spend:{}", System.currentTimeMillis() - start + "ms");
    }

    /**
     * 获取某词语的词林编码，一个词语可以对应多个编码，set表示
     *
     * @param word
     * @return
     */
    public Set<String> getCilinCodes(String word) {
        return wordIndex.get(word);
    }

    public Set<String> getCilinWords(String code) {
        return codeIndex.get(code);
    }

}
