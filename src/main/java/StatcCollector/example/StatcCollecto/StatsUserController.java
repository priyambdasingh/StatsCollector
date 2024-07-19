package StatcCollector.example.StatcCollecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/StatsCollector")
public class StatsUserController {
    @Autowired
        private StatsUserService StatsService;

    @PostMapping("/submit")
    public ResponseEntity<StatsUsers> submitStats(@RequestBody StatsUsers stats) {
        String savedStats = StatsService.upsert( stats);
        return new ResponseEntity<>(stats, HttpStatus.CREATED);
    }

    @GetMapping("/stats")
    public ResponseEntity<List<StatsUsers>> getAllStats() {
        List<StatsUsers>allStats= StatsService.getAllstats();

        return new ResponseEntity<>(allStats,HttpStatus.OK);
    }
    }


