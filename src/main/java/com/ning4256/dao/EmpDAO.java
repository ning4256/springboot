package com.ning4256.dao;


import com.ning4256.pojo.Emp;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpDAO {
    List<Emp> queryEmpsByPage(@Param("currentNum") Integer currentNum, @Param("pageSize") Integer pageSize);

    int deleteByPrimaryKey(Integer empno);

    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(Integer empno);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);

    List<Emp> selectAll();
}