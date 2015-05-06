import scalaj.http.Http
import scalaj.http.HttpResponse

import java.util.logging.Level

import org.json4s._
import org.json4s.native.JsonMethods._

class MovieDB {
}

object MovieDB {
	val baseUrl = "http://api.themoviedb.org/3"
	val apiKey = "### supply moviedb api key here ###"
	

	def searchMovieData(movieTitle: String): VideoData = {

		//required by extract json call below
		implicit val formats = DefaultFormats

		Logger.log(Level.FINE, "searching for " + movieTitle)
		
		// add api retrieval here
		val response: HttpResponse[String] = Http(this.baseUrl + "/search/multi").param("query", movieTitle).param("api_key",apiKey).param("include_adult", "false").asString
		
		val fullJsonResponse = parse(response body)
		Logger.log(Level.FINE, pretty(render(fullJsonResponse)))

		val mediaType = ((fullJsonResponse \ "results")(0) \ "media_type").extract[String]
		Logger.log(Level.FINE, "found mediaType of " + mediaType)

		val name = mediaType match {
			case "tv" => ((fullJsonResponse \ "results")(0) \ "name").extract[String]
			case "movie" => ((fullJsonResponse \ "results")(0) \ "title").extract[String]
			case _ => "Undetermined"
		}
		
		Logger.log(Level.FINE, "Found matched movie name as " + name)

		new VideoData(name, mediaType)		
	}
}
