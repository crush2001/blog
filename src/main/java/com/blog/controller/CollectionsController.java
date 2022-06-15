package com.blog.controller;

import com.blog.entity.Collections;
import com.blog.service.CollectionsService;
import com.blog.tools.BaseController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.alibaba.fastjson.JSONArray;
import javax.annotation.Resource;

/**
 * (Collections)表控制层
 *
 * @author makejava
 * @since 2022-06-15 10:41:38
 */
@RestController
@RequestMapping("collections")
public class CollectionsController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private CollectionsService collectionsService;

    /**
     * 分页查询
     *
     * @param collections 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Collections>> queryByPage(Collections collections, PageRequest pageRequest) {
        return ResponseEntity.ok(this.collectionsService.queryByPage(collections, pageRequest));
    }
    
    
     @PostMapping("/getall")
    public String queryall(Collections collections, @RequestParam("page") int offset, @RequestParam("pageSize")int pageSize){
        List<Collections> Collectionss = this.collectionsService.queryAllByLimits(collections,offset,pageSize);
        long counts = collectionsService.count(collections);
        JSONArray jsonArray=new JSONArray();
        jsonArray.add(counts);
        jsonArray.add(Collectionss);
        return RespInfo(1,"查询信息",jsonArray);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Collections> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.collectionsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param collections 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Collections> add(Collections collections) {
        return ResponseEntity.ok(this.collectionsService.insert(collections));
    }

    /**
     * 编辑数据
     *
     * @param collections 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public ResponseEntity<Collections> edit(Collections collections) {
        return ResponseEntity.ok(this.collectionsService.update(collections));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/del")
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.collectionsService.deleteById(id));
    }

}

