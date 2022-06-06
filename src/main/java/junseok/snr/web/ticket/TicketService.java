package junseok.snr.web.ticket;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class TicketService {
    private final Tickets tickets;

    public void createTicket() {
        tickets.create();
    }

    public void ticketing() {
        tickets.addTicket(new Ticket());
    }

    public void printTicketState() {
        log.info(">>>>> Ticket");
        log.info(">>>>> Ticket - limit : {}", Tickets.TICKET_SIZE);
        log.info(">>>>> Ticket - size : {}", tickets.getTickets().size());
    }
}
