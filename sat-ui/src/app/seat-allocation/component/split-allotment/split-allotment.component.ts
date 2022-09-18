import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { BsModalRef } from 'ngx-bootstrap/modal';
import { AlertService } from 'src/app/common/component/common/alert/alert-service.service';
import { LoaderService } from 'src/app/common/component/common/loader/loader.service';
import { AllotmentDetails } from '../../model/allotment-details.model';
import { CreateAllotmentInput } from '../../model/create-allotment-input.model';
import { Division } from '../../model/division.model';
import { SplitAllotmentInput } from '../../model/split-allotment-input.model';
import { AdminService } from '../../service/admin.service';
import { AllotmentService } from '../../service/allotment.service';

@Component({
  selector: 'app-split-allotment',
  templateUrl: './split-allotment.component.html',
  styleUrls: ['./split-allotment.component.scss']
})
export class SplitAllotmentComponent implements OnInit {

  allotmentDetails! : AllotmentDetails;
  splitAllotmentForm : FormGroup;
  divisionList! : Array<Division>;

  constructor(private _bsModalRef: BsModalRef,
    private loaderService : LoaderService,
    private alertService : AlertService,
    private adminService : AdminService,
    private allotmentService : AllotmentService,
    private fb:FormBuilder) {
      this.divisionList = []
      this.splitAllotmentForm = this.fb.group({
        "id" : new FormControl(""),   
        "floorName": new FormControl(""),     
        "zoneName" : new FormControl(""),
        "allotedSeats" : new FormControl(""),
        "seats" : new FormControl("",Validators.required),
        "noOfSeats" : new FormControl(null),
        "division" : new FormControl(null,Validators.required)
      });         
  }

  ngOnInit(): void {
    this.loaderService.show();         
    this.splitAllotmentForm.patchValue(this.allotmentDetails);
    this.adminService.getUserChildDivisions().subscribe(response => {    
      this.loaderService.hide(); 
      if(response){                   
          this.divisionList = response;               
       }
    });    
  }

  splitAllotment(form : any): void {   
    let availableSeats = this.allotmentDetails.noOfSeats;
    if(this.allotmentDetails.allotedSeats){
      availableSeats = availableSeats - this.allotmentDetails.allotedSeats;
    }
    if(form.seats > availableSeats) {
      this.alertService.error("Entered seats are greater than available seats")
      return;
    }
    this.loaderService.show();         
    let allotmentInput : SplitAllotmentInput = {      
      noOfSeats: form.seats,      
      divisionId : form.division.id,
      parentId : this.allotmentDetails.id
    }
    this.allotmentService.splitAllotment(allotmentInput).subscribe(response => {    
      if(response){         
          this.loaderService.hide();       
          this.alertService.success("Allotment has been splitted successfully");          
        }                
      }, error => {
        this.loaderService.hide();       
    }); 
  }

  public onCancel(): void {     
    this._bsModalRef.hide();    
  }

}
