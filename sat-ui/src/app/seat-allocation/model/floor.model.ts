import { Zone } from "./zone.model";

export interface Floor {
    id : number,
    name : string,
    officeId : number ,
    zoneList : Array<Zone> 
}