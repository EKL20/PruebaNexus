import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { PositionCRUDComponent } from "./position/position-crud.component";
import { ProductCRUDComponent } from "./product/product-crud.component";
import { UserCRUDComponent } from "./user/user-crud.component";


const roots: Routes = [{
    path: "",
    children: [
        {
            path: "position", 
            component: PositionCRUDComponent

        },
        {
            path: "product", 
            component: ProductCRUDComponent
        },
        {
            path: "user", 
            component: UserCRUDComponent
        }
    ]
}]



@NgModule({
    imports: [RouterModule.forChild(roots)],
    exports: [RouterModule]
})
export class catalogoRoutingModule { }