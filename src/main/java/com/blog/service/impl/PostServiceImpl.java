package com.blog.service.impl;

import com.blog.entity.Post;
import com.blog.dao.PostDao;
import com.blog.service.PostService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import java.util.List;
import javax.annotation.Resource;

/**
 * (Post)表服务实现类
 *
 * @author makejava
 * @since 2022-06-15 08:45:47
 */
@Service("postService")
public class PostServiceImpl implements PostService {
    @Resource
    private PostDao postDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Post queryById(Long id) {
        return this.postDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param post 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Post> queryByPage(Post post, PageRequest pageRequest) {
        long total = this.postDao.count(post);
        return new PageImpl<>(this.postDao.queryAllByLimit(post, pageRequest), pageRequest, total);
    }
    
     @Override
    public List<Post> queryAllByLimits(Post post, int offset, int pageSize) {
        return this.postDao.queryAllByLimits(post,(offset-1)*pageSize,pageSize);
    }
    
     @Override
    public long count(Post post) {
        long total = this.postDao.count(post);
        return total;
    }

    /**
     * 新增数据
     *
     * @param post 实例对象
     * @return 实例对象
     */
    @Override
    public Post insert(Post post) {
        this.postDao.insert(post);
        return post;
    }

    /**
     * 修改数据
     *
     * @param post 实例对象
     * @return 实例对象
     */
    @Override
    public Post update(Post post) {
        this.postDao.update(post);
        return this.queryById(post.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.postDao.deleteById(id) > 0;
    }
}
