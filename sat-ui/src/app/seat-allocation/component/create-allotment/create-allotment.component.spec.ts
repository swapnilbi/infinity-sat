import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateAllotmentComponent } from './create-allotment.component';

describe('CreateAllotmentComponent', () => {
  let component: CreateAllotmentComponent;
  let fixture: ComponentFixture<CreateAllotmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateAllotmentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateAllotmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
