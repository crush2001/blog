package com.blog.service.impl;

import com.blog.entity.Admin;
import com.blog.dao.AdminDao;
import com.blog.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import java.util.List;
import javax.annotation.Resource;

/**
 * (Admin)表服务实现类
 *
 * @author makejava
 * @since 2022-06-15 08:45:46
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Admin queryById(Long id) {
        return this.adminDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param admin 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Admin> queryByPage(Admin admin, PageRequest pageRequest) {
        long total = this.adminDao.count(admin);
        return new PageImpl<>(this.adminDao.queryAllByLimit(admin, pageRequest), pageRequest, total);
    }
    
     @Override
    public List<Admin> queryAllByLimits(Admin admin, int offset, int pageSize) {
        return this.adminDao.queryAllByLimits(admin,(offset-1)*pageSize,pageSize);
    }
    
     @Override
    public long count(Admin admin) {
        long total = this.adminDao.count(admin);
        return total;
    }

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin insert(Admin admin) {
        this.adminDao.insert(admin);
        return admin;
    }

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin update(Admin admin) {
        this.adminDao.update(admin);
        return this.queryById(admin.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.adminDao.deleteById(id) > 0;
    }

    public Admin login(Admin admin) {
        return this.adminDao.login(admin);
    }
}
