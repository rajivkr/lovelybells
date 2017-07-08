var MouseWheel = function () {

    return {

        initMouseWheel: function () {
            jQuery('.slider-snap').noUiSlider({
                start: [ 100,200  ],
                snap: true,
                connect: true,
                range: {
                    'min': 0,
                    '5%': 1000,
                    '10%': 1000,
                    '15%': 1000,
                    '20%': 1000,
                    '25%': 1000,
                    '30%': 1000,
                    '35%': 1000,
                    '40%': 1000,
                    '50%': 1000,
                    '60%': 1000,
                    '70%': 1000,
                    '80%': 1000,
                    '140%': 1000,
                    'max': 1000
                }
            });
            jQuery('.slider-snap').Link('lower').to(jQuery('.slider-snap-value-lower'));
            jQuery('.slider-snap').Link('upper').to(jQuery('.slider-snap-value-upper'));
        }

    };

}();        