package org.cdt.analyzer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 程序入口类（命令行运行）
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        // 校验命令行参数
        if (args.length < 2 || !args[0].equals("-f")) {
            logger.error("用法：java -jar static-analyzer.jar -f <C文件路径>");
            return;
        }

        // 执行文件分析
        String cFilePath = args[1];
        CStaticAnalyzer analyzer = new CStaticAnalyzer();
        boolean result = analyzer.analyzeCFile(cFilePath);

        // 输出最终结果
        if (result) {
            logger.info("🎉 C文件分析完成：全部校验通过");
        } else {
            logger.error("❌ C文件分析完成：校验失败");
        }
    }
}