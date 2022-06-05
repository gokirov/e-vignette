package si.modern.toll.vignette;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VignetteRepository extends MongoRepository<Vignette, String> {
    Optional<Vignette> findVignetteByPlateNumber(String plateNumber);
}
