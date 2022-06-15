package com.blog.service;

import com.blog.entity.Collections;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;
/**
 * (Collections)表服务接口
 *
 * @author makejava
 * @since 2022-06-15 10:41:39
 */
public interface CollectionsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Collections queryById(Long id);

    /**
     * 分页查询
     *
     * @param collections 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Collections> queryByPage(Collections collections, PageRequest pageRequest);

 List<Collections> queryAllByLimits(Collections collections, int offset,int pageSize);
    
    long count(Collections collections);
    /**
     * 新增数据
     *
     * @param collections 实例对象
     * @return 实例对象
     */
    Collections insert(Collections collections);

    /**
     * 修改数据
     *
     * @param collections 实例对象
     * @return 实例对象
     */
    Collections update(Collections collections);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
