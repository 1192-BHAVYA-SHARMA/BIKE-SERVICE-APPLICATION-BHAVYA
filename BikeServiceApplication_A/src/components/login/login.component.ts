import { Component } from "@angular/core";
import { FormBuilder, FormControl, FormGroup, Validators } from "@angular/forms";
import {  Router } from "@angular/router";
import { BikeServiceService } from "src/service/bike-service.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  //form builder
  loginForm: FormGroup = new FormGroup({}); // Initialize to an empty FormGroup
 
  constructor(private formBuilder: FormBuilder, private serv: BikeServiceService, private router: Router) {
    this.loginForm = this.formBuilder.group({
      email: new FormControl('', [Validators.required, Validators.email]),
      contactNumber: new FormControl('', Validators.pattern('[0-9]{10}')),
      password: new FormControl('', Validators.required)
    });
  }
  
  onSubmit() {
    if (this.loginForm && this.loginForm.invalid) {
      // Add null check before accessing properties or methods of loginForm
      return alert("Kindly enter valid Data.");
    }
  
    const email = this.loginForm.get('email')?.value;
    const password = this.loginForm.get('password')?.value;
    let id="";
    this.serv.loginUser(email, password).subscribe({
      // Handle success and error responses 
      next: (response) => {
        // Handle successful response here
        console.log(response);
        
        window.alert("User login Successfully.")
        this.serv.setUserId(response.userId); // Save the received ID in service
        this.router.navigate(['/home']);//redirect to home  
      },
      error: (err) => {
        // Handle error response here
        window.alert(err);
        console.log(err);
      }
    });
  }
  
}


// onSubmit() {
  //   // console.log(this.loginForm.value);
  //   const formData = this.loginForm.value; // Get form data
  //   console.log(formData);
    
  //   if (this.loginForm.invalid) {
  //     return alert("Kindly enter valid Data.");
  //   }
  //   this.serv.loginUser(formData).subscribe({
  //     next: (response) => {
  //       // Handle successful response here
  //       console.log(response);
  //       window.alert("User login Succesfully.")
  //       this.router.navigate(['/home']); //redirect to home 
  //     },
  //     error: (err) => {
  //       // Handle error response here
  //       window.alert(err);
  //       console.log(err);
  //     }
  //   });
  // }