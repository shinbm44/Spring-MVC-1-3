package hello.itemservice.domain.item;

import lombok.Getter;
import lombok.Setter;

// @DATA는 핵심 도메인 모델에 사용하기에 위험하다.
// 예측하지 못하게 동작할 수 있다.
// DTO에서는 사용해도 괜찮다.(일반적으론) 즉 주의할 필요가 있다.
@Getter @Setter
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item(){
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
