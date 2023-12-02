import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ServiceProvider } from 'src/model/ServiceProvider';
import { BikeServiceService } from 'src/service/bike-service.service';

@Component({
  selector: 'app-reviews-ratings',
  templateUrl: './reviews-ratings.component.html',
  styleUrls: ['./reviews-ratings.component.css']
})
export class ReviewsRatingsComponent implements OnInit{

  public ReviewsForm!: FormGroup;
  public currentRating: number = 0;
  public Currp!:ServiceProvider;//store cur provider

  constructor(private fg:FormBuilder,private serv:BikeServiceService){}

  ngOnInit(): void {
    this.ReviewsForm = this.fg.group({
      rating: ['', Validators.required],
      Review: ['', Validators.required]
    });
  }

  onSubmit(): void {
    if (this.ReviewsForm.valid) {
      let provider_id:string=this.serv.getProvider_id(); //get provider id 
      console.log(provider_id);
      console.log(this.ReviewsForm.value);//review data of user
      // this.currentRating=this.serv.getrating();//get current rating
      //get provider id 
      let user_rating: number = this.ReviewsForm.get('rating')?.value; 
      //user rating from form 
      let user_review: string = this.ReviewsForm.get('Review')?.value;
      //get provider details by id and update it
      this.serv.getProviderById(provider_id).subscribe({
        next: (CurrProvider) => {
          this.Currp = CurrProvider;
          this.Currp.review = CurrProvider.review || [];
          this.Currp.review.push(user_review);//add new review
          console.log(this.Currp.review);
          this.Currp.rating = (CurrProvider.rating+ user_rating)/2;
        },
        error: (err) => {console.log(err)},
        complete: () => {//once completed  then update the values
          this.serv.updateProviderdetails(provider_id,this.Currp.name, this.Currp.location, 
            this.Currp.rating, this.Currp.expertise, this.Currp.serviceCategories, 
            this.Currp.latitude, this.Currp.longitude, this.Currp.review).subscribe({
              next: (data) => {console.log(data)
              
              },
              error: (err) => {console.log(err)},
              complete: () => {},
            });
        },
      })
      // location.reload(); // reload the entire website --
    } 
    else 
    {
      console.log("invalid");
    }
  }

  getProviderDetails(id: string): void {
    this.serv.getProviderById(this.serv.getProvider_id()).subscribe({
      next: (resp) => {
        console.log(resp);
        this.Currp = resp;
          this.Currp.review = resp.review || [];
          // this.Currp.review.push(user_review);//add new review
          console.log(this.Currp.review);
          // this.Currp.rating = (resp.rating+ user_rating)/2;

      },
      complete: () => {},
      error: (err) => {
        console.error(err);
      }
    }) //get provider id )
  }

}
