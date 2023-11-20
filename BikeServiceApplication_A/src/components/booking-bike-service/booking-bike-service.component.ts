import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Booking } from 'src/model/Booking';
import { BikeServiceService } from 'src/service/bike-service.service';

@Component({
  selector: 'app-booking-bike-service',
  templateUrl: './booking-bike-service.component.html',
  styleUrls: ['./booking-bike-service.component.css']
})
export class BookingBikeServiceComponent implements OnInit{

  public serviceproviderBookingForm!: FormGroup;
  constructor(private fg:FormBuilder,private serv:BikeServiceService,private router:Router){}

  ngOnInit(): void {
    this.serviceproviderBookingForm = this.fg.group({
      date: ['', Validators.required],
      slot: ['', Validators.required]
    });
  }

  onSubmit(): void {
    if (this.serviceproviderBookingForm.valid) {
      let user_id:string=this.serv.getUserId();//get id of the user 
      let provider_id:string=this.serv.getProvider_id(); //get provider id 
      console.log(user_id);
      console.log(provider_id);
      console.log(this.serviceproviderBookingForm.value);//boking data of user
      // send the form data to the server via service file 
      this.serv.bookServiceForUser(user_id,provider_id,this.serviceproviderBookingForm.get('date')?.value,
      this.serviceproviderBookingForm.get('slot')?.value).subscribe({
        next: (response:Booking) => {
          // Handle successful response here
          console.log(response);
          window.alert("Booking Successfully done");
          this.router.navigate(['/home']);//redirect to home 
        },
        error: (err) => {
          // Handle error response here
          window.alert("Error while bokking form");
          console.log(err);
        }}
      )
    } else {
      console.log("invalid");
    }
  }

}
