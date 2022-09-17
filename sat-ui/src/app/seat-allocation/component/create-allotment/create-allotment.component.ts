import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AllotmentService } from '../../service/allotment.service';
import { AlertService } from '../../../common/component/common/alert/alert-service.service';
import { LoaderService } from '../../../common/component/common/loader/loader.service';
import { CreateAllotmentDetails } from '../../model/create-allotment-details.model';
import { Zone } from '../../model/zone.model';
import { AllotmentDetails } from '../../model/allotment-details.model';

@Component({
  selector: 'app-create-allotment',
  templateUrl: './create-allotment.component.html',
  styleUrls: ['./create-allotment.component.scss']
})
export class CreateAllotmentComponent implements OnInit {

  allotmentId? : number;
  createAllotmentDetails? : CreateAllotmentDetails;
  allotmentForm: FormGroup;

  constructor(private route: ActivatedRoute,    
    private router : Router,    
    private location : Location,
    private fb:FormBuilder,
    private allotmentService : AllotmentService,
    private alertService : AlertService, 
    private loaderService: LoaderService) { 
      
    this.allotmentForm = this.fb.group({
        "office": new FormControl(null, Validators.required),
        "floor": new FormControl(null, Validators.required),
        "zone": new FormControl(null,Validators.required),
        "division" : new FormControl(null,Validators.required),                
        "noOfSeats" : new FormControl(null,Validators.required),                
        "fromDate" : new FormControl(null),                
        "toDate" : new FormControl(null),                
     }); 

  }

  createAllotment(form: any) : void {
    if(form.noOfSeats > form.zone.seatsAvailable){
      this.alertService.error("Entered seats are greater than available seats");
      return;
    }
    let allotmentForm = this.getAllotmentForm(form);        
    this.loaderService.show();       
    this.allotmentService.createAllotment(allotmentForm).subscribe(response => {    
      if(response){         
          this.loaderService.hide();       
          this.alertService.success("Allotment has been created successfully");
          this.showAllotments();
        }                
      }, error => {
        this.loaderService.hide();       
    }); 
  }

  showAllotments() : void{
    var url = 'sat/space/allotment';
    this.router.navigateByUrl(url);   
  }

  updateAllotment(form: any) : void {

  }

  onZoneChange(zone : Zone){
    this.loaderService.show();
    this.allotmentService.getAllotmentsByZone(zone.id).subscribe(response => {      
      if(response){
        let seatsAvailable = zone.totalNoSeats;
        response.forEach(function (allotment: AllotmentDetails) {    
          if(allotment.maxNoSeats){
            seatsAvailable = seatsAvailable - allotment.maxNoSeats;
          }             
        });        
        zone.seatsAvailable = seatsAvailable; 
      }
      this.loaderService.hide();
    })
  }


  getAllotmentForm(allotmentForm : any){
    let createAllotmentForm = {
      officeId : allotmentForm.office.id,
      floorId : allotmentForm.office.id,
      zoneId : allotmentForm.zone.id,
      divisionId : allotmentForm.division.id,
      noOfSeats : allotmentForm.noOfSeats
    }
    return createAllotmentForm;
  }

  ngOnInit(): void {
    this.loaderService.show(); 
    this.allotmentService.initAllotment().subscribe(response => {    
      if(response){         
          this.loaderService.hide(); 
          this.createAllotmentDetails = response;
          console.log(this.createAllotmentDetails)
          if(this.createAllotmentDetails){
            let defaultOffice = this.createAllotmentDetails.officeList[0];
            let defaultValues = {
                office : defaultOffice,
                floor : defaultOffice.floorList[0],                
                division : this.createAllotmentDetails.divisionList[0]
            }            
            this.allotmentForm.patchValue(defaultValues);   
          }          
      }
    });
  }

  back(){        
    this.location.back();
  }

}
