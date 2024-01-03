# musicProject

## Project Thema
Wij bijden hebben een enorme passie voor muziek en wilden graag deze passie combineren met ons project. 

## Microservices
We hebben gekozen om voor onze microservices gebruik te maken van de volgende services:
### Artist-service:
        Een artist heeft een skuCode, naam, geboortedatum, land van herkomst, label en een boolean die aangeeft of de artiest nog actief muziek uitbrengt. 
        Artists is verbonden met een mysql databese. 
### Album-service:
    Een album heeft een skuCode, titel, releaseDate, aantal tracks, artistId en een genreId.
    Albums is verbonden met een MongoDB databese. 
### Genre-service:
    Een genre heeft een naam, beschrijving en een skuCode.
    Genres is verbonden met een mysql databese. 
### Song-service:
    Een song heeft een titel, artist en een jaar van uitgave.
    Songs is verbonden met een mysql databese. 

We zijn voor deze microservices gegaan omdat deze heel handig zijn bij het opzoeken van informatie over een bepaalde artiest, album, genre of song.
Elk Album bestaat uit een artist, genre en songs.

## API Gateway
Onze api gateway is een spring cloud gateway. Deze zorgt ervoor dat de requests van de client naar de juiste microservice worden gestuurd.
Al onze api calls zijn beveiligd met oauth2.0. De api gateway zorgt ervoor dat de client een token kan aanvragen en deze kan gebruiken om de api calls beveiligd te doen.
Enkel de genres kunnen zonder token worden opgevraagd.

We zijn gegaan voor 4 get calls. Eén get per microservice. Zo konden we makkelijk de informatie van een bepaalde microservice opvragen. Vorvolgens hebben we 2 post calls gemaakt. Eén voor het toevoegen van een album en één voor het toevoegen van een artiest.

Dan hebben we ook nog 1 put en 1 delete call gemaakt. Deze zijn voor het aanpassen en verwijderen van artisten.

## Kubernetes
We hebben gekozen om de uitbreiding van prometheus en grafana te doen. 

## Hosted
Ons project is niet gehost, dit komt omdat wij te laat waren om een okteto account aan te maken. Dit is waarom we dit locaal hosten op docker.