package com.aviasoletechnologies.productservice.helper;


import com.aviasoletechnologies.productservice.dto.ImageResp;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.InputStream;

@Component
public class FileUploadHelper {

    public final String
    UPLOAD_DIR="C:\\Users\\LENOVO\\Desktop\\Adarsh Projects\\Back-end\\product-service\\src\\main\\resources\\static\\images";


    public ImageResp uploadFile(MultipartFile multipartFile){

        try{
//        for(MultipartFile multipartFile: multipartFiles){
//
//        }
            InputStream is= multipartFile.getInputStream();

            byte data[]=new byte[is.available()];
            is.read(data);

            FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+"\\"+multipartFile.getOriginalFilename());
            fos.write(data);

            fos.close();
            return  new ImageResp(multipartFile.getOriginalFilename());


        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
