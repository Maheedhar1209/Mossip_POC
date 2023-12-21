import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private baseUrl = 'http://localhost:8101'
  
  constructor(private http: HttpClient) {
    this.http=http;
  }

  submitStudentApplication(formData: any, jsonData: any): Observable<any> {
   
    // Append the custom JSON-LD data to the form data
    formData.append('jsonData',JSON.stringify(jsonData));
    const formDataEncoded = encodeURIComponent(JSON.stringify(formData));
    //const jsonDataEncoded = encodeURIComponent(JSON.stringify(jsonData));

    const url = `${this.baseUrl}/applications?formData=${formDataEncoded}`;

    return this.http.get(url);
  
}
login(username: string,pass: string,age:string,fathername:string) {
   
  // Append the custom JSON-LD data to the form data
  
  //const jsonDataEncoded = encodeURIComponent(JSON.stringify(jsonData));

  const url = `${this.baseUrl}/user/verifyOTP?phone_number=${username}&password=${pass}&age=${age}&fathername=${fathername}`;

  return this.http.get(url);
}

}