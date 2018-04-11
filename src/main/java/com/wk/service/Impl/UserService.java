package com.wk.service.Impl;

import com.wk.dao.TUserMapper;
import com.wk.model.TUser;
import com.wk.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 锴 on 2018/3/4.
 */
@Service
public class UserService implements IUserService {

    @Resource
    private TUserMapper userMapper;

    @Override
    public TUser selectByUsername(TUser user) {
        return userMapper.selectByUsername(user);
    }
}
