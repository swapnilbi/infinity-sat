import { Division } from "./division.model";
import { Office } from "./office.model";

export interface CreateAllotmentDetails {
    officeList : Array<Office>,
	divisionList : Array<Division>	
}