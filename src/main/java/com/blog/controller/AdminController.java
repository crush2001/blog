package com.blog.controller;

import com.blog.entity.Admin;
import com.blog.service.AdminService;
import com.blog.tools.BaseController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.alibaba.fastjson.JSONArray;
import javax.annotation.Resource;

/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2022-06-15 08:45:46
 */
@RestController
@RequestMapping("admin")
public class AdminController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private AdminService adminService;

    /**
     * 分页查询
     *
     * @param admin 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Admin>> queryByPage(Admin admin, PageRequest pageRequest) {
        return ResponseEntity.ok(this.adminService.queryByPage(admin, pageRequest));
    }
    
    
     @PostMapping("/getall")
    public String queryall(Admin admin, @RequestParam("page") int offset, @RequestParam("pageSize")int pageSize){
        List<Admin> Admins = this.adminService.queryAllByLimits(admin,offset,pageSize);
        long counts = adminService.count(admin);
        JSONArray jsonArray=new JSONArray();
        jsonArray.add(counts);
        jsonArray.add(Admins);
        return RespInfo(1,"查询信息",jsonArray);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Admin> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.adminService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param admin 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Admin> add(Admin admin) {
        return ResponseEntity.ok(this.adminService.insert(admin));
    }

    /**
     * 编辑数据
     *
     * @param admin 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public ResponseEntity<Admin> edit(Admin admin) {
        return ResponseEntity.ok(this.adminService.update(admin));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/del")
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.adminService.deleteById(id));
    }

    @PostMapping("/login")
    public String login(Admin admin) {
        Admin login = this.adminService.login(admin);
        return RespInfo(1,"登录信息",login);
    }

    @PostMapping("/logout")
    public String logout(String s){
        //Admin logout = this.adminService.logout(admin);
        return RespInfo(1,"退出信息",s);
    }
}

