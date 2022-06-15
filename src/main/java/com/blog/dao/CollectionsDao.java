package com.blog.dao;

import com.blog.entity.Collections;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Collections)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-15 10:41:38
 */
public interface CollectionsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Collections queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param collections 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Collections> queryAllByLimit(Collections collections, @Param("pageable") Pageable pageable);


    List<Collections> queryAllByLimits(@Param("Collections") Collections collections,@Param("page") int offset,@Param("pageSize") int pageSize);

    /**
     * 统计总行数
     *
     * @param collections 查询条件
     * @return 总行数
     */
    long count(Collections collections);

    /**
     * 新增数据
     *
     * @param collections 实例对象
     * @return 影响行数
     */
    int insert(Collections collections);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Collections> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Collections> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Collections> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Collections> entities);

    /**
     * 修改数据
     *
     * @param collections 实例对象
     * @return 影响行数
     */
    int update(Collections collections);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

