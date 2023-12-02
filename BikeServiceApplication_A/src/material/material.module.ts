import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatDialogModule} from '@angular/material/dialog';
import {MatInputModule} from '@angular/material/input'
import {MatSelectModule} from '@angular/material/select';

@NgModule({
  declarations: [],
  imports: [
    CommonModule, MatDialogModule,MatFormFieldModule, MatInputModule,MatSelectModule
  ],
  exports:[
    MatDialogModule,MatFormFieldModule,MatInputModule,MatSelectModule
  ]
})

export class MaterialModule { }
