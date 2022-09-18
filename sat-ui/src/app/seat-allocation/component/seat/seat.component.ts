import { Component, Input, OnInit, SimpleChanges } from '@angular/core';
import { Seat } from '../../model/seat.model';
import { ReservationService } from '../../service/reservation.service';


@Component({
  selector: 'app-seat',
  templateUrl: './seat.component.html',
  styleUrls: ['./seat.component.scss']
})
export class SeatComponent implements OnInit {
  @Input()seatDetail: Seat;
  @Input()zoneDetail: any;
  @Input()searchSeatInput: any;
  @Input()isSeatSelected: boolean;
  @Input()resetFloorOnPanelClose: boolean;
  isOpen = false;
  isSelected: boolean = false;
  seatSuggestionInput: Seat[] = [];
  constructor(private reservationSerice: ReservationService) { }

  ngOnInit(): void {
  }
  ngOnChanges(changes: SimpleChanges): void {
     if(changes && changes['isSeatSelected'] && changes['isSeatSelected'].currentValue){
       this.selectSeat();
     } else {
        this.deSelectSeat();
     }
   }
   selectSeat(){
     if(!this.seatDetail.hide && !this.seatDetail.booked){
     this.isSelected = !this.isSelected;
     this.isOpen = !this.isOpen;
     }
   }
   updateSelectSeat(){
     if(!this.seatDetail.hide && !this.seatDetail.booked){
       this.reservationSerice.updateSelectedSeat({seat: this.seatDetail, zoneName: this.zoneDetail['zoneName']});
      }
   }
 deSelectSeat(){
   if(this.isSelected){
     this.isSelected = !this.isSelected;
   }
   if(this.isOpen){
     this.isOpen = !this.isOpen;
   }
 }

}

