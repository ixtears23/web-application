package junseok.snr.web.ticket;

import junseok.snr.web.util.RandomNumber;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Component
@Slf4j
public class Tickets {
    private List<Ticket> tickets;
    public static final int TICKET_SIZE = 1000;

    public void create() {
        validateCreatedTicket();
        tickets = new ArrayList<>();
    }

    private void validateCreatedTicket() {
        if (this.tickets != null) throw new RuntimeException("이미 티켓이 생성되었습니다.");
    }

    public void addTicket(Ticket ticket) {
        try {
            final int millis = Integer.parseInt(RandomNumber.getNumber(4));
            log.debug(">>>>> addTicket sleep millis : {}", millis);
            Thread.sleep(millis);
        } catch (InterruptedException exception) {
            log.error(">>>>>>>>>> addTicket ::: {}", exception.getMessage(), exception);
        }
        validateTicketSize();
        this.tickets.add(ticket);
    }

    public void validateTicketSize() {
        if (tickets.size() > TICKET_SIZE) throw new RuntimeException("티켓 사이즈를 초과하였습니다.");
    }
}
