package com.mall.thirdparty;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThirdPartyApplicationTests {
    @Value("${accesskey}")
    private String accessKey;

    @Value("${secretkey}")
    private String secretKey;

    @Autowired
    S3PreSignedURL s3PreSignedURL;

    @Test
    public void contextLoads() {
    }

//    @Test
//    public void uploadPicture() {
//        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
//
//        AmazonS3 s3client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.EU_WEST_2).build();
//
//        String bucketName = "myolshop";
//        s3client.putObject(bucketName, "8.png", new File("/home/ubuntu/data/online_shop/Screenshot_20221116_213056.png"));
//    }

    @Test
    public void presignUrl() throws IOException {
        String res = s3PreSignedURL.genPresignedURL();
        System.out.println(res);
    }
}
