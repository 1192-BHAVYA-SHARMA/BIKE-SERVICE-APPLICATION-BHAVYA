//import { Availability } from "./Availability";
// import { Inventory } from "./Inventory";
import { ServiceCategory } from "./ServiceCategory";

export interface ServiceProvider extends ServiceCategory
// ,Inventory 
{
    id:  string;
    name:   string;
    location:  string;
    //availability:      Availability;
    rating:number;
    expertise: string;
    serviceCategories: ServiceCategory[];
    latitude: number;
    longitude: number;
    review:string[];
    // inventory:         Inventory;
}
