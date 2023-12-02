import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ServiceCategory } from 'src/model/ServiceCategory';
import { ServiceProvider } from 'src/model/ServiceProvider';
import { BikeServiceService } from 'src/service/bike-service.service';
import { BookingBikeServiceComponent } from '../booking-bike-service/booking-bike-service.component';
import { categories } from 'src/model/category_icons';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  categories = categories;// array declared and defined in model folder

  selectedCategory: string = "";
  //if admin show user table also
  isAdmin!: boolean;

  ngOnInit() {
    const isAdminString = localStorage.getItem('ADMIN');
    this.isAdmin = isAdminString ? isAdminString === 'true' : false;
  }
  //inject service
  constructor(private srv: BikeServiceService, private router: Router, public dialog: MatDialog) {
  }

  Provider: ServiceProvider[] = [];  //array will have list of service
  showServices(cat: string) {
    this.selectedCategory = cat;
    this.srv.getServiceProviderByCategory(cat).subscribe({ 
      next: (data: ServiceProvider[]) => { this.Provider = data; console.log(this.Provider); },
       error: (error: any) => { console.log(error); //if error 
    }, 
    complete: () => { console.log('Subscription Completed Successfully');  } });



  }
  //filter service to get required service only not the additional service.
  getRequiredService(serviceCategory: ServiceCategory[]): ServiceCategory {
    return serviceCategory.filter(category => category.category == this.selectedCategory)[0];
  }

  showServiceProviderDetails(provider: ServiceProvider): void {
    this.router.navigate(['/service-provider-details', provider.id]);//route to details page
  }

  //open dialogbox for booking 
  openBooking(providerId: string) {
    this.srv.setProvider_id(providerId);//set provider id in service file for particular session
    let dialog_add = this.dialog.open(BookingBikeServiceComponent, {
      height: '500px',
      width: '700px'
    })
  }

  sortDirection: string = "asc";

  // sort providers by price
  sortProviders(direction: string): void {
    if (direction == 'asc') {
      this.Provider.sort((a, b) => {
        return a.serviceCategories[0].price - b.serviceCategories[0].price;
      });
      this.sortDirection = 'asc';
    } else if (direction == 'desc') {
      this.Provider.sort((a, b) => {
        return b.serviceCategories[0].price - a.serviceCategories[0].price;
      });
      this.sortDirection = 'desc';
    }
  }
}