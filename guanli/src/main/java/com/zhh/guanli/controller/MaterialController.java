package com.zhh.guanli.controller;


import com.zhh.guanli.common.ResponseCode;
import com.zhh.guanli.common.ServerResponse;
import com.zhh.guanli.dao.MaterialMapper;
import com.zhh.guanli.pojo.Material;
import com.zhh.guanli.pojo.User;
import com.zhh.guanli.service.IMaterialService;
import com.zhh.guanli.util.CookieUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Map;

@CrossOrigin
@RestController
public class MaterialController {
    @Autowired
    private IMaterialService iMaterialService;



    //查询所有材料返回列表页面
    @GetMapping("/material")
    @ResponseBody
    public ServerResponse list(HttpServletRequest httpServletRequest,
                               @RequestParam(value = "query",required = false) String query,
                               @RequestParam(value = "pagenum",defaultValue = "1") int pageNum,
                               @RequestParam(value = "pagesize",defaultValue = "10") int pageSize){
//        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
//        if(StringUtils.isEmpty(loginToken)){
//            return ServerResponse.createByErrorMessage("用户未登录");
//        }

        //业务

        ServerResponse response=iMaterialService.getMaterialList(query,pageNum,pageSize);
        return response;

    }

    //添加材料
    @PostMapping("/material")
    public ServerResponse addMaterial(Material material){
        //来到添加页面,查出所有的部门，在页面显示
        ServerResponse response=iMaterialService.addMaterial(material);
        return response;
    }

    @GetMapping("/customer/{id}")
    @ResponseBody
    public ServerResponse getMaterialById(HttpServletRequest httpServletRequest,
                                          @PathVariable(value="id",required=true) int id){
        ServerResponse response=iMaterialService.getMaterial(id);
        return response;

    }

    //员工修改；需要提交员工id；
    @PutMapping("/customer/{id}")
    public ServerResponse updateMaterial(@PathVariable(value="id",required=true) int id,
                                         @RequestBody Map info){
        ServerResponse response=iMaterialService.updateMaterialById(id,info);
        return response;
    }

    @DeleteMapping("/customer/{id}")
    public ServerResponse deleteCustomer(@PathVariable(value="id",required=true) int id){
        ServerResponse response=iMaterialService.deleteMaterial(id);
        return response;
    }

//
//    //员工添加
//    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
//    @PostMapping("/emp")
//    public String addEmp(Employee employee){
//        //来到员工列表页面
//
//        System.out.println("保存的员工信息："+employee);
//        //保存员工
//        employeeDao.save(employee);
//        // redirect: 表示重定向到一个地址  /代表当前项目路径
//        // forward: 表示转发到一个地址
//        return "redirect:/emps";
//    }
//
//    //来到修改页面，查出当前员工，在页面回显
//    @GetMapping("/emp/{id}")
//    public String toEditPage(@PathVariable("id") Integer id, Model model){
//        Employee employee = employeeDao.get(id);
//        model.addAttribute("emp",employee);
//
//        //页面要显示所有的部门列表
//        Collection<Department> departments = departmentDao.getDepartments();
//        model.addAttribute("depts",departments);
//        //回到修改页面(add是一个修改添加二合一的页面);
//        return "emp/add";
//    }
//
//    //员工修改；需要提交员工id；
//    @PutMapping("/emp")
//    public String updateEmployee(Employee employee){
//        System.out.println("修改的员工数据："+employee);
//        employeeDao.save(employee);
//        return "redirect:/emps";
//    }
//
//    //员工删除
//    @DeleteMapping("/emp/{id}")
//    public String deleteEmployee(@PathVariable("id") Integer id){
//        employeeDao.delete(id);
//        return "redirect:/emps";
//    }



}
