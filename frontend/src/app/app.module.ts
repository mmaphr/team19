import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import {
  MatAutocompleteModule,
  MatButtonModule,
  MatButtonToggleModule,
  MatCardModule,
  MatCheckboxModule,
  MatChipsModule,
  MatDatepickerModule,
  MatDialogModule,
  MatDividerModule,
  MatExpansionModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatMenuModule,
  MatNativeDateModule,
  MatPaginatorModule,
  MatProgressBarModule,
  MatProgressSpinnerModule,
  MatRadioModule,
  MatRippleModule,
  MatSelectModule,
  MatSidenavModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatSnackBarModule,
  MatSortModule,
  MatStepperModule,
  MatTableModule,
  MatTabsModule,
  MatToolbarModule,
  } from '@angular/material';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';



import { RoomImformationComponent } from './room-imformation/room-imformation.component';
import { RoomEditComponent } from './room-edit/room-edit.component';
import { RoomImformationService } from './shared/room-imformation/room-imformation.service';
import { RoomAllComponent } from './room-all/room-all.component';
import { RoomAddComponent } from './room-add/room-add.component';
import { RoomDeleteComponent } from './room-delete/room-delete.component';
import { LoginpageComponent } from './loginpage/loginpage.component';
import {LoginpageService} from './shared/loginmain/loginpage.service';
import { MainComponent } from './main/main.component';

const appRoutes: Routes = [
  { path: '',  redirectTo: '/loginpage', pathMatch: 'full' },
  { path: 'loginpage',component : LoginpageComponent},
  { path: 'main',component:MainComponent},
  {path:'roomInformation',component : RoomImformationComponent},
  {path:'roomEdit',component : RoomEditComponent},
  {path:'roomAll',component : RoomAllComponent},
  {path:'roomAdd',component : RoomAddComponent},
  {path:'roomDelete',component : RoomDeleteComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    RoomImformationComponent,
    RoomEditComponent,
    RoomAllComponent,
    RoomAddComponent,
    RoomDeleteComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatAutocompleteModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatDatepickerModule,
    MatDialogModule,
    MatDividerModule,
    MatExpansionModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatStepperModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [RoomImformationService,LoginpageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
