import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsOfProviderComponent } from './details-of-provider.component';

describe('DetailsOfProviderComponent', () => {
  let component: DetailsOfProviderComponent;
  let fixture: ComponentFixture<DetailsOfProviderComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DetailsOfProviderComponent]
    });
    fixture = TestBed.createComponent(DetailsOfProviderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
