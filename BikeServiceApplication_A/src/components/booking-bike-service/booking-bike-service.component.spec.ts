import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookingBikeServiceComponent } from './booking-bike-service.component';

describe('BookingBikeServiceComponent', () => {
  let component: BookingBikeServiceComponent;
  let fixture: ComponentFixture<BookingBikeServiceComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BookingBikeServiceComponent]
    });
    fixture = TestBed.createComponent(BookingBikeServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
