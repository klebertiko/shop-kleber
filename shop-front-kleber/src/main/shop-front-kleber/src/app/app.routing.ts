import {RouterModule, Routes} from "@angular/router";
import {ShopComponent} from "./shop/shop.component";
import {CartComponent} from "./cart/cart.component";

const appRoutes: Routes = [
  {path: '', component: ShopComponent},
  {path: 'cart', component: CartComponent}
];

export const routing = RouterModule.forRoot(appRoutes);
