import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {

  products: any;

  constructor(private http: Http) {
  }

  ngOnInit(): void {

    this.products = [
      {
        id: 1,
        name: "Dell Inspiron 15 Gaming",
        image: "http://i.dell.com/sites/imagecontent/products/PublishingImages/inspiron-15-7559-laptop/pandora-hero.png",
        price: 4269.99,
        detail: "Notebook de 15 polegadas de alta performance para jogos com processadores Intel® Core ™, um sistema de resfriamento inovador e as mais recentes placas de vídeo para um novo nível de diversão, jogos e vídeos.​"
      },
      {
        id: 2,
        name: "Logitech Proteus Spectrum G502",
        image: "https://static7.kabum.com.br/produtos/fotos/63157/63157_index_gg.jpg",
        price: 329.99,
        detail: "Mouse Gamer com 12000dpi, 11 botões e Ajuste de peso"
      },
      {
        id: 3,
        name: "Logitech Orion Spark G910",
        image: "https://static1.kabum.com.br/produtos/fotos/69991/69991_index_gg.jpg",
        price: 890.99,
        detail: "Teclado Gamer mecânico com LED multicolorido e Anti-Ghosting"
      }
    ];
    //this.http.get("/api/products").subscribe(products => this.products = products.json())
  }

}
