package si.modern.toll.vignette;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VignetteService {

    private final VignetteRepository vignetteRepository;

    public VignetteService(VignetteRepository vignetteRepository) {
        this.vignetteRepository = vignetteRepository;
    }

    public List<Vignette> getAllVignettes() {
        return vignetteRepository.findAll();
    }

    public Vignette saveVignette(Vignette vignette) {
        return vignetteRepository.save(vignette);
    }

    public void updateVignette(String id, Vignette updatedVignette) {
        Vignette vignette = getByIdVignette(id);

        if (updatedVignette.getFirstName() != null) vignette.setFirstName(updatedVignette.getFirstName());

        if (updatedVignette.getLastName() != null) vignette.setLastName(updatedVignette.getLastName());

        if (updatedVignette.getPlateNumber() != null) vignette.setPlateNumber(updatedVignette.getPlateNumber());

        if (updatedVignette.getCreated() != null) vignette.setCreated(LocalDateTime.now());

        vignetteRepository.save(vignette);
    }

    public void deleteVignette(String id) {
        Vignette vignette = getByIdVignette(id);
        vignetteRepository.delete(vignette);
    }

    public Vignette getByIdVignette(String id) {
        return vignetteRepository.findById(id).get();
    }
}
