package io.demo01.filewriter;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/**
 * created by Jay on 2019/7/28
 */
public class FileWriterTest
{
    /**
     * FileWriter无法指定编码, 采用默认的UTF-8编码格式，
     * 写入的文件temp.txt是UTF-8编码格式, 占用6个字节的大小
     *
     * @throws Exception
     */
    @Test
    public void testCharset() throws Exception
    {
        FileWriter fileWriter = new FileWriter("D:\\temp.txt");
        fileWriter.write("中国");
        fileWriter.flush();
        fileWriter.close();
    }

    @Test
    public void testOutputStreamWriterCharset() throws Exception
    {
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(new File("D:\\temp1.txt")));
        writer.write("中国");
        writer.flush();
        writer.close();

    }


    @Test
    public void getDefaultCharset()
    {
        // 以下是windows环境
        // 操作系统编码 GBK
        System.out.println(System.getProperty("sun.jnu.encoding"));
        // java文件编码 UTF-8, 不是class文件的编码, 所有的class文件都是UTF-8编码格式
        System.out.println(System.getProperty("file.encoding"));
        // JVM默认字符集UTF-8， 一般情况下, 默认字符集等于file.encoding
        System.out.println(Charset.defaultCharset());
    }


    @Test
    public void testReadFromFile() throws Exception
    {
        // JVM字符集为UTF-8
        System.out.println("file.encoding:" + System.getProperty("file.encoding"));
        System.out.println("DefaultCharset:" + Charset.defaultCharset());
        File file = new File("D:\\temp.txt");
        byte[] data = FileUtils.readFileToByteArray(file);
        // 如果temp.txt编码格式为UTF-8, 可以用以下代码; 如果编码格式为GBK, 则需要 System.out.println(new String(data, "GBK"));
        System.out.println(new String(data));
    }


}
