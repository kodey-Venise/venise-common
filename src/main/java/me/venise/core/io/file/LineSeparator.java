package me.venise.core.io.file;

/**
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/28 15:21
 */
public enum LineSeparator {
    /** Mac系统换行符："\r" */
    MAC("\r"),
    /** Linux系统换行符："\n" */
    LINUX("\n"),
    /** Windows系统换行符："\r\n" */
    WINDOWS("\r\n");

    private final String value;

    LineSeparator(String lineSeparator) {
        this.value = lineSeparator;
    }

    public String getValue() {
        return this.value;
    }
}