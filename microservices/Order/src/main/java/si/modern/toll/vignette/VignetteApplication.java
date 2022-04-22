package si.modern.toll.vignette;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;

import javax.management.Query;

@SpringBootApplication
public class VignetteApplication {

    public static void main(String[] args) {
        SpringApplication.run(VignetteApplication.class, args);
    }
/*
	private void usingMongoTemplateAndQuery(VignetteRepository repository, MongoTemplate mongoTemplate, String email, Vignette vignette) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));
		mongoTemplate.find(query, Vignette.class);

		repository.insert(vignette);
	}
*/
}
