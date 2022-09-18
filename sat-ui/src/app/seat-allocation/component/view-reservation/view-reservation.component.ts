import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AlertService } from 'src/app/common/component/common/alert/alert-service.service';
import { LoaderService } from 'src/app/common/component/common/loader/loader.service';
import { BookingDetails } from '../../model/booking-details.model';
import { CreateReservationDetails } from '../../model/create-reservation-details.model';
import { SearchSeatInput } from '../../model/search-seat-input.model';
import { AllotmentService } from '../../service/allotment.service';
import { ReservationService } from '../../service/reservation.service';


@Component({
  selector: 'app-view-reservation',
  templateUrl: './view-reservation.component.html',
  styleUrls: ['./view-reservation.component.scss']
})
export class ViewReservationComponent implements OnInit {

  allotmentId? : number;
  minDate: Date = new Date();
  reservationList: Array<BookingDetails>;
  createReservationDetails? : CreateReservationDetails;
  searchForm: FormGroup;

  constructor(private route: ActivatedRoute,    
    private router : Router,    
    private location : Location,
    private fb:FormBuilder,
    private reservationService : ReservationService,
    private alertService : AlertService, 
    private loaderService: LoaderService) { 
    this.reservationList = []
    this.searchForm = this.fb.group({
        "office": new FormControl(null, Validators.required),
        "floor": new FormControl(null, Validators.required),        
        "startDate" : new FormControl(null)                       
     }); 
  }

  ngOnInit(): void {
    this.loaderService.show(); 
    this.reservationService.initReservation().subscribe(response => {    
      if(response){         
          this.loaderService.hide(); 
          this.createReservationDetails = response;          
          if(this.createReservationDetails && this.createReservationDetails.officeList){
            let defaultOffice = this.createReservationDetails.officeList[0];
            let defaultValues = {
                office : defaultOffice,                                
            }            
            this.searchForm.patchValue(defaultValues);   
          }          
      }
    });
  }

  viewReservations(form : any){
    this.loaderService.show(); 
    let searchSeatInput : SearchSeatInput = {
      officeId: form.office.id,
      floorId: form.floor.id,
      startDate: form.startDate,
      viewAll: true
    }    
    this.reservationService.viewBookedReservation(searchSeatInput).subscribe(response => {    
      this.loaderService.hide(); 
      this.reservationList = response;
    });
  }

  back(){        
    this.location.back();
  }

}
