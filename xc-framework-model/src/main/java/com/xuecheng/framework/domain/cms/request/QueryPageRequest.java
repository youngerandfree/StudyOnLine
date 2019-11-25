package com.xuecheng.framework.domain.cms.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Administrator
 * @version 1.0
 * @create 2018-09-12 14:59
 **/
@Data
public class QueryPageRequest {
    //接收页面查询的查询条件
    //站点id
    //站点id
    @ApiModelProperty("站点id")
    private String siteId;
    //页面ID
    @ApiModelProperty("当前所在页面的id")
    private String pageId;
    //页面名称
    @ApiModelProperty("当前页面的名称")
    private String pageName;
    //别名
    @ApiModelProperty("当前页面取的别名")
    private String pageAliase;
    //模版id
    @ApiModelProperty("当前页面所使用的模板ID")
    private String templateId;
    //....
}
