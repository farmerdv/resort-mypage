package reserveresort;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MypageRepository extends CrudRepository<Mypage, Long> {

    List<Mypage> findByReserveId(String reserveId);
    List<Mypage> findByReserveId(String reserveId);

}