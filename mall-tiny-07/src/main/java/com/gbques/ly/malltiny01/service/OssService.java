package com.gbques.ly.malltiny01.service;

import com.gbques.ly.malltiny01.dto.OssCallbackResult;
import com.gbques.ly.malltiny01.dto.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ly
 * @since 2020-11-26 10:09
 * oss上传管理Service
 */

public interface OssService {
    /**
     * oss上传策略生成
     */
    OssPolicyResult policy();

    /**
     * oss上传成功回调
     */
    OssCallbackResult callback(HttpServletRequest request);
}
