import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AlertService } from 'src/app/common/component/common/alert/alert-service.service';
import { LoaderService } from 'src/app/common/component/common/loader/loader.service';
import { CreateReservationDetails } from '../../model/create-reservation-details.model';
import { SearchSeatInput } from '../../model/search-seat-input.model';
import { AllotmentService } from '../../service/allotment.service';
import { ReservationService } from '../../service/reservation.service';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.scss']
})
export class ReservationComponent implements OnInit {

  allotmentId? : number;
  minDate: Date = new Date();
  createReservationDetails? : CreateReservationDetails;
  searchForm: FormGroup;

  constructor(private route: ActivatedRoute,    
    private router : Router,    
    private location : Location,
    private fb:FormBuilder,
    private reservationService : ReservationService,
    private alertService : AlertService, 
    private loaderService: LoaderService) { 
      
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

  searchSeats(form : any){
    this.loaderService.show(); 
    let searchSeatInput : SearchSeatInput = {
      officeId: form.office.id,
      floorId: form.floor.id,
      startDate: form.startDate,
      viewAll: false
    }    
    this.reservationService.searchSeats(searchSeatInput).subscribe(response => {    
      this.loaderService.hide(); 
      
    });
  }

  back(){        
    this.location.back();
  }

}