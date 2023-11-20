import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReviewsRatingsComponent } from './reviews-ratings.component';

describe('ReviewsRatingsComponent', () => {
  let component: ReviewsRatingsComponent;
  let fixture: ComponentFixture<ReviewsRatingsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ReviewsRatingsComponent]
    });
    fixture = TestBed.createComponent(ReviewsRatingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
