import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { BikeServiceService } from 'src/service/bike-service.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  paymentOptions = [
    'CASH_ON_DELIVERY',
    'CREDIT_CARD',
    'DEBIT_CARD',
    'UPI_PAYMENT',
    'NET_BANKING'
  ];
  roleOptions=['ADMIN','USER'];
  registrationForm!: FormGroup;  
  constructor(private formBuilder: FormBuilder,private serv:BikeServiceService
    ,private router:Router) { }

  ngOnInit() {
    this.registrationForm = this.formBuilder.group({
      userName: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', [Validators.required, Validators.pattern("^[0-9]{10}$")]],
      password: ['', [Validators.required, Validators.minLength(8)]],
      address: ['', [Validators.required]],
      paymentMode:['', Validators.required],
      role:['',Validators.required]
    });
  }
  
  onSubmit() {
    if (this.registrationForm.invalid) {
      return alert("Kindly give valid details to register.");
    }
    const formData = this.registrationForm.value;
    this.serv.registerUser(formData).subscribe({
      next: (response) => {
        // Handle successful response here----send to login part
        console.log(response.role);
        
        window.alert("User Registered Succesfully.")
        console.log(response);
        this.router.navigate(['login']);
      },
      error: (err) => {
        // Handle error response here
        console.log(err);
      }
    });

  }

  

}
