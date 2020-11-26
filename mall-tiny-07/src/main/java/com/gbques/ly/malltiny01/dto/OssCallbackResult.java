package com.gbques.ly.malltiny01.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ly
 * @since 2020-11-26 10:07
 * oss上传文件的回调结果
 */
@Data
public class OssCallbackResult {
    @ApiModelProperty("文件名称")
    private String filename;
    @ApiModelProperty("文件大小")
    private String size;
    @ApiModelProperty("文件的mimeType")
    private String mimeType;
    @ApiModelProperty("图片文件的宽")
    private String width;
    @ApiModelProperty("图片文件的高")
    private String height;
}