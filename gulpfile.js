
/**
 * to install gulp plugins
 * npm install gulp-util --save-dev
	npm install gulp-imagemin --save-dev
	npm install gulp-ruby-sass --save-dev
	npm install gulp-clean-css --save-dev
	npm install gulp-jshint --save-dev
	npm install gulp-uglify --save-dev
	npm install gulp-rename --save-dev
	npm install gulp-concat --save-dev
	npm install gulp-clean --save-dev
	npm install gulp-notify --save-dev
	npm install gulp-livereload --save-dev
	npm install tiny-lr --save-dev
 * --save-dev
 */

// gulp components
var gulp    = require('gulp'),                 //basis
    imagemin = require('gulp-imagemin'),       //image compass
    sass = require('gulp-ruby-sass'),          //sass
    											//gulp-autoprefixer
    minifycss = require('gulp-clean-css'),    //css compass
    //jshint = require('gulp-jshint'),           //js hint
    uglify  = require('gulp-uglify'),          //js compass
    rename = require('gulp-rename'),           //rename
    concat  = require('gulp-concat'),          // 
    clean = require('gulp-clean'),             //clean folder
    notify = require('gulp-notify'),           //
    tinylr = require('tiny-lr'),               //livereload
    server = tinylr(),
    port = 35729,
    livereload = require('gulp-livereload');   //livereload

// HTML process
/*gulp.task('html', function() {
    var htmlSrc = './src/main/resource/*.html',
        htmlDst = './src/main/resource/*.html';

    gulp.src(htmlSrc)
        .pipe(livereload(server))
        .pipe(gulp.dest(htmlDst))
});*/

// css process
/*gulp.task('css', function () {
    var cssSrc = './src/main/resources/static/css/*.scss',
        cssDst = './src/main/resources/static/css/';

    gulp.src(cssSrc)
        .pipe(sass({ style: 'expanded'}))
        .pipe(gulp.dest(cssDst))
        .pipe(rename({ suffix: '.min' }))
        .pipe(minifycss())
        .pipe(livereload(server))
        .pipe(gulp.dest(cssDst));
});*/

// image compass
/*gulp.task('images', function(){
//    var imgSrc = './src/main/resources/static/img/** /* ,  
/*        imgDst = './src/main/resources/static/img';
    gulp.src(imgSrc)
        .pipe(imagemin())
        .pipe(livereload(server))
        .pipe(gulp.dest(imgDst));
})*/

// js process
gulp.task('js', function () {
    var jsSrc = './src/main/javascript/**/*.js',
        jsDst ='./src/main/resources/static/js';

    gulp.src(jsSrc)
//        .pipe(jshint('.jshintrc'))
//        .pipe(jshint.reporter('default'))
        .pipe(concat('main.js'))
        .pipe(gulp.dest(jsDst))
        .pipe(rename({ suffix: '.min' }))
        .pipe(uglify())
        .pipe(livereload(server))
        .pipe(gulp.dest(jsDst))
        .pipe(notify({ message: 'js task completed' }));
});

//copy vendor js
gulp.task('vendor', function() {
var vendorSrc = ['./bower_components/angular/angular.js','./bower_components/angular-resource/angular-resource.js'],
	vendorDst = './src/main/resource/vendor/*.js';
gulp.src(vendorSrc)
    .pipe(livereload(server))
    .pipe(gulp.dest(vendorDst))
});

// clean image css and js
gulp.task('clean', function() {
    gulp.src(['./src/main/resources/static/css/', './src/main/resources/static/js'], {read: false})
        .pipe(clean())
        .pipe(notify({ message: 'clean task completed' }));;
});

//  gulp
gulp.task('default', ['clean'], function(){
	gulp.start('js');
    //gulp.start('html','css','images','js');
});

//  gulp watch
gulp.task('watch',function(){

    server.listen(port, function(err){
        if (err) {
            return console.log(err);
        }

        // html
        gulp.watch('./src/main/resources/**/*.html', function(event){
            gulp.run('html');
        })

        // css
        gulp.watch('./src/scss/*.scss', function(){
            gulp.run('css');
        });

        // images
        gulp.watch('./src/images/**/*', function(){
            gulp.run('images');
        });

        // js

        gulp.watch('./src/js/*.js', function(){
            gulp.run('js');
        });

    });
});