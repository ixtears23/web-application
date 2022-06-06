package junseok.snr.web.ticket;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/ticket")
@RestController
public class TicketController {

    private final TicketService ticketService;

    @PutMapping
    public void createTicket() {
        ticketService.createTicket();
    }

    @PatchMapping
    public void ticketing() {
        ticketService.ticketing();
        ticketService.printTicketState();
    }

}
