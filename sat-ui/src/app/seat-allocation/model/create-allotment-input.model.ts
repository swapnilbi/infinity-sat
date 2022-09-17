export interface CreateAllotmentInput {
    officeId : number,
	floorId : number,
	zoneId : number,
	noOfSeats : number,
	fromDate? : Date,
	toDate? : Date,
	divisionId : number,
}