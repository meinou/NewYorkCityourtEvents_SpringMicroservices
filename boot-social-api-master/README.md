# Springboot backend

# To make everything working, download backend and run

 - In `spring-boot-microservices` folder make `docker-compose up`
 - See localhost:8082 (or http://127.0.0.1:8080/boot)


### If it's not working, may be I regenerated my API keys.

 - Go to `https://apps.twitter.com/app/15307872/keys`, create new app with the `website` and `callback` properties of `http://127.0.0.1:8080/app`
 - Replace KEY and SECRET in `application.properties` and `application-dev.properties` with your new keys
 - Restart

### If still does not work, try run without microservices. From the `boot-social-api` folder make `./gradlew bootRun`
 - See http://127.0.0.1:8080


### If still does not work, may be I was banned in Google maps API.

In this case download frontend here: NewYorkCityourtEvents_React

 - in frontend folder
 - in `static` folder of backend replace everything exept the `app` folder with the content of `build`-> `static` folder of frontend
 - replace index.html from `app` with new `index.html`
 - restart
 - see http://127.0.0.1:8080

