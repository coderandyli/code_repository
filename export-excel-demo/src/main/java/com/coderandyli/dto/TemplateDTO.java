package com.coderandyli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * Created by lizhen on 2019-03-04
 */
@Data
@AllArgsConstructor
public class TemplateDTO {

//    @ApiModelProperty(value = "消息类型 mail、station_letter(站内信) 、")
    private String type;

//    @ApiModelProperty(value = "模板code")
    private String code;

//    @ApiModelProperty(value = "模板名称")
    private String name;

//    @ApiModelProperty(value = "(中文)模板内容")
    private String templeteCn;

//    @ApiModelProperty(value = "(英文)模板内容")
    private String templeteEn;

//    @ApiModelProperty(value = "备注信息")
    private String remark;


}
