import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ResumeUploadComponent } from './components/resume-upload/resume-upload.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [{path:'',component:LoginComponent},{path:'resume',component:ResumeUploadComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }