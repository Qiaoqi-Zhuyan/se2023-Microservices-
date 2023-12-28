package com.project.assemblyManagementSystem.service.impl;

import com.project.assemblyManagementSystem.bo.User;
import com.project.assemblyManagementSystem.mapper.UsrMapper;
import com.project.assemblyManagementSystem.service.UserService;
import org.apache.catalina.mbeans.UserMBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsrMapper usrMapper;

    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Override
    public List<String> getEmailAddress(String  position) {
        User user = new User();
        user.setPosition(position);
        List<String> emailAddressList = null;
        try {
            emailAddressList = usrMapper.selectUserEmailAddress(user);
        } catch (DataAccessException e) {
            logger.error("Sql error", e);
        } catch (Exception e) {
            logger.error("error", e);
        }

        return emailAddressList;
    }
}
