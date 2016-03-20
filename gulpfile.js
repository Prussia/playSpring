
/**
 * to install gulp plugins
 * npm install gulp-util gulp-imagemin gulp-ruby-sass gulp-minify-css gulp-jshint gulp-uglify gulp-rename gulp-concat gulp-clean gulp-livereload tiny-lr --save-dev
 */

// 引入 gulp及组件
var gulp    = require('gulp'),                 //basis
    imagemin = require('gulp-imagemin'),       //image compass
    sass = require('gulp-ruby-sass'),          //sass
    											//gulp-autoprefixer
    minifycss = require('gulp-clean-css'),    //css compass
    jshint = require('gulp-jshint'),           //js hint
    uglify  = require('gulp-uglify'),          //js compass
    rename = require('gulp-rename'),           //rename
    concat  = require('gulp-concat'),          // 
    clean = require('gulp-clean'),             //clean folder
<<<<<<< HEAD
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
        .pipe(jshint('.jshintrc'))
        .pipe(jshint.reporter('default'))
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
=======
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
        .pipe(jshint('.jshintrc'))
        .pipe(jshint.reporter('default'))
        .pipe(concat('main.js'))
        .pipe(gulp.dest(jsDst))
        .pipe(rename({ suffix: '.min' }))
        .pipe(uglify())
        .pipe(livereload(server))
        .pipe(gulp.dest(jsDst));
});

// 清空图片、样式、js
gulp.task('clean', function() {
    gulp.src(['./src/main/resources/static/css/', './src/main/resources/static/js'], {read: false})
        .pipe(clean());
});

// 默认任务 清空图片、样式、js并重建 运行语句 gulp
gulp.task('default', ['clean'], function(){
	gulp.start('js');
    //gulp.start('html','css','images','js');
});

// 监听任务 运行语句 gulp watch
gulp.task('watch',function(){

    server.listen(port, function(err){
        if (err) {
            return console.log(err);
        }

        // 监听html
        gulp.watch('./src/*.html', function(event){
            gulp.run('html');
        })

        // 监听css
        gulp.watch('./src/scss/*.scss', function(){
            gulp.run('css');
        });

        // 监听images
        gulp.watch('./src/images/**/*', function(){
            gulp.run('images');
        });

        // 监听js
>>>>>>> branch 'master' of https://github.com/Prussia/playSpring
        gulp.watch('./src/js/*.js', function(){
            gulp.run('js');
        });

    });
});