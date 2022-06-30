package com.fileExplorer.file.model;

import java.util.Date;

public class FileModel {

    private String name;
    private String path;
    private boolean isDirectory;
    private boolean isFile;
    private boolean isHidden;
    private Date lastModified;
    private long size;
    private String parentPath;

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public boolean getIsDirectory() {
        return isDirectory;
    }

    public boolean getIsFile() {
        return isFile;
    }

    public boolean getIsHidden() {
        return isHidden;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public long getSize() {
        return size;
    }

    public String getParentPath() { return parentPath; }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setIsDirectory(boolean directory) {
        isDirectory = directory;
    }

    public void setIsFile(boolean file) {
        isFile = file;
    }

    public void setIsHidden(boolean hidden) {
        isHidden = hidden;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }
}
