package si.modern.toll.Domain.Service;

import si.modern.toll.Domain.Entity.Validity;
import si.modern.toll.Domain.Entity.Vignette;
import si.modern.toll.Domain.Repository.ValidityRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Date;

@ApplicationScoped
public class ValidityService {
    @Inject
    ValidityRepository validityRepository;

    public String addVignette(Vignette vignette) {
        return validityRepository.addVignette(vignette);
    }

    public Boolean checkPlateNumber(String plateNumber) {
        Validity validity = new Validity();
        Vignette vignette = validityRepository.getVignette(plateNumber);

        if (vignette.getNumberPlate() != null) {
            validity.setNumberPlate(vignette.getNumberPlate());
            validity.setDateFrom(vignette.getDateTo());
            validity.setDateTo(vignette.getDateTo());
            validity.setDateChecked(new Date());
            long timeDiff = vignette.getDateTo().getTime() - vignette.getDateFrom().getTime();
            int daysDiff = (int) (timeDiff / (1000 * 60 * 60 * 24));
            System.out.println("AASA: " + daysDiff);
            validity.setDaysRemained(daysDiff);
            validity.setValid(daysDiff > 0);
            validityRepository.setValidity(validity);
            return validity.getValid();
        }
        return false;
    }
}
