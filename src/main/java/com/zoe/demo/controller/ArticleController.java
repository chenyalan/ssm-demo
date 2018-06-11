package com.zoe.demo.controller;
import com.sun.org.apache.xml.internal.serializer.EmptySerializer;
import com.zoe.demo.common.ResultData;
import com.zoe.demo.entity.ArticleDO;
import com.zoe.demo.service.ArticleService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.io.File;
import java.io.IOException;

/**
 * Created by 陈亚兰 on 2018/3/5.
 */
@RestController
@RequestMapping("/article")
@Slf4j
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Value(value = "${isdevmode}")
    private boolean isdevmode;

    @Value(value = "${user.photo.address}")
    private String baseUrl;

    @PostMapping("/add")
    public ResultData add(MultipartFile file) throws IOException {
        String fileName=file.getOriginalFilename().toLowerCase();
        String name=fileName.substring(0,fileName.lastIndexOf("."));
        String symble;
        if(isdevmode) {
            symble="\\";
        }else{
            symble="/";
        }

        File fileAddress=new File(baseUrl);
        if(!fileAddress.exists()){
            fileAddress.mkdir();
        }
        String filePath=baseUrl+fileName;
        if(articleService.findByAddress(filePath)!=null){
            return ResultData.error("此文件已经存在");
        }
        log.info("baseUrl:"+baseUrl+"\tfilePath:"+filePath);
        file.transferTo(new File(filePath));
        ArticleDO articleDO=new ArticleDO(name,"zoe",baseUrl+fileName);
        articleService.add(articleDO);
        return ResultData.success(articleDO);
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",value = "当前页",defaultValue = "0",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "size",value = "每页个数",defaultValue = "10",paramType = "query",dataType = "String")
    })
    @GetMapping("/myArticle")
    public ResultData getMyArticle(@ApiIgnore@PageableDefault(value = 10,page = 0,size = 10,sort={"createDate"},direction = Sort.Direction.DESC)Pageable page){
        Page p=articleService.getMyArticle(page);
        return ResultData.success(p);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除文章")
    @ApiImplicitParam(name = "id",value = "文章id",paramType = "path",dataType = "Long")
    public ResultData deleteById(@PathVariable Long id){
        Long flag=articleService.delete(id);
        if(flag>0){
            return ResultData.success("删除成功");
        }else {
            return ResultData.error("所选id不存在");
        }
    }
    @DeleteMapping
    @ApiOperation("删除选中文章")
    @ApiImplicitParam(name = "ids",value = "选中id",paramType = "query",dataType = "Long[]")
    public ResultData deleteSelected(Long[] ids){
        Long flag=articleService.deleteSelected(ids);
        if(flag<0){
            return ResultData.error("所选id:"+(-flag)+"不存在");
        }else if(flag==1){
            return ResultData.success("删除成功");
        }
        return ResultData.error("删除失败");
    }

    @GetMapping("/ddd")
    public ResultData get(){
        return ResultData.success(articleService.selectAll());
    }

    @GetMapping("/empAll")
    public ResultData selectEmpAll(){
        return ResultData.success(articleService.selectEmpAll());
    }
}
