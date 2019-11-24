package com.fourav.medal.service;

import com.fourav.medal.conf.FourAVException;
import com.fourav.medal.util.MedalObject;
import com.fourav.medal.util.MedalResource;
import com.fourav.medal.util.MedalResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.fourav.medal.util.Constants.EMPTY_API_KEY_RECEIVED_CONTACT_MEDAL;
import static com.fourav.medal.util.Constants.USER_ID_REQUIRED;
import static org.slf4j.LoggerFactory.getLogger;

@Service
public class ClipService {

    public static final String NO_VIDEOS_FOUND = "No Videos found";
    @Autowired
    MedalResource medalResource;

    private final Logger logger = getLogger(ClipService.class);

    public String getMedalKey() throws FourAVException {

        logger.info( "Getting Medal Key" );

        String apiResponse = null, apiKey = null;

        apiResponse = medalResource.fetchMedalKey();

        if (apiResponse == null || apiResponse.trim().isEmpty() || (apiResponse.split(":")[1] == null)) {
            logger.error( EMPTY_API_KEY_RECEIVED_CONTACT_MEDAL );
            throw new FourAVException(EMPTY_API_KEY_RECEIVED_CONTACT_MEDAL);
        }
        apiKey = extractKey(apiResponse);

        logger.info( apiKey );

        return apiKey;
    }

    public String getFeaturedVideo(String userId) throws FourAVException {

        MedalResponse medalResponse = null;
        MedalObject medalObject = null;

        if (userId == null) {
            throw new FourAVException(USER_ID_REQUIRED);
        }

        medalResponse = medalResource.fetchFeaturedVideo(userId);

        if( medalResponse == null ||
                medalResponse.getContentObjects() == null ||
                medalResponse.getContentObjects().isEmpty() ){
            logger.error( NO_VIDEOS_FOUND );
            throw new FourAVException( NO_VIDEOS_FOUND );
        }

        medalObject = medalResponse.getContentObjects().get( 0 );

        logger.info (" Received medal object" );

        return extractDirectLink( medalObject.getDirectClipUrl() );
    }

    private String extractDirectLink( String embeddedLink ) throws FourAVException {
        Document document = null;
        Elements meta = null;
        StringBuffer rawLink = new StringBuffer();
        try {
            document = Jsoup.connect(embeddedLink).get();
            meta = document.getElementsByTag("meta");
            meta.forEach( element ->{
                if( element.attr("property").equals( "og:video:url" )) {
                    rawLink.append(element.attr("content").trim() );
                }

            });

            logger.info ("Video URL Extraction done !" );
            return extractVideoUrl( rawLink.toString() );
        } catch (IOException e) {
            logger.error ( e.getMessage() );
            throw new FourAVException( e.getMessage() );
        }
    }

    private String extractVideoUrl(String rawLink) {
        return rawLink.split("\\?")[0].trim();
    }

    private String extractKey(String operand){
        return operand.split(":")[1].trim();
    }


}
