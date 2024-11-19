package  ma.zyn.app.ws.dto.money;

import ma.zyn.app.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


import ma.zyn.app.ws.dto.catalog.ProductDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class PurchaseItemDto  extends AuditBaseDto {

    private BigDecimal price  ;
    private BigDecimal quantity  ;
    private String image  ;

    private ProductDto product ;
    private PurchaseDto purchase ;



    public PurchaseItemDto(){
        super();
    }




    public BigDecimal getPrice(){
        return this.price;
    }
    public void setPrice(BigDecimal price){
        this.price = price;
    }


    public BigDecimal getQuantity(){
        return this.quantity;
    }
    public void setQuantity(BigDecimal quantity){
        this.quantity = quantity;
    }


    public String getImage(){
        return this.image;
    }
    public void setImage(String image){
        this.image = image;
    }


    public ProductDto getProduct(){
        return this.product;
    }

    public void setProduct(ProductDto product){
        this.product = product;
    }
    public PurchaseDto getPurchase(){
        return this.purchase;
    }

    public void setPurchase(PurchaseDto purchase){
        this.purchase = purchase;
    }






}
