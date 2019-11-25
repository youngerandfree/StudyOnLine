package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.mapper.CmsPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Liu
 * @date 2019/11/23
 * @version 1.0.0
 */
@Service
public class PageService {
    @Autowired
    private CmsPageRepository cmsPageRepository;

    /**
     *该方法是为了对页面属性进行分页查询，要查询的数据库为MongodDB类型
     * @param currentPage 查询时传入的当前页码值，为null或0时会被赋予初始值1
     * @param pageSize 查询时传入的每页大小，为null或0时会被赋予初始值20
     * @param queryPageRequest 请求的其他详细信息，为null时被赋予新建对象
     * @return 查询结果统一为QueryResponseResult类
     * @see com.xuecheng.framework.model.response.QueryResponseResult
     * @see com.xuecheng.framework.model.response.QueryResult
     * @see com.xuecheng.framework.model.response.Response
     * @see com.xuecheng.framework.domain.cms.request.QueryPageRequest
     */
    public QueryResponseResult findList(Integer currentPage,Integer pageSize,QueryPageRequest queryPageRequest){
        //判断传入的当前页码值，为空则赋值
        if (currentPage == null || currentPage <= 0){
            currentPage = 1;
        }
        //为了匹配MongodDB数据库，需要对当前页码减1
        currentPage = currentPage - 1;
        if (pageSize == null || pageSize <= 0){
            pageSize = 20;
        }
        if (queryPageRequest == null){
            queryPageRequest = new QueryPageRequest();
        }

        Pageable pageable = PageRequest.of(currentPage,pageSize);
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);

        QueryResult queryResult = new QueryResult();
        queryResult.setTotal(all.getTotalElements());
        queryResult.setList(all.getContent());

        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);

    }
}
