import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { StudentService } from 'services/student.service';

@Component({
  selector: 'app-resume-upload',
  templateUrl: './resume-upload.component.html',
  styleUrls: ['./resume-upload.component.css']
})
export class ResumeUploadComponent {
  form: FormGroup;
  formData = {
    name: '',
    email: '',
    rollNumber: '',
    resume: null as File | null,
    jsonData: null as any |null
  };
  resumeFile: File | null = null;
  resumeFileInvalid = false;
  constructor(private formBuilder: FormBuilder, private studentService: StudentService) {
    this.form = this.formBuilder.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      rollNumber: ['', Validators.required],
      resume: [null, Validators.required]
    });
  }

  ngOnInit(): void {}
  onFileSelected(event: any) {
    const file = event.target.files[0];
    if (file && file.type === 'application/pdf') {
      this.resumeFile = file;
      this.resumeFileInvalid = false;
    } else {
      this.resumeFile = null;
      this.resumeFileInvalid = true;
    }
  }

  Submit() {
    console.log("dfd");
      
      const customJsonLdData = {
        '@context': {
          '@vocab': 'http://example.com/vocab#', // Replace with your custom vocabulary URL
          'name': 'http://schema.org/name',
          'email': 'http://schema.org/email',
          'rollNumber': 'http://example.com/vocab#rollNumber',
          'resume': 'http://example.com/vocab#resume'
        },
        '@type': 'StudentApplication',
        'name': this.formData.name,
        'email': this.formData.email,
        'rollNumber': this.formData.rollNumber,
        'resume': this.resumeFile // Replace with the actual URL or path
      };
      if (this.resumeFile) {
        this.formData.resume = this.resumeFile;
      }
      const formData = new FormData();
      formData.append('name', this.formData.name);
      formData.append('email', this.formData.email);
      formData.append('rollNumber', this.formData.rollNumber);
      formData.append('resume', this.resumeFile!);

      this.studentService.submitStudentApplication(formData, customJsonLdData).subscribe(
        response => {
          console.log(response);
        //  console.log(response.subject.toString);
        },
        error => {
          console.error('Error submitting form:', error);
        }
      );
    
  }

  onFileChange(event: any) {
    if (event.target.files && event.target.files.length > 0) {
      const file = event.target.files[0];
      this.form.get('resume')!.setValue(file);
    }
  }
 

  isFormInvalid(): boolean {
    return (
      !this.formData.name ||
      !this.formData.email ||
      !this.formData.rollNumber ||
      this.resumeFileInvalid
    );
  }
}
