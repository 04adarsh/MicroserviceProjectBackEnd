package com.aviasoletechnologies.productservice.helper;


import com.aviasoletechnologies.productservice.dto.ImageResp;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;



@Component
public class FileUploadHelper {

    public final String
    UPLOAD_DIR="C:\\Users\\LENOVO\\Desktop\\Adarsh Projects\\Back-end\\product-service\\src\\main\\resources\\static\\images";


    public ImageResp uploadFile(MultipartFile multipartFile){


        UUID uuid = UUID.randomUUID();
        String randomAppend=uuid.toString();
        String fileName=randomAppend+multipartFile.getOriginalFilename();

        Path saveTo= Paths.get(UPLOAD_DIR+"\\" + fileName);

        try {
            try {
                Files.copy(multipartFile.getInputStream(), saveTo);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Error : " + e.getMessage());
            }
            return new ImageResp(fileName);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: "+ e.getMessage());
        }
        return null;
    }
    public List<String> uploadFiles(MultipartFile multipartFiles[]) {
        List<String> respList = new ArrayList<>();

        try {
            for (MultipartFile multipartFile : multipartFiles) {
                UUID uuid = UUID.randomUUID();
                String randomAppend = uuid.toString();
                String fileName = randomAppend + multipartFile.getOriginalFilename();

                Path saveTo = Paths.get(UPLOAD_DIR + "\\" + fileName);
                try {
                    Files.copy(multipartFile.getInputStream(), saveTo);
                    respList.add(fileName);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException("Error : " + e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return respList;
    }

    public InputStream getResource(String path, String filename) throws FileNotFoundException, Exception{
        String fullPath=path+ File.separator+filename;
        InputStream is=new FileInputStream(fullPath);
        return is;
    }
}
