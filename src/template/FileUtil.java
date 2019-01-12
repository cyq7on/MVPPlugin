package template;

import java.io.*;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA
 * User yugai
 * Time 17/2/24.
 */
public class FileUtil {
    public static String traverseFolder(String path) {
        File file = new File(path);
        if (file.exists()) {
            LinkedList<File> list = new LinkedList<File>();
            File[] files = file.listFiles();
            for (File file2 : files) {
                if (file2.isDirectory()) {
                    System.out.println("文件夹:" + file2.getAbsolutePath());
                    if (file2.getName().endsWith("mvp")) {
                        return file2.getAbsolutePath();
                    }
                    list.add(file2);
                }
            }
            File temp_file;
            while (!list.isEmpty()) {
                temp_file = list.removeFirst();
                files = temp_file.listFiles();
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        System.out.println("文件夹:" + file2.getAbsolutePath());
                        if (file2.getName().endsWith("mvp")) {
                            return file2.getAbsolutePath();
                        }
                        list.add(file2);

                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
        System.out.println("没有发现文件");
        return "";
    }

    public static String readFile(String filePath) {
        InputStream is = null;
        BufferedReader reader = null;
        StringBuilder buffer = new StringBuilder();
        try {
            is = new FileInputStream(filePath);
            String line; // 用来保存每行读取的内容
            reader = new BufferedReader(new InputStreamReader(is));
            line = reader.readLine(); // 读取第一行
            while (line != null) { // 如果 line 为空说明读完了
                buffer.append(line); // 将读到的内容添加到 buffer 中
                buffer.append("\n"); // 添加换行符
                line = reader.readLine(); // 读取下一行
            }
            return buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }

    }
}
