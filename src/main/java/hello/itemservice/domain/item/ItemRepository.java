package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    // 실제로 멀티쓰래드 환경에서 여러 클라이언트가 접근하면 그냥 HashMap이나 Long을 사용하면 안된다.
    // ex) ConcurrentHashMap, AtomicLong...등등
    private static final Map<Long, Item> store = new HashMap<>(); //static
    private static long sequence = 0L; //static

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values()); //감싸서 반환하는 이유 - ArrayList에 값을 넣어도 store에는 변화가 없음
    }

    public void updata(Long itemId, Item updataParam){
        Item findItem = findById(itemId);
        findItem.setItemName(updataParam.getItemName());
        findItem.setPrice(updataParam.getPrice());
        findItem.setQuantity(updataParam.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }
}
