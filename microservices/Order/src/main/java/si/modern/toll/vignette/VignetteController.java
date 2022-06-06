package si.modern.toll.vignette;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("api/v1/vignettes")
public class VignetteController {

    private final VignetteService vignetteService;

    public VignetteController(VignetteService vignetteService) {
        this.vignetteService = vignetteService;
    }


    @GetMapping
    public List<Vignette> fetchAllVignettes() {
        return vignetteService.getAllVignettes();
    }

    @GetMapping("/{id}")
    public Vignette get(@PathVariable String id) {
        return vignetteService.getByIdVignette(id);
    }

    @PostMapping
    public void save(@RequestBody Vignette vignette) {
        vignetteService.saveVignette(vignette);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        vignetteService.deleteVignette(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody Vignette vignette) {
        vignetteService.updateVignette(id, vignette);
    }
}
