package com.fileExplorer.file.services;

import com.fileExplorer.file.model.FileModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class FileService {

    public void getFileList(String path) {
        findPathAndCreateFileModel(path);
    }

    public List<FileModel> findPathAndCreateFileModel(String path) {
        File directoryPath = new File(path);

        File filesList[] = directoryPath.listFiles();

        List<FileModel> fileModelList = new ArrayList<FileModel>();

        for(File file : filesList) {
            if(!file.isHidden()) {
                FileModel newFile = new FileModel();

                newFile.setName(file.getName());
                newFile.setPath(file.getAbsolutePath());
                newFile.setIsDirectory(file.isDirectory());
                newFile.setIsFile(file.isFile());
                newFile.setIsHidden(file.isHidden());
                Date date = new Date(file.lastModified());
                newFile.setLastModified(date);

                if (newFile.getIsFile()) {
                    newFile.setSize(file.length());
                }
                newFile.setParentPath(file.getParent());

                fileModelList.add(newFile);
            }
        }
        System.out.println("path = " + path);
        return fileModelList;
    }
}
