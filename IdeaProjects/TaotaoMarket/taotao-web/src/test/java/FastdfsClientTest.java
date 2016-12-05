import com.waitsober.utils.FastDFSClient;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FastdfsClientTest {
	
	//客户端配置文件
	public String conf_filename = "/Users/Renhai/IdeaProjects/TaotaoMarket/taotao-web/src/main/resources/fdfs_client.conf";
    //本地文件，要上传的文件
	public String local_filename = "/Users/Renhai/Documents/myablums/headimg.png";

//上传文件
    @Test
    public void testUpload() { 
    	
    	for(int i=0;i<100;i++){

        try { 
            ClientGlobal.init(conf_filename);

            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;

            StorageClient storageClient = new StorageClient(trackerServer,
                    storageServer); 
            NameValuePair nvp [] = new NameValuePair[]{
                    new NameValuePair("item_id", "100010"), 
                    new NameValuePair("width", "80"),
                    new NameValuePair("height", "90")
            }; 
            String fileIds[] = storageClient.upload_file(local_filename, null, 
                    nvp); 

            System.out.println(fileIds.length); 
            System.out.println("组名：" + fileIds[0]); 
            System.out.println("路径: " + fileIds[1]); 

        } catch (FileNotFoundException e) {
            e.printStackTrace(); 
        } catch (IOException e) {
            e.printStackTrace(); 
        } catch (Exception e) {
			e.printStackTrace();
		} 
    	}
    }



    @Test
    public void testFastDFSClient() throws Exception{
        FastDFSClient fastDFSClient=new FastDFSClient("/Users/Renhai/IdeaProjects/TaotaoMarket/taotao-web/src/main/resources/resource/fast_dfs.conf");
        String s = fastDFSClient.uploadFile("/Users/Renhai/Documents/myablums/headimg.png");
        System.out.println(s);
    }

}
