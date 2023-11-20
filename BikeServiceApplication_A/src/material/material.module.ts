import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatDialogModule} from '@angular/material/dialog';
import {MatInputModule} from '@angular/material/input'


@NgModule({
  declarations: [],
  imports: [
    CommonModule, MatDialogModule,MatFormFieldModule, MatInputModule
  ],
  exports:[
    MatDialogModule,MatFormFieldModule,MatInputModule
  ]
})

export class MaterialModule { }
