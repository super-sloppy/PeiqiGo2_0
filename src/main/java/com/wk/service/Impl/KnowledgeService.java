package com.wk.service.Impl;

import com.wk.dao.TKnowledgeMapper;
import com.wk.model.TKnowledge;
import com.wk.service.IKnowledgeService;
import com.wk.util.ReadExcel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 锴 on 2018/3/4.
 */
@Service
public class KnowledgeService implements IKnowledgeService {
    @Resource
    private TKnowledgeMapper knowledgeMapper;
    @Override
    public List<TKnowledge> selectAll() {
        return knowledgeMapper.selectAll();
    }

    @Override
    public boolean batchImort(String name, MultipartFile file) {
        boolean b = false;
        //创建处理EXCEL
        ReadExcel readExcel=new ReadExcel();
        //解析excel，获取客户信息集合。
        List<TKnowledge> knowledgeList = readExcel.getExcelInfo(name ,file);

        if(knowledgeList != null){
            b = true;
        }
        //迭代添加客户信息（注：实际上这里也可以直接将customerList集合作为参数，在Mybatis的相应映射文件中使用foreach标签进行批量添加。）
        for(TKnowledge knowledge:knowledgeList){
            knowledgeMapper.insert(knowledge);
        }
        return b;
    }

    @Override
    public int insert(TKnowledge record) {
        return knowledgeMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return knowledgeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<TKnowledge> selectByLike(String[] words) {
        return knowledgeMapper.selectByLike(words);
    }

    @Override
    public int updateByUse(TKnowledge record) {
        return knowledgeMapper.updateByUse(record);
    }

    @Override
    public TKnowledge selectByPrimaryKey(Integer id) {
        return knowledgeMapper.selectByPrimaryKey(id);
    }
}
