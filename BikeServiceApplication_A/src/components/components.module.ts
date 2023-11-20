import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { DetailsOfProviderComponent } from './details-of-provider/details-of-provider.component';
import { BookingBikeServiceComponent } from './booking-bike-service/booking-bike-service.component';
import { MaterialModule } from 'src/material/material.module';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { HistoryComponent } from './history/history.component';
import { ReviewsRatingsComponent } from './reviews-ratings/reviews-ratings.component';

@NgModule({
  declarations: [
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    NavbarComponent,
    LandingPageComponent,
    DetailsOfProviderComponent,
    BookingBikeServiceComponent,
    HistoryComponent,
    ReviewsRatingsComponent
  ],
  imports: [
    CommonModule,ReactiveFormsModule,HttpClientModule,MaterialModule, AppRoutingModule
  ],
  exports:[LoginComponent,RegisterComponent,HomeComponent,NavbarComponent,LandingPageComponent,DetailsOfProviderComponent]
})
export class ComponentsModule { }
