
export interface AllotmentDetails {
    id : number,
	officeName : string,
	floorName : string,
	zoneName : string,
	noOfSeats : number,
	maxNoSeats? : number,
	fromDate? : Date
	endDate? : Date
	divisionName : string
}