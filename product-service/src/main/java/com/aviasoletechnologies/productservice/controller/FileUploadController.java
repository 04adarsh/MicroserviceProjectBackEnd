package com.aviasoletechnologies.productservice.controller;


import com.aviasoletechnologies.productservice.dto.ImageResp;

import com.aviasoletechnologies.productservice.helper.FileUploadHelper;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = {"http://localhost:4200","*"},allowedHeaders = {"Origin", "Access-Control-Allow-Origin", "X-Requested-With", "Content-Type", "Accept", "Authorization"})
public class FileUploadController {



    @Autowired
    private FileUploadHelper fileUploadHelper;
    @PostMapping("/upload-file")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file){

       ImageResp resp= this.fileUploadHelper.uploadFile(file);
       if(resp==null){
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
        return ResponseEntity.ok(resp);





    }
}
