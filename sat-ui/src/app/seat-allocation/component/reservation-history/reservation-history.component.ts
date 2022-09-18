import { Component, OnInit } from '@angular/core';
import { AlertService } from 'src/app/common/component/common/alert/alert-service.service';
import { LoaderService } from 'src/app/common/component/common/loader/loader.service';
import Swal from 'sweetalert2';
import { BookingDetails } from '../../model/booking-details.model';
import { ReservationService } from '../../service/reservation.service';

@Component({
  selector: 'app-reservation-history',
  templateUrl: './reservation-history.component.html',
  styleUrls: ['./reservation-history.component.scss']
})
export class ReservationHistoryComponent implements OnInit {

  reservationList? : Array<BookingDetails>;

  constructor(private alertService : AlertService, 
    private reservationService : ReservationService,
    private loaderService: LoaderService) {
      this.reservationList = []
  }

  ngOnInit(): void {
    this.loaderService.show();
    this.reservationService.getBookingHistory().subscribe(response => {      
      this.loaderService.hide();
      if(response){
        this.reservationList = response;
      }      
    })
  }

  cancelReservation(reservation : BookingDetails){
    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes'
    }).then((result) => {
      if (result.isConfirmed) {        
        this.loaderService.show();    
        this.reservationService.cancelBooking(reservation).subscribe(response => {   
          this.alertService.success('Reservation cancelled successfully');   
          this.ngOnInit()
          this.loaderService.hide();      
        })
      }      
    })    
  }

}
