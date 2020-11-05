package reserveresort;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Mypage_table")
public class Mypage {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String reserveId;
        private String roomId;
        private Integer peopleCount;
        private String confirmId;
        private String status;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public String getReserveId() {
            return reserveId;
        }

        public void setReserveId(String reserveId) {
            this.reserveId = reserveId;
        }
        public String getRoomId() {
            return roomId;
        }

        public void setRoomId(String roomId) {
            this.roomId = roomId;
        }
        public Integer getPeopleCount() {
            return peopleCount;
        }

        public void setPeopleCount(Integer peopleCount) {
            this.peopleCount = peopleCount;
        }
        public String getConfirmId() {
            return confirmId;
        }

        public void setConfirmId(String confirmId) {
            this.confirmId = confirmId;
        }
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

}
