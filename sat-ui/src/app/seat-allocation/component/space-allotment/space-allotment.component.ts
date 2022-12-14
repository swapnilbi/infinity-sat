import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { AlertService } from '../../../common/component/common/alert/alert-service.service';
import { LoaderService } from '../../../common/component/common/loader/loader.service';
import { AllotmentDetails } from '../../model/allotment-details.model';
import { SpaceCapacity } from '../../model/space-capacity.model';
import { Zone } from '../../model/zone.model';
import { AllotmentService } from '../../service/allotment.service';

@Component({
  selector: 'app-space-allotment',
  templateUrl: './space-allotment.component.html',
  styleUrls: ['./space-allotment.component.scss']
})
export class SpaceAllotmentComponent implements OnInit {


  allotmentList : Array<AllotmentDetails>;
  spaceCapacityList : Array<SpaceCapacity>;


  constructor(
    private location : Location,
    private router : Router,
    private allotmentService : AllotmentService,
    private alertService : AlertService, 
    private loaderService: LoaderService){
      this.allotmentList = [];
      this.spaceCapacityList = [];
  }

  ngOnInit(): void {
    this.getAllotmentList();
    this.getSpaceCapacityList();
  }

  back(){        
    this.location.back();
  }

  createAllotment(){    
    this.router.navigate(['sat/space/allotment/create']);                      
  }

  getAllotmentList(){
    this.loaderService.show();
    this.allotmentService.getAllotments().subscribe(response => {
      this.allotmentList = response;
      this.loaderService.hide();
    })
  }

  deleteAllotment(allotment : AllotmentDetails){
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
        this.allotmentService.deleteAllotment(allotment.id).subscribe(response => {              
            this.loaderService.hide();       
            this.alertService.success('Allotment deleted successfully');
            this.getAllotmentList();          
          }, error => {
            this.loaderService.hide();       
          });   
      }
    })  
  }

  getSpaceCapacityList(){
    this.loaderService.show();
    this.allotmentService.getSpaceCapacityList().subscribe(response => {
      this.spaceCapacityList = response;
      this.loaderService.hide();
    })
  }


}
