package com.hz.websit.controller;

import cn.hutool.core.lang.UUID;
import com.hz.websit.common.Result;
import com.hz.websit.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 项目名称：hz-websit
 * 类 名 称：CommonController
 * 类 描 述：TODO
 * 创建时间：2021/8/25 9:32 上午
 * 创 建 人：guan
 */
@CrossOrigin
@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {

    // 平台域名
    private String domainUrl = "https://www.huancelian.com/platform";

    @Value("${file.upload.url}")
    private String uploadFilePath;

    @Value("${video.upload.url}")
    private String uploadVideoPath;

    @RequestMapping(value = "/img/upload", method = RequestMethod.POST)
    public Result<Object> httpImgUpload(@RequestParam("file") MultipartFile files[]) {
        if(files == null || files.length == 0) {
            return ResultUtil.error("上传失败，请选择文件！");
        }
        StringBuilder fileNames = new StringBuilder();
        for(int i = 0; i < files.length; i++) {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            String fileName = "";
            if(files[i].getOriginalFilename().endsWith(".png")) {
                fileName = uuid + ".png";
            }else if(files[i].getOriginalFilename().endsWith(".jpg")) {
                fileName = uuid + ".jpg";
            }else if(files[i].getOriginalFilename().endsWith(".jpeg")) {
                fileName = uuid + ".jpeg";
            }
            fileNames.append(fileName).append(",");
            File dest = new File(uploadFilePath + "/" + fileName);
            if(!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try{
                files[i].transferTo(dest);
            }catch (Exception e){
                log.error("{}", e);
                return ResultUtil.error("程序错误，请重新上传！");
            }
        }
        return ResultUtil.data(fileNames.toString().substring(0,fileNames.length()-1), "文件上传成功！");
    }


    @RequestMapping(value = "/video/upload", method = RequestMethod.POST)
    public Result<Object> httpUpload(@RequestParam("files") MultipartFile files[]) {
        if(files == null || files.length == 0) {
            return ResultUtil.error("上传失败，请选择文件！");
        }
        StringBuilder fileNames = new StringBuilder();
        for(int i = 0; i < files.length; i++) {
            String fileName = files[i].getOriginalFilename();
            fileNames.append(fileName).append(",");
            File dest = new File(uploadVideoPath + "/" + fileName);
            if(!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try{
                files[i].transferTo(dest);
            }catch (Exception e){
                log.error("{}", e);
                return ResultUtil.error("程序错误，请重新上传！");
            }
        }
        return ResultUtil.data(fileNames.toString().substring(0,fileNames.length()-1), "文件上传成功！");
    }
}
