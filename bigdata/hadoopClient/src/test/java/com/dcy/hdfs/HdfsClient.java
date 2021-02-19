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
        // Path src ָҪ���ص��ļ�·��
        // Path dst ָ���ļ����ص���·��
        // boolean useRawLocalFileSystem �Ƿ����ļ�У��
        fs.copyToLocalFile(false, new Path("/banzhang.txt"), new Path("e:/banhua.txt"), true);

        // 3 �ر���Դ
        fs.close();
    }

    //delete file
    @Test
    public void testDelete() throws IOException, InterruptedException, URISyntaxException {

        // 1 ��ȡ�ļ�ϵͳ
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://centos-node-132:8020"), configuration, "atguigu");

        // 2 ִ��ɾ��
        fs.delete(new Path("/0508/"), true);

        // 3 �ر���Դ
        fs.close();
    }

    //update file name
    @Test
    public void testRename() throws IOException, InterruptedException, URISyntaxException {

        // 1 ��ȡ�ļ�ϵͳ
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://centos-node-132:8020"), configuration, "atguigu");

        // 2 �޸��ļ�����
        fs.rename(new Path("/banzhang.txt"), new Path("/banhua.txt"));

        // 3 �ر���Դ
        fs.close();
    }

    //ll file
    @Test
    public void testListFiles() throws IOException, InterruptedException, URISyntaxException {

        // 1��ȡ�ļ�ϵͳ
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://centos-node-132:8020"), configuration, "atguigu");

        // 2 ��ȡ�ļ�����
        RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"), true);

        while (listFiles.hasNext()) {
            LocatedFileStatus status = listFiles.next();

            // �������
            // �ļ�����
            System.out.println(status.getPath().getName());
            // ����
            System.out.println(status.getLen());
            // Ȩ��
            System.out.println(status.getPermission());
            // ����
            System.out.println(status.getGroup());

            // ��ȡ�洢�Ŀ���Ϣ
            BlockLocation[] blockLocations = status.getBlockLocations();

            for (BlockLocation blockLocation : blockLocations) {

                // ��ȡ��洢�������ڵ�
                String[] hosts = blockLocation.getHosts();

                for (String host : hosts) {
                    System.out.println(host);
                }
            }

            System.out.println("-----------�೤�ķָ���----------");
        }

        // 3 �ر���Դ
        fs.close();
    }

    //Determine whether it's a file or a folder
    @Test
    public void testListStatus() throws IOException, InterruptedException, URISyntaxException{

        // 1 ��ȡ�ļ�������Ϣ
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://centos-node-132:8020"), configuration, "atguigu");

        // 2 �ж����ļ������ļ���
        FileStatus[] listStatus = fs.listStatus(new Path("/"));

        for (FileStatus fileStatus : listStatus) {

            // ������ļ�
            if (fileStatus.isFile()) {
                System.out.println("f:"+fileStatus.getPath().getName());
            }else {
                System.out.println("d:"+fileStatus.getPath().getName());
            }
        }

        // 3 �ر���Դ
        fs.close();
    }
}
