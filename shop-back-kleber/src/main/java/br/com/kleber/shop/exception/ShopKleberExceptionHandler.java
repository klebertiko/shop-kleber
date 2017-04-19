package br.com.kleber.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ShopKleberExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ShopKleberException.class)
    @ResponseBody
    public ShopKleberExceptionResponseMessage handleBadRequest(ShopKleberException shopKleberException) {
        ShopKleberExceptionResponseMessage shopKleberExceptionResponseMessage = new ShopKleberExceptionResponseMessage(HttpStatus.BAD_REQUEST.getReasonPhrase(), shopKleberException.getMessage());
        return shopKleberExceptionResponseMessage;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedShopKleberException.class)
    @ResponseBody
    public ShopKleberExceptionResponseMessage handleUnauthorized(UnauthorizedShopKleberException unauthorizedShopKleberException) {
        ShopKleberExceptionResponseMessage shopKleberExceptionResponseMessage = new ShopKleberExceptionResponseMessage(HttpStatus.UNAUTHORIZED.getReasonPhrase(), unauthorizedShopKleberException.getMessage());
        return shopKleberExceptionResponseMessage;
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedShopKleberException.class)
    @ResponseBody
    public ShopKleberExceptionResponseMessage handleForbidden(AccessDeniedShopKleberException accessDeniedShopKleberException) {
        ShopKleberExceptionResponseMessage shopKleberExceptionResponseMessage = new ShopKleberExceptionResponseMessage(HttpStatus.FORBIDDEN.getReasonPhrase(), accessDeniedShopKleberException.getMessage());
        return shopKleberExceptionResponseMessage;
    }

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(BusinessShopKleberException.class)
    @ResponseBody
    public ShopKleberExceptionResponseMessage handleNotAcceptable(BusinessShopKleberException businessShopKleberException) {
        ShopKleberExceptionResponseMessage shopKleberExceptionResponseMessage = new ShopKleberExceptionResponseMessage(HttpStatus.NOT_ACCEPTABLE.getReasonPhrase(), businessShopKleberException.getMessage());
        return shopKleberExceptionResponseMessage;
    }

}