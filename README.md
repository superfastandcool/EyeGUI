
# Eye Rest Software
A GUI designed to reduce eye damage by reminding users to take breaks.

## Motivation
This software was designed to help people, like myself, who use computers for long stretches at a time to have healthy eyes. I often spend many hours a day sitting behind a screen; coding, studying or just working on programs like this. I wanted an application that would ensure I rest my eyes regularly. I wanted the software to work when I am not connected to the internet and is very simple to use.

Let me know what you think!


## Installation
To use this software, there are two options:
- build from source code
- execute the `.jar` file.

### Build from source code
A summary of the process is given.
In a command-line application enter the following in the same directory as the source code:
```shell
javac -d . Main.java OpeningPanel.java WorkPanel.java
```
Once compiled create a manifest file with the following contents:
```
Main-Class: src.Main
```

Finally, create a jar file by entering the following:
``` shell
jar -cmf manifest.mf mye.jar src
```

### Executing the .jar file
For those who wish to directly run the application without having to build, I have included a jar file in this repository.



## To Do
- [x] Create "Opening Panel"
- [x] Create "Countdown Panel"/"Work Panel"
- [x] Increase the size of the countdown
- [ ] Add music to alert the user
- [ ] Finalise the design

## Important Information
This software is experimental in nature. The author makes no guarantee of any kind about the software. The author will not be held liable for any damages incurred from the use of this product.

