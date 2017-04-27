package br.com.kleber.shop.service;

import br.com.kleber.shop.model.PromoCode;
import br.com.kleber.shop.repository.PromoCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by renan on 08/04/17.
 */

@Service
public class PromoCodeService {

    private final PromoCodeRepository promoCodeRepository;

    @Autowired
    public PromoCodeService(PromoCodeRepository promoCodeRepository) {
        this.promoCodeRepository = promoCodeRepository;
    }

    public PromoCode find(String code) {
        return this.promoCodeRepository.findById(code);
    }
}
