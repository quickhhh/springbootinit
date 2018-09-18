package com.example.panda.mapper;

import com.example.panda.pojo.People;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PeopleMapper {

    @Select("select * from people_ ")
    List<People> findAll();

    @Insert(" insert into people_ ( name ) values (#{name}) ")
    public int save(People people);

    @Delete(" delete from people_ where id= #{id} ")
    public void delete(int id);

    @Select("select * from people_ where id= #{id} ")
    public People get(int id);

    @Update("update people_ set name=#{name} where id=#{id} ")
    public int update(People people);
}
