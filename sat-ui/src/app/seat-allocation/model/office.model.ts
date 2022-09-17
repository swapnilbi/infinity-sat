import { Department } from "./department.model";
import { Floor } from "./floor.model";

export interface Office {
    id : number,
    name : string,
    address : string,
    city : string,
    country : string,
    departmentList : Array<Department>,
    floorList : Array<Floor>
}