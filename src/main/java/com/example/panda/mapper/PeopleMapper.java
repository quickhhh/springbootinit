package com.example.panda.mapper;

import com.example.panda.pojo.People;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PeopleMapper {

    //@Select("select * from people_ ")
    List<People> findAll();
}
