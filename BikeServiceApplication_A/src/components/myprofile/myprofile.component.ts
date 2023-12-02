import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { BikeServiceService } from 'src/service/bike-service.service';

@Component({
  selector: 'app-myprofile',
  templateUrl: './myprofile.component.html',
  styleUrls: ['./myprofile.component.css']
})
export class MyprofileComponent {
  paymentOptions = [
    'CASH_ON_DELIVERY',
    'CREDIT_CARD',
    'DEBIT_CARD',
    'UPI_PAYMENT',
    'NET_BANKING'
  ];
  profileForm!: FormGroup ;
  
  currentUserId !:string;

  constructor(private fb: FormBuilder, private userService: BikeServiceService) {
    this.currentUserId =this.userService.getUserId();
    console.log(this.currentUserId);
  }

  ngOnInit(): void {
    this.profileForm = this.fb.group({
      userName: ['', Validators.required],
      phone: ['', Validators.required],
      address: ['', Validators.required],
      password: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      paymentMode: ['', Validators.required]
    });

  }

  onSubmit(): void {
    console.log(this.profileForm.value);
    const userId = this.currentUserId;
    const updatedUserDetails = this.profileForm.value;
    this.userService.updateUser(userId, updatedUserDetails).subscribe({ 
      next: (res) => { console.log('User details updated: ', res); 
      window.alert("Your details updated Successful!!!") }, 
      error: (err) => { console.log('Error occurred: ', err); } });
  }
}
