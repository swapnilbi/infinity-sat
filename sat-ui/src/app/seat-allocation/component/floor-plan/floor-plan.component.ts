import { Component, Input, OnInit } from '@angular/core';
import { ReservationService } from '../../service/reservation.service';

@Component({
  selector: 'app-floor-plan',
  templateUrl: './floor-plan.component.html',
  styleUrls: ['./floor-plan.component.scss']
})
export class FloorPlanComponent implements OnInit {
  @Input() floorData;
  recentselectedSeat;
  constructor(private reserVationService: ReservationService) { }

  ngOnInit(): void {
    this.reserVationService.getSelectedSeat().subscribe((seat) => {
      this.recentselectedSeat = seat;
  }
    )
  }
  isCurrrentSeatSelected(seat, zoneName){
    return (zoneName === this.recentselectedSeat.zoneName) && (seat.number === this.recentselectedSeat.seat.number);
  }
  getZoneDetail(zone){
    return {zoneName: zone['zoneName'], zoneId: zone['zoneId']}
  }
}

