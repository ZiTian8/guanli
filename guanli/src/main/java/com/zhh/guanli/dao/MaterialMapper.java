package com.zhh.guanli.dao;


import com.zhh.guanli.pojo.Material;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MaterialMapper {


    List<Material> selectList();

    int addMaterial(Material material);

    int selectSame(Material material);

    Material getSameId(Material material);

    int updateById(Material material);

    Material selectById(int id);
}
