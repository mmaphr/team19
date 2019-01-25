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
import { AddDataOlderPageComponent } from './add-data-older-page/add-data-older-page.component';
import { AddDataOlderService } from './shared/DataOlder/add-data-older.service';
import { AdditemComponent } from './additem/additem.component';
import {AdditemService} from './shared/Additem/additem.service';
import {OutactivityComponent} from "./outactivity/outactivity.component";
import { OutactivityService } from './service/outactivity.service';
import { ShowsOutActivityComponent } from './shows-out-activity/shows-out-activity.component';

const appRoutes: Routes = [
  { path: '',  redirectTo: '/loginpage', pathMatch: 'full' },
  { path: 'loginpage',component : LoginpageComponent},
  { path: 'additem',component : AdditemComponent},
  { path: 'main',component:MainComponent},
  { path: 'InputDataOlder' , component : AddDataOlderPageComponent},
  {path:'roomInformation',component : RoomImformationComponent},
  {path:'roomEdit',component : RoomEditComponent},
  {path:'roomAll',component : RoomAllComponent},
  {path:'roomAdd',component : RoomAddComponent},
  {path:'roomDelete',component : RoomDeleteComponent},
  {path: 'outactivity', component: OutactivityComponent} ,
  {path: 'showsOutActivity', component: ShowsOutActivityComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    RoomImformationComponent,
    RoomEditComponent,
    RoomAllComponent,
    RoomAddComponent,
    RoomDeleteComponent,
    LoginpageComponent,
    MainComponent,
    AddDataOlderPageComponent,
    AdditemComponent,
    OutactivityComponent,
    ShowsOutActivityComponent
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
  providers: [RoomImformationService,AdditemService,LoginpageService,AddDataOlderService,OutactivityService],
  bootstrap: [AppComponent]
})
export class AppModule { }
