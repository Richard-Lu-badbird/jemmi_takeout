package com.richard.jemmi.controller;

import com.richard.jemmi.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/common/")
@Slf4j
public class CommenController {

    @Value("${jemmi.path}")
    public String bashPath;
    /**
     * 文件上传
     * @param file
     * 这里的参数必须写成file
     * @return
     */
    @PostMapping("upload")
    public R<String> upload(MultipartFile file) {
        //file是临时文件，需要转存到指定的位置，否则本次请求完成后，临时文件会删除

        log.info(file.toString());
        //原始文件名称
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //使用UUID重新生成文件名称，防止文件名称相同造成覆盖
        String fileName = UUID.randomUUID().toString() + suffix;


        //创建一个目录对象
        File dir = new File(bashPath);

        //判断当前目录是否存在
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            file.transferTo(new File(bashPath + fileName));
        }catch (IOException ioException) {
            ioException.printStackTrace();
        }

        return R.success(fileName);
    }

    @GetMapping("download")
    public void download(String name, HttpServletResponse response) {
        //通过流的形式返回

        try {
            //输入流，通过输入流读取文件内容
            FileInputStream fileInputStream = new FileInputStream(new File(bashPath + name));

            response.setContentType("image/jpg");
            //输出流，通过输出流将文件写回浏览器，在浏览器中展示图片
            ServletOutputStream servletOutputStream = response.getOutputStream();
            int len = 0;
            byte[] bytes = new byte[1024];

            while ((len = fileInputStream.read(bytes)) != -1) {
                servletOutputStream.write(bytes, 0, len);
                servletOutputStream.flush();
            }
            servletOutputStream.close();
            fileInputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
