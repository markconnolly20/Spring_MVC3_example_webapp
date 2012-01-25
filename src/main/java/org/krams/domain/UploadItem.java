/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krams.domain;

/**
 *
 * @author mark.connolly
 */
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class UploadItem {
        private String filename;
        private CommonsMultipartFile fileData;

        public String getFilename() {
                return filename;
        }

        public void setFilename(String filename) {
                this.filename = filename;
        }

        public CommonsMultipartFile getFileData() {
                return fileData;
        }

        public void setFileData(CommonsMultipartFile fileData) {
                this.fileData = fileData;
        }
}