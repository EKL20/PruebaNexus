import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PositionCRUDComponent } from './position/position-crud.component';
import { ProductCRUDComponent } from './product/product-crud.component';
import { UserCRUDComponent } from './user/user-crud.component';
import { catalogoRoutingModule } from './catalogo-routing.module';




@NgModule({
  declarations: [
    PositionCRUDComponent,
    ProductCRUDComponent,
    UserCRUDComponent
  ],
  imports: [
    CommonModule,
    catalogoRoutingModule
  ]
})

export class catalogoModule { }