package com.ankaref.tides.core.utilities.file;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.UUID;

@Service
public class FileService {

    public String writeBase64StringtoFile (String image) throws IOException{
       String fileName= randomName();
       File target =new File ("D:\\projects\\backend\\tides\\src\\main\\java\\picture-storage\\"+ fileName);
       OutputStream outputStream=new FileOutputStream(target);

       byte[] base64enoded= Base64.getDecoder().decode(image);

       outputStream.write(base64enoded);
       outputStream.close();
       return fileName;
    }

    public String randomName(){
        return UUID.randomUUID().toString().replaceAll("-","");

    }

}
