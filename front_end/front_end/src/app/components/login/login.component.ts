import { Component } from '@angular/core';
import { Route, Router } from '@angular/router';
import { StudentService } from 'services/student.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  model:any={}
  getData:any
  constructor(private loginservice:StudentService,private router : Router) { }

  ngOnInit(): void {
    // TODO document why this method 'ngOnInit' is empty
  

  }
  loginadmin(){
     //console.log("sff");
      let user=this.model.username;
      let password=this.model.password;
      let age=this.model.age;
      let fathername=this.model.fathername;
      if (user== null || password == null || age==null || fathername==null)
         alert("Please fill all the fields");
      else{
        console.log("dgsdf")
      this.loginservice.login(user,password,age,fathername).subscribe((res) => {
          this.getData=res;
          
          console.log(this.getData)
      })

   }
}
}