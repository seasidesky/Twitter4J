package twitter4j.internal.json;

import static org.junit.Assert.*;

import junit.framework.TestCase;
import twitter4j.GeoLocation;
import twitter4j.Status;
import twitter4j.json.DataObjectFactory;

/**
 * @author Cedric Meury - cedric at meury.com
 */
public class StatusJSONImplTest extends TestCase {

    public void testGetIsoLanguageCode() throws Exception {
        // given
        String json = "{\"contributors\":null,\"text\":\"@belbeer After four years of study in radiotechnical college I realized that the language skills are much more useful than fucking math.\",\"geo\":null,\"retweeted\":false,\"in_reply_to_screen_name\":\"belbeer\",\"truncated\":false,\"entities\":{\"urls\":[],\"hashtags\":[],\"user_mentions\":[{\"id\":74987101,\"name\":\"belbeer\",\"indices\":[0,8],\"screen_name\":\"belbeer\",\"id_str\":\"74987101\"}]},\"in_reply_to_status_id_str\":\"297250346298904576\",\"id\":297265580690513920,\"source\":\"web\",\"in_reply_to_user_id_str\":\"74987101\",\"favorited\":false,\"in_reply_to_status_id\":297250346298904576,\"retweet_count\":0,\"created_at\":\"Fri Feb 01 08:50:12 +0000 2013\",\"in_reply_to_user_id\":74987101,\"id_str\":\"297265580690513920\",\"place\":null,\"user\":{\"location\":\"where am i?\",\"default_profile\":true,\"profile_background_tile\":false,\"statuses_count\":1100,\"lang\":\"ru\",\"profile_link_color\":\"0084B4\",\"id\":386522307,\"following\":null,\"protected\":false,\"favourites_count\":13,\"profile_text_color\":\"333333\",\"description\":\"160 символов\",\"verified\":false,\"contributors_enabled\":false,\"profile_sidebar_border_color\":\"C0DEED\",\"name\":\"Безумный Рыбник\",\"profile_background_color\":\"C0DEED\",\"created_at\":\"Fri Oct 07 12:44:01 +0000 2011\",\"default_profile_image\":false,\"followers_count\":46,\"profile_image_url_https\":\"https://si0.twimg.com/profile_images/2785804589/b0b355c75d3f77658fc94ec05a7bb5af_normal.jpeg\",\"geo_enabled\":true,\"profile_background_image_url\":\"http://a0.twimg.com/images/themes/theme1/bg.png\",\"profile_background_image_url_https\":\"https://si0.twimg.com/images/themes/theme1/bg.png\",\"follow_request_sent\":null,\"entities\":{\"description\":{\"urls\":[]},\"url\":{\"urls\":[{\"expanded_url\":null,\"indices\":[0,29],\"url\":\"http://goodfoto.blogspot.com/\"}]}},\"url\":\"http://goodfoto.blogspot.com/\",\"utc_offset\":7200,\"time_zone\":\"Athens\",\"notifications\":null,\"profile_use_background_image\":true,\"friends_count\":46,\"profile_sidebar_fill_color\":\"DDEEF6\",\"screen_name\":\"LonliLokli2000\",\"id_str\":\"386522307\",\"profile_image_url\":\"http://a0.twimg.com/profile_images/2785804589/b0b355c75d3f77658fc94ec05a7bb5af_normal.jpeg\",\"listed_count\":1,\"is_translator\":false},\"coordinates\":null,\"metadata\":{\"result_type\":\"recent\",\"iso_language_code\":\"en\"}}";
        Status status = DataObjectFactory.createStatus(json);

        // when
        String lang = status.getIsoLanguageCode();

        // then
        assertEquals("en", lang);
    }

    public void testReturningNullForMissingIsoLanguageCode() throws Exception {
        // given
        String json = "{\"contributors\":null,\"text\":\"@belbeer After four years of study in radiotechnical college I realized that the language skills are much more useful than fucking math.\",\"geo\":null,\"retweeted\":false,\"in_reply_to_screen_name\":\"belbeer\",\"truncated\":false,\"entities\":{\"urls\":[],\"hashtags\":[],\"user_mentions\":[{\"id\":74987101,\"name\":\"belbeer\",\"indices\":[0,8],\"screen_name\":\"belbeer\",\"id_str\":\"74987101\"}]},\"in_reply_to_status_id_str\":\"297250346298904576\",\"id\":297265580690513920,\"source\":\"web\",\"in_reply_to_user_id_str\":\"74987101\",\"favorited\":false,\"in_reply_to_status_id\":297250346298904576,\"retweet_count\":0,\"created_at\":\"Fri Feb 01 08:50:12 +0000 2013\",\"in_reply_to_user_id\":74987101,\"id_str\":\"297265580690513920\",\"place\":null,\"user\":{\"location\":\"where am i?\",\"default_profile\":true,\"profile_background_tile\":false,\"statuses_count\":1100,\"lang\":\"ru\",\"profile_link_color\":\"0084B4\",\"id\":386522307,\"following\":null,\"protected\":false,\"favourites_count\":13,\"profile_text_color\":\"333333\",\"description\":\"160 символов\",\"verified\":false,\"contributors_enabled\":false,\"profile_sidebar_border_color\":\"C0DEED\",\"name\":\"Безумный Рыбник\",\"profile_background_color\":\"C0DEED\",\"created_at\":\"Fri Oct 07 12:44:01 +0000 2011\",\"default_profile_image\":false,\"followers_count\":46,\"profile_image_url_https\":\"https://si0.twimg.com/profile_images/2785804589/b0b355c75d3f77658fc94ec05a7bb5af_normal.jpeg\",\"geo_enabled\":true,\"profile_background_image_url\":\"http://a0.twimg.com/images/themes/theme1/bg.png\",\"profile_background_image_url_https\":\"https://si0.twimg.com/images/themes/theme1/bg.png\",\"follow_request_sent\":null,\"entities\":{\"description\":{\"urls\":[]},\"url\":{\"urls\":[{\"expanded_url\":null,\"indices\":[0,29],\"url\":\"http://goodfoto.blogspot.com/\"}]}},\"url\":\"http://goodfoto.blogspot.com/\",\"utc_offset\":7200,\"time_zone\":\"Athens\",\"notifications\":null,\"profile_use_background_image\":true,\"friends_count\":46,\"profile_sidebar_fill_color\":\"DDEEF6\",\"screen_name\":\"LonliLokli2000\",\"id_str\":\"386522307\",\"profile_image_url\":\"http://a0.twimg.com/profile_images/2785804589/b0b355c75d3f77658fc94ec05a7bb5af_normal.jpeg\",\"listed_count\":1,\"is_translator\":false},\"coordinates\":null}";
        Status status = DataObjectFactory.createStatus(json);

        // when
        String lang = status.getIsoLanguageCode();

        // then
        assertNull(lang);
    }

