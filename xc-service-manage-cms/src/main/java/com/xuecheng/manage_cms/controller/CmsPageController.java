package com.xuecheng.manage_cms.controller;

import com.xuecheng.api.cms.CmsPageControllerApi;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CmsPageController implements CmsPageControllerApi {

    @Autowired
    private PageService pageService;

    @Override
    @GetMapping("/list/{currentPage}/{pageSize}")
    public QueryResponseResult findList
            (@PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize, QueryPageRequest queryPageRequest) {
        try{
            return pageService.findList(currentPage, pageSize, queryPageRequest);
        }catch (Exception e){
            e.printStackTrace();
            return new QueryResponseResult(CommonCode.FAIL,new QueryResult());
        }

    }
}
