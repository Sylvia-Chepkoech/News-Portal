# News_Portal
##### By Sylvia Chepkoech

## Table of Content
+ [Description](#description)
+ [Installation Requirement](#Installation)
+ [Setup](#Project-setup)
+ [Reference](#reference)
+ [Contact Info](#Support and Contact details)
## Description
 <p>A rest REST API for querying and retrieving scoped news and information. </p>

## Setup
### Prerequisites
* Postgresql (14.2)
* Postman
* Gradle
* Java Development Kit (JDK)

## Installation
* Clone this repository to a location in your file system.
* Open terminal command line then navigate to the root folder of the application.
  ```
    $ git clone  https://github.com/Sylvia-Chepkoech/News-Portal.git
    $ cd ../path/to/the/file
  
   ```
## Recreate Database
* Navigate to the root directory of the project in your terminal and Run the following command to recreate the database on your local machine
   ```
   $ psql < create.sql;
  ```
* If the database seems to be populated, reset it using:
  ```
   $ psql < drop.sql;
  ```
* and recreate it again

## Run
 <p> Open the project in Intellij Idea and refresh gradle to download dependencies.
After downloading dependencies, run;

   ```
   gradle build;
  ```
* and thereafter

   ```
   gradle run;
  ```
* to ignite a Spark server.The project is now live at
 ```
  localhost4567
  ```

## Postman
<p>Use the following templates for the post methods;</p>
* new employee

  ```
  {
      "name":" ",
      "position":" ",
      "email":" ",
      "departmentId": integer
      
  }
  ```
* new department
  ```
  {
      "departmentName": " ",
      "description":" ",
      "numberOfEmployees": integer
  }
  
   ```
* new news
 ```
  {
      "heading": " ",
      "context":" ",
      "departmentId": integer
  }
  
   ```
## Support and Contact details
 <p>In case of any queries you can reach out via email; sylvia.chepkoech@student.moringaschool.com</p>

## License
MIT License

Copyright (c) 2022 Sylvia-Chepkoech

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.