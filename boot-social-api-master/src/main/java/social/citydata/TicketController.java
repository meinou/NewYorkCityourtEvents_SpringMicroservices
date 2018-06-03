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

//    @RequestMapping("/tickets")
//    public String getTickets() {
//        final String uri = "https://data.cityofnewyork.us/resource/buex-bi6w.json?category_description=Construction/Construction Services";
//
//        RestTemplate restTemplate = new RestTemplate();
//        String result = restTemplate.getForObject(uri, String.class);
//
//        log.debug(result);
//        return result;
//    }

//    @RequestMapping("/tickets")
//    public String getTickets() {
//        final String uri = "https://data.cityofnewyork.us/resource/buex-bi6w.json?category_description=Construction/Construction Services";
//
//        RestTemplate restTemplate = new RestTemplate();
//        String result = restTemplate.getForObject(uri, String.class);
//
//        log.debug(result.toString());
//        return result;
//    }
// Set<User> test = httpService.get(url).toResponseSet(User[].class);
//    public <T> Set<T> toResponseSet(Class<T[]> setType) {
//        HttpEntity<?> body = new HttpEntity<>(objectBody, headers);
//        ResponseEntity<T[]> response = template.exchange(url, method, body, setType);
//        return Sets.newHashSet(response.getBody());
//    }



//    @RequestMapping(value="/tickets", method=RequestMethod.GET)
//    public @ResponseBody
//    Object[] findAllObjects() {
//        RestTemplate restTemplate = new RestTemplate();
//        final String url = "https://data.cityofnewyork.us/resource/buex-bi6w.json?category_description=Construction/Construction Services";
//
//        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(url, Object[].class);
//        Object[] objects = responseEntity.getBody();
//        MediaType contentType = responseEntity.getHeaders().getContentType();
//        HttpStatus statusCode = responseEntity.getStatusCode();
//        String result = objects.toString();
//        log.debug(result);
//       // List<Object> objects = new ArrayList<Object>();
//        return objects;
//    }

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
}
