# Daily-Message
The project maintains a small web application that implements the display of a random message of the day for users. The administrator has the ability to view statistics, as well as select the message of the day or write his own.

To run this app you will need:
- TomCat (version 9+);
- PostgreSQL (version 12+);
- JDK (version 14+).

Required changes in the code: 
file "ConfigurationProcess.pdf" is attached to the master.


TO RUN THE APP:
- Run the server after configuration process;
- Go to domain name (temporary) - https://localhost:8080;


Project structure:
DB consists of 4 tables:
- User
- Statistic
- Diary
- Messages
Messages is an archive for prebuilt messages to choose from by admin.
User keeps information of every registered user, such as email and password. Is binded to Statistic table with 1..n to 1..n cordinality.
Diary keeps information of every day that had Message of the Day. Is binded to Statistic table with 1..n to 1..n cordinality.
Statistic keeps track of unique users that viewed particular MotD. May be expanded to keep more statistic info.

Solutions used in the development: 
- Backend: 
  - Java (version 8.281);
  - Spring Modules:
    - Core;
    - MVC;
    - Boot;
  - TomCat (version 9.0.43) for server deployment;
  - PostgreSQL (version 12) for database;
- Frontend:
  - JQuery (version 3.5.1+) for async server requests and dynamic HTML;
  - HTML5;
  - JS.

API methods:
-  @CrossOrigin
    @GetMapping("/adminPanel")
    public String sendMessages() {...}
Returns JSON file with messages archive to the client
    
-  @CrossOrigin
    @PostMapping("/adminPanel")
    public String choiceMessage(...) {...}
Saves message of the day to the DB and redirects to the DailyMessage view
    
- @CrossOrigin
    @GetMapping ("/getPath")
    public void getPath() {...}
Returns URL of the home page to the redirect script

- @CrossOrigin
    @PostMapping("/authorization")
    public String authorization(...) {...}
Returns JSON string with access parameters and URL view

-  @CrossOrigin
    @GetMapping("/dailyMassage")
    public String sendMessages()
Returns JSON file with messages archive to the client
    
