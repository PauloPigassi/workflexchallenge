📦 Workflex Challenge - Full Stack (Spring Boot + Angular + PostgreSQL)
This project is a full-stack application using:

Spring Boot (Backend)

Angular (Frontend)

PostgreSQL (Database)

Docker Compose (Container Orchestration)

⚙️ Requirements
Docker and Docker Compose installed

Maven installed (for local builds)

🚀 How to Run the Full Project
Clone the repository

bash
Copy
Edit
git clone <your-repo-url>
cd <your-project-folder>
Build the backend application

Go to the backend folder and generate the .jar:

bash
Copy
Edit
cd backend
mvn clean package
After this, a .jar will be generated inside backend/target/.

Build and start all containers

Go back to the root of the project (where docker-compose.yml is) and run:

bash
Copy
Edit
docker-compose up --build
This command will:

Start a PostgreSQL database

Start the Spring Boot backend

Build and serve the Angular frontend

🌐 Accessing the Applications
Backend API (Spring Boot): http://localhost:8080

Frontend Application (Angular): http://localhost:4200

📂 Project Structure
bash
Copy
Edit
/project-root
  /backend    → Spring Boot project (Java)
/frontend     → Angular project (TypeScript)
docker-compose.yml
🛠 Environment Details
PostgreSQL

Hostname: postgres

Port: 5432

Database: mydb

User: myuser

Password: mypassword

Spring Boot

Port: 8080

Environment variables are automatically injected via docker-compose.yml.

Angular (Nginx)

Port: 4200

🧹 Useful Commands
Stop containers

bash
Copy
Edit
docker-compose down
Rebuild everything

bash
Copy
Edit
docker-compose up --build --force-recreate
⚡ Notes
Make sure the backend .jar file is built (mvn clean package) before running Docker Compose.

Adjust environment variables if needed inside the docker-compose.yml.

You can extend the configuration to add production profiles or use a reverse proxy like Traefik/Nginx.

🎯 Summary
Once you run docker-compose up --build, your full stack application will be live at:

Frontend: http://localhost:4200

Backend: http://localhost:8080

