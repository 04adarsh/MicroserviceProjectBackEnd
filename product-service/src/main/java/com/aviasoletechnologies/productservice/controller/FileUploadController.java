package com.aviasoletechnologies.productservice.controller;


import com.aviasoletechnologies.productservice.dto.ImageResp;

import com.aviasoletechnologies.productservice.helper.FileUploadHelper;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200","*"},allowedHeaders = {"Origin", "Access-Control-Allow-Origin", "X-Requested-With", "Content-Type", "Accept", "Authorization"})
public class FileUploadController {



    @Autowired
    private FileUploadHelper fileUploadHelper;
    public final String
    DIR="C:\\Users\\LENOVO\\Desktop\\Adarsh Projects\\Back-end\\product-service\\src\\main\\resources\\static\\images";
    @PostMapping("/upload-file")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file){

       ImageResp resp= this.fileUploadHelper.uploadFile(file);
        System.out.println(file.getName());
       if(resp==null){
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/upload-files")
    public ResponseEntity<?> uploadFile(@RequestParam("files") MultipartFile files[]){

        List<String> resp= this.fileUploadHelper.uploadFiles(files);
        if(resp==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(resp);
    }

    @GetMapping(value = "/getImages/{imageName}",produces =MediaType.ALL_VALUE )
    public void getImages(@PathVariable("imageName") String imageName,
                          HttpServletResponse response){

        try{
          InputStream resource=  this.fileUploadHelper.getResource(DIR,imageName);
          response.setContentType(MediaType.ALL_VALUE);
            StreamUtils.copy(resource,response.getOutputStream());

        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
