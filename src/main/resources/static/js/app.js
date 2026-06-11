$(document).ready(function() {


/*     Fixed Header*/
let header = $('#header');
let intro = $('#intro');
let introH = intro.innerHeight();
let scrollPos = $(window).scrollTop();
    
    checkScroll( scrollPos, introH ); /*onload событие в функции ниже не работает*/


$(window).on("scroll load resize", function() {
    scrollPos = $(this).scrollTop();
    introH = intro.innerHeight();
    checkScroll( scrollPos, introH );  
});
    
    function checkScroll( scrollPos, introH ) {
        
        if( scrollPos > introH ){
        header.addClass('fixed');
        }else{
        header.removeClass('fixed');
        }
        
    };    
    
/*     Scroll*/
$('[data-scroll]').on('click', function(event) {
   event.preventDefault();
    nav.removeClass('show');
    let elementId = $(this).data('scroll');
    let elementOffSet = $(elementId).offset().top;
    
$('html, body').animate({scrollTop : elementOffSet - 70}, 700);
       
});
    
    
     
    
/*     Nav*/
    let nav = $('#nav');
    
    $('#navToggle').on('click', function(event){
    event.preventDefault();
    nav.toggleClass('show');
        
});
    
    
/*     Reviews* https://kenwheeler.github.io/slick/* /*/
    let slider = $('#reviewsSlider');
    
    slider.slick({
        infinite: true,
        slidesToShow: 1,
        slidesToScroll: 1,
        fade: true,
        arrows: false,
        dots: true,
        speed: 300
});

    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


});