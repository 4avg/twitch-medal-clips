package com.fourav.medal.util;

import com.fourav.medal.conf.FourAVException;
import com.fourav.medal.service.ClipService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static com.fourav.medal.util.Constants.ERROR_GENERATING_API_KEY_INVALID_URL;
import static com.fourav.medal.util.Constants.USER_ID_REQUIRED;
import static org.slf4j.LoggerFactory.getLogger;

@Component
public class MedalResource {

    public static final String EMBEDDED_LINK_REQUIRED = "Embedded Link required";
    @Autowired
    RestTemplate restTemplate;

    @Value("${application.api-key-url}")
    String apiKeyUrl;

    @Value("${application.featured-video-url}")
    String featuredVideoUrl;

    @Value("${application.featured-video-limit}")
    String limit;

    private final Logger logger = getLogger(MedalResource.class);

    public String fetchMedalKey() throws FourAVException {

        if (apiKeyUrl == null) {
            logger.error(ERROR_GENERATING_API_KEY_INVALID_URL);
            throw new FourAVException(ERROR_GENERATING_API_KEY_INVALID_URL);
        }

        try {
            logger.info( "Calling the API Url " +apiKeyUrl );
            return restTemplate.getForObject(apiKeyUrl, String.class, new HashMap<String, String>());
        }
        catch (Exception e ){
            throw new FourAVException( e.getMessage() );
        }

    }

    public MedalResponse fetchFeaturedVideo(String userId) throws FourAVException {

        if (userId == null) {
            logger.error( USER_ID_REQUIRED );
            throw new FourAVException( USER_ID_REQUIRED );
        }

        Map<String,String> params = new HashMap<String,String>();
        params.put( "userId",  userId);
        params.put( "limit", limit);

        HttpHeaders headers = new HttpHeaders();
        headers.set( "authorization" ,  fetchMedalKey());
        HttpEntity<String> httpEntity = new HttpEntity<String>(headers);

        try {
            logger.info( "Calling the Featured Video Url " +featuredVideoUrl );
            return restTemplate.exchange( featuredVideoUrl,HttpMethod.GET,httpEntity,MedalResponse.class, params ).getBody();
        }
        catch (Exception e ){
            throw new FourAVException( e.getMessage() );
        }

    }
}
