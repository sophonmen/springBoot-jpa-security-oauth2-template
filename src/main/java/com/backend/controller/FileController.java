package com.backend.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

/**
 * Created by sophon on 7/9/17.
 */
@Controller
@RequestMapping("api/file")
public class FileController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private Path location = Paths.get("upload-dir");

    @PostMapping("")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {

        logger.error("file name" + file.getOriginalFilename());
        // Files.copy(file.getInputStream(), location.resolve(file.getOriginalFilename()));
        File file1 = new File(System.getProperty("java.io.tmpdir") + "/" + file.getOriginalFilename());
        file.transferTo(file1);

        String[] s = file.getOriginalFilename().split("\\.");
        String extension = s[s.length - 1];
        String filename = "";
        for (int i = 0; i < s.length - 1; i++) {
            filename += s[i];
        }
        filename += "-";
        filename += new java.util.Date().getTime();
        logger.error("file name: " + filename);
        logger.error("file extension : " + extension);
        tests3(file1, filename + "." + extension);

        return new ResponseEntity<>("/upload-dir/" + file.getOriginalFilename(), HttpStatus.OK);
    }

    private void tests3(File file, String filename) throws IOException {

        final String keyID = "AKIAIWISO64UTJC6CWJA";
        final String keyname = "gmo/3pS4mZKU3DlR96+gw+GwrPQvlfivILAqCRtw";
        final String bucketname = "mytest-spring";
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(keyID, keyname);
        AmazonS3Client client = new AmazonS3Client(awsCredentials);

        PutObjectRequest request = new PutObjectRequest(bucketname, "image/" + filename, file);
        request.setCannedAcl(CannedAccessControlList.PublicRead);
        client.putObject(request);

    }
}




