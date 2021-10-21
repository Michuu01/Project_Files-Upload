import { HttpErrorResponse, HttpEvent, HttpEventType, HttpResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { UploadFileService } from '../_services/upload-file.service';
import { saveAs } from 'file-saver';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-upload-files',
  templateUrl: './upload-files.component.html',
  styleUrls: ['./upload-files.component.scss']
})
export class UploadFilesComponent {
  selectedFiles?: FileList;
  currentFile?: File;
  progress = 0;
  message = '';

  fileInfos?: Observable<any>;

  constructor(private fileuploadingService: UploadFileService) { }
  ngOnInit() {
  this.fileInfos = this.fileuploadingService.getFiles();
  }
  selectFile(event: any) {
  this.selectedFiles = event.target.files;
  }

  upload(): void {
  this.progress = 0;
  
  if (this.selectedFiles) {
    const file: File | null = this.selectedFiles.item(0);
  
    if (file) {
    this.currentFile = file;
  
    this.fileuploadingService.upload(this.currentFile).subscribe(
      (event: any) => {
      if (event.type === HttpEventType.UploadProgress) {
        this.progress = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        this.message = event.body.message;
        this.fileInfos = this.fileuploadingService.getFiles();
      }
      },
      (err: any) => {
      console.log(err);
      this.progress = 0;
  
      if (err.error && err.error.message) {
        this.message = err.error.message;
      } else {
        this.message = 'Could not upload the file!';
      }
  
      this.currentFile = undefined;
      });
    }
  
    this.selectedFiles = undefined;
  }
  }
}