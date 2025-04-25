import { Routes } from '@angular/router';
import { UserListComponent } from './user/views/user-list/user-list.component';
import { WorkationListComponent } from './components/workation-list/workation-list.component';

export const routes: Routes = [
  { path: '', component: WorkationListComponent },
];
