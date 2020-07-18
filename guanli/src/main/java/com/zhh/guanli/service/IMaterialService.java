package com.zhh.guanli.service;


import com.zhh.guanli.common.ServerResponse;
import com.zhh.guanli.pojo.Material;
import com.zhh.guanli.pojo.User;

import java.util.Map;

public interface IMaterialService {

    ServerResponse getMaterialList(String query,int pageNum, int pageSize);

    ServerResponse addMaterial(Material material);

    ServerResponse getMaterial(int id);

    ServerResponse updateMaterialById(int id, Map info);

    ServerResponse deleteMaterial(int id);

}
