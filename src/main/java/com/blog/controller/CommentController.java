package com.blog.controller;

import com.blog.entity.Comment;
import com.blog.service.CommentService;
import com.blog.tools.BaseController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.alibaba.fastjson.JSONArray;
import javax.annotation.Resource;

/**
 * (Comment)表控制层
 *
 * @author makejava
 * @since 2022-06-20 19:51:41
 */
@RestController
@RequestMapping("comment")
public class CommentController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private CommentService commentService;

    /**
     * 分页查询
     *
     * @param comment 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Comment>> queryByPage(Comment comment, PageRequest pageRequest) {
        return ResponseEntity.ok(this.commentService.queryByPage(comment, pageRequest));
    }
    
    
     @PostMapping("/getall")
    public String queryall(Comment comment, @RequestParam("page") int offset, @RequestParam("pageSize")int pageSize){
        List<Comment> Comments = this.commentService.queryAllByLimits(comment,offset,pageSize);
        long counts = commentService.count(comment);
        JSONArray jsonArray=new JSONArray();
        jsonArray.add(counts);
        jsonArray.add(Comments);
        return RespInfo(1,"查询信息",jsonArray);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Comment> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.commentService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param comment 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Comment> add(Comment comment) {
        return ResponseEntity.ok(this.commentService.insert(comment));
    }

    /**
     * 编辑数据
     *
     * @param comment 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public ResponseEntity<Comment> edit(Comment comment) {
        return ResponseEntity.ok(this.commentService.update(comment));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/del")
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.commentService.deleteById(id));
    }

}

