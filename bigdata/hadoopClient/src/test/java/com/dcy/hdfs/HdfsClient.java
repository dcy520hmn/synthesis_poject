package com.dcy.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * use hadoop client to operator hdfs.
 */
public class HdfsClient {

    //create director
    @Test
    public void testMkdirs() throws IOException, InterruptedException, URISyntaxException {

        // 1 get file system
        Configuration configuration = new Configuration();
        // config run at cluster
        // configuration.set("fs.defaultFS", "hdfs://centos-node-132:8020");
        // FileSystem fs = FileSystem.get(configuration);

        FileSystem fs = FileSystem.get(new URI("hdfs://centos-node-132:8020"), configuration, "root");

        // 2 create director
        fs.mkdirs(new Path("/1108/daxian/banzhang"));

        // 3 close resource
        fs.close();
    }

    //upload file
    @Test
    public void testCopyFromLocalFile() throws IOException, InterruptedException, URISyntaxException {

        // 1 get file system
        Configuration configuration = new Configuration();
        //set replication
        configuration.set("dfs.replication", "2");
        FileSystem fs = FileSystem.get(new URI("hdfs://centos-node-132:8020"), configuration, "root");

        // 2 upload file
        fs.copyFromLocalFile(new Path("D:\\Test.txt"), new Path("/test/test.txt"));

        // 3 close resource
        fs.close();

        System.out.println("over");
    }

    //download file
    @Test
    public void testCopyToLocalFile() throws IOException, InterruptedException, URISyntaxException {

        // 1 get file system
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://centos-node-132:8020"), configuration, "atguigu");

        // 2 execute download operator
        // boolean delSrc  Whether or not to delete delete source file
        // Path src 指要下载的文件路径
        // Path dst 指将文件下载到的路径
        // boolean useRawLocalFileSystem 是否开启文件校验
        fs.copyToLocalFile(false, new Path("/banzhang.txt"), new Path("e:/banhua.txt"), true);

        // 3 关闭资源
        fs.close();
    }

    //delete file
    @Test
    public void testDelete() throws IOException, InterruptedException, URISyntaxException {

        // 1 获取文件系统
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://centos-node-132:8020"), configuration, "atguigu");

        // 2 执行删除
        fs.delete(new Path("/0508/"), true);

        // 3 关闭资源
        fs.close();
    }

    //update file name
    @Test
    public void testRename() throws IOException, InterruptedException, URISyntaxException {

        // 1 获取文件系统
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://centos-node-132:8020"), configuration, "atguigu");

        // 2 修改文件名称
        fs.rename(new Path("/banzhang.txt"), new Path("/banhua.txt"));

        // 3 关闭资源
        fs.close();
    }

    //ll file
    @Test
    public void testListFiles() throws IOException, InterruptedException, URISyntaxException {

        // 1获取文件系统
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://centos-node-132:8020"), configuration, "atguigu");

        // 2 获取文件详情
        RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"), true);

        while (listFiles.hasNext()) {
            LocatedFileStatus status = listFiles.next();

            // 输出详情
            // 文件名称
            System.out.println(status.getPath().getName());
            // 长度
            System.out.println(status.getLen());
            // 权限
            System.out.println(status.getPermission());
            // 分组
            System.out.println(status.getGroup());

            // 获取存储的块信息
            BlockLocation[] blockLocations = status.getBlockLocations();

            for (BlockLocation blockLocation : blockLocations) {

                // 获取块存储的主机节点
                String[] hosts = blockLocation.getHosts();

                for (String host : hosts) {
                    System.out.println(host);
                }
            }

            System.out.println("-----------班长的分割线----------");
        }

        // 3 关闭资源
        fs.close();
    }

    //Determine whether it's a file or a folder
    @Test
    public void testListStatus() throws IOException, InterruptedException, URISyntaxException{

        // 1 获取文件配置信息
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://centos-node-132:8020"), configuration, "atguigu");

        // 2 判断是文件还是文件夹
        FileStatus[] listStatus = fs.listStatus(new Path("/"));

        for (FileStatus fileStatus : listStatus) {

            // 如果是文件
            if (fileStatus.isFile()) {
                System.out.println("f:"+fileStatus.getPath().getName());
            }else {
                System.out.println("d:"+fileStatus.getPath().getName());
            }
        }

        // 3 关闭资源
        fs.close();
    }
}
