import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {HttpModule, JsonpModule} from "@angular/http";

import {AppComponent} from "./app.component";
import {routing} from "./app.routing";
import {ShopComponent} from "./shop/shop.component";
import {NavbarComponent} from "./navbar/navbar.component";
import {CartComponent} from "./cart/cart.component";
import {FootbarComponent} from "./footbar/footbar.component";
import {CartService} from "./cart/cart.service";

@NgModule({
  declarations: [
    AppComponent,
    ShopComponent,
    NavbarComponent,
    CartComponent,
    FootbarComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    JsonpModule,
    routing
  ],
  providers: [CartService],
  bootstrap: [AppComponent]
})
export class AppModule { }
