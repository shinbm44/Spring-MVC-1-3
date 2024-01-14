package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Item item = new Item("itemA", 10000, 10);
        //when
        Item savedItem = itemRepository.save(item);
        //then
        Item findItem = itemRepository.findById(item.getId());
        assertThat(findItem).isEqualTo(savedItem);
    }

    @Test
    void findAll() {
        //given
        Item item1= new Item("itemA", 10000, 10);
        Item item2 = new Item("itemB", 20000, 30);

        itemRepository.save(item1);
        itemRepository.save(item2);
        //when
        List<Item> result = itemRepository.findAll();
        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(item1, item2);
    }

    @Test
    void updateItem() {
        //given
        Item item = new Item("itemA", 10000, 10);

        Item savedItem = itemRepository.save(item);
        Long itemId = savedItem.getId();
        System.out.println("itemId = " + itemId);

        //when
        Item updataParam = new Item("item2", 20000, 30);
        itemRepository.updata(itemId, updataParam);


        //then
        Item findItem = itemRepository.findById(itemId);

        System.out.println(findItem);

        System.out.println(updataParam.getItemName());
        System.out.println(findItem.getItemName());

        System.out.println(updataParam.getQuantity());
        System.out.println(findItem.getQuantity());


        System.out.println(updataParam.getPrice());
        System.out.println(findItem.getPrice());


        assertThat(findItem.getItemName()).isEqualTo(updataParam.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(updataParam.getPrice());
        assertThat(findItem.getQuantity()).isEqualTo(updataParam.getQuantity());

    }

}