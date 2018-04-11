package com.wk.service;

import com.wk.model.TKnowledge;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by 锴 on 2018/3/4.
 */
public interface IKnowledgeService {
    List<TKnowledge> selectAll();

    boolean batchImort(String name, MultipartFile file);

    int insert(TKnowledge record);

    int deleteByPrimaryKey(Integer id);

    List<TKnowledge> selectByLike(String[] words);

    int updateByUse(TKnowledge record);

    TKnowledge selectByPrimaryKey(Integer id);
}
