package StatcCollector.example.StatcCollecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsUserServiceImp implements StatsUserService {
    @Autowired
    private StatsUserRepository Statrepo;

    @Override
    public String upsert(StatsUsers stats) {
        Statrepo.save(stats);
        return "Success";

    }

    @Override
    public List<StatsUsers> getAllstats() {
        return Statrepo.findAll();
    }
}
