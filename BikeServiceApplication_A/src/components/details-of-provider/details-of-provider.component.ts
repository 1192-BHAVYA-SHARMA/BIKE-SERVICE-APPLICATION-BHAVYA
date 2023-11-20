import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BikeServiceService } from 'src/service/bike-service.service';
import * as L from 'leaflet';
import { ServiceProvider } from 'src/model/ServiceProvider';
import { ReviewsRatingsComponent } from '../reviews-ratings/reviews-ratings.component';
import { MatDialog } from '@angular/material/dialog';
@Component({
  selector: 'app-details-of-provider',
  templateUrl: './details-of-provider.component.html',
  styleUrls: ['./details-of-provider.component.css']
})
export class DetailsOfProviderComponent {
  CurrProvider!: ServiceProvider;
  constructor(private srv: BikeServiceService, router: Router, private actroute: ActivatedRoute,
    public dialog: MatDialog) {
  }
  ngOnInit() {
    //const id = this.actroute.snapshot.paramMap.get('id');
    const id = String(this.actroute.snapshot.paramMap.get('id'));
    console.log(id);
    

    this.srv.getProviderById(id).subscribe(provider => {
      this.CurrProvider = provider;
      //set ratings 
      //this.srv.setrating(this.CurrProvider.rating);
      // do any additional processing based on the current provider
      const map = L.map('map').setView([this.CurrProvider.latitude, this.CurrProvider.longitude], 13);
      L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors',
        maxZoom: 18
      }).addTo(map);
    });
  }

  // add dialog to open 
  openReviews(providerId: string) {
    this.srv.setProvider_id(providerId);//set provider id in service file for particular session
    let dialog_add = this.dialog.open(ReviewsRatingsComponent, {
      height: '400px',
      width: '600px'
    })
  }


}
