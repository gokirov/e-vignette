package si.modern.toll.Domain.Repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import si.modern.toll.Domain.Entity.Validity;
import si.modern.toll.Domain.Entity.Vignette;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ValidityRepository {
    @Inject
    MongoClient mongoClient;

    private MongoCollection getCollectionVignettes() {
        return mongoClient.getDatabase("e-vignette").getCollection("Vignettes");
    }

    private MongoCollection getCollectionValidity() {
        return mongoClient.getDatabase("e-vignette").getCollection("Validity");
    }


    public void addVignette(Vignette vignette) {
        Document document = new Document()
                .append("numberPlate", vignette.getNumberPlate())
                .append("dateFrom", vignette.getDateFrom())
                .append("dateTo", vignette.getDateTo())
                .append("datePurchased", vignette.getDatePurchased())
                .append("locationPurchased", vignette.getLocationPurchased())
                .append("durationType", vignette.getDurationType())
                .append("vehicleType", vignette.getVehicleType());
        getCollectionVignettes().insertOne(document);
    }

    public List<Vignette> getAllVignettes() {
        List<Vignette> list = new ArrayList<>();

        try (MongoCursor<Document> cursor = getCollectionVignettes().find().iterator()) {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                Vignette vignette = new Vignette();
                vignette.setNumberPlate(document.getString("numberPlate"));
                vignette.setDateFrom(document.getDate("dateFrom"));
                vignette.setDateTo(document.getDate(document.getString("dateTo")));
                vignette.setDatePurchased(document.getDate("datePurchased"));
                vignette.setLocationPurchased(document.getString("locationPurchased"));
                vignette.setDurationType(Vignette.DurationType.valueOf("durationType"));
                vignette.setVehicleType(Vignette.VehicleType.valueOf("vehicleType"));
                list.add(vignette);
            }
        }
        return list;
    }

    public Vignette getVignette(String plateNumber) {
        try (MongoCursor<Document> cursor = getCollectionVignettes().find().iterator()) {
            Vignette vignette = new Vignette();
            while (cursor.hasNext()) {
                Document document = cursor.next();
                if (document.getString("numberPlate").equals(plateNumber)) {
                    vignette.setNumberPlate(document.getString("numberPlate"));
                    vignette.setDateFrom(document.getDate("dateFrom"));
                    vignette.setDateTo(document.getDate(document.getString("dateTo")));
                    vignette.setDatePurchased(document.getDate("datePurchased"));
                    vignette.setLocationPurchased(document.getString("locationPurchased"));
                    vignette.setDurationType(Vignette.DurationType.valueOf("durationType"));
                    vignette.setVehicleType(Vignette.VehicleType.valueOf("vehicleType"));
                    break;
                }
            }
            return vignette;
        }
    }

    public void setValidity(Validity validity) {
        Document document = new Document()
                .append("numberPlate", validity.getNumberPlate())
                .append("dateFrom", validity.getDateFrom())
                .append("dateTo", validity.getDateTo())
                .append("dateChecked", validity.getDateChecked())
                .append("isValid", validity.getValid())
                .append("daysRemained", validity.getValid());
        getCollectionValidity().insertOne(document);
    }
}
