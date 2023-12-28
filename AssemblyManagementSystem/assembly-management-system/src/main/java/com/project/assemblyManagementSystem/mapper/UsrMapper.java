package com.project.assemblyManagementSystem.mapper;

import com.project.assemblyManagementSystem.bo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsrMapper {

    public void insertUser(User user);

    public void deleteUser(User user);

    public void updateUser(User user);

    public List<User> selectUser(User user);

    public List<String> selectUserEmailAddress(User user);
}
