var gulp   = require('gulp');
var concat = require('gulp-concat');
var uglify = require('gulp-uglify');

const ASSETS_SOURCE_FOLDER 		   = 'assets';
const RESOURCES_SOURCE_FOLDER 	   = 'resources';
const ASSETS_TARGET_FOLDER = RESOURCES_SOURCE_FOLDER + '/assets';

gulp.task('watch', function () {
	console.log("teste");
//    gulp.watch(ASSETS_SOURCE_FOLDER + '/**/*', ['assets:js']);
    gulp.watch(ASSETS_SOURCE_FOLDER + '/app/**/*', ['assets:js']);
});

gulp.task('assets:js', function() {
	console.log("OI");
	 var sources = [
         ASSETS_SOURCE_FOLDER + '/app/**/*.js'
     ];
	
	    var stream = gulp
	        .src(sources)
	        .pipe(concat('assets.min.js'))
	        .pipe(uglify())
	        .pipe(gulp.dest(ASSETS_TARGET_FOLDER));
	
      return stream;
})
 
gulp.task('teste', function () {
	console.log("OI")
});