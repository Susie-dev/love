package org.cdt.analyzer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * 基础版本：仅做C文件基础校验（无CDT依赖，可直接运行）
 * 功能：校验文件是否存在、是否为.c后缀
 */
public class CStaticAnalyzer {
    private static final Logger logger = LoggerFactory.getLogger(CStaticAnalyzer.class);

    /**
     * 分析C文件（基础校验）
     * @param cFilePath C文件路径
     * @return 校验是否通过
     */
    public boolean analyzeCFile(String cFilePath) {
        File cFile = new File(cFilePath);

        // 1. 校验文件是否存在
        if (!cFile.exists()) {
            logger.error("❌ C文件不存在：{}", cFilePath);
            return false;
        }

        // 2. 校验文件后缀是否为.c
        if (!cFilePath.endsWith(".c")) {
            logger.error("❌ 不是合法的C文件（后缀非.c）：{}", cFilePath);
            return false;
        }

        // 3. 校验通过
        logger.info("✅ C文件基础校验通过：{}", cFilePath);
        return true;
    }
}