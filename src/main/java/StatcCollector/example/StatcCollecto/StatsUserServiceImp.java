package StatcCollector.example.StatcCollecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsUserServiceImp implements StatsUserService {
    @Autowired
    private StatsUserRepository Statrepo;

    @Override
    public String upsert(Users stats) {
        Statrepo.save(stats);
        return "Success";

    }

    @Override
    public List<Users> getAllstats() {
        return Statrepo.findAll();
    }
}


