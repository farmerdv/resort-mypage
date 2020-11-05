package reserveresort;

import reserveresort.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MypageViewHandler {


    @Autowired
    private MypageRepository mypageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReserved_then_CREATE_1 (@Payload Reserved reserved) {
        try {
            if (reserved.isMe()) {
                // view 객체 생성
                Mypage mypage = new Mypage();
                // view 객체에 이벤트의 Value 를 set 함
                mypage.setReserveId(String.valueOf(reserved.getId()));
                mypage.setRoomId(reserved.getRoomId());
                mypage.setPeopleCount(reserved.getPeopleCount());
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenConfimed_then_UPDATE_1(@Payload Confimed confimed) {
        try {
            if (confimed.isMe()) {
                // view 객체 조회
                List<Mypage> mypageList = mypageRepository.findByReserveId(confimed.getReserveId());
                for(Mypage mypage : mypageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    mypage.setConfirmId(String.valueOf(confimed.getId()));
                    mypage.setStatus(confimed.getStatus());
                    // view 레파지 토리에 save
                    mypageRepository.save(mypage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenConfirmCanceled_then_UPDATE_2(@Payload ConfirmCanceled confirmCanceled) {
        try {
            if (confirmCanceled.isMe()) {
                // view 객체 조회
                List<Mypage> mypageList = mypageRepository.findByReserveId(confirmCanceled.getReserveId());
                for(Mypage mypage : mypageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    mypage.setStatus(confirmCanceled.getStatus());
                    // view 레파지 토리에 save
                    mypageRepository.save(mypage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}