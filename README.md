# Social Platform Project Spring BOot

# Technical details

I had problems with git, the project is in the socialplatform folder, I should probably delete the others as soon as I get the other issues I am currently facing with this platform resolved

This project uses:
 - Spring Boot
 - Maven (for project managment / initialization)
 - Spring Security (mainly used to handle login and logout)
 - In-Memory H2 database (I am aware that this database is for testing, but thanks to the way a spring boot project is organized, it can be changed to a real SQL database by changind the pom.xml file. All of the things that work on an h2 database are sure to work on a real one too, I prefer this one because of the simple interface it provides for testing)
  - React (for handling all front-end)
  - Axios (for handling all requests)
 
# Features and description
This web application is a social platform, it allows people to create an account, add friends, post stuff and review what their friends have posted. The features are:
  - Register an account
  - Login / Logout
  - Add a post
  - Add a friend
  - View what your friends post
  - Comment on a post
  - Lookup people
  
 # Problems I've run into
 I'm actually thinking to redo this project and make it better, considering I've learned new things since I've created it. 
 The first thing in the back-end is that I've figured a better way to organize the data from a person on the internet, he'd have a seperate package where he kept entities for his database containing all the information, and a seperate package where he kept all of the classes that contained json data that would be sent / received from the front-end.
 I had a lot of trouble with React actually, considering this is my first time woring with it and I was stuck between chosing React (which I've never worked with before) and Angular (which I've never worked with before). Therefor, the front-end is pretty lackluster to be honest, but hey, it works.
 There is an issue where the login will only work from the back-end, and no matter how I changed the spring security config it just would not work. I tried sending data to 8080/perform_login/, but it would not do anything, displaying only a 200 ok response from the server, and I can not figure why it would not work.
 I've tested everything else and it's fine, though.
