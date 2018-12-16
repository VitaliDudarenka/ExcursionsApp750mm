# ExcursionsApp750mm

The application for booking excursions on 750mm.by
Shows the list of excursions, the list of news. There is realised showing excursions on the map, 
clicking on marker makes the transition to excursion details.
Also there is implemented the share button and push-notifications.
The app uses Backendless.com API. There is used clean architecture, consists of 3 modules: domain, data, presentation.

# Domain module
Independent layer, it contains only business logic - no dependencies from Android SDK, other modules 
or libs , except RxJava. Here we have interfaces that should be implemented in other modules.

# Data module
It contains functions for getting entities of excursions and articles, booking the excursion. 
This module implements the interfaces located in the domain module and does not contain business logic. 
For working out it uses such libraries as: RxJava, Retrofit, OkHttp, Room.

# Presentation module
This module contains the logic to configure the application user interface and all business logic. 
This module uses the MVVM pattern for organizing work with the user interface.

# Used liblrares
RxJava Retrofit OkHttp Picasso GooglePlayServicesMap FirebaseMessaging Dagger2 ConstraintLayout RecyclerView Crashlytics Room

# Download
To download this project click "Cone or download" button, then click "downloadZip" or copy the project link. 
If you have installed GitHub client you may click "Open in Desctop".
