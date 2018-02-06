package model;

/**
 * Created by admin.son.ton on 1/25/18.
 */
public class ProductDetailInfo {

    private String productTitle;
    private String productUrl;

    public ProductDetailInfo(String title,String url){
        productTitle = title;
        productUrl=url;
    }

    public String getProductTitle(){
        return productTitle;
    }

    public String getProductUrl(){
        return productUrl;
    }
}


