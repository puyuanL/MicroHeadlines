# MicroHeadline Project Documentation  

## 📌 Notice  
**Note:** This project only implements the backend part. The frontend part is developed by Shangguigu.  

## 1. Introduction to MicroHeadline Business  
MicroHeadline is a news publishing and browsing platform, mainly including the following businesses:  

- **User Functions**  
  - Registration function  
  - Login function  

- **Headline News**  
  - Paged browsing of news  
  - Search news by title keywords  
  - View news details  
  - Modify and delete news  

- **Permission Control**  
  - Users can only modify the Toutiao news they published  

## 2. Introduction to Technology Stack  

### 2.1 Frontend Technology Stack  
- **ES6** as the basic JS syntax  
- **Node.js** for the runtime environment  
- **npm** as the project dependency management tool  
- **Vite** as the project build tool  
- **Vue 3** as the project data rendering framework  
- **Axios** for front-end and back-end data interaction  
- **Router** for page navigation  
- **Pinia** for storing user data  
- **LocalStorage** as the storage method for user verification tokens  
- **Element-Plus** for providing components  

### 2.2 Backend Technology Stack  
- **Development Language**  
  - JAVA (JDK 17)  
- **Service Container**  
  - Tomcat 10.1.42  
- **Data Storage**  
  - MySQL 8.4  
- **Core Components**  
  - **Servlet**: Control layer for front-end-back-end data interaction  
  - **JDBC**: Implement data CURD (Create, Read, Update, Delete)  
  - **Druid**: Data source connection pool  
  - **MD5**: User password encryption  
  - **JWT**: Token generation and verification  
  - **Jackson**: JSON conversion  
  - **Filter**: User login verification and cross-domain processing  
  - **Lombok**: Entity class handling  

