# converter

use URL of file path to convert image to gray scale



edit process.java --> line 27 for output file location


```shell
javac *.java
java process
```


### GrayScale

```java
    int p = img.getRGB(x,y);
    
    int a = (p>>24)&0xff;
    int r = (p>>16)&0xff;
    int g = (p>>8)&0xff;
    int b = p&0xff;
    
    //calculate average
    int avg = (r+g+b)/3;

    //replace RGB value with avg
    p = (a<<24) | (avg<<16) | (avg<<8) | avg;
    
    img.setRGB(x, y, p);
```

### Edge Detection

EDGE --> set of points where discontinuities in brigthness occur

by using derivative (by filters) calculate the points of discontinuities

1st derivative
2nd derivative

convoultion

test


### USED ARTIVLES

<a>https://medium.com/javarevisited/building-a-java-edge-detection-application-6147b68e5d79</a>

