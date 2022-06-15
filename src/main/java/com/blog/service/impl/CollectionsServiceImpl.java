package com.blog.service.impl;

import com.blog.entity.Collections;
import com.blog.dao.CollectionsDao;
import com.blog.service.CollectionsService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import java.util.List;
import javax.annotation.Resource;

/**
 * (Collections)表服务实现类
 *
 * @author makejava
 * @since 2022-06-15 10:41:39
 */
@Service("collectionsService")
public class CollectionsServiceImpl implements CollectionsService {
    @Resource
    private CollectionsDao collectionsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Collections queryById(Long id) {
        return this.collectionsDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param collections 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Collections> queryByPage(Collections collections, PageRequest pageRequest) {
        long total = this.collectionsDao.count(collections);
        return new PageImpl<>(this.collectionsDao.queryAllByLimit(collections, pageRequest), pageRequest, total);
    }
    
     @Override
    public List<Collections> queryAllByLimits(Collections collections, int offset, int pageSize) {
        return this.collectionsDao.queryAllByLimits(collections,(offset-1)*pageSize,pageSize);
    }
    
     @Override
    public long count(Collections collections) {
        long total = this.collectionsDao.count(collections);
        return total;
    }

    /**
     * 新增数据
     *
     * @param collections 实例对象
     * @return 实例对象
     */
    @Override
    public Collections insert(Collections collections) {
        this.collectionsDao.insert(collections);
        return collections;
    }

    /**
     * 修改数据
     *
     * @param collections 实例对象
     * @return 实例对象
     */
    @Override
    public Collections update(Collections collections) {
        this.collectionsDao.update(collections);
        return this.queryById(collections.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.collectionsDao.deleteById(id) > 0;
    }
}
