package com.coderandyli.fastdfsdemo.controller;

import com.coderandyli.fastdfsdemo.utils.FastDFSClientUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.lwawt.macosx.CSystemTray;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/filestorage")
public class FileStorageController {
    @Autowired
    private FastDFSClientUtil dfsClient;

    @PostMapping("/upload")
    public String fdfsUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        try {
            return dfsClient.uploadFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/download")
    public void download(@RequestParam("filePath") String filePath, HttpServletRequest request, HttpServletResponse response) throws IOException {

        String[] paths = filePath.split("/");
        String groupName = null;
        for (String item : paths) {
            if (item.indexOf("group") != -1) {
                groupName = item;
                break;
            }
        }
        String path = filePath.substring(filePath.indexOf(groupName) + groupName.length() + 1, filePath.length());
        InputStream input = dfsClient.download(groupName, path);

        //根据文件名获取 MIME 类型
        String fileName = paths[paths.length - 1];
        String contentType = request.getServletContext().getMimeType(fileName);
        System.out.println(contentType);
        String contentDisposition = "attachment;filename=" + fileName;

        // 设置头
        response.setHeader("Content-Type", contentType);
        response.setHeader("Content-Disposition", contentDisposition);

        // 获取绑定了客户端的流
        ServletOutputStream output = response.getOutputStream();

        // 把输入流中的数据写入到输出流中
        IOUtils.copy(input, output);
        input.close();
    }

    /**
     * http://localhost/deleteFile?filePath=group1/M00/00/00/wKgIZVzZaRiAZemtAARpYjHP9j4930.jpg
     *
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/delete")
    public String delFile(@RequestParam("filePath") String filePath, HttpServletRequest request, HttpServletResponse response) {
        try {
            dfsClient.delFile(filePath);
        } catch (Exception e) {
            // 文件不存在报异常 ： com.github.tobato.fastdfs.exception.FdfsServerException: 错误码：2，错误信息：找不到节点或文件
            // e.printStackTrace();
        }
        request.setAttribute("msg", "成功删除，'" + filePath);

        return "index";
    }
}
