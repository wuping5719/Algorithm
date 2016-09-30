package acmCoder;

import java.io.File;

/**
 * @author WuPing
 * @version 2016年9月30日 下午8:33:13
 */

public class CountFileNum {

    private static int filecount = 0;
    private static int menucount = 0;
    private static int size = 0;
    private static long time = 0;

    public static void countFile(String path) {
	File file = new File(path);

	if (!file.exists()) {
	    System.out.println("文件不存在");
	    return;
	}

	File[] files = file.listFiles(); // 返回当前路径下的所有文件
	if (files == null) {
	    // file不是一个文件夹, 是一个文件
	    size = (int) file.length();
	    time = file.lastModified();
	    filecount = 1;

	    System.out.println(file.getAbsolutePath() + "最后修改时间为 :" + time);
	    return;
	}

	// 运行到这里说明path路径是一个文件夹
	for (int i = 0; i < files.length; i++) {
	    File f = files[i];
	    if (f.isFile()) {
		filecount++;
		size += (int) f.length();
		time = file.lastModified();

		// 将所有文件设为只读
		// f.setReadOnly();
	    } else if (f.isDirectory()) {
		// 调用本身
		menucount++;
		System.out.println(f.getAbsolutePath());
		countFile(f.getAbsolutePath());
	    }
	}
    }

    public static void main(String[] args) {
	String path = "E:\\面试资料";
	countFile(path);
	System.out.println("文件数:" + filecount);
	System.out.println("文件夹数:" + menucount);
	System.out.println("总文件大小:" + size);
    }

}
