import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeatSearchComponent } from './seat-search.component';

describe('SeatSearchComponent', () => {
  let component: SeatSearchComponent;
  let fixture: ComponentFixture<SeatSearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SeatSearchComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SeatSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
