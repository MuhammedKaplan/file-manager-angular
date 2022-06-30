package com.fileExplorer.file.controller;

import com.fileExplorer.file.model.FileModel;
import com.fileExplorer.file.services.FileService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/file")
public class FileApi {

    FileService fileService;

    @PostMapping
    public ResponseEntity<List<FileModel>> fileList(@RequestBody String path){
        return ResponseEntity.ok(fileService.findPathAndCreateFileModel(path));
    }

    @PostMapping(value = "/back")
    public ResponseEntity<List<FileModel>> backFileLists(@RequestBody String currentPath){
        File currentFile = new File(currentPath);
        return ResponseEntity.ok(fileService.findPathAndCreateFileModel(currentFile.getParent()));
    }

}
