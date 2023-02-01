package com.mall.thirdparty.aws.s3.controller;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.HttpMethod;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.mall.common.utils.R;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;
import java.time.Instant;

@RestController
@RequestMapping("thirdparty/s3")
public class S3PreSignedURL {
    @RequestMapping("/presignedurl/{file}")
    public R genPresignedURL(@PathVariable("file") String fileName) throws IOException {
        Regions clientRegion = Regions.EU_WEST_2;
        String bucketName = "myolshop";
        String objectKey = fileName;
        URL url = null;

        String bucket_name = bucketName;
        String key_name = objectKey;

        System.out.format("Creating a pre-signed URL for uploading %s to S3 bucket %s...\n", key_name, bucket_name);
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.EU_WEST_2).build();

        // Set the pre-signed URL to expire after 12 hours.
        java.util.Date expiration = new java.util.Date();
        long expirationInMs = expiration.getTime();
        expirationInMs += 1000 * 60 * 60 * 12;
        expiration.setTime(expirationInMs);

        try {
            GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucket_name, key_name)
                    .withMethod(HttpMethod.PUT)
                    .withExpiration(expiration);
            url = s3.generatePresignedUrl(generatePresignedUrlRequest);
            //print URL
            System.out.println("\n\rGenerated URL: " + url.toString());
            //Print curl command to consume URL
            System.out.println("\n\rExample command to use URL for file upload: \n\r");
            System.out.println("curl --request PUT --upload-file /path/to/" + key_name + " '" + url.toString() + "' -# > /dev/null");
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }

        return R.ok().put("presignedURL", url.toString());
    }
}