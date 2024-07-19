package StatcCollector.example.StatcCollecto;
import java.util.List;
public interface StatsUserService {
    String upsert(StatsUsers stats);
    List<StatsUsers> getAllstats();
}
