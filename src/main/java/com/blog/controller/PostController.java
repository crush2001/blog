package com.blog.controller;

import com.blog.entity.Post;
import com.blog.service.PostService;
import com.blog.tools.BaseController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.alibaba.fastjson.JSONArray;
import javax.annotation.Resource;

/**
 * (Post)表控制层
 *
 * @author makejava
 * @since 2022-06-20 19:51:42
 */
@RestController
@RequestMapping("post")
public class PostController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private PostService postService;

    /**
     * 分页查询
     *
     * @param post 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Post>> queryByPage(Post post, PageRequest pageRequest) {
        return ResponseEntity.ok(this.postService.queryByPage(post, pageRequest));
    }
    
    
     @PostMapping("/getall")
    public String queryall(Post post, @RequestParam("page") int offset, @RequestParam("pageSize")int pageSize){
        List<Post> Posts = this.postService.queryAllByLimits(post,offset,pageSize);
        long counts = postService.count(post);
        JSONArray jsonArray=new JSONArray();
        jsonArray.add(counts);
        jsonArray.add(Posts);
        return RespInfo(1,"查询信息",jsonArray);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Post> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.postService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param post 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<Post> add(Post post) {
        return ResponseEntity.ok(this.postService.insert(post));
    }

    /**
     * 编辑数据
     *
     * @param post 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public ResponseEntity<Post> edit(Post post) {
        return ResponseEntity.ok(this.postService.update(post));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/del")
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.postService.deleteById(id));
    }

}

