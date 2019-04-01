package com.ning4256.springboot;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ning4256.dao.EmpDAO;
import com.ning4256.pojo.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    @Autowired
    private EmpDAO empDAO;

    @Test
    public void contextLoads() {
//        List<Emp> emps = empDAO.queryEmpsByPage(2, 5);

        PageInfo<Emp> info = PageHelper.startPage(1, 5).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                empDAO.selectAll();
            }
        });
        System.out.println("当前页数为:" + info.getPageNum());
        System.out.println("总页数为:" + info.getPages());
        System.out.println("是否有下一页:" + info.isHasNextPage());
        System.out.println("是否有上一页:" + info.isHasPreviousPage());
        System.out.println("结束行:" + info.getEndRow());
        System.out.println("得到导航到第一页:" + info.getNavigateFirstPage());
        System.out.println("得到导航总页数:" + info.getNavigatePages());
        System.out.println("得到页面的行数:" + info.getPageSize());
        System.out.println("是否为首页:" + info.isIsFirstPage());

    }

}
