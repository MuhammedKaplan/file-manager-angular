import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

import { File } from '../models/file';

@Component({
  selector: 'app-explorer',
  templateUrl: './explorer.component.html',
  styleUrls: ['./explorer.component.css']
})
export class ExplorerComponent implements OnInit {

  public files: Array<File>;
  public curPath: String; 

  constructor(
    public http: HttpClient,
    public router: Router,
  ) { }

  ngOnInit(): void {
    this.getFileList("C://");
    this.curPath = "C://"
  }

  getFileList(path: string) {
    const headers: HttpHeaders = new HttpHeaders({Authorization: localStorage.getItem('token')});
    return this.http.post<Array<File>>('http://localhost:8080/api/file', path, {headers})
    .subscribe(result => {this.files = result;
      this.sortFileListByFileName(this.files);
      this.curPath = path;},
      err=>console.log(err));
  }

  back() {
    const headers: HttpHeaders = new HttpHeaders({Authorization: localStorage.getItem('token')});
    return this.http.post<Array<File>>('http://localhost:8080/api/file/back', this.curPath, {headers})
    .subscribe(result => {this.files = result;
      this.sortFileListByFileName(this.files);
      this.curPath = this.files[1].parentPath},
      err=>console.log(err));
  }

  sortFileListByFileName(list: Array<File>) {
    list.sort((a,b) => a.name.localeCompare(b.name));
  }

  logOut() {
    localStorage.removeItem('token');
    this.router.navigate(['/login']);
  }

}
