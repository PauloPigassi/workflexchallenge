import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserListComponent } from './user/views/user-list/user-list.component';

const routes: Routes = [
  { path: '', component: UserListComponent },
  // { path: '**', redirectTo: '' } // opcional para redirecionamento
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
