package com.javartisan.springboot.javartisanspringboot;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.*;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping(value = "/login")
    public String login(HttpServletRequest request) {
        try {
            System.out.println("exit : " + IOUtils.toString(request.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "login";
    }


    @PostMapping(value = "/exit")
    public String exit(HttpServletRequest request) {
        try {
            System.out.println("exit : " + IOUtils.toString(request.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "exit";
    }


    @PutMapping(value = "/use")
    public String use(HttpServletRequest request,String aaa) {
        try {
            System.out.println("use : " + IOUtils.toString(request.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "use";
    }


    @PostMapping(value = "/upload")
    public String upload(MultipartFile file) {

        try {
            FileOutputStream out = new FileOutputStream(new File(System.currentTimeMillis() + ".txt"));

            // file是可以重复调用getInputStream方法，原因是底层实现时候讲文件保存在临时文件夹，每一次调用getInputStream方法都会读取文件，具体实现参见：org.apache.tomcat.util.http.fileupload.disk.DiskFileItem.getInputStream()
            InputStream in = file.getInputStream();

            byte[] buf = new byte[1024];
            int index = in.read(buf);
            while (index != -1) {
                out.write(buf, 0, index);
                out.flush();
                index = in.read(buf);
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success";
    }


}
