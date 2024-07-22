package StatcCollector.example.StatcCollecto;

import java.util.List;

public interface StatsUserService {
    String upsert(Users stats);
    List<Users> getAllstats();
}

