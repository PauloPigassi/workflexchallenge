import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserListComponent } from './user/views/user-list/user-list.component';
import { WorkationListComponent } from './components/workation-list/workation-list.component';

const routes: Routes = [
  { path: '', component: WorkationListComponent },
  // { path: '**', redirectTo: '' } // opcional para redirecionamento
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
