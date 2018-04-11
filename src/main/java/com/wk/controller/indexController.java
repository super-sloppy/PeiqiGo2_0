package com.wk.controller;


import com.wk.model.TKnowledge;
import com.wk.service.Impl.KnowledgeService;
import com.wk.wordSimilar.Similarity;
import com.wk.wordSimilar.tokenizer.Tokenizer;
import com.wk.wordSimilar.tokenizer.Word;
import com.wk.wordSimilar.word2vec.Word2vec;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Controller
public class indexController {

    @Resource
    private KnowledgeService knowledgeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login() {
        System.out.println("加载起始页index");
        return "web/index";
    }

    @RequestMapping(value = "/web/index/send", method = RequestMethod.POST)
    public String message(@RequestParam(value = "message") String message, Model model) throws IOException {
        //message 前端传进来的用户信息
        List<Word> wordsList = Tokenizer.segment(message);      //初步tokenizer分词
        String respond = "Sorry，无法回答该问题，正在开发中";   //初始回复  不知道
        String[] wordsArray = null;
        TKnowledge knowledge;
        List<String> temp = null;
        for (int i = 0; i < wordsList.size(); i++) {
            temp.add(wordsList.get(i).getName());//得到分词后 词汇的数组
        }
        for (int i = 0; i < wordsArray.length; i++)//modelPath训练文本的路径，wordsArray[i] 单个词语，topN返回相似词语的个数
            temp.addAll(Word2vec.getHomoionym("银行相关词语.txt", wordsArray[i], 1));
        for (int i = 0; i < temp.size(); i++)
            wordsArray[i] = temp.get(i);//都放入一个数组中
        List<TKnowledge> knowledges = knowledgeService.selectByLike(wordsArray);   //每个词汇执行相似查询，得到list
        for (int i = 0; i < knowledges.size(); i++) {
            //对每个得到的knowledges和问题比较相似度，过了阈值就输出
            if (Similarity.isSimilar(message, knowledges.get(i).getQuestion1())) {
                model.addAttribute("respond", knowledges.get(i).getAnswer());
                knowledge = knowledges.get(i);
                knowledge.setUseNum(knowledge.getUseNum() + 1);
                knowledgeService.updateByUse(knowledge);
                return "web/index";
            }
        }
        //如果没有找到，直接返回不知道
        model.addAttribute("respond", respond);
        return "web/index";
    }

    @RequestMapping(value = "/web/index/{flag}", method = RequestMethod.GET)
    public void evaluation(@PathVariable int flag, Integer currentId) {
        TKnowledge knowledge = knowledgeService.selectByPrimaryKey(currentId);
        if (flag == 1) {
            knowledge.setSolveNum(knowledge.getSolveNum() + 1);
            knowledgeService.updateByUse(knowledge);
        } else {
            knowledge.setSolveNum(knowledge.getUnsolveNum() + 1);
        }
        knowledgeService.updateByUse(knowledge);
    }

}