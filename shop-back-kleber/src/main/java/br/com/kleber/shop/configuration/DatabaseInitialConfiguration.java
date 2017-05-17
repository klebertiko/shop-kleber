package br.com.kleber.shop.configuration;

import br.com.kleber.shop.model.Product;
import br.com.kleber.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Component
@Scope("singleton")
public class DatabaseInitialConfiguration {

    private final ProductRepository productRepository;

    @Autowired
    public DatabaseInitialConfiguration(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void initializeValues() {

        this.productRepository.save(new Product("Dell Inspiron 15 Gaming",
                "http://i.dell.com/sites/imagecontent/products/PublishingImages/inspiron-15-7559-laptop/pandora-hero.png",
                "Notebook de 15 polegadas de alta performance para jogos com processadores Intel® Core ™, um sistema de resfriamento inovador e as mais recentes placas de vídeo para um novo nível de diversão, jogos e vídeos.​",
                new BigDecimal(4269.90), 10));

        this.productRepository.save(new Product("Logitech Proteus Spectrum G502",
                "https://static7.kabum.com.br/produtos/fotos/63157/63157_index_gg.jpg",
                "Mouse Gamer com 12000dpi 11 Botões e Ajuste de Peso.",
                new BigDecimal(329.90), 15));

        this.productRepository.save(new Product("Logitech Orion Spark G910",
                "https://static1.kabum.com.br/produtos/fotos/69991/69991_index_gg.jpg",
                "Teclado Gamer Mecânico LED Multicolorido Anti-Ghosting.​",
                new BigDecimal(989.90), 20));
    }

}
