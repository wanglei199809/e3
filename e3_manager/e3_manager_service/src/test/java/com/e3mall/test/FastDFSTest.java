package com.e3mall.test;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import com.e3mall.common.utils.FastDFSClient;

public class FastDFSTest {

	@Test
	public void testFileUpload() throws Exception {
		// 1、加载配置文件，配置文件中的内容就是tracker服务的地址。
		ClientGlobal.init("D:/EclipseWorkSpace/heima-yilifang/workspace/e3_manager/e3_manager_service/src/main/resources/conf/client.conf");
		// 2、创建一个TrackerClient对象。直接new一个。
		TrackerClient trackerClient = new TrackerClient();
		// 3、使用TrackerClient对象创建连接，获得一个TrackerServer对象。
		TrackerServer trackerServer = trackerClient.getConnection();
		// 4、创建一个StorageServer的引用，值为null
		StorageServer storageServer = null;
		// 5、创建一个StorageClient对象，需要两个参数TrackerServer对象、StorageServer的引用
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		// 6、使用StorageClient对象上传图片。
		//扩展名不带“.”
		String[] strings = storageClient.upload_file("D:/learnResource/黑马32/项目二：宜立方商城(80-93天）/e3商城_day01/01.教案-3.0/01.参考资料/广告图片/9a80e2d06170b6bb01046233ede701b3.jpg", "jpg", null);
		// 7、返回数组。包含组名和图片的路径。
		for (String string : strings) {
			System.out.println(string);
		}
	}
	
	@Test
	public void testFastDfsClient() throws Exception {
		FastDFSClient fastDFSClient = new FastDFSClient("D:/EclipseWorkSpace/heima-yilifang/workspace/e3_manager/e3_manager_service/src/main/resources/conf/client.conf");
		String file = fastDFSClient.uploadFile("D:/learnResource/黑马32/项目二：宜立方商城(80-93天）/e3商城_day01/01.教案-3.0/01.参考资料/广告图片/b463a2b010033397a2dcd09aa6f57d0c.jpg");
		System.out.println(file);
	}

}
