/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krams.controller;

/**
 *
 * @author mark.connolly
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletConfig;
import java.io.FileOutputStream;

import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.http.*;
import org.krams.domain.UploadItem;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/admin/uploadfile")
public class UploadFileController {
        private String uploadFolderPath;
        ServletConfig config;

        public String getUploadFolderPath() {
                return uploadFolderPath;
        }

        public void setUploadFolderPath(String uploadFolderPath) {
                this.uploadFolderPath = uploadFolderPath;
        }

        @RequestMapping(method = RequestMethod.GET)
        public String getUploadForm(Model model) {
                model.addAttribute(new UploadItem());
                return "/uploadfile";
        }

        @RequestMapping(method = RequestMethod.POST)
        public String create(UploadItem uploadItem, BindingResult result,
                        HttpServletRequest request, HttpServletResponse response,
                        HttpSession session) {
                if (result.hasErrors()) {
                        for (ObjectError error : result.getAllErrors()) {
                                System.err.println("Error: " + error.getCode() + " - "
                                                + error.getDefaultMessage());
                        }
                        return "/uploadfile";
                }

                // Some type of file processing...
                System.err.println("-------------------------------------------");
                try {
                        MultipartFile file = uploadItem.getFileData();
                        String fileName = null;
                        InputStream inputStream = null;
                        OutputStream outputStream = null;
                        if (file.getSize() > 0) {
                                inputStream = file.getInputStream();
                                
                                //is file over the user limit!?
                                if (file.getSize() > 999999999) {
                                        System.out.println("File Size:::" + file.getSize());
                                        return "/admin/uploadfile";
                                }
                                
                                
                                System.out.println("size::" + file.getSize());
                                fileName = request.getRealPath("") + "/resources/files/"
                                              + file.getOriginalFilename();
                 ////  fileName = "c:/images/"    + file.getOriginalFilename();
                                
                                outputStream = new FileOutputStream(fileName);
                                System.out.println("fileName:" + file.getOriginalFilename());

                                int readBytes = 0;
                                byte[] buffer = new byte[104857600];
                                while ((readBytes = inputStream.read(buffer, 0, 104857600)) != -1) {
                                        outputStream.write(buffer, 0, readBytes);
                                }
                                outputStream.close();
                                inputStream.close();
                        }

                        // ..........................................
                        session.setAttribute("uploadFile", file.getOriginalFilename());
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return "redirect:/admin/uploadfile";
                  // return "redirect:/home";
        }

}