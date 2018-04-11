package com.wk.dao;

import com.wk.model.TKnowledge;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TKnowledgeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TKnowledge record);

    int insertSelective(TKnowledge record);

    TKnowledge selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TKnowledge record);

    int updateByPrimaryKey(TKnowledge record);

    List<TKnowledge> selectAll();

    List<TKnowledge> selectByLike(String[] words);

    int updateByUse(TKnowledge record);
}