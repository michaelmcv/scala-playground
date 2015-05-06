### Background

As a java developer looking to get more familar with scala, created this simple utility as a means of getting to grips with the 
differences.  This was primarily an exercise in skilling up in scala while also viewing an online course.

The scala program runs as an application, it takes the name of a video file name as an input, and attempts to determine if the video
is a movie or a tv show based on the name. The expected filename input is the standard torrent format e.g. <filename>.<seasoninfo>.<formats>.<groups>.<extension>.

This could be used in conjunction with a bash script to decide where to move a supplied video file to the correct location in your video media library i.e. film or tv show.

This functionality could easily be achieved completely with a single bash script, but where's the scala fun in that ???

### Enhancements

Inspection of search results for the best match (currently only returns the 1st result)
The util could be extended to extract the tv season and episode number from the standard torrent filenae convention with regex.
Add a bash script to package the application as a jar.
error handling

### Usage

run on commandline via sbt:

./sbt "run <filename> <logLevel e.g. INFO>"

e.g.

./sbt "run Fortitude.S01E01.HDTV.XVID-LOL.AVI INFO"
