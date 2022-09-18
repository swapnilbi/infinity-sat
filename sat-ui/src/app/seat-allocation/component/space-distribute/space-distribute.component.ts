import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ColDef, GridReadyEvent,IsGroupOpenByDefaultParams } from 'ag-grid-community';
import { BsModalService } from 'ngx-bootstrap/modal';
import { AlertService } from 'src/app/common/component/common/alert/alert-service.service';
import { LoaderService } from 'src/app/common/component/common/loader/loader.service';
import { AllotmentDetails } from '../../model/allotment-details.model';
import 'ag-grid-enterprise';
import { AllotmentService } from '../../service/allotment.service';
import { SplitAllotmentComponent } from '../split-allotment/split-allotment.component';

@Component({
  selector: 'app-space-distribute',
  templateUrl: './space-distribute.component.html',
  styleUrls: ['./space-distribute.component.scss']
})
export class SpaceDistributeComponent implements OnInit {

  allotmentList : Array<AllotmentDetails>;
  public defaultColDef: ColDef = {
    flex: 1,
    minWidth: 100,
    autoHeight : true,    
    sortable: true,
    resizable: true,
  };
  public autoGroupColumnDef: ColDef = {
    minWidth: 200,
  };
  public rowGroupPanelShow = 'always';
  public rowData!: AllotmentDetails[];
  
  ngOnInit(): void {
    this.allotmentService.getManagerAllotments()
    .subscribe((data) => (this.allotmentList = data));
  }

  splitAllotment(allotment : AllotmentDetails){
    const initialState = {
      allotmentDetails : allotment
    };
     this.modalService.show(SplitAllotmentComponent, {initialState, class: 'modal-xl modal-dialog-scrollable'});              
  }

  public columnDefs: ColDef[] = [
    { field: 'officeName', rowGroup: true, enableRowGroup: true, hide: true },
    { field: 'floorName', rowGroup: true, enableRowGroup: true, hide: true },
    { field: 'zoneName', rowGroup: true, enableRowGroup: true },
    { field: 'divisionName', enableRowGroup: true },
    { field: 'oeCode', enableRowGroup: true, headerName: 'OE Code' },
    { field: 'noOfSeats', headerName: 'Seats Alloted' }    
  ];

  public isGroupOpenByDefault: (
    params: IsGroupOpenByDefaultParams
  ) => boolean = (params: IsGroupOpenByDefaultParams) => {
    return true;
  };


  constructor(private http: HttpClient,     
    private allotmentService : AllotmentService,
    private modalService: BsModalService,
    private alertService : AlertService, 
    private loaderService: LoaderService) {
      this.allotmentList = []
    }

  onGridReady(params: any) {
    this.allotmentService.getSplittedAllotmentList()
    .subscribe((data) => (this.rowData = data));
  }

}
