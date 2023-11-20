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
      this.serv.getProviderById(provider_id).subscribe(CurrProvider => {
        CurrProvider.review = CurrProvider.review || [];
        CurrProvider.review.push(user_review);
        //update current rating by taking average
        CurrProvider.rating = Math.round((CurrProvider.rating+ user_rating)/2);
    this.serv.updateProviderdetails(provider_id, CurrProvider.name, CurrProvider.location, 
      CurrProvider.rating, CurrProvider.expertise, CurrProvider.serviceCategories, 
      CurrProvider.latitude, CurrProvider.longitude, CurrProvider.review);
  });
  //location.reload(); // reload the current page
    } else {
      console.log("invalid");
    }
  }

}
