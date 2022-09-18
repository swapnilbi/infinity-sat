import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpaceDistributeComponent } from './space-distribute.component';

describe('SpaceDistributeComponent', () => {
  let component: SpaceDistributeComponent;
  let fixture: ComponentFixture<SpaceDistributeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SpaceDistributeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SpaceDistributeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
