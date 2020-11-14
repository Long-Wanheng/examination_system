package com.examination_system.utils;

import java.io.IOException;
import java.util.Date;
import java.util.logging.*;

/**
 * @program examination-system
 * @description: 日志打印工具类
 * @author: yao
 * @create: 2020/11/14 16:04
 */
public class LogUtil {
    private static Logger LOGGER = null;

    static {
        try {
            init();
        } catch (Exception e) {

        }
    }

    /**
     * 初始化LOGGER
     *
     * @throws IOException I/O异常
     */
    public static void init() throws IOException {
        LOGGER = Logger.getLogger("service_log");
        LOGGER.setLevel(Level.ALL);
        FileHandler fileHandler = new FileHandler("service_log.log");
        fileHandler.setLevel(Level.ALL);
        fileHandler.setFormatter(new LogFormatter());
        LOGGER.addHandler(fileHandler);
    }

    /**
     * 获取 LOGGER
     *
     * @return Logger
     */
    public static Logger getLogger() {
        return LOGGER;
    }

    static class LogFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            Date date = new Date();
            String sDate = date.toString();
            return "[" + sDate + "]" + "[" + record.getLevel() + "]"
                    + record.getClass() + record.getMessage() + "\n";
        }
    }
}
