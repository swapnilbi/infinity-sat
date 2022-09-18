import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SplitAllotmentComponent } from './split-allotment.component';

describe('SplitAllotmentComponent', () => {
  let component: SplitAllotmentComponent;
  let fixture: ComponentFixture<SplitAllotmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SplitAllotmentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SplitAllotmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
