package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "cms页面管理接口",description = "该接口提供页面的增删改查")
public interface CmsPageControllerApi {
    @ApiOperation("分页查询页面列表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage",value = "查询时的当前页",required = true,paramType = "pathURL",dataType = "int"),
            @ApiImplicitParam(name = "pageSize",value = "每次查询的页面数量",required = true,paramType = "pathURL",dataType = "int")

    })
    public QueryResponseResult findList(Integer currentPage, Integer pageSize, QueryPageRequest queryPageRequest);
}
