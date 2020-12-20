# JavaFx Tutorial

## Install

### Install plugin

- In Eclipse click Help menu > Eclipse Marketplace, and type fx in find box and enter, choose the first option [ e(fx)clipse 3.6.0 ] and click install.
- Now create a JavaFx project. Goto File > New > Project, and select JavaFX > Java Fx Project

### Add User Library

- Now you need to download JavaFx jar files from here (LTS 11.\*) : [link](https://gluonhq.com/products/javafx/)
- Extract the zip file in an easily accessible path
- Make JRE run time is selected. Right click project directory > properties > Java build path > Libraries (tab) > Modulepath, and there should be JRE System Library [JavaSE-11], add remove if needed.
- Now create a user library. Goto Window menu > preferences > Java > Build Path > User Libraries. Click New and give a name: JavaFx. Then click : Add external jars, and browse to path of jar files (first step in this section) and select all files with .jar extensions.

### Configure build path

- After the above step, Right click project direcotry > Build path > Configure build path.
- Click Libraries tab > Classpath, Click button : Add Library and select JavaFx

### Add Run time evironment arguments

- The project cannot still compile successfully because we have not configured run time.
- Click Run menu > Run Configurations > Click Arguments tab, and paste the following
  `--module-path "/home/alex/eclipse/javafx-sdk-11.0.2/lib" --add-modules javafx.controls`
- To find path to this library, on a terminal `echo $JAVA_HOME`

## First FX program

- A stage is the main window
- A scene is the content area
- A layout is need for placement of controls
- Lambda function
  `btn.setOnAction(e -> System.out.println("Btn clicked from lambda")); `
