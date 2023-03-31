package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectorPhotoTest {

    @Test
    void selectPictures() {
    }

    private static final String[] pictures =
            {
                    "Paris\\20140101_090000.jpg",
                    "Paris\\20140201_121005.jpg",
                    "Paris\\20150301_211035.jpg",
                    "Paris\\20150401_110023.gif",
                    "Paris\\20150401_181705.jpg",
                    "Paris\\20150501_231035.gif",
                    "London\\20140205_090000.jpg",
                    "London\\20140205_121005.jpg",
                    "London\\20140601_211035.gif",
                    "London\\20151001_110023.jpg",
                    "London\\20151001_121705.jpg",
                    "London\\20151001_231035.jpg",
                    "Chicago\\20150301_120001.png",
                    "Chicago\\20151111_232000.png"
            };
    private final static String autumn_pictures = "\\\\(\\d{4})(09|1[01])";
    private final static String spring_2015_pictures = "\\\\(2015)(0[3-5])";
    private final static String night_pictures = "_((1[89]|2[0-3])\\d{4})|(0{6})";
    private final static String jpg_png_pictures = "\\.(jpg|png)";


    @Test
    void testAllEuropePictures() {
        String regex = "London|Paris";
        String[] actual = SelectorPhoto.selectPictures(pictures, regex);

        String[] expected = {
                        "Paris\\20140101_090000.jpg",
                        "Paris\\20140201_121005.jpg",
                        "Paris\\20150301_211035.jpg",
                        "Paris\\20150401_110023.gif",
                        "Paris\\20150401_181705.jpg",
                        "Paris\\20150501_231035.gif",
                        "London\\20140205_090000.jpg",
                        "London\\20140205_121005.jpg",
                        "London\\20140601_211035.gif",
                        "London\\20151001_110023.jpg",
                        "London\\20151001_121705.jpg",
                        "London\\20151001_231035.jpg"
                };

        assertArrayEquals(expected, actual);
    }

    @Test
    void testAllAutumnPictures() {
        String[] actual = SelectorPhoto.selectPictures(pictures, autumn_pictures);
        String[] expected ={
                "London\\20151001_110023.jpg",
                "London\\20151001_121705.jpg",
                "London\\20151001_231035.jpg",
                "Chicago\\20151111_232000.png"
        };
        assertArrayEquals(actual, expected);

    }

    @Test
    void testAll2015SpringPictures() {
        String[] actual = SelectorPhoto.selectPictures(pictures,spring_2015_pictures);
        String[] expected = {
                "Paris\\20150301_211035.jpg",
                "Paris\\20150401_110023.gif",
                "Paris\\20150401_181705.jpg",
                "Paris\\20150501_231035.gif",
                "Chicago\\20150301_120001.png",
        };
        assertArrayEquals(expected, actual);

    }

    @Test
    void testAllNightPictures() {//from 18:00 to 00:00
        String[] actual = SelectorPhoto.selectPictures(pictures, night_pictures);
        String[] expected =
                {
                        "Paris\\20150301_211035.jpg",
                        "Paris\\20150401_181705.jpg",
                        "Paris\\20150501_231035.gif",
                        "London\\20140601_211035.gif",
                        "London\\20151001_231035.jpg",
                        "Chicago\\20151111_232000.png"
                };
        assertArrayEquals(expected, actual);
    }

    @Test
    void testAllNightPicturesFromChicago(){ //from 18:00 to 00:00
        String regex = String.format("Chicago(.+)(%1$s)", night_pictures);
        String[] actual = SelectorPhoto.selectPictures(pictures, regex);
        String[] expected =
                {
                        "Chicago\\20151111_232000.png"
                };
        assertArrayEquals(expected, actual);
    }

    @Test
    void testAllJpgAndPngPictures() {
        String[] actual = SelectorPhoto.selectPictures(pictures, jpg_png_pictures);
        String[] expected =
                {
                        "Paris\\20140101_090000.jpg",
                        "Paris\\20140201_121005.jpg",
                        "Paris\\20150301_211035.jpg",
                        "Paris\\20150401_181705.jpg",
                        "London\\20140205_090000.jpg",
                        "London\\20140205_121005.jpg",
                        "London\\20151001_110023.jpg",
                        "London\\20151001_121705.jpg",
                        "London\\20151001_231035.jpg",
                        "Chicago\\20150301_120001.png",
                        "Chicago\\20151111_232000.png"
                };
        assertArrayEquals(expected, actual);

    }

}