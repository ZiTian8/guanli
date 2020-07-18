///**
// * @ClassName UserServiceImpl
// * @Description
// * @Author HAHA
// * @Version V1.0.0
// * @Date 2019-02-28 19:59
// */
//package com.zhh.guanli.service.impl;
//
//
////import com.mmall.util.RedisShardedPoolUtil;
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.google.common.collect.Lists;
//import com.zhh.guanli.common.Const;
//import com.zhh.guanli.common.ServerResponse;
//import com.zhh.guanli.dao.MaterialMapper;
//import com.zhh.guanli.dao.UserMapper;
//import com.zhh.guanli.pojo.Material;
//import com.zhh.guanli.pojo.Material;
//import com.zhh.guanli.pojo.User;
//import com.zhh.guanli.service.IMaterialService;
//
//import com.zhh.guanli.util.MD5Util;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Timer;
//
//@Service("iMaterialService")
//public class MaterialServiceImpl implements IMaterialService {
//    @Autowired
//    private MaterialMapper MaterialMapper;
//    @Autowired
//    private UserMapper userMapper;
//
//    @Override
//    public ServerResponse getMaterialList(String query ,int pageNum, int pageSize) {
//        //startPage--start
//        //填充自己的sql查询逻辑
//        //pageHelper-收尾
//        PageHelper.startPage(pageNum,pageSize);
//        List<Material> materialList = MaterialMapper.selectList();
//        if(StringUtils.isBlank(query)){
//            PageInfo pageResult = new PageInfo(materialList);
//            pageResult.setList(materialList);
//            return ServerResponse.createBySuccess(pageResult);
//        }else if(query.equals("1")){
//            List<Material> materialList1= new ArrayList<>();
//            Material mItem1=materialList.get(0);
//            Material mItem2 =null;
//            for (int i = 1; i < materialList.size(); i++) {
//                mItem2=materialList.get(i);
//                if(mItem1.getName().equals(mItem2.getName())&&
//                        mItem1.getSupplier().equals(mItem2.getSupplier())&&
//                        mItem1.getPrice()==mItem2.getPrice()){
//                    mItem1.setStock((int) (mItem1.getStock()+mItem2.getStock()));
//                }else{
//                    materialList1.add(mItem1);
//                    mItem1=mItem2;
//                }
//            }
//            materialList1.add(mItem2);
//            PageInfo pageResult = new PageInfo(materialList1);
//            pageResult.setList(materialList1);
//            return ServerResponse.createBySuccess(pageResult);
//        }else{
//
//        }
//        return null;
//
//    }
//    @Override
//    public ServerResponse addMaterial(Material material){
//        int count = MaterialMapper.addMaterial(material);
//        if(count > 0){
//            return ServerResponse.createBySuccess("添加产品成功");
//        }else{
//            return ServerResponse.createByErrorMessage("添加失败");
//        }
////        int haveres = MaterialMapper.selectSame(material);
////
////        if(haveres>0){
////            Material existMaterial = MaterialMapper.getSameId(material);
////            existMaterial.setStock((int) (existMaterial.getStock()+material.getStock()));
////            int count =MaterialMapper.updateById(existMaterial);
////            if(count > 0){
////                return ServerResponse.createBySuccess("添加库存成功");
////            }else{
////                return ServerResponse.createByErrorMessage("添加失败");
////            }
////        }else{
////
////        }
//
//
//
//
//    }
//
//    @Override
//    public ServerResponse getMaterial(int id) {
//        Material Material = MaterialMapper.selectById(id);
//        return ServerResponse.createBySuccess(Material);
//    }
//
//    @Override
//    public ServerResponse updateMaterialById(int id, Map info) {
//        Material Material = new Material();
//        Material.setId(id);
////        Material.setPhone((String) info.get("phone"));
////        Material.setAddress((String) info.get("address"));
//        int count = MaterialMapper.updateById(Material);
//        if(count > 0){
//            return ServerResponse.createBySuccess("更新信息成功");
//        }else{
//            return ServerResponse.createByErrorMessage("更新信息失败");
//        }
//    }
//
////    @Override
////    public ServerResponse deleteMaterial(int id) {
////        int count = MaterialMapper.deleteMaterial(id);
////        if(count > 0){
////            return ServerResponse.createBySuccess("删除成功");
////        }else{
////            return ServerResponse.createByErrorMessage("删除失败");
////        }
////    }
//
//
//}
