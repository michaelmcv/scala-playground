import java.util.logging.Level

object Runner {
   def main(args: Array[String]) {
     val numberOfParams = args.length
     if(numberOfParams == 0 || numberOfParams > 2) {     
     	Logger.log(Level.SEVERE, "Usage: Runner <videoTorrentFileName> <optional: logging level>")   
     	System.exit(0)
     }	

     if(numberOfParams > 1)	Logger.loggingLevel = Level.parse(args(1))

     Logger.log(Level.FINE, "about to run the tool ...")

     val fileName = args(0)
               
     Logger.log(Level.FINE, "processing filename " + fileName)     

     val title = new TitleMatcher matchMetaData fileName     
     
     Logger.log(Level.FINE, "Found title " + title)
     val video: VideoData = MovieDB.searchMovieData(title)
     
     Logger.log(Level.INFO, "Video Report - video: " + video.name + " | mediaType: " + video.mediaType)     

     Logger.log(Level.FINE,"run complete")     
   }
}
