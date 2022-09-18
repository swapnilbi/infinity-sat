import { Component, OnInit } from '@angular/core';
const ELEMENT_DATA: any[] = [
  {seatNumber: 1, assignedTo: 'xyz', startDate: '19.09.2022', dueDate: '19.09.2022', comment: '', oeCode: 'SUB'},
  {seatNumber: 2, assignedTo: 'xyz', startDate: '19.09.2022', dueDate: '19.09.2022', comment: '', oeCode: 'SUB'},
  {seatNumber: 3, assignedTo: 'xyz', startDate: '19.09.2022', dueDate: '19.09.2022', comment: '', oeCode: 'SUB'},
  {seatNumber: 4, assignedTo: 'xyz', startDate: '19.09.2022', dueDate: '19.09.2022', comment: '', oeCode: 'SUB'},
  {seatNumber: 5, assignedTo: 'xyz', startDate: '19.09.2022', dueDate: '19.09.2022', comment: '', oeCode: 'SUB'},
  {seatNumber: 6, assignedTo: 'xyz', startDate: '19.09.2022', dueDate: '19.09.2022', comment: '', oeCode: 'SUB'},
  {seatNumber: 7, assignedTo: 'xyz', startDate: '19.09.2022', dueDate: '19.09.2022', comment: '', oeCode: 'SUB'},
  {seatNumber: 8, assignedTo: 'xyz', startDate: '19.09.2022', dueDate: '19.09.2022', comment: '', oeCode: 'SUB'},
  {seatNumber: 9, assignedTo: 'xyz', startDate: '19.09.2022', dueDate: '19.09.2022', comment: '', oeCode: 'SUB'},
  {seatNumber: 10, assignedTo: 'xyz', startDate: '19.09.2022', dueDate: '19.09.2022', comment: '', oeCode: 'SUB'},
];
@Component({
  selector: 'app-registration-history',
  templateUrl: './registration-history.component.html',
  styleUrls: ['./registration-history.component.scss']
})
export class RegistrationHistoryComponent implements OnInit {
  displayedColumns: string[] = ['seatNo', 'assignedTo', 'startDate', 'dueDate', 'comment', 'OECode', 'action'];
  dataSource = ELEMENT_DATA;
  constructor() { }

  ngOnInit(): void {
  }
  cancelBooking(){}
}
