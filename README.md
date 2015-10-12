# learning basic selenium
Learning selenium in scope of "full-stack" activities.  
Basic selenium spring-boot setup and simple test for [TodoMVC](http://todomvc.com/examples/angularjs/) application.

##tests
`TodoMvcAngularTest` - plain jUnit  
`TodoMvcAngularTestSpring` - spring-test

## grid setup
Use `remote` profile to use grid instead of local.   
See [docker-compose.yml](https://github.com/golonzovsky/selenium/blob/master/docker-compose-selenium-grid/docker-compose.yml) to start a selenium grid. 
Use `docker-compose up -d` command to start grid.  
`docker-compose scale nodechrome=5` - scale chrome nodes.  
`docker ps` - see what is running:
```
~/_project/selenium-pc/docker-compose-selenium-grid$ docker ps
CONTAINER ID        IMAGE                         COMMAND                  CREATED              STATUS              PORTS                     NAMES
332aa86e3a89        selenium/node-firefox-debug   "/opt/bin/entry_point"   About a minute ago   Up 2 seconds        0.0.0.0:32779->5900/tcp   dockercomposeseleniumgrid_nodeff_1
552a2a604a23        selenium/node-chrome-debug    "/opt/bin/entry_point"   11 hours ago         Up 3 seconds        0.0.0.0:32777->5900/tcp   dockercomposeseleniumgrid_nodechrome_2
cabc55db8d2d        selenium/node-chrome-debug    "/opt/bin/entry_point"   11 hours ago         Up 2 seconds        0.0.0.0:32778->5900/tcp   dockercomposeseleniumgrid_nodechrome_1
7701797ba81f        selenium/hub                  "/opt/bin/entry_point"   11 hours ago         Up 3 seconds        0.0.0.0:4444->4444/tcp    dockercomposeseleniumgrid_selhub_1
```

More datails at https://sandro-keil.de/blog/2015/03/23/selenium-grid-in-minutes-with-docker/
