import { Component, Input, OnInit, Output } from '@angular/core';
import { EventEmitter } from '@angular/core';
import { Seat } from '../../model/seat.model';
import * as moment from 'moment';
import { ReservationService } from '../../service/reservation.service';
import { BookSeatInput } from '../../model/book-seat-input.model';
import { AlertService } from 'src/app/common/component/common/alert/alert-service.service';

@Component({
  selector: 'app-seat-suggestion',
  templateUrl: './seat-suggestion.component.html',
  styleUrls: ['./seat-suggestion.component.scss']
})
export class SeatSuggestionComponent implements OnInit {
  @Input() seatDetail: Seat;
  @Input() zoneId: number;
  @Input() searchSeatInput: any;
  @Output() closeOverlay: EventEmitter<boolean> = new EventEmitter();
  datesSuggestions = [];
  constructor(private reservationService: ReservationService, private alertService: AlertService) { }

  ngOnInit(): void {
      this.datesSuggestions = [{day: moment(this.searchSeatInput.startDate), isWeekendOrHoliday: this.isWeekend(moment(this.searchSeatInput.startDate))}];
      this.getNextFourDays(this.searchSeatInput.startDate);
  }
  getNextFourDays(startDate){
    for (let i = 1; i < 5; i++) {
      this.datesSuggestions.push({day: moment(startDate).add(i, 'days'), isWeekendOrHoliday: this.isWeekend(moment(startDate).add(i, 'days'))})
    }
  }
  isWeekend(day){
    return day.day() == 6 || day.day() == 0
  }
  bookSeat(selectedDay){
    const seatDetail: BookSeatInput = {
      zoneId : this.zoneId,
      seatNo : this.seatDetail.number.toString(),
      startDate : moment(selectedDay.day).toDate()
    }
    this.reservationService.bookSeat(seatDetail).subscribe((response) => {
      if(response){
       // this.loaderService.hide();
        this.alertService.success('Booked Successfully');
        this.reservationService.updateRefreshSearch(true);
      }
  });
    this.closeOverlay.emit(true);
    
  }
  showFullDay(day){
    return day.format('dddd');
  }
  closeSuggestion(){
  this.closeOverlay.emit(true);
  }

}
