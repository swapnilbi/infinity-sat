import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { BehaviorSubject } from 'rxjs';
import { LoaderService } from 'src/app/common/component/common/loader/loader.service';
import { SeatBookingService } from '../../service/seatBooking.service';

@Component({
  selector: 'app-seat-search',
  templateUrl: './seat-search.component.html',
  styleUrls: ['./seat-search.component.scss']
})
export class SeatSearchComponent implements OnInit {
  searchSeat: FormGroup;
  isFloorSelctionShown = false;
  zone: FormControl = new FormControl('');
  isZoneSelctionShown = false;
  bookingDate: FormControl = new FormControl('');
  isbookingDateSelctionShown = false;
  floor: FormControl = new FormControl('');
  buildingList = [
    {
      id: 'eon1',
      name: 'EON 1',
      floorList: [
        {id: 'floor1', name: 'floor1', zoneList: [
          {id: 'A', name: 'A'}
        ]}
      ]
    }
  ]
  floorListForm$ = new BehaviorSubject([]);
  zoneListForm$ = new BehaviorSubject([]);
  constructor(private fb: FormBuilder, private seatBookingService: SeatBookingService, private loaderService: LoaderService) { }

  ngOnInit(): void {
    this.searchSeat = this.fb.group({
      building: ['eon1']
    });
    if(this.searchSeat.controls['building'].value){
      this.updateFloor();
    }
    this.updateFormOnBuildingSelection();
    this.updateFormOnFloorSelection();
  }
  searchSeats(){
    this.loaderService.show();
    this.seatBookingService.searchSeats(this.searchSeat.value);
  }
  updateFormOnBuildingSelection(){
    this.searchSeat.controls['building'].valueChanges.subscribe((buildingVal) => {
     this.updateFloor()
    })
  }
  updateFormOnFloorSelection(){
    if(this.searchSeat.controls['floor']){
      this.searchSeat.controls['floor'].valueChanges.subscribe((floorVal) => {
        this.getZoneList();
        this.searchSeat.addControl('zone', this.zone);
        this.isZoneSelctionShown = true;
        this.searchSeat.addControl('bookingDate', this.bookingDate);
        this.isbookingDateSelctionShown = true;
    })
    }
  }
  updateFloor(){
    this.getFloorList();
    this.searchSeat.addControl('floor', this.floor);
    this.isFloorSelctionShown = true;
  }
  getFloorList(){
    let floorList: { id: string; name: string; zoneList: { id: string; name: string; }[]; }[]= [];
    this.buildingList.forEach((building) => {
if(this.searchSeat.controls['building'].value === building.id){
  floorList = [...building.floorList];
}
    })
    this.floorListForm$.next(floorList);
  }
  getZoneList(){
    let zoneList: any[]= [];
    this.floorListForm$.subscribe((floors) => {
  floors.forEach((floor) => {
  if(this.searchSeat.controls['floor'].value === floor.id){
    zoneList = [...floor.zoneList];
  }
      })
      this.zoneListForm$.next(zoneList);
    })
  }
}