    public void testLoadingGeoLocationWithCoordinatesField() throws Exception{

        //given
        String json ="{\"filter_level\":\"medium\",\"contributors\":null,\"text\":\"@Livvy_Scott1 because I am a clever  boy.\",\"geo\":{\"type\":\"Point\",\"coordinates\":[52.25604116,0.70928444]},\"retweeted\":false,\"in_reply_to_screen_name\":\"Livvy_Scott1\",\"truncated\":false,\"lang\":\"en\",\"entities\":{\"urls\":[],\"hashtags\":[],\"user_mentions\":[{\"id\":476669159,\"name\":\"livs ?\",\"indices\":[0,13],\"screen_name\":\"Livvy_Scott1\",\"id_str\":\"476669159\"}]},\"in_reply_to_status_id_str\":\"320934680662794241\",\"id\":320936613498744832,\"source\":\"<a href=\\\"http://twitter.com/download/android\\\" rel=\\\"nofollow\\\">Twitter for Android<\\/a>\",\"in_reply_to_user_id_str\":\"476669159\",\"favorited\":false,\"in_reply_to_status_id\":320934680662794241,\"retweet_count\":0,\"created_at\":\"Sun Apr 07 16:30:26 +0000 2013\",\"in_reply_to_user_id\":476669159,\"favorite_count\":0,\"id_str\":\"320936613498744832\",\"place\":{\"id\":\"55c6bcd3013a0607\",\"bounding_box\":{\"type\":\"Polygon\",\"coordinates\":[[[0.38178,52.055592],[0.38178,52.400796],[0.967452,52.400796],[0.967452,52.055592]]]},\"place_type\":\"city\",\"contained_within\":[],\"name\":\"St. Edmundsbury\",\"attributes\":{},\"country_code\":\"GB\",\"url\":\"http://api.twitter.com/1/geo/id/55c6bcd3013a0607.json\",\"polylines\":[],\"geometry\":null,\"country\":\"United Kingdom\",\"full_name\":\"St. Edmundsbury, Suffolk\"},\"user\":{\"location\":\"Attleborough\",\"default_profile\":false,\"profile_background_tile\":true,\"statuses_count\":2520,\"lang\":\"en\",\"profile_link_color\":\"009999\",\"profile_banner_url\":\"https://si0.twimg.com/profile_banners/448404395/1365018601\",\"id\":448404395,\"following\":null,\"protected\":false,\"favourites_count\":203,\"profile_text_color\":\"333333\",\"description\":\"Born at a very young age. Top Jock - DJ Bookings-maxwellDJ18@hotmail.co.uk \",\"verified\":false,\"contributors_enabled\":false,\"profile_sidebar_border_color\":\"EEEEEE\",\"name\":\"DJ MaxwellJ \",\"profile_background_color\":\"131516\",\"created_at\":\"Tue Dec 27 23:49:48 +0000 2011\",\"default_profile_image\":false,\"followers_count\":309,\"profile_image_url_https\":\"https://si0.twimg.com/profile_images/3472432483/07133836faedec0252f17d691cb7eb5d_normal.jpeg\",\"geo_enabled\":true,\"profile_background_image_url\":\"http://a0.twimg.com/images/themes/theme14/bg.gif\",\"profile_background_image_url_https\":\"https://si0.twimg.com/images/themes/theme14/bg.gif\",\"follow_request_sent\":null,\"url\":null,\"utc_offset\":0,\"time_zone\":\"Casablanca\",\"notifications\":null,\"profile_use_background_image\":true,\"friends_count\":342,\"profile_sidebar_fill_color\":\"EFEFEF\",\"screen_name\":\"maxwellDJ18\",\"id_str\":\"448404395\",\"profile_image_url\":\"http://a0.twimg.com/profile_images/3472432483/07133836faedec0252f17d691cb7eb5d_normal.jpeg\",\"listed_count\":0,\"is_translator\":false},\"coordinates\":{\"type\":\"Point\",\"coordinates\":[0.70928444,52.25604116]}}\n";

        //when
        Status status = DataObjectFactory.createStatus(json);
        GeoLocation geoLocation = status.getGeoLocation();
        //then
        assertNotNull(geoLocation);
        assertEquals(geoLocation.getLatitude(),0.70928444,0.00000001);
        assertEquals(geoLocation.getLongitude(),52.25604116,0.00000001);
    }


}
