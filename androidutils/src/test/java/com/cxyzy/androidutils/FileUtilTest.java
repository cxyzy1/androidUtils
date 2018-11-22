package com.cxyzy.androidutils;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public final class FileUtilTest {
    private final String filePath = "d:/test.txt";

    @Test
    public final void test_deleteFile() {
        FileUtil.createNewFile(filePath);
        Assert.assertTrue((new File(this.filePath)).exists());
        FileUtil.deleteFile(this.filePath);
        Assert.assertFalse((new File(this.filePath)).exists());
    }

    @Test
    public final void test_writeFile() {
        String content = "test123";
        FileUtil.deleteFile(this.filePath);
        FileUtil.writeFile(this.filePath, content);
        Assert.assertEquals(FileUtil.getFileContent(this.filePath), content);
        FileUtil.writeFile(this.filePath, content);
        Assert.assertEquals(FileUtil.getFileContent(this.filePath), content);
    }

    @Test
    public final void test_appendContent() {
        String content = "test123";
        FileUtil.deleteFile(this.filePath);
        FileUtil.appendContent(this.filePath, content);
        Assert.assertEquals(FileUtil.getFileContent(this.filePath), content);
        FileUtil.appendContent(this.filePath, content);
        Assert.assertEquals(FileUtil.getFileContent(this.filePath), content + content);
    }
}
