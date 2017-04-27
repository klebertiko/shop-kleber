import {RouterModule, Routes} from "@angular/router";
import {ShopComponent} from "./shop/shop.component";

const appRoutes: Routes = [
  {path: '', component: ShopComponent},

  // redirecionar para pagina inicial
  {path: '**', redirectTo: ''}
];

export const routing = RouterModule.forRoot(appRoutes);
