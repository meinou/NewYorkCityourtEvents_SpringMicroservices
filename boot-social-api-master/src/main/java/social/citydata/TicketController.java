package social.citydata;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TicketController {
    private static final Logger log = LoggerFactory.getLogger(TicketController.class);

    @RequestMapping(value="/requests", method=RequestMethod.GET)
    public @ResponseBody
    Request[] findRequests() {
        RestTemplate restTemplate = new RestTemplate();
        final String url = "http://data.cityofnewyork.us/resource/buex-bi6w.json?category_description=Construction/Construction Services";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        log.error(">>>> requests");
        log.error(response.getStatusCode().toString());

        Request[] requests = new Request[0];
        ObjectMapper objectMapper = new ObjectMapper();

        log.error(response.getBody());
        objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        try {
            requests = objectMapper.readValue(response.getBody(), Request[].class);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return requests;
    }


    //https://data.cityofnewyork.us/resource/buex-bi6w.json?pin=84617B0024
    @RequestMapping(value="/requests/{id}", method=RequestMethod.GET)
    public @ResponseBody
    Request findRequest(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        final String url = "https://data.cityofnewyork.us/resource/buex-bi6w.json?pin=" + id;

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        log.error(">>>> requests id");
        log.error(response.getStatusCode().toString());

        Request request = new Request();// = new Request[0];
        ObjectMapper objectMapper = new ObjectMapper();

        log.error(response.getBody());
        try {
            request = objectMapper.readValue(response.getBody(), Request.class);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return request;
    }

}
