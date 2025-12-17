package org.cdt.analyzer;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.Assert.*;

public class CStaticAnalyzerTest {
    private static final Logger logger = LoggerFactory.getLogger(CStaticAnalyzerTest.class);
    private final CStaticAnalyzer analyzer = new CStaticAnalyzer();

    // 测试合法C文件
    @Test
    public void testAnalyzeValidCFile() {
        String validCPath = "src/test/resources/test-cases/valid.c";
        boolean result = analyzer.analyzeCFile(validCPath);
        assertTrue("合法C文件分析失败", result);
    }

    // 测试不存在的文件
    @Test
    public void testAnalyzeNonExistentFile() {
        String nonExistentPath = "src/test/resources/test-cases/none.c";
        boolean result = analyzer.analyzeCFile(nonExistentPath);
        assertFalse("不存在的文件分析应返回false", result);
    }

    // 测试非C文件
    @Test
    public void testAnalyzeNonCFile() {
        String nonCPath = "src/test/resources/test-cases/valid.txt";
        boolean result = analyzer.analyzeCFile(nonCPath);
        assertFalse("非C文件分析应返回false", result);
    }
}