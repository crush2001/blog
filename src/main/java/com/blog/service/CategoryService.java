package com.blog.service;

import com.blog.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;
/**
 * (Category)表服务接口
 *
 * @author makejava
 * @since 2022-06-15 08:45:47
 */
public interface CategoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Category queryById(Long id);

    /**
     * 分页查询
     *
     * @param category 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Category> queryByPage(Category category, PageRequest pageRequest);

 List<Category> queryAllByLimits(Category category, int offset,int pageSize);
    
    long count(Category category);
    /**
     * 新增数据
     *
     * @param category 实例对象
     * @return 实例对象
     */
    Category insert(Category category);

    /**
     * 修改数据
     *
     * @param category 实例对象
     * @return 实例对象
     */
    Category update(Category category);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
