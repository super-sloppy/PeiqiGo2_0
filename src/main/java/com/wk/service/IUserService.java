package com.wk.service;

import com.wk.model.TUser;

/**
 * Created by 锴 on 2018/3/4.
 */
public interface IUserService {
    TUser selectByUsername(TUser user);

}
