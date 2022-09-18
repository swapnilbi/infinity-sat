import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeatSuggestionComponent } from './seat-suggestion.component';

describe('SeatSuggestionComponent', () => {
  let component: SeatSuggestionComponent;
  let fixture: ComponentFixture<SeatSuggestionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SeatSuggestionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SeatSuggestionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
